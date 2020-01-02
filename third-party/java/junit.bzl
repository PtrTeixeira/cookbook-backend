"""External dependencies & java_junit5_test rule"""
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test")
load("@rules_jvm_external//:defs.bzl", "maven_install")

JUNIT_JUPITER_GROUP_ID = "org.junit.jupiter"
JUNIT_JUPITER_ARTIFACT_ID_LIST = [
    "junit-jupiter-api",
    "junit-jupiter-engine",
    "junit-jupiter-params",
]

JUNIT_PLATFORM_GROUP_ID = "org.junit.platform"
JUNIT_PLATFORM_ARTIFACT_ID_LIST = [
    "junit-platform-commons",
    "junit-platform-console",
    "junit-platform-engine",
    "junit-platform-launcher",
    "junit-platform-suite-api",
]

JUNIT_EXTRA_DEPENDENCIES = [
    ("org.apiguardian", "apiguardian-api", "1.0.0"),
    ("org.opentest4j", "opentest4j", "1.1.1"),
]

def junit_jupiter_java_repositories(version = "5.5.2"):
    """Imports dependencies for JUnit Jupiter"""
    artifacts = [
        "%s:%s:%s" % (JUNIT_JUPITER_GROUP_ID, artifact, version)
        for artifact in JUNIT_JUPITER_ARTIFACT_ID_LIST
    ] + [
        "%s:%s:%s" % artifact
        for artifact in JUNIT_EXTRA_DEPENDENCIES
    ]

    maven_install(
        name = "junit_jupiter",
        artifacts = artifacts,
        repositories = [
            "https://jcenter.bintray.com/",
            "https://repo1.maven.org/maven2",
        ]
    )

def junit_platform_java_repositories(version = "1.5.2"):
    artifacts = [
        "%s:%s:%s" % (JUNIT_PLATFORM_GROUP_ID, artifact, version)
        for artifact in JUNIT_PLATFORM_ARTIFACT_ID_LIST
    ]

    maven_install(
        name = "junit_platform",
        artifacts = artifacts,
        repositories = [
            "https://jcenter.bintray.com/",
            "https://repo1.maven.org/maven2",
        ],
        strict_visibility = True,
    )

def java_junit5_test(name, srcs, test_class = None, deps = [], runtime_deps = [], **kwargs):
    FILTER_KWARGS = [
        "main_class",
        "use_testrunner",
        "args",
    ]

    for arg in FILTER_KWARGS:
        if arg in kwargs.keys():
            kwargs.pop(arg)

    junit_console_args = []
    if test_class:
        junit_console_args += ["--select-class", test_class]
    else:
        fail("must specific 'test_class'")

    native.java_test(
        name = name,
        srcs = srcs,
        use_testrunner = False,
        main_class = "org.junit.platform.console.ConsoleLauncher",
        args = junit_console_args,
        deps = deps + [
            "@junit_jupiter//:%s" % _format_maven_jar_name(JUNIT_JUPITER_GROUP_ID, artifact_id)
            for artifact_id in JUNIT_JUPITER_ARTIFACT_ID_LIST
        ] + [
            "@junit_jupiter//:%s" % _format_maven_jar_name(it[0], it[1])
            for it in JUNIT_EXTRA_DEPENDENCIES
        ] + [
            "@junit_platform//:%s" % _format_maven_jar_name(JUNIT_PLATFORM_GROUP_ID, artifact)
            for artifact in ["junit-platform-suite-api"]
        ],
        runtime_deps = runtime_deps + [
            "@junit_platform//:%s" % _format_maven_jar_name(JUNIT_PLATFORM_GROUP_ID, artifact_id)
            for artifact_id in JUNIT_PLATFORM_ARTIFACT_ID_LIST
        ],
        **kwargs
    )

def kt_junit5_test(name, srcs, test_class = None, deps = [], runtime_deps = [], **kwargs):
    FILTER_KWARGS = [
        "main_class",
        "use_testrunner",
        "args",
    ]

    for arg in FILTER_KWARGS:
        if arg in kwargs.keys():
            kwargs.pop(arg)

    junit_console_args = []
    if test_class:
        junit_console_args += ["--select-class", test_class]
    else:
        fail("must specific 'test_class'")

    kt_jvm_test(
        name = name,
        srcs = srcs,
        # use_testrunner = False,
        main_class = "org.junit.platform.console.ConsoleLauncher",
        args = junit_console_args,
        deps = deps + [
            "@junit_jupiter//:%s" % _format_maven_jar_name(JUNIT_JUPITER_GROUP_ID, artifact_id)
            for artifact_id in JUNIT_JUPITER_ARTIFACT_ID_LIST
        ] + [
            "@junit_jupiter//:%s" % _format_maven_jar_name(it[0], it[1])
            for it in JUNIT_EXTRA_DEPENDENCIES
        ] + [
            "@junit_platform//:%s" % _format_maven_jar_name(JUNIT_PLATFORM_GROUP_ID, artifact)
            for artifact in ["junit-platform-suite-api"]
        ],
        runtime_deps = runtime_deps + [
            "@junit_platform//:%s" % _format_maven_jar_name(JUNIT_PLATFORM_GROUP_ID, artifact_id)
            for artifact_id in JUNIT_PLATFORM_ARTIFACT_ID_LIST
        ],
        **kwargs
    )

def _format_maven_jar_name(group_id, artifact_id):
    return ("%s_%s" % (group_id, artifact_id)).replace(".", "_").replace("-", "_")

def _format_maven_jar_dep_name(group_id, artifact_id):
    return "@%s//jar" % _format_maven_jar_name(group_id, artifact_id)
