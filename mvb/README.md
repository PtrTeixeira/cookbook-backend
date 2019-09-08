mvb CLI Utility
==============

A batch file-moving utility. 

## Should I Use this? 

No.

## Usage

Usage example:

```
mvb '(.+)\.json' '$1.yml'
```

Currently, it's basically just delegating to the Rust's regex engine, which is
why the grammer is rather unfortunate. It also unbelieveably primitive. I make
no guarantees as to what will happen if you try to move 0 files, or move files
into a directory that isn't present, or any other reasonable edge cases. In
short, you shouldn't use this unless you know exactly what you're doing, and you
have all of the interesting files backed up anyway.

## Development

Build with `bazel build ...`. Test with `bazel test ...`.
