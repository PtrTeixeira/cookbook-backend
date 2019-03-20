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
        name = "raze__ansi_term__0_11_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/ansi_term/ansi_term-0.11.0.crate",
        type = "tar.gz",
        sha256 = "ee49baf6cb617b853aa8d93bf420db2383fab46d314482ca2803b40d5fde979b",
        strip_prefix = "ansi_term-0.11.0",
        build_file = Label("//third-party/cargo/remote:ansi_term-0.11.0.BUILD")
    )

    _new_http_archive(
        name = "raze__arrayref__0_3_5",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/arrayref/arrayref-0.3.5.crate",
        type = "tar.gz",
        sha256 = "0d382e583f07208808f6b1249e60848879ba3543f57c32277bf52d69c2f0f0ee",
        strip_prefix = "arrayref-0.3.5",
        build_file = Label("//third-party/cargo/remote:arrayref-0.3.5.BUILD")
    )

    _new_http_archive(
        name = "raze__atty__0_2_11",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/atty/atty-0.2.11.crate",
        type = "tar.gz",
        sha256 = "9a7d5b8723950951411ee34d271d99dddcc2035a16ab25310ea2c8cfd4369652",
        strip_prefix = "atty-0.2.11",
        build_file = Label("//third-party/cargo/remote:atty-0.2.11.BUILD")
    )

    _new_http_archive(
        name = "raze__bitflags__1_0_4",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/bitflags/bitflags-1.0.4.crate",
        type = "tar.gz",
        sha256 = "228047a76f468627ca71776ecdebd732a3423081fcf5125585bcd7c49886ce12",
        strip_prefix = "bitflags-1.0.4",
        build_file = Label("//third-party/cargo/remote:bitflags-1.0.4.BUILD")
    )

    _new_http_archive(
        name = "raze__block_buffer__0_3_3",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/block-buffer/block-buffer-0.3.3.crate",
        type = "tar.gz",
        sha256 = "a076c298b9ecdb530ed9d967e74a6027d6a7478924520acddcddc24c1c8ab3ab",
        strip_prefix = "block-buffer-0.3.3",
        build_file = Label("//third-party/cargo/remote:block-buffer-0.3.3.BUILD")
    )

    _new_http_archive(
        name = "raze__byte_tools__0_2_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/byte-tools/byte-tools-0.2.0.crate",
        type = "tar.gz",
        sha256 = "560c32574a12a89ecd91f5e742165893f86e3ab98d21f8ea548658eb9eef5f40",
        strip_prefix = "byte-tools-0.2.0",
        build_file = Label("//third-party/cargo/remote:byte-tools-0.2.0.BUILD")
    )

    _new_http_archive(
        name = "raze__clap__2_32_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/clap/clap-2.32.0.crate",
        type = "tar.gz",
        sha256 = "b957d88f4b6a63b9d70d5f454ac8011819c6efa7727858f458ab71c756ce2d3e",
        strip_prefix = "clap-2.32.0",
        build_file = Label("//third-party/cargo/remote:clap-2.32.0.BUILD")
    )

    _new_http_archive(
        name = "raze__digest__0_7_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/digest/digest-0.7.6.crate",
        type = "tar.gz",
        sha256 = "03b072242a8cbaf9c145665af9d250c59af3b958f83ed6824e13533cf76d5b90",
        strip_prefix = "digest-0.7.6",
        build_file = Label("//third-party/cargo/remote:digest-0.7.6.BUILD")
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
        name = "raze__generic_array__0_9_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/generic-array/generic-array-0.9.0.crate",
        type = "tar.gz",
        sha256 = "ef25c5683767570c2bbd7deba372926a55eaae9982d7726ee2a1050239d45b9d",
        strip_prefix = "generic-array-0.9.0",
        build_file = Label("//third-party/cargo/remote:generic-array-0.9.0.BUILD")
    )

    _new_http_archive(
        name = "raze__libc__0_2_50",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/libc/libc-0.2.50.crate",
        type = "tar.gz",
        sha256 = "aab692d7759f5cd8c859e169db98ae5b52c924add2af5fbbca11d12fefb567c1",
        strip_prefix = "libc-0.2.50",
        build_file = Label("//third-party/cargo/remote:libc-0.2.50.BUILD")
    )

    _new_http_archive(
        name = "raze__maplit__1_0_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/maplit/maplit-1.0.1.crate",
        type = "tar.gz",
        sha256 = "08cbb6b4fef96b6d77bfc40ec491b1690c779e77b05cd9f07f787ed376fd4c43",
        strip_prefix = "maplit-1.0.1",
        build_file = Label("//third-party/cargo/remote:maplit-1.0.1.BUILD")
    )

    _new_http_archive(
        name = "raze__pest__2_1_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest/pest-2.1.0.crate",
        type = "tar.gz",
        sha256 = "54f0c72a98d8ab3c99560bfd16df8059cc10e1f9a8e83e6e3b97718dd766e9c3",
        strip_prefix = "pest-2.1.0",
        build_file = Label("//third-party/cargo/remote:pest-2.1.0.BUILD")
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
        name = "raze__pest_generator__2_1_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest_generator/pest_generator-2.1.0.crate",
        type = "tar.gz",
        sha256 = "63120576c4efd69615b5537d3d052257328a4ca82876771d6944424ccfd9f646",
        strip_prefix = "pest_generator-2.1.0",
        build_file = Label("//third-party/cargo/remote:pest_generator-2.1.0.BUILD")
    )

    _new_http_archive(
        name = "raze__pest_meta__2_1_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/pest_meta/pest_meta-2.1.0.crate",
        type = "tar.gz",
        sha256 = "f5a3492a4ed208ffc247adcdcc7ba2a95be3104f58877d0d02f0df39bf3efb5e",
        strip_prefix = "pest_meta-2.1.0",
        build_file = Label("//third-party/cargo/remote:pest_meta-2.1.0.BUILD")
    )

    _new_http_archive(
        name = "raze__proc_macro2__0_4_27",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/proc-macro2/proc-macro2-0.4.27.crate",
        type = "tar.gz",
        sha256 = "4d317f9caece796be1980837fd5cb3dfec5613ebdb04ad0956deea83ce168915",
        strip_prefix = "proc-macro2-0.4.27",
        build_file = Label("//third-party/cargo/remote:proc-macro2-0.4.27.BUILD")
    )

    _new_http_archive(
        name = "raze__quote__0_6_11",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/quote/quote-0.6.11.crate",
        type = "tar.gz",
        sha256 = "cdd8e04bd9c52e0342b406469d494fcb033be4bdbe5c606016defbb1681411e1",
        strip_prefix = "quote-0.6.11",
        build_file = Label("//third-party/cargo/remote:quote-0.6.11.BUILD")
    )

    _new_http_archive(
        name = "raze__redox_syscall__0_1_51",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/redox_syscall/redox_syscall-0.1.51.crate",
        type = "tar.gz",
        sha256 = "423e376fffca3dfa06c9e9790a9ccd282fafb3cc6e6397d01dbf64f9bacc6b85",
        strip_prefix = "redox_syscall-0.1.51",
        build_file = Label("//third-party/cargo/remote:redox_syscall-0.1.51.BUILD")
    )

    _new_http_archive(
        name = "raze__redox_termios__0_1_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/redox_termios/redox_termios-0.1.1.crate",
        type = "tar.gz",
        sha256 = "7e891cfe48e9100a70a3b6eb652fef28920c117d366339687bd5576160db0f76",
        strip_prefix = "redox_termios-0.1.1",
        build_file = Label("//third-party/cargo/remote:redox_termios-0.1.1.BUILD")
    )

    _new_http_archive(
        name = "raze__sha_1__0_7_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/sha-1/sha-1-0.7.0.crate",
        type = "tar.gz",
        sha256 = "51b9d1f3b5de8a167ab06834a7c883bd197f2191e1dda1a22d9ccfeedbf9aded",
        strip_prefix = "sha-1-0.7.0",
        build_file = Label("//third-party/cargo/remote:sha-1-0.7.0.BUILD")
    )

    _new_http_archive(
        name = "raze__strsim__0_7_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/strsim/strsim-0.7.0.crate",
        type = "tar.gz",
        sha256 = "bb4f380125926a99e52bc279241539c018323fab05ad6368b56f93d9369ff550",
        strip_prefix = "strsim-0.7.0",
        build_file = Label("//third-party/cargo/remote:strsim-0.7.0.BUILD")
    )

    _new_http_archive(
        name = "raze__syn__0_15_29",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/syn/syn-0.15.29.crate",
        type = "tar.gz",
        sha256 = "1825685f977249735d510a242a6727b46efe914bb67e38d30c071b1b72b1d5c2",
        strip_prefix = "syn-0.15.29",
        build_file = Label("//third-party/cargo/remote:syn-0.15.29.BUILD")
    )

    _new_http_archive(
        name = "raze__termion__1_5_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/termion/termion-1.5.1.crate",
        type = "tar.gz",
        sha256 = "689a3bdfaab439fd92bc87df5c4c78417d3cbe537487274e9b0b2dce76e92096",
        strip_prefix = "termion-1.5.1",
        build_file = Label("//third-party/cargo/remote:termion-1.5.1.BUILD")
    )

    _new_http_archive(
        name = "raze__textwrap__0_10_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/textwrap/textwrap-0.10.0.crate",
        type = "tar.gz",
        sha256 = "307686869c93e71f94da64286f9a9524c0f308a9e1c87a583de8e9c9039ad3f6",
        strip_prefix = "textwrap-0.10.0",
        build_file = Label("//third-party/cargo/remote:textwrap-0.10.0.BUILD")
    )

    _new_http_archive(
        name = "raze__typenum__1_10_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/typenum/typenum-1.10.0.crate",
        type = "tar.gz",
        sha256 = "612d636f949607bdf9b123b4a6f6d966dedf3ff669f7f045890d3a4a73948169",
        strip_prefix = "typenum-1.10.0",
        build_file = Label("//third-party/cargo/remote:typenum-1.10.0.BUILD")
    )

    _new_http_archive(
        name = "raze__ucd_trie__0_1_1",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/ucd-trie/ucd-trie-0.1.1.crate",
        type = "tar.gz",
        sha256 = "71a9c5b1fe77426cf144cc30e49e955270f5086e31a6441dfa8b32efc09b9d77",
        strip_prefix = "ucd-trie-0.1.1",
        build_file = Label("//third-party/cargo/remote:ucd-trie-0.1.1.BUILD")
    )

    _new_http_archive(
        name = "raze__unicode_width__0_1_5",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/unicode-width/unicode-width-0.1.5.crate",
        type = "tar.gz",
        sha256 = "882386231c45df4700b275c7ff55b6f3698780a650026380e72dabe76fa46526",
        strip_prefix = "unicode-width-0.1.5",
        build_file = Label("//third-party/cargo/remote:unicode-width-0.1.5.BUILD")
    )

    _new_http_archive(
        name = "raze__unicode_xid__0_1_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/unicode-xid/unicode-xid-0.1.0.crate",
        type = "tar.gz",
        sha256 = "fc72304796d0818e357ead4e000d19c9c174ab23dc11093ac919054d20a6a7fc",
        strip_prefix = "unicode-xid-0.1.0",
        build_file = Label("//third-party/cargo/remote:unicode-xid-0.1.0.BUILD")
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
        name = "raze__winapi__0_3_6",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi/winapi-0.3.6.crate",
        type = "tar.gz",
        sha256 = "92c1eb33641e276cfa214a0522acad57be5c56b10cb348b3c5117db75f3ac4b0",
        strip_prefix = "winapi-0.3.6",
        build_file = Label("//third-party/cargo/remote:winapi-0.3.6.BUILD")
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
        name = "raze__winapi_x86_64_pc_windows_gnu__0_4_0",
        url = "https://crates-io.s3-us-west-1.amazonaws.com/crates/winapi-x86_64-pc-windows-gnu/winapi-x86_64-pc-windows-gnu-0.4.0.crate",
        type = "tar.gz",
        sha256 = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f",
        strip_prefix = "winapi-x86_64-pc-windows-gnu-0.4.0",
        build_file = Label("//third-party/cargo/remote:winapi-x86_64-pc-windows-gnu-0.4.0.BUILD")
    )

