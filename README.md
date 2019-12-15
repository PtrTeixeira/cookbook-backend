# Cookbook

This is a "monorepo" of stuff that I like working on.
Most of the seperate project directories have their own
READMEs, which should help provide some more guidance on
what they do. 

## Background

### Why does this exist?

I like working on projects. The key thing I like about
CS as a field is that I can have an idea and then just *do* it.
It might not always be a good idea; if it is a good idea, someone
else will probably already have made a better version of it. Neither
of those things get in the way of me enjoying working on projects.

But having several repos each containing a single project is kinda
inconvenient. It means I would need to publish a large number of
very small utilities in order to get a consistent development
experience, and I don't think that's great for anyone. Monorepos
are the solution to that for big companies (among other problems),
and I think they'll work well enough for me. (More to the point, I've
worked at a company with significant inter-project dependencies, and
we needed to put a lot of work into faking a monorepo at build-time in
order to catch integration problems, and what we put together only
kind-of solved the problem).

### License

The MIT license. See `LICENSE.md` for details.

### Should I use this?

In general, no.

If you want to, though, go for it! I'm very open to issues or PRs,
though I can't always guarantee that I'll get to them in a timely
manner. Individual projects within this repo will have more information
on building an using them, as well as a more detailed description of
their status.

## The Code

### Backend Things

All of the backend things are built with [bazel](http://bazel.build).
I don't know Bazel that well, but I'm learning as I go.

You should see individual folders for more detailed information.

You can test everything (in CI, for instance) with `bazel test ...`.

### Frontend Things

Frontend things are built with Node / Yarn, seperately from all the 
backend things. I haven't been able to get the frontend build to 
play nicely with Bazel, so it's basically just a seperate workspace 
on top of the backend one, living in the same repository.

* `packages/punchcard-ui` - Contains the frontend for the `punchcard`
  backend. A typescript / create-react-app single-page application.
  * Build with `yarn workspace punchcard-ui build`
  * Test with `yarn workspace punchcard-ui test`
  * Run dev server with `yarn workspace punchcard-ui start`. If you do this, you
    can start a mock backend with `yarn run punchcard:backend` (or, I guess, 
    you can run the real backend, but it's kinda inconvenient).

You can test everything (in CI, for instance) with `yarn workspaces test`.
