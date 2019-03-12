extern crate pest;
#[macro_use]
extern crate pest_derive;

use pest::iterators::Pair;
use pest::Parser;

#[derive(Parser)]
#[grammar_inline = r#"
kwd_true = { "True" }
kwd_false = { "False" }
kwd_add1 = { "add1" }
kwd_sub1 = { "sub1" }
kwd_let = _{ "let" }
kwd_in = _{ "in" }
kwd_if = _{ "if" }
kwd_else = _{ "else" }
kwd_equal = _{ "=" }
kwd_colon = _{ ":" }
kwd_end = _{ "end" }
kwd_fn = _{ "fn" }

kwd = _{
    kwd_true
    | kwd_false
    | kwd_add1
    | kwd_sub1
    | kwd_let
    | kwd_in
    | kwd_if
    | kwd_else
    | kwd_end
    | kwd_fn
}

unary_op = _{
    kwd_add1
    | kwd_sub1
}

signed_int = @{ ASCII_DIGIT+ | "-" ~ ASCII_DIGIT+ }
bool = _{ kwd_true | kwd_false }
ident = @{
    !kwd ~ (ASCII_ALPHA | "_") ~ (ASCII_ALPHANUMERIC | "_" | "?")*
}

unary_expr = {
    unary_op ~ "(" ~ expr ~ ")"
}

let_expr = {
    kwd_let
    ~ ident
    ~ kwd_equal
    ~ expr
    ~ kwd_in
    ~ expr
}

if_expr = {
    kwd_if ~ expr ~ kwd_colon
    ~ expr
    ~ kwd_else ~ kwd_colon
    ~ expr
    ~ kwd_end
}

expr = _{
    "(" ~ expr ~ ")"
    | let_expr
    | signed_int
    | bool
    | ident
    | unary_expr
    | if_expr
}

program = _{ SOI ~ expr ~ EOI }

WHITESPACE = _{ " " | "\t" | "\n" }
COMMENT = _{ ";" ~ (!"\n" ~ ANY)* ~ "\n"}
"#]
struct SexpParser;

#[derive(Debug, PartialEq)]
pub enum UnaryOp {
    Add1,
    Sub1,
}

#[derive(Debug, PartialEq)]
pub enum BinaryOp {
    Plus,
    Minus,
    Times,
    Div,
}

#[derive(Debug, PartialEq)]
pub enum ParseTree<'a> {
    Num(i64),
    Ident(&'a str),
    Bool(bool),
    Unary(UnaryOp, Box<ParseTree<'a>>),
    Binary(BinaryOp, Box<ParseTree<'a>>, Box<ParseTree<'a>>),
    Let(&'a str, Box<ParseTree<'a>>, Box<ParseTree<'a>>),
    If(Box<ParseTree<'a>>, Box<ParseTree<'a>>, Box<ParseTree<'a>>),
    Statement(Box<ParseTree<'a>>),
    Useless(),
}

pub fn read_input(input: &str) -> ParseTree {
    let result = SexpParser::parse(Rule::program, input);
    let program = result
        .expect("Failed to parse file") // lol
        .next()
        .unwrap(); // Must succeed

    parse_pair(program)
}

fn parse_pair(pair: Pair<Rule>) -> ParseTree {
    match pair.as_rule() {
        Rule::signed_int => ParseTree::Num(pair.as_str().parse().unwrap()),
        Rule::ident => ParseTree::Ident(pair.as_str()),
        Rule::kwd_true => ParseTree::Bool(true),
        Rule::kwd_false => ParseTree::Bool(false),
        Rule::unary_expr => {
            let mut inner_rules = pair.into_inner();
            let op = inner_rules.next().unwrap();
            let expr = parse_pair(inner_rules.next().unwrap());
            match op.as_rule() {
                Rule::kwd_add1 => ParseTree::Unary(UnaryOp::Add1, Box::new(expr)),
                Rule::kwd_sub1 => ParseTree::Unary(UnaryOp::Sub1, Box::new(expr)),
                _ => unreachable!(),
            }
        }
        Rule::let_expr => {
            let mut inner_rules = pair.into_inner();
            let name = inner_rules.next().unwrap().as_str();
            let bound = parse_pair(inner_rules.next().unwrap());
            let body = parse_pair(inner_rules.next().unwrap());

            ParseTree::Let(name, Box::new(bound), Box::new(body))
        }
        Rule::if_expr => {
            let mut inner_rules = pair.into_inner();
            let cond_expr = parse_pair(inner_rules.next().unwrap());
            let then_expr = parse_pair(inner_rules.next().unwrap());
            let else_expr = parse_pair(inner_rules.next().unwrap());

            ParseTree::If(
                Box::new(cond_expr),
                Box::new(then_expr),
                Box::new(else_expr))
        },
        _ => {
            println!("{:?}", &pair.into_inner());
            ParseTree::Useless()
        }
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test_parse_number() {
        let result = read_input("46");
        assert_eq!(result, ParseTree::Num(46));
    }

    #[test]
    fn test_parse_negative_int() {
        let result = read_input("-43");
        assert_eq!(result, ParseTree::Num(-43));
    }

    #[test]
    fn test_parse_true() {
        let result = read_input("True");
        assert_eq!(result, ParseTree::Bool(true));
    }

    #[test]
    fn test_parse_false() {
        let result = read_input("False");
        assert_eq!(result, ParseTree::Bool(false));
    }

    #[test]
    fn test_parse_ident() {
        let result = read_input("is_even?");
        assert_eq!(result, ParseTree::Ident("is_even?"));
    }

    #[test]
    fn test_unary_exp() {
        let result = read_input("add1(4)");
        let expected = ParseTree::Unary(UnaryOp::Add1, Box::new(ParseTree::Num(4)));
        assert_eq!(result, expected);
    }

    #[test]
    fn test_let_bindings() {
        let result = read_input("let x = 4 in x");
        let expected = ParseTree::Let(
            "x",
            Box::new(ParseTree::Num(4)),
            Box::new(ParseTree::Ident("x")),
        );
        assert_eq!(result, expected);
    }

    #[test]
    fn test_complicated_let_binding() {
        let result = read_input("
        let x = 4 in
        let y = add1(x) in
        y
        ");
        let body = ParseTree::Ident("y");
        let inner_let = ParseTree::Let(
            "y",
            Box::new(ParseTree::Unary(
                UnaryOp::Add1,
                Box::new(ParseTree::Ident("x")),
            )),
            Box::new(body),
        );
        let outer_let = ParseTree::Let("x", Box::new(ParseTree::Num(4)), Box::new(inner_let));
        assert_eq!(result, outer_let);
    }

    #[test]
    fn test_if_expression() {
        let result = read_input("
        if True:
          4
        else:
          5
        end
        ");

        let expected = ParseTree::If(
            Box::new(ParseTree::Bool(true)),
            Box::new(ParseTree::Num(4)),
            Box::new(ParseTree::Num(5))
        );
        assert_eq!(result, expected);
        }
}
