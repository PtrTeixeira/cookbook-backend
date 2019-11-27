"""
cargo-raze crate workspace functions

DO NOT EDIT! Replaced on runs of cargo-raze
"""
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "new_git_repository")

def _new_http_archive(name, **kwargs):
    if not native.existing_rule(name):
        http_archive(name=name, **kwargs)

def _new_git_repository(name, **kwargs):
    if not native.existing_rule(name):
        new_git_repository(name=name, **kwargs)

def raze_fetch_remote_crates():

    _new_http_archive(
        name = "raze__aho_corasick__0_7_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/aho-corasick/aho-corasick-0.7.6.crate",
        type = "tar.gz",
        sha256 = "58fb5e95d83b38284460a5fda7d6470aa0b8844d283a0b614b8535e880800d2d",
        strip_prefix = "aho-corasick-0.7.6",
        build_file = Label("//third-party/cargo/remote:aho-corasick-0.7.6.BUILD")
    )

    _new_http_archive(
        name = "raze__ansi_term__0_11_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/ansi_term/ansi_term-0.11.0.crate",
        type = "tar.gz",
        sha256 = "ee49baf6cb617b853aa8d93bf420db2383fab46d314482ca2803b40d5fde979b",
        strip_prefix = "ansi_term-0.11.0",
        build_file = Label("//third-party/cargo/remote:ansi_term-0.11.0.BUILD")
    )

    _new_http_archive(
        name = "raze__atty__0_2_13",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/atty/atty-0.2.13.crate",
        type = "tar.gz",
        sha256 = "1803c647a3ec87095e7ae7acfca019e98de5ec9a7d01343f611cf3152ed71a90",
        strip_prefix = "atty-0.2.13",
        build_file = Label("//third-party/cargo/remote:atty-0.2.13.BUILD")
    )

    _new_http_archive(
        name = "raze__bitflags__1_2_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/bitflags/bitflags-1.2.1.crate",
        type = "tar.gz",
        sha256 = "cf1de2fe8c75bc145a2f577add951f8134889b4795d47466a54a5c846d691693",
        strip_prefix = "bitflags-1.2.1",
        build_file = Label("//third-party/cargo/remote:bitflags-1.2.1.BUILD")
    )

    _new_http_archive(
        name = "raze__block_buffer__0_7_3",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/block-buffer/block-buffer-0.7.3.crate",
        type = "tar.gz",
        sha256 = "c0940dc441f31689269e10ac70eb1002a3a1d3ad1390e030043662eb7fe4688b",
        strip_prefix = "block-buffer-0.7.3",
        build_file = Label("//third-party/cargo/remote:block-buffer-0.7.3.BUILD")
    )

    _new_http_archive(
        name = "raze__block_padding__0_1_5",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/block-padding/block-padding-0.1.5.crate",
        type = "tar.gz",
        sha256 = "fa79dedbb091f449f1f39e53edf88d5dbe95f895dae6135a8d7b881fb5af73f5",
        strip_prefix = "block-padding-0.1.5",
        build_file = Label("//third-party/cargo/remote:block-padding-0.1.5.BUILD")
    )

    _new_http_archive(
        name = "raze__byte_tools__0_3_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/byte-tools/byte-tools-0.3.1.crate",
        type = "tar.gz",
        sha256 = "e3b5ca7a04898ad4bcd41c90c5285445ff5b791899bb1b0abdd2a2aa791211d7",
        strip_prefix = "byte-tools-0.3.1",
        build_file = Label("//third-party/cargo/remote:byte-tools-0.3.1.BUILD")
    )

    _new_http_archive(
        name = "raze__byteorder__1_3_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/byteorder/byteorder-1.3.2.crate",
        type = "tar.gz",
        sha256 = "a7c3dd8985a7111efc5c80b44e23ecdd8c007de8ade3b96595387e812b957cf5",
        strip_prefix = "byteorder-1.3.2",
        build_file = Label("//third-party/cargo/remote:byteorder-1.3.2.BUILD")
    )

    _new_http_archive(
        name = "raze__clap__2_33_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/clap/clap-2.33.0.crate",
        type = "tar.gz",
        sha256 = "5067f5bb2d80ef5d68b4c87db81601f0b75bca627bc2ef76b141d7b846a3c6d9",
        strip_prefix = "clap-2.33.0",
        build_file = Label("//third-party/cargo/remote:clap-2.33.0.BUILD")
    )

    _new_http_archive(
        name = "raze__digest__0_8_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/digest/digest-0.8.1.crate",
        type = "tar.gz",
        sha256 = "f3d0c8c8752312f9713efd397ff63acb9f85585afbf179282e720e7704954dd5",
        strip_prefix = "digest-0.8.1",
        build_file = Label("//third-party/cargo/remote:digest-0.8.1.BUILD")
    )

    _new_http_archive(
        name = "raze__fake_simd__0_1_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/fake-simd/fake-simd-0.1.2.crate",
        type = "tar.gz",
        sha256 = "e88a8acf291dafb59c2d96e8f59828f3838bb1a70398823ade51a84de6a6deed",
        strip_prefix = "fake-simd-0.1.2",
        build_file = Label("//third-party/cargo/remote:fake-simd-0.1.2.BUILD")
    )

    _new_http_archive(
        name = "raze__generic_array__0_12_3",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/generic-array/generic-array-0.12.3.crate",
        type = "tar.gz",
        sha256 = "c68f0274ae0e023facc3c97b2e00f076be70e254bc851d972503b328db79b2ec",
        strip_prefix = "generic-array-0.12.3",
        build_file = Label("//third-party/cargo/remote:generic-array-0.12.3.BUILD")
    )

    _new_http_archive(
        name = "raze__lazy_static__1_4_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/lazy_static/lazy_static-1.4.0.crate",
        type = "tar.gz",
        sha256 = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646",
        strip_prefix = "lazy_static-1.4.0",
        build_file = Label("//third-party/cargo/remote:lazy_static-1.4.0.BUILD")
    )

    _new_http_archive(
        name = "raze__libc__0_2_65",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/libc/libc-0.2.65.crate",
        type = "tar.gz",
        sha256 = "1a31a0627fdf1f6a39ec0dd577e101440b7db22672c0901fe00a9a6fbb5c24e8",
        strip_prefix = "libc-0.2.65",
        build_file = Label("//third-party/cargo/remote:libc-0.2.65.BUILD")
    )

    _new_http_archive(
        name = "raze__maplit__1_0_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/maplit/maplit-1.0.2.crate",
        type = "tar.gz",
        sha256 = "3e2e65a1a2e43cfcb47a895c4c8b10d1f4a61097f9f254f183aee60cad9c651d",
        strip_prefix = "maplit-1.0.2",
        build_file = Label("//third-party/cargo/remote:maplit-1.0.2.BUILD")
    )

    _new_http_archive(
        name = "raze__memchr__2_2_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/memchr/memchr-2.2.1.crate",
        type = "tar.gz",
        sha256 = "88579771288728879b57485cc7d6b07d648c9f0141eb955f8ab7f9d45394468e",
        strip_prefix = "memchr-2.2.1",
        build_file = Label("//third-party/cargo/remote:memchr-2.2.1.BUILD")
    )

    _new_http_archive(
        name = "raze__opaque_debug__0_2_3",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/opaque-debug/opaque-debug-0.2.3.crate",
        type = "tar.gz",
        sha256 = "2839e79665f131bdb5782e51f2c6c9599c133c6098982a54c794358bf432529c",
        strip_prefix = "opaque-debug-0.2.3",
        build_file = Label("//third-party/cargo/remote:opaque-debug-0.2.3.BUILD")
    )

    _new_http_archive(
        name = "raze__pest__2_1_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest/pest-2.1.2.crate",
        type = "tar.gz",
        sha256 = "7e4fb201c5c22a55d8b24fef95f78be52738e5e1361129be1b5e862ecdb6894a",
        strip_prefix = "pest-2.1.2",
        build_file = Label("//third-party/cargo/remote:pest-2.1.2.BUILD")
    )

    _new_http_archive(
        name = "raze__pest_derive__2_1_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest_derive/pest_derive-2.1.0.crate",
        type = "tar.gz",
        sha256 = "833d1ae558dc601e9a60366421196a8d94bc0ac980476d0b67e1d0988d72b2d0",
        strip_prefix = "pest_derive-2.1.0",
        build_file = Label("//third-party/cargo/remote:pest_derive-2.1.0.BUILD")
    )

    _new_http_archive(
        name = "raze__pest_generator__2_1_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest_generator/pest_generator-2.1.1.crate",
        type = "tar.gz",
        sha256 = "7b9fcf299b5712d06ee128a556c94709aaa04512c4dffb8ead07c5c998447fc0",
        strip_prefix = "pest_generator-2.1.1",
        build_file = Label("//third-party/cargo/remote:pest_generator-2.1.1.BUILD")
    )

    _new_http_archive(
        name = "raze__pest_meta__2_1_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest_meta/pest_meta-2.1.2.crate",
        type = "tar.gz",
        sha256 = "df43fd99896fd72c485fe47542c7b500e4ac1e8700bf995544d1317a60ded547",
        strip_prefix = "pest_meta-2.1.2",
        build_file = Label("//third-party/cargo/remote:pest_meta-2.1.2.BUILD")
    )

    _new_http_archive(
        name = "raze__proc_macro2__1_0_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/proc-macro2/proc-macro2-1.0.6.crate",
        type = "tar.gz",
        sha256 = "9c9e470a8dc4aeae2dee2f335e8f533e2d4b347e1434e5671afc49b054592f27",
        strip_prefix = "proc-macro2-1.0.6",
        build_file = Label("//third-party/cargo/remote:proc-macro2-1.0.6.BUILD")
    )

    _new_http_archive(
        name = "raze__quote__1_0_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/quote/quote-1.0.2.crate",
        type = "tar.gz",
        sha256 = "053a8c8bcc71fcce321828dc897a98ab9760bef03a4fc36693c231e5b3216cfe",
        strip_prefix = "quote-1.0.2",
        build_file = Label("//third-party/cargo/remote:quote-1.0.2.BUILD")
    )

    _new_http_archive(
        name = "raze__regex__1_3_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/regex/regex-1.3.1.crate",
        type = "tar.gz",
        sha256 = "dc220bd33bdce8f093101afe22a037b8eb0e5af33592e6a9caafff0d4cb81cbd",
        strip_prefix = "regex-1.3.1",
        build_file = Label("//third-party/cargo/remote:regex-1.3.1.BUILD")
    )

    _new_http_archive(
        name = "raze__regex_syntax__0_6_12",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/regex-syntax/regex-syntax-0.6.12.crate",
        type = "tar.gz",
        sha256 = "11a7e20d1cce64ef2fed88b66d347f88bd9babb82845b2b858f3edbf59a4f716",
        strip_prefix = "regex-syntax-0.6.12",
        build_file = Label("//third-party/cargo/remote:regex-syntax-0.6.12.BUILD")
    )

    _new_http_archive(
        name = "raze__same_file__1_0_5",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/same-file/same-file-1.0.5.crate",
        type = "tar.gz",
        sha256 = "585e8ddcedc187886a30fa705c47985c3fa88d06624095856b36ca0b82ff4421",
        strip_prefix = "same-file-1.0.5",
        build_file = Label("//third-party/cargo/remote:same-file-1.0.5.BUILD")
    )

    _new_http_archive(
        name = "raze__sha_1__0_8_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/sha-1/sha-1-0.8.1.crate",
        type = "tar.gz",
        sha256 = "23962131a91661d643c98940b20fcaffe62d776a823247be80a48fcb8b6fce68",
        strip_prefix = "sha-1-0.8.1",
        build_file = Label("//third-party/cargo/remote:sha-1-0.8.1.BUILD")
    )

    _new_http_archive(
        name = "raze__strsim__0_8_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/strsim/strsim-0.8.0.crate",
        type = "tar.gz",
        sha256 = "8ea5119cdb4c55b55d432abb513a0429384878c15dde60cc77b1c99de1a95a6a",
        strip_prefix = "strsim-0.8.0",
        build_file = Label("//third-party/cargo/remote:strsim-0.8.0.BUILD")
    )

    _new_http_archive(
        name = "raze__syn__1_0_8",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/syn/syn-1.0.8.crate",
        type = "tar.gz",
        sha256 = "661641ea2aa15845cddeb97dad000d22070bb5c1fb456b96c1cba883ec691e92",
        strip_prefix = "syn-1.0.8",
        build_file = Label("//third-party/cargo/remote:syn-1.0.8.BUILD")
    )

    _new_http_archive(
        name = "raze__textwrap__0_11_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/textwrap/textwrap-0.11.0.crate",
        type = "tar.gz",
        sha256 = "d326610f408c7a4eb6f51c37c330e496b08506c9457c9d34287ecc38809fb060",
        strip_prefix = "textwrap-0.11.0",
        build_file = Label("//third-party/cargo/remote:textwrap-0.11.0.BUILD")
    )

    _new_http_archive(
        name = "raze__thread_local__0_3_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/thread_local/thread_local-0.3.6.crate",
        type = "tar.gz",
        sha256 = "c6b53e329000edc2b34dbe8545fd20e55a333362d0a321909685a19bd28c3f1b",
        strip_prefix = "thread_local-0.3.6",
        build_file = Label("//third-party/cargo/remote:thread_local-0.3.6.BUILD")
    )

    _new_http_archive(
        name = "raze__typenum__1_11_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/typenum/typenum-1.11.2.crate",
        type = "tar.gz",
        sha256 = "6d2783fe2d6b8c1101136184eb41be8b1ad379e4657050b8aaff0c79ee7575f9",
        strip_prefix = "typenum-1.11.2",
        build_file = Label("//third-party/cargo/remote:typenum-1.11.2.BUILD")
    )

    _new_http_archive(
        name = "raze__ucd_trie__0_1_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/ucd-trie/ucd-trie-0.1.2.crate",
        type = "tar.gz",
        sha256 = "8f00ed7be0c1ff1e24f46c3d2af4859f7e863672ba3a6e92e7cff702bf9f06c2",
        strip_prefix = "ucd-trie-0.1.2",
        build_file = Label("//third-party/cargo/remote:ucd-trie-0.1.2.BUILD")
    )

    _new_http_archive(
        name = "raze__unicode_width__0_1_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/unicode-width/unicode-width-0.1.6.crate",
        type = "tar.gz",
        sha256 = "7007dbd421b92cc6e28410fe7362e2e0a2503394908f417b68ec8d1c364c4e20",
        strip_prefix = "unicode-width-0.1.6",
        build_file = Label("//third-party/cargo/remote:unicode-width-0.1.6.BUILD")
    )

    _new_http_archive(
        name = "raze__unicode_xid__0_2_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/unicode-xid/unicode-xid-0.2.0.crate",
        type = "tar.gz",
        sha256 = "826e7639553986605ec5979c7dd957c7895e93eabed50ab2ffa7f6128a75097c",
        strip_prefix = "unicode-xid-0.2.0",
        build_file = Label("//third-party/cargo/remote:unicode-xid-0.2.0.BUILD")
    )

    _new_http_archive(
        name = "raze__vec_map__0_8_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/vec_map/vec_map-0.8.1.crate",
        type = "tar.gz",
        sha256 = "05c78687fb1a80548ae3250346c3db86a80a7cdd77bda190189f2d0a0987c81a",
        strip_prefix = "vec_map-0.8.1",
        build_file = Label("//third-party/cargo/remote:vec_map-0.8.1.BUILD")
    )

    _new_http_archive(
        name = "raze__walkdir__2_2_9",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/walkdir/walkdir-2.2.9.crate",
        type = "tar.gz",
        sha256 = "9658c94fa8b940eab2250bd5a457f9c48b748420d71293b165c8cdbe2f55f71e",
        strip_prefix = "walkdir-2.2.9",
        build_file = Label("//third-party/cargo/remote:walkdir-2.2.9.BUILD")
    )

    _new_http_archive(
        name = "raze__winapi__0_3_8",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi/winapi-0.3.8.crate",
        type = "tar.gz",
        sha256 = "8093091eeb260906a183e6ae1abdba2ef5ef2257a21801128899c3fc699229c6",
        strip_prefix = "winapi-0.3.8",
        build_file = Label("//third-party/cargo/remote:winapi-0.3.8.BUILD")
    )

    _new_http_archive(
        name = "raze__winapi_i686_pc_windows_gnu__0_4_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi-i686-pc-windows-gnu/winapi-i686-pc-windows-gnu-0.4.0.crate",
        type = "tar.gz",
        sha256 = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6",
        strip_prefix = "winapi-i686-pc-windows-gnu-0.4.0",
        build_file = Label("//third-party/cargo/remote:winapi-i686-pc-windows-gnu-0.4.0.BUILD")
    )

    _new_http_archive(
        name = "raze__winapi_util__0_1_2",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi-util/winapi-util-0.1.2.crate",
        type = "tar.gz",
        sha256 = "7168bab6e1daee33b4557efd0e95d5ca70a03706d39fa5f3fe7a236f584b03c9",
        strip_prefix = "winapi-util-0.1.2",
        build_file = Label("//third-party/cargo/remote:winapi-util-0.1.2.BUILD")
    )

    _new_http_archive(
        name = "raze__winapi_x86_64_pc_windows_gnu__0_4_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi-x86_64-pc-windows-gnu/winapi-x86_64-pc-windows-gnu-0.4.0.crate",
        type = "tar.gz",
        sha256 = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f",
        strip_prefix = "winapi-x86_64-pc-windows-gnu-0.4.0",
        build_file = Label("//third-party/cargo/remote:winapi-x86_64-pc-windows-gnu-0.4.0.BUILD")
    )

