"""
@generated
cargo-raze generated Bazel file.

DO NOT EDIT! Replaced on runs of cargo-raze
"""

load("@bazel_tools//tools/build_defs/repo:git.bzl", "new_git_repository")  # buildifier: disable=load
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")  # buildifier: disable=load
load("@bazel_tools//tools/build_defs/repo:utils.bzl", "maybe")  # buildifier: disable=load

def raze_fetch_remote_crates():
    """This function defines a collection of repos and should be called in a WORKSPACE file"""
    maybe(
        http_archive,
        name = "raze__aho_corasick__0_7_3",
        url = "https://crates.io/api/v1/crates/aho-corasick/0.7.3/download",
        type = "tar.gz",
        sha256 = "e6f484ae0c99fec2e858eb6134949117399f222608d84cadb3f58c1f97c2364c",
        strip_prefix = "aho-corasick-0.7.3",
        build_file = Label("//third-party/cargo/remote:BUILD.aho-corasick-0.7.3.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__ansi_term__0_11_0",
        url = "https://crates.io/api/v1/crates/ansi_term/0.11.0/download",
        type = "tar.gz",
        sha256 = "ee49baf6cb617b853aa8d93bf420db2383fab46d314482ca2803b40d5fde979b",
        strip_prefix = "ansi_term-0.11.0",
        build_file = Label("//third-party/cargo/remote:BUILD.ansi_term-0.11.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__atty__0_2_11",
        url = "https://crates.io/api/v1/crates/atty/0.2.11/download",
        type = "tar.gz",
        sha256 = "9a7d5b8723950951411ee34d271d99dddcc2035a16ab25310ea2c8cfd4369652",
        strip_prefix = "atty-0.2.11",
        build_file = Label("//third-party/cargo/remote:BUILD.atty-0.2.11.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__bitflags__1_0_4",
        url = "https://crates.io/api/v1/crates/bitflags/1.0.4/download",
        type = "tar.gz",
        sha256 = "228047a76f468627ca71776ecdebd732a3423081fcf5125585bcd7c49886ce12",
        strip_prefix = "bitflags-1.0.4",
        build_file = Label("//third-party/cargo/remote:BUILD.bitflags-1.0.4.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__block_buffer__0_7_3",
        url = "https://crates.io/api/v1/crates/block-buffer/0.7.3/download",
        type = "tar.gz",
        sha256 = "c0940dc441f31689269e10ac70eb1002a3a1d3ad1390e030043662eb7fe4688b",
        strip_prefix = "block-buffer-0.7.3",
        build_file = Label("//third-party/cargo/remote:BUILD.block-buffer-0.7.3.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__block_padding__0_1_4",
        url = "https://crates.io/api/v1/crates/block-padding/0.1.4/download",
        type = "tar.gz",
        sha256 = "6d4dc3af3ee2e12f3e5d224e5e1e3d73668abbeb69e566d361f7d5563a4fdf09",
        strip_prefix = "block-padding-0.1.4",
        build_file = Label("//third-party/cargo/remote:BUILD.block-padding-0.1.4.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__byte_tools__0_3_1",
        url = "https://crates.io/api/v1/crates/byte-tools/0.3.1/download",
        type = "tar.gz",
        sha256 = "e3b5ca7a04898ad4bcd41c90c5285445ff5b791899bb1b0abdd2a2aa791211d7",
        strip_prefix = "byte-tools-0.3.1",
        build_file = Label("//third-party/cargo/remote:BUILD.byte-tools-0.3.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__byteorder__1_3_1",
        url = "https://crates.io/api/v1/crates/byteorder/1.3.1/download",
        type = "tar.gz",
        sha256 = "a019b10a2a7cdeb292db131fc8113e57ea2a908f6e7894b0c3c671893b65dbeb",
        strip_prefix = "byteorder-1.3.1",
        build_file = Label("//third-party/cargo/remote:BUILD.byteorder-1.3.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__clap__2_33_0",
        url = "https://crates.io/api/v1/crates/clap/2.33.0/download",
        type = "tar.gz",
        sha256 = "5067f5bb2d80ef5d68b4c87db81601f0b75bca627bc2ef76b141d7b846a3c6d9",
        strip_prefix = "clap-2.33.0",
        build_file = Label("//third-party/cargo/remote:BUILD.clap-2.33.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__digest__0_8_0",
        url = "https://crates.io/api/v1/crates/digest/0.8.0/download",
        type = "tar.gz",
        sha256 = "05f47366984d3ad862010e22c7ce81a7dbcaebbdfb37241a620f8b6596ee135c",
        strip_prefix = "digest-0.8.0",
        build_file = Label("//third-party/cargo/remote:BUILD.digest-0.8.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__fake_simd__0_1_2",
        url = "https://crates.io/api/v1/crates/fake-simd/0.1.2/download",
        type = "tar.gz",
        sha256 = "e88a8acf291dafb59c2d96e8f59828f3838bb1a70398823ade51a84de6a6deed",
        strip_prefix = "fake-simd-0.1.2",
        build_file = Label("//third-party/cargo/remote:BUILD.fake-simd-0.1.2.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__generic_array__0_12_0",
        url = "https://crates.io/api/v1/crates/generic-array/0.12.0/download",
        type = "tar.gz",
        sha256 = "3c0f28c2f5bfb5960175af447a2da7c18900693738343dc896ffbcabd9839592",
        strip_prefix = "generic-array-0.12.0",
        build_file = Label("//third-party/cargo/remote:BUILD.generic-array-0.12.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__lazy_static__1_3_0",
        url = "https://crates.io/api/v1/crates/lazy_static/1.3.0/download",
        type = "tar.gz",
        sha256 = "bc5729f27f159ddd61f4df6228e827e86643d4d3e7c32183cb30a1c08f604a14",
        strip_prefix = "lazy_static-1.3.0",
        build_file = Label("//third-party/cargo/remote:BUILD.lazy_static-1.3.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__libc__0_2_53",
        url = "https://crates.io/api/v1/crates/libc/0.2.53/download",
        type = "tar.gz",
        sha256 = "ec350a9417dfd244dc9a6c4a71e13895a4db6b92f0b106f07ebbc3f3bc580cee",
        strip_prefix = "libc-0.2.53",
        build_file = Label("//third-party/cargo/remote:BUILD.libc-0.2.53.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__maplit__1_0_1",
        url = "https://crates.io/api/v1/crates/maplit/1.0.1/download",
        type = "tar.gz",
        sha256 = "08cbb6b4fef96b6d77bfc40ec491b1690c779e77b05cd9f07f787ed376fd4c43",
        strip_prefix = "maplit-1.0.1",
        build_file = Label("//third-party/cargo/remote:BUILD.maplit-1.0.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__memchr__2_2_0",
        url = "https://crates.io/api/v1/crates/memchr/2.2.0/download",
        type = "tar.gz",
        sha256 = "2efc7bc57c883d4a4d6e3246905283d8dae951bb3bd32f49d6ef297f546e1c39",
        strip_prefix = "memchr-2.2.0",
        build_file = Label("//third-party/cargo/remote:BUILD.memchr-2.2.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__numtoa__0_1_0",
        url = "https://crates.io/api/v1/crates/numtoa/0.1.0/download",
        type = "tar.gz",
        sha256 = "b8f8bdf33df195859076e54ab11ee78a1b208382d3a26ec40d142ffc1ecc49ef",
        strip_prefix = "numtoa-0.1.0",
        build_file = Label("//third-party/cargo/remote:BUILD.numtoa-0.1.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__opaque_debug__0_2_2",
        url = "https://crates.io/api/v1/crates/opaque-debug/0.2.2/download",
        type = "tar.gz",
        sha256 = "93f5bb2e8e8dec81642920ccff6b61f1eb94fa3020c5a325c9851ff604152409",
        strip_prefix = "opaque-debug-0.2.2",
        build_file = Label("//third-party/cargo/remote:BUILD.opaque-debug-0.2.2.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__pest__2_1_1",
        url = "https://crates.io/api/v1/crates/pest/2.1.1/download",
        type = "tar.gz",
        sha256 = "933085deae3f32071f135d799d75667b63c8dc1f4537159756e3d4ceab41868c",
        strip_prefix = "pest-2.1.1",
        build_file = Label("//third-party/cargo/remote:BUILD.pest-2.1.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__pest_derive__2_1_0",
        url = "https://crates.io/api/v1/crates/pest_derive/2.1.0/download",
        type = "tar.gz",
        sha256 = "833d1ae558dc601e9a60366421196a8d94bc0ac980476d0b67e1d0988d72b2d0",
        strip_prefix = "pest_derive-2.1.0",
        build_file = Label("//third-party/cargo/remote:BUILD.pest_derive-2.1.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__pest_generator__2_1_0",
        url = "https://crates.io/api/v1/crates/pest_generator/2.1.0/download",
        type = "tar.gz",
        sha256 = "63120576c4efd69615b5537d3d052257328a4ca82876771d6944424ccfd9f646",
        strip_prefix = "pest_generator-2.1.0",
        build_file = Label("//third-party/cargo/remote:BUILD.pest_generator-2.1.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__pest_meta__2_1_1",
        url = "https://crates.io/api/v1/crates/pest_meta/2.1.1/download",
        type = "tar.gz",
        sha256 = "f249ea6de7c7b7aba92b4ff4376a994c6dbd98fd2166c89d5c4947397ecb574d",
        strip_prefix = "pest_meta-2.1.1",
        build_file = Label("//third-party/cargo/remote:BUILD.pest_meta-2.1.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__proc_macro2__0_4_28",
        url = "https://crates.io/api/v1/crates/proc-macro2/0.4.28/download",
        type = "tar.gz",
        sha256 = "ba92c84f814b3f9a44c5cfca7d2ad77fa10710867d2bbb1b3d175ab5f47daa12",
        strip_prefix = "proc-macro2-0.4.28",
        build_file = Label("//third-party/cargo/remote:BUILD.proc-macro2-0.4.28.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__quote__0_6_12",
        url = "https://crates.io/api/v1/crates/quote/0.6.12/download",
        type = "tar.gz",
        sha256 = "faf4799c5d274f3868a4aae320a0a182cbd2baee377b378f080e16a23e9d80db",
        strip_prefix = "quote-0.6.12",
        build_file = Label("//third-party/cargo/remote:BUILD.quote-0.6.12.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__redox_syscall__0_1_54",
        url = "https://crates.io/api/v1/crates/redox_syscall/0.1.54/download",
        type = "tar.gz",
        sha256 = "12229c14a0f65c4f1cb046a3b52047cdd9da1f4b30f8a39c5063c8bae515e252",
        strip_prefix = "redox_syscall-0.1.54",
        build_file = Label("//third-party/cargo/remote:BUILD.redox_syscall-0.1.54.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__redox_termios__0_1_1",
        url = "https://crates.io/api/v1/crates/redox_termios/0.1.1/download",
        type = "tar.gz",
        sha256 = "7e891cfe48e9100a70a3b6eb652fef28920c117d366339687bd5576160db0f76",
        strip_prefix = "redox_termios-0.1.1",
        build_file = Label("//third-party/cargo/remote:BUILD.redox_termios-0.1.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__regex__1_1_6",
        url = "https://crates.io/api/v1/crates/regex/1.1.6/download",
        type = "tar.gz",
        sha256 = "8f0a0bcab2fd7d1d7c54fa9eae6f43eddeb9ce2e7352f8518a814a4f65d60c58",
        strip_prefix = "regex-1.1.6",
        build_file = Label("//third-party/cargo/remote:BUILD.regex-1.1.6.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__regex_syntax__0_6_6",
        url = "https://crates.io/api/v1/crates/regex-syntax/0.6.6/download",
        type = "tar.gz",
        sha256 = "dcfd8681eebe297b81d98498869d4aae052137651ad7b96822f09ceb690d0a96",
        strip_prefix = "regex-syntax-0.6.6",
        build_file = Label("//third-party/cargo/remote:BUILD.regex-syntax-0.6.6.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__same_file__1_0_4",
        url = "https://crates.io/api/v1/crates/same-file/1.0.4/download",
        type = "tar.gz",
        sha256 = "8f20c4be53a8a1ff4c1f1b2bd14570d2f634628709752f0702ecdd2b3f9a5267",
        strip_prefix = "same-file-1.0.4",
        build_file = Label("//third-party/cargo/remote:BUILD.same-file-1.0.4.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__sha_1__0_8_1",
        url = "https://crates.io/api/v1/crates/sha-1/0.8.1/download",
        type = "tar.gz",
        sha256 = "23962131a91661d643c98940b20fcaffe62d776a823247be80a48fcb8b6fce68",
        strip_prefix = "sha-1-0.8.1",
        build_file = Label("//third-party/cargo/remote:BUILD.sha-1-0.8.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__strsim__0_8_0",
        url = "https://crates.io/api/v1/crates/strsim/0.8.0/download",
        type = "tar.gz",
        sha256 = "8ea5119cdb4c55b55d432abb513a0429384878c15dde60cc77b1c99de1a95a6a",
        strip_prefix = "strsim-0.8.0",
        build_file = Label("//third-party/cargo/remote:BUILD.strsim-0.8.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__syn__0_15_33",
        url = "https://crates.io/api/v1/crates/syn/0.15.33/download",
        type = "tar.gz",
        sha256 = "ec52cd796e5f01d0067225a5392e70084acc4c0013fa71d55166d38a8b307836",
        strip_prefix = "syn-0.15.33",
        build_file = Label("//third-party/cargo/remote:BUILD.syn-0.15.33.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__termion__1_5_2",
        url = "https://crates.io/api/v1/crates/termion/1.5.2/download",
        type = "tar.gz",
        sha256 = "dde0593aeb8d47accea5392b39350015b5eccb12c0d98044d856983d89548dea",
        strip_prefix = "termion-1.5.2",
        build_file = Label("//third-party/cargo/remote:BUILD.termion-1.5.2.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__textwrap__0_11_0",
        url = "https://crates.io/api/v1/crates/textwrap/0.11.0/download",
        type = "tar.gz",
        sha256 = "d326610f408c7a4eb6f51c37c330e496b08506c9457c9d34287ecc38809fb060",
        strip_prefix = "textwrap-0.11.0",
        build_file = Label("//third-party/cargo/remote:BUILD.textwrap-0.11.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__thread_local__0_3_6",
        url = "https://crates.io/api/v1/crates/thread_local/0.3.6/download",
        type = "tar.gz",
        sha256 = "c6b53e329000edc2b34dbe8545fd20e55a333362d0a321909685a19bd28c3f1b",
        strip_prefix = "thread_local-0.3.6",
        build_file = Label("//third-party/cargo/remote:BUILD.thread_local-0.3.6.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__typenum__1_10_0",
        url = "https://crates.io/api/v1/crates/typenum/1.10.0/download",
        type = "tar.gz",
        sha256 = "612d636f949607bdf9b123b4a6f6d966dedf3ff669f7f045890d3a4a73948169",
        strip_prefix = "typenum-1.10.0",
        build_file = Label("//third-party/cargo/remote:BUILD.typenum-1.10.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__ucd_trie__0_1_1",
        url = "https://crates.io/api/v1/crates/ucd-trie/0.1.1/download",
        type = "tar.gz",
        sha256 = "71a9c5b1fe77426cf144cc30e49e955270f5086e31a6441dfa8b32efc09b9d77",
        strip_prefix = "ucd-trie-0.1.1",
        build_file = Label("//third-party/cargo/remote:BUILD.ucd-trie-0.1.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__ucd_util__0_1_3",
        url = "https://crates.io/api/v1/crates/ucd-util/0.1.3/download",
        type = "tar.gz",
        sha256 = "535c204ee4d8434478593480b8f86ab45ec9aae0e83c568ca81abf0fd0e88f86",
        strip_prefix = "ucd-util-0.1.3",
        build_file = Label("//third-party/cargo/remote:BUILD.ucd-util-0.1.3.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__unicode_width__0_1_5",
        url = "https://crates.io/api/v1/crates/unicode-width/0.1.5/download",
        type = "tar.gz",
        sha256 = "882386231c45df4700b275c7ff55b6f3698780a650026380e72dabe76fa46526",
        strip_prefix = "unicode-width-0.1.5",
        build_file = Label("//third-party/cargo/remote:BUILD.unicode-width-0.1.5.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__unicode_xid__0_1_0",
        url = "https://crates.io/api/v1/crates/unicode-xid/0.1.0/download",
        type = "tar.gz",
        sha256 = "fc72304796d0818e357ead4e000d19c9c174ab23dc11093ac919054d20a6a7fc",
        strip_prefix = "unicode-xid-0.1.0",
        build_file = Label("//third-party/cargo/remote:BUILD.unicode-xid-0.1.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__utf8_ranges__1_0_2",
        url = "https://crates.io/api/v1/crates/utf8-ranges/1.0.2/download",
        type = "tar.gz",
        sha256 = "796f7e48bef87609f7ade7e06495a87d5cd06c7866e6a5cbfceffc558a243737",
        strip_prefix = "utf8-ranges-1.0.2",
        build_file = Label("//third-party/cargo/remote:BUILD.utf8-ranges-1.0.2.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__vec_map__0_8_1",
        url = "https://crates.io/api/v1/crates/vec_map/0.8.1/download",
        type = "tar.gz",
        sha256 = "05c78687fb1a80548ae3250346c3db86a80a7cdd77bda190189f2d0a0987c81a",
        strip_prefix = "vec_map-0.8.1",
        build_file = Label("//third-party/cargo/remote:BUILD.vec_map-0.8.1.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__walkdir__2_2_7",
        url = "https://crates.io/api/v1/crates/walkdir/2.2.7/download",
        type = "tar.gz",
        sha256 = "9d9d7ed3431229a144296213105a390676cc49c9b6a72bd19f3176c98e129fa1",
        strip_prefix = "walkdir-2.2.7",
        build_file = Label("//third-party/cargo/remote:BUILD.walkdir-2.2.7.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__winapi__0_3_7",
        url = "https://crates.io/api/v1/crates/winapi/0.3.7/download",
        type = "tar.gz",
        sha256 = "f10e386af2b13e47c89e7236a7a14a086791a2b88ebad6df9bf42040195cf770",
        strip_prefix = "winapi-0.3.7",
        build_file = Label("//third-party/cargo/remote:BUILD.winapi-0.3.7.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__winapi_i686_pc_windows_gnu__0_4_0",
        url = "https://crates.io/api/v1/crates/winapi-i686-pc-windows-gnu/0.4.0/download",
        type = "tar.gz",
        sha256 = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6",
        strip_prefix = "winapi-i686-pc-windows-gnu-0.4.0",
        build_file = Label("//third-party/cargo/remote:BUILD.winapi-i686-pc-windows-gnu-0.4.0.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__winapi_util__0_1_2",
        url = "https://crates.io/api/v1/crates/winapi-util/0.1.2/download",
        type = "tar.gz",
        sha256 = "7168bab6e1daee33b4557efd0e95d5ca70a03706d39fa5f3fe7a236f584b03c9",
        strip_prefix = "winapi-util-0.1.2",
        build_file = Label("//third-party/cargo/remote:BUILD.winapi-util-0.1.2.bazel"),
    )

    maybe(
        http_archive,
        name = "raze__winapi_x86_64_pc_windows_gnu__0_4_0",
        url = "https://crates.io/api/v1/crates/winapi-x86_64-pc-windows-gnu/0.4.0/download",
        type = "tar.gz",
        sha256 = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f",
        strip_prefix = "winapi-x86_64-pc-windows-gnu-0.4.0",
        build_file = Label("//third-party/cargo/remote:BUILD.winapi-x86_64-pc-windows-gnu-0.4.0.bazel"),
    )
