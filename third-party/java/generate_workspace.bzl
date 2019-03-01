# The following dependencies were calculated from:
#
# generate_workspace --artifact com.squareup.retrofit2:retrofit:2.4.0 --artifact io.projectreactor:reactor-core:3.2.2.RELEASE --artifact com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7 --artifact com.fasterxml.jackson.core:jackson-annotations:2.9.7 --artifact com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7 --artifact org.mockito:mockito-core:2.23.0 --artifact io.projectreactor:reactor-test:3.2.2.RELEASE --artifact org.assertj:assertj-core:3.11.1 --artifact org.reactivestreams:reactive-streams:1.0.2 --repositories=https://jcenter.bintray.com


def generated_maven_jars():
  # org.mockito:mockito-core:jar:2.23.0
  native.maven_jar(
      name = "net_bytebuddy_byte_buddy_agent",
      artifact = "net.bytebuddy:byte-buddy-agent:1.9.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "37b5703b4a6290be3fffc63ae9c6bcaaee0ff856",
  )


  native.maven_jar(
      name = "org_mockito_mockito_core",
      artifact = "org.mockito:mockito-core:2.23.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "497ddb32fd5d01f9dbe99a2ec790aeb931dff1b1",
  )


  native.maven_jar(
      name = "com_fasterxml_jackson_module_jackson_module_kotlin",
      artifact = "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7",
      repository = "https://jcenter.bintray.com/",
      sha1 = "9ec9b84e8af4c4f31efcbc5c21e34da8021419f1",
  )


  native.maven_jar(
      name = "io_projectreactor_reactor_test",
      artifact = "io.projectreactor:reactor-test:3.2.2.RELEASE",
      repository = "https://jcenter.bintray.com/",
      sha1 = "76df94de42ea811707ab77ad39408b9bc4cc2403",
  )


  native.maven_jar(
      name = "org_reactivestreams_reactive_streams",
      artifact = "org.reactivestreams:reactive-streams:1.0.2",
      repository = "https://jcenter.bintray.com/",
      sha1 = "323964c36556eb0e6209f65c1cef72b53b461ab8",
  )


  native.maven_jar(
      name = "com_squareup_retrofit2_retrofit",
      artifact = "com.squareup.retrofit2:retrofit:2.4.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "fc4aa382632bfaa7be7b41579efba41d5a71ecf3",
  )


  # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7 wanted version 2.9.0
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_annotations",
      artifact = "com.fasterxml.jackson.core:jackson-annotations:2.9.7",
      sha1 = "4b838e5c4fc17ac02f3293e9a558bb781a51c46d",
  )


  # org.jetbrains.kotlin:kotlin-stdlib:jar:1.2.51
  native.maven_jar(
      name = "org_jetbrains_kotlin_kotlin_stdlib_common",
      artifact = "org.jetbrains.kotlin:kotlin-stdlib-common:1.2.51",
      repository = "https://jcenter.bintray.com/",
      sha1 = "e4a9d4b13ab19ed1e6531fce6df98e8cfa7f7301",
  )


  # com.squareup.retrofit2:retrofit:jar:2.4.0
  native.maven_jar(
      name = "com_squareup_okhttp3_okhttp",
      artifact = "com.squareup.okhttp3:okhttp:3.10.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "7ef0f1d95bf4c0b3ba30bbae25e0e562b05cf75e",
  )


  # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7
  native.maven_jar(
      name = "org_jetbrains_kotlin_kotlin_reflect",
      artifact = "org.jetbrains.kotlin:kotlin-reflect:1.2.51",
      repository = "https://jcenter.bintray.com/",
      sha1 = "36b719a7b84452dd13eeec979d8c82bfb765c57d",
  )


  native.maven_jar(
      name = "org_assertj_assertj_core",
      artifact = "org.assertj:assertj-core:3.11.1",
      repository = "https://jcenter.bintray.com/",
      sha1 = "fdac3217b804d6900fa3650f17b5cb48e620b140",
  )


  # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7 got requested version
  # com.fasterxml.jackson.datatype:jackson-datatype-jdk8:bundle:2.9.7
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_databind",
      artifact = "com.fasterxml.jackson.core:jackson-databind:2.9.7",
      repository = "https://jcenter.bintray.com/",
      sha1 = "e6faad47abd3179666e89068485a1b88a195ceb7",
  )


  native.maven_jar(
      name = "com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
      artifact = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7",
      repository = "https://jcenter.bintray.com/",
      sha1 = "98d8f190db07f97c64c0ea3af5792f718a6c2cc1",
  )


  # com.squareup.okhttp3:okhttp:jar:3.10.0
  native.maven_jar(
      name = "com_squareup_okio_okio",
      artifact = "com.squareup.okio:okio:1.14.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "102d7be47241d781ef95f1581d414b0943053130",
  )


  # org.jetbrains.kotlin:kotlin-reflect:jar:1.2.51
  native.maven_jar(
      name = "org_jetbrains_kotlin_kotlin_stdlib",
      artifact = "org.jetbrains.kotlin:kotlin-stdlib:1.2.51",
      repository = "https://jcenter.bintray.com/",
      sha1 = "fa8127e505bff50fec291d0dd619d1bda5c619e0",
  )


  # org.mockito:mockito-core:jar:2.23.0
  native.maven_jar(
      name = "net_bytebuddy_byte_buddy",
      artifact = "net.bytebuddy:byte-buddy:1.9.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "8cb0d5baae526c9df46ae17693bbba302640538b",
  )


  # org.mockito:mockito-core:jar:2.23.0
  native.maven_jar(
      name = "org_objenesis_objenesis",
      artifact = "org.objenesis:objenesis:2.6",
      repository = "https://jcenter.bintray.com/",
      sha1 = "639033469776fd37c08358c6b92a4761feb2af4b",
  )


  # com.fasterxml.jackson.datatype:jackson-datatype-jdk8:bundle:2.9.7
  # com.fasterxml.jackson.core:jackson-databind:bundle:2.9.7 got requested version
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_core",
      artifact = "com.fasterxml.jackson.core:jackson-core:2.9.7",
      repository = "https://jcenter.bintray.com/",
      sha1 = "4b7f0e0dc527fab032e9800ed231080fdc3ac015",
  )


  # io.projectreactor:reactor-test:jar:3.2.2.RELEASE got requested version
  native.maven_jar(
      name = "io_projectreactor_reactor_core",
      artifact = "io.projectreactor:reactor-core:3.2.2.RELEASE",
      repository = "https://jcenter.bintray.com/",
      sha1 = "b4202ff3469c943b94c01eb5cefc9a1646e6f151",
  )


  # org.jetbrains.kotlin:kotlin-stdlib:jar:1.2.51
  native.maven_jar(
      name = "org_jetbrains_annotations",
      artifact = "org.jetbrains:annotations:13.0",
      repository = "https://jcenter.bintray.com/",
      sha1 = "919f0dfe192fb4e063e7dacadee7f8bb9a2672a9",
  )




