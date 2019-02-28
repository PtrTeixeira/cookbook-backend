def _parcel_impl(ctx):
    args = ctx.actions.args()
    args.add("build")
    args.add("--no-cache")
    args.add("--no-autoinstall")
    args.add("--log-level", "4")
    args.add(ctx.files.entry_point)

    inputs = ctx.files.entry_point + ctx.files.srcs + ctx.files.deps

    ctx.actions.run(
        inputs = depset(inputs),
        executable = ctx.executable._parcel,
        outputs = [
            ctx.outputs.index,
        ],
        arguments = [args],
        progress_message = "Running Parcel to produce %s" % ctx.outputs.index,
    )

    return [DefaultInfo()]


parcel = rule(
    implementation = _parcel_impl,
    attrs = {
        "srcs": attr.label_list(allow_files = True),
        "deps": attr.label_list(),
        "entry_point": attr.label(
            allow_files=True,
            mandatory = True
        ),
        "_parcel": attr.label(
            default = Label("//bzl/parcel:parcel"),
            executable = True,
            cfg = "host",
        ),
    },
    outputs = {
        "index": "dist/index.html",
    },
)
