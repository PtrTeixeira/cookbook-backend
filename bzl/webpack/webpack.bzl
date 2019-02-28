def _webpack_impl(ctx):
    args = ctx.actions.args()
    args.add_all("-c", ctx.files.config)
    args.add("-o", ctx.outputs.bundle)
    args.add("--entry", ctx.attr.entry_point)
    args.add("--mode", "production")

    ctx.actions.run_shell(
        inputs = ctx.files.srcs,
        command = "tree | tee tmp.data",
        # executable = ctx.executable._webpack,
        # outputs = [ctx.outputs.bundle, ctx.outputs.sourcemap,],
        # arguments = [args],
        outputs = [ctx.outputs.data],
        progress_message = "Running Webpack to produce %s" % ctx.outputs.bundle.path,
    )
    ctx.actions.run(
        inputs = ctx.files.srcs,
        executable = ctx.executable._webpack,
        outputs = [ctx.outputs.bundle, ctx.outputs.sourcemap,],
        arguments = [args],
        progress_message = "Running Webpack to produce %s" % ctx.outputs.bundle.path,
    )

    return [DefaultInfo()]


webpack = rule(
    implementation = _webpack_impl,
    attrs = {
        "srcs": attr.label_list(allow_files = True),
        "config": attr.label(allow_files=True),
        "entry_point": attr.string(mandatory = True),
        "_webpack": attr.label(
            default = Label("@npm//webpack-cli/bin:webpack-cli"),
            executable = True,
            cfg = "host",
        ),
    },
    outputs = {
        "bundle": "%{name}.js",
        "sourcemap": "%{name}.map",
        "data": "tmp.data",
    },
)