def generated_java_libraries():
  native.java_library(
      name = "net_bytebuddy_byte_buddy_agent",
      visibility = ["//visibility:public"],
      exports = ["@net_bytebuddy_byte_buddy_agent//jar"],
  )


  native.java_library(
      name = "org_mockito_mockito_core",
      visibility = ["//visibility:public"],
      exports = ["@org_mockito_mockito_core//jar"],
      runtime_deps = [
          ":net_bytebuddy_byte_buddy",
          ":net_bytebuddy_byte_buddy_agent",
          ":org_objenesis_objenesis",
      ],
  )


  native.java_library(
      name = "com_fasterxml_jackson_module_jackson_module_kotlin",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_module_jackson_module_kotlin//jar"],
      runtime_deps = [
          ":com_fasterxml_jackson_core_jackson_annotations",
          ":com_fasterxml_jackson_core_jackson_databind",
          ":org_jetbrains_annotations",
          ":org_jetbrains_kotlin_kotlin_reflect",
          ":org_jetbrains_kotlin_kotlin_stdlib",
          ":org_jetbrains_kotlin_kotlin_stdlib_common",
      ],
  )


  native.java_library(
      name = "io_projectreactor_reactor_test",
      visibility = ["//visibility:public"],
      exports = ["@io_projectreactor_reactor_test//jar"],
      runtime_deps = [
          ":io_projectreactor_reactor_core",
      ],
  )


  native.java_library(
      name = "org_reactivestreams_reactive_streams",
      visibility = ["//visibility:public"],
      exports = ["@org_reactivestreams_reactive_streams//jar"],
  )


  native.java_library(
      name = "com_squareup_retrofit2_retrofit",
      visibility = ["//visibility:public"],
      exports = ["@com_squareup_retrofit2_retrofit//jar"],
      runtime_deps = [
          ":com_squareup_okhttp3_okhttp",
          ":com_squareup_okio_okio",
      ],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_annotations//jar"],
  )


  native.java_library(
      name = "org_jetbrains_kotlin_kotlin_stdlib_common",
      visibility = ["//visibility:public"],
      exports = ["@org_jetbrains_kotlin_kotlin_stdlib_common//jar"],
  )


  native.java_library(
      name = "com_squareup_okhttp3_okhttp",
      visibility = ["//visibility:public"],
      exports = ["@com_squareup_okhttp3_okhttp//jar"],
      runtime_deps = [
          ":com_squareup_okio_okio",
      ],
  )


  native.java_library(
      name = "org_jetbrains_kotlin_kotlin_reflect",
      visibility = ["//visibility:public"],
      exports = ["@org_jetbrains_kotlin_kotlin_reflect//jar"],
      runtime_deps = [
          ":org_jetbrains_annotations",
          ":org_jetbrains_kotlin_kotlin_stdlib",
          ":org_jetbrains_kotlin_kotlin_stdlib_common",
      ],
  )


  native.java_library(
      name = "org_assertj_assertj_core",
      visibility = ["//visibility:public"],
      exports = ["@org_assertj_assertj_core//jar"],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_databind",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_databind//jar"],
      runtime_deps = [
          ":com_fasterxml_jackson_core_jackson_annotations",
          ":com_fasterxml_jackson_core_jackson_core",
      ],
  )


  native.java_library(
      name = "com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_datatype_jackson_datatype_jdk8//jar"],
      runtime_deps = [
          ":com_fasterxml_jackson_core_jackson_annotations",
          ":com_fasterxml_jackson_core_jackson_core",
          ":com_fasterxml_jackson_core_jackson_databind",
      ],
  )


  native.java_library(
      name = "com_squareup_okio_okio",
      visibility = ["//visibility:public"],
      exports = ["@com_squareup_okio_okio//jar"],
  )


  native.java_library(
      name = "org_jetbrains_kotlin_kotlin_stdlib",
      visibility = ["//visibility:public"],
      exports = ["@org_jetbrains_kotlin_kotlin_stdlib//jar"],
      runtime_deps = [
          ":org_jetbrains_annotations",
          ":org_jetbrains_kotlin_kotlin_stdlib_common",
      ],
  )


  native.java_library(
      name = "net_bytebuddy_byte_buddy",
      visibility = ["//visibility:public"],
      exports = ["@net_bytebuddy_byte_buddy//jar"],
  )


  native.java_library(
      name = "org_objenesis_objenesis",
      visibility = ["//visibility:public"],
      exports = ["@org_objenesis_objenesis//jar"],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_core",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_core//jar"],
  )


  native.java_library(
      name = "io_projectreactor_reactor_core",
      visibility = ["//visibility:public"],
      exports = ["@io_projectreactor_reactor_core//jar"],
      runtime_deps = [
          ":org_reactivestreams_reactive_streams",
      ],
  )


  native.java_library(
      name = "org_jetbrains_annotations",
      visibility = ["//visibility:public"],
      exports = ["@org_jetbrains_annotations//jar"],
  )


