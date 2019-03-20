The Bagel Language Frontend
===========================

This package defines what the Bagel language *looks like*. 
As such, it is in common between the Bagel interpreter
and the Bagel compiler.

## Background

This is just a big fancy wrapper for [Pest](https://github.com/pest-parser/pest),
a PEG parser in Rust.A

## Examples of Bagel syntax

```
let x = 4;
x
```

```
fn foo() 
  4
end
```

```
fn add(x : Int, y : Int) -> Int
  x + y
end

add(4, 5)
```

```
fn max(x: Int, y: Int) -> Int
  if x > y:
    x
  else:
    y
  end
end

max(1, -40)
```

```
fn is_even?(n)
  if n == 0:
    true
  else:
    !is_odd?(n - 1)
  end
end

fn is_odd?(n)
  if n == 0:
    false
  else:
    !is_even?(n - 1)
  end
end

let elems = [1, 2, 3];
elems 
  |> |l| filter(|it| is_even?(it), l)
```

```
let elems = [1, 2, 3];

foldl(|accum, next| { accum + next }, 0, elems)
```

```
type Tree<T> is 
| Leaf(T)
| Branch(Tree<T>, Tree<T>)
end

fn sum_tree(tree : Tree<Int>) -> Int
  match tree with 
  | Leaf(n) -> n
  | Branch(l, r) -> sum_tree(l) + sum_tree(r)
  end
end

let data = Branch(Leaf(1), Branch(Leaf(2), Leaf(4)))
sum_tree(data)
```
