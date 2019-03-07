# The following dependencies were calculated from:
#
# generate_workspace --artifact com.fasterxml.jackson.core:jackson-annotations:2.9.7 --artifact com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7 --artifact com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7 --artifact com.h2database:h2:1.4.197 --artifact com.squareup.retrofit2:retrofit:2.4.0 --artifact com.tylerkindy.com:dropwizard-dagger:0.1.0-alpha03 --artifact io.dropwizard:dropwizard-auth:1.3.5 --artifact io.dropwizard:dropwizard-core:1.3.5 --artifact io.dropwizard:dropwizard-jdbi3:1.3.5 --artifact io.dropwizard:dropwizard-logging:1.3.5 --artifact io.dropwizard:dropwizard-migrations:1.3.5 --artifact io.dropwizard:dropwizard-testing:1.3.5 --artifact io.projectreactor:reactor-core:3.2.2.RELEASE --artifact io.projectreactor:reactor-test:3.2.2.RELEASE --artifact io.sentry:sentry-logback:1.7.13 --artifact org.assertj:assertj-core:3.11.1 --artifact org.jdbi:jdbi3-kotlin:sqlobject:3.5.1 --artifact org.mockito:mockito-core:2.23.0 --artifact org.reactivestreams:reactive-streams:1.0.2 --repositories=https://jcenter.bintray.com --output_dir /home/teixeira/Documents/cookbook/third-party/java

def generated_maven_jars():
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "javax_annotation_javax_annotation_api",
        artifact = "javax.annotation:javax.annotation-api:1.2",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "479c1e06db31c432330183f5cae684163f186146",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "org_eclipse_jetty_toolchain_setuid_jetty_setuid_java",
        artifact = "org.eclipse.jetty.toolchain.setuid:jetty-setuid-java:1.0.3",
        repository = "https://jcenter.bintray.com/",
        sha1 = "73ae4ab171d396103f32e392970641e985d1a845",
    )

    # io.dropwizard:dropwizard-db:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-testing:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_dropwizard_core",
        artifact = "io.dropwizard:dropwizard-core:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "40ad5a0f6c01c99f23f9f44a021ca10af0e186bf",
    )

    # io.dropwizard:dropwizard-lifecycle:jar:1.3.5
    # io.dropwizard:dropwizard-jetty:jar:1.3.5 got requested version
    # org.eclipse.jetty:jetty-security:jar:9.4.11.v20180605 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_server",
        artifact = "org.eclipse.jetty:jetty-server:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "58353c2f27515b007fc83ae22002feb34fc24714",
    )

    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_logback",
        artifact = "io.dropwizard.metrics:metrics-logback:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "cf32cce38dc3c9f07273780fd3a0740c234686b8",
    )

    # org.hibernate:hibernate-validator:jar:5.4.2.Final
    native.maven_jar(
        name = "org_jboss_logging_jboss_logging",
        artifact = "org.jboss.logging:jboss-logging:3.3.0.Final",
        repository = "https://jcenter.bintray.com/",
        sha1 = "3616bb87707910296e2c195dc016287080bba5af",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-metrics:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_lifecycle",
        artifact = "io.dropwizard:dropwizard-lifecycle:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f2cb54711a5873d61c66a1ccacabfa73d55d4a1c",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5 got requested version
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

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "net_sourceforge_argparse4j_argparse4j",
        artifact = "net.sourceforge.argparse4j:argparse4j:0.8.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "2c8241f84acf6c924bd75be0dbd68e8d74fbcd70",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_module_jackson_module_afterburner",
        artifact = "com.fasterxml.jackson.module:jackson-module-afterburner:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8f864e3a2bb4da738d8cdc56f3825298bee8b943",
    )

    native.maven_jar(
        name = "io_sentry_sentry_logback",
        artifact = "io.sentry:sentry-logback:1.7.13",
        repository = "https://jcenter.bintray.com/",
        sha1 = "3d1f7d631f7c5f71c705f5ba6da6fc52bb3c8b8c",
    )

    native.maven_jar(
        name = "io_dropwizard_dropwizard_migrations",
        artifact = "io.dropwizard:dropwizard-migrations:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a25fd27d6bda57a6f109ed59c30d305d03bcf8e2",
    )

    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 got requested version
    # org.hibernate:hibernate-validator:jar:5.4.2.Final
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    native.maven_jar(
        name = "javax_validation_validation_api",
        artifact = "javax.validation:validation-api:1.1.0.Final",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8613ae82954779d518631e05daa73a6a954817d5",
    )

    # org.jdbi:jdbi3-core:jar:3.2.1
    native.maven_jar(
        name = "org_antlr_antlr_runtime",
        artifact = "org.antlr:antlr-runtime:3.4",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8f011408269a8e42b8548687e137d8eeb56df4b4",
    )

    # io.dropwizard:dropwizard-jetty:jar:1.3.5
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_servlets",
        artifact = "org.eclipse.jetty:jetty-servlets:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8301f94a8b8e4a8ed7c065984b18c02c4206b920",
    )

    native.maven_jar(
        name = "io_dropwizard_dropwizard_jdbi3",
        artifact = "io.dropwizard:dropwizard-jdbi3:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "1575291199a884e746e6bc5e4d57b2b9f7806adf",
    )

    # org.eclipse.jetty:jetty-webapp:jar:9.4.11.v20180605
    # io.dropwizard:dropwizard-jetty:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_servlet",
        artifact = "org.eclipse.jetty:jetty-servlet:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "66d31900fcfc70e3666f0b3335b6660635154f98",
    )

    # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-jdk8:bundle:2.9.7
    # com.fasterxml.jackson.module:jackson-module-parameter-names:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.module:jackson-module-jaxb-annotations:bundle:2.9.7 got requested version
    # io.dropwizard:dropwizard-jackson:jar:1.3.5 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-joda:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-jsr310:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.jaxrs:jackson-jaxrs-base:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-guava:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.module:jackson-module-afterburner:bundle:2.9.7 got requested version
    native.maven_jar(
        name = "com_fasterxml_jackson_core_jackson_databind",
        artifact = "com.fasterxml.jackson.core:jackson-databind:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "e6faad47abd3179666e89068485a1b88a195ceb7",
    )

    # io.dropwizard:dropwizard-configuration:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
        artifact = "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a428edc4bb34a2da98a50eb759c26941d4e85960",
    )

    # org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-inmemory:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_jersey_core_jersey_client",
        artifact = "org.glassfish.jersey.core:jersey-client:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "4d563b1f93352ee9fad597e9e1daf2c6159993c6",
    )

    native.maven_jar(
        name = "org_jdbi_jdbi3_kotlin",
        artifact = "org.jdbi:jdbi3-kotlin:3.5.1",
        repository = "https://jcenter.bintray.com/",
    )

    native.maven_jar(
        name = "org_jdbi_jdbi3_kotlin_sqlobject",
        artifact = "org.jdbi:jdbi3-kotlin-sqlobject:3.5.1",
        repository = "https://jcenter.bintray.com/",
    )

    # com.fasterxml.jackson.datatype:jackson-datatype-jdk8:bundle:2.9.7
    # com.fasterxml.jackson.module:jackson-module-parameter-names:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.module:jackson-module-jaxb-annotations:bundle:2.9.7 got requested version
    # io.dropwizard:dropwizard-jackson:jar:1.3.5 got requested version
    # com.fasterxml.jackson.core:jackson-databind:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-joda:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-jsr310:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.jaxrs:jackson-jaxrs-base:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.datatype:jackson-datatype-guava:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:bundle:2.9.7 got requested version
    # com.fasterxml.jackson.module:jackson-module-afterburner:bundle:2.9.7 got requested version
    # io.sentry:sentry:jar:1.7.13 wanted version 2.8.7
    native.maven_jar(
        name = "com_fasterxml_jackson_core_jackson_core",
        artifact = "com.fasterxml.jackson.core:jackson-core:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "4b7f0e0dc527fab032e9800ed231080fdc3ac015",
    )

    # org.glassfish.jersey.core:jersey-server:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_jersey_media_jersey_media_jaxb",
        artifact = "org.glassfish.jersey.media:jersey-media-jaxb:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "0d7da0beeed5614a3bfd882662faec602699e24b",
    )

    # io.dropwizard:dropwizard-migrations:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_db",
        artifact = "io.dropwizard:dropwizard-db:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "80a9db60bd85ff1389c1e1058a4eed1e8f4ac042",
    )

    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "org_jdbi_jdbi3_sqlobject",
        artifact = "org.jdbi:jdbi3-sqlobject:3.2.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8640d20c9fcfe5200f18c77972945cb6a7b25461",
    )

    # io.dropwizard:dropwizard-servlets:jar:1.3.5 got requested version
    # io.sentry:sentry-logback:jar:1.7.13 wanted version 1.2.1
    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # org.liquibase:liquibase-core:jar:3.6.1 got requested version
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "ch_qos_logback_logback_classic",
        artifact = "ch.qos.logback:logback-classic:1.2.3",
        repository = "https://jcenter.bintray.com/",
        sha1 = "7c4f3c474fb2c041d8028740440937705ebb473a",
    )

    # org.mockito:mockito-core:jar:2.23.0
    native.maven_jar(
        name = "net_bytebuddy_byte_buddy_agent",
        artifact = "net.bytebuddy:byte-buddy-agent:1.9.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "37b5703b4a6290be3fffc63ae9c6bcaaee0ff856",
    )

    native.maven_jar(
        name = "io_projectreactor_reactor_test",
        artifact = "io.projectreactor:reactor-test:3.2.2.RELEASE",
        repository = "https://jcenter.bintray.com/",
        sha1 = "76df94de42ea811707ab77ad39408b9bc4cc2403",
    )

    native.maven_jar(
        name = "com_squareup_retrofit2_retrofit",
        artifact = "com.squareup.retrofit2:retrofit:2.4.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "fc4aa382632bfaa7be7b41579efba41d5a71ecf3",
    )

    # org.eclipse.jetty:jetty-http:jar:9.4.11.v20180605
    # org.eclipse.jetty:jetty-servlets:jar:9.4.11.v20180605 got requested version
    # org.eclipse.jetty:jetty-server:jar:9.4.11.v20180605 got requested version
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_io",
        artifact = "org.eclipse.jetty:jetty-io:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "d164de1dac18c4ca80a1b783d879c97449909c3b",
    )

    # com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:bundle:2.9.7
    native.maven_jar(
        name = "com_fasterxml_jackson_module_jackson_module_jaxb_annotations",
        artifact = "com.fasterxml.jackson.module:jackson-module-jaxb-annotations:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "2774b8e960697678ca87cf54abd59c736fcd1e83",
    )

    # org.jdbi:jdbi3-core:jar:3.2.1
    native.maven_jar(
        name = "net_jodah_expiringmap",
        artifact = "net.jodah:expiringmap:0.5.6",
        repository = "https://jcenter.bintray.com/",
        sha1 = "11833abbdd64050d455187f374dc096944f9ffb0",
    )

    native.maven_jar(
        name = "io_dropwizard_dropwizard_testing",
        artifact = "io.dropwizard:dropwizard-testing:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "ffaf14f389b95c0bfde5df2a586630cbd7978c4b",
    )

    # io.sentry:sentry-logback:jar:1.7.13 wanted version 1.2.1
    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # ch.qos.logback:logback-classic:jar:1.2.3 got requested version
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    # ch.qos.logback:logback-access:jar:1.2.3 got requested version
    native.maven_jar(
        name = "ch_qos_logback_logback_core",
        artifact = "ch.qos.logback:logback-core:1.2.3",
        repository = "https://jcenter.bintray.com/",
        sha1 = "864344400c3d4d92dfeb0a305dc87d953677c03c",
    )

    # org.mockito:mockito-core:jar:2.23.0
    native.maven_jar(
        name = "net_bytebuddy_byte_buddy",
        artifact = "net.bytebuddy:byte-buddy:1.9.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "8cb0d5baae526c9df46ae17693bbba302640538b",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_module_jackson_module_parameter_names",
        artifact = "com.fasterxml.jackson.module:jackson-module-parameter-names:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f2bdd7696beffa2dbc5dc62cd24c3906a40ffcff",
    )

    # org.glassfish.jersey.containers:jersey-container-servlet:jar:2.25.1
    # org.glassfish.jersey.test-framework:jersey-test-framework-core:jar:2.25.1 got requested version
    native.maven_jar(
        name = "org_glassfish_jersey_containers_jersey_container_servlet_core",
        artifact = "org.glassfish.jersey.containers:jersey-container-servlet-core:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "400e30bb035a0cdf3c554530224141ce659a0d1e",
    )

    # org.glassfish.jersey.containers:jersey-container-servlet:jar:2.25.1 got requested version
    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 got requested version
    # org.glassfish.jersey.ext:jersey-metainf-services:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-client:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    # org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "javax_ws_rs_javax_ws_rs_api",
        artifact = "javax.ws.rs:javax.ws.rs-api:2.0.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "104e9c2b5583cfcfeac0402316221648d6d8ea6b",
    )

    # org.glassfish.jersey.media:jersey-media-jaxb:jar:2.25.1 got requested version
    # org.glassfish.hk2:hk2-locator:jar:2.5.0-b32 got requested version
    # org.glassfish.jersey.core:jersey-client:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_hk2_hk2_api",
        artifact = "org.glassfish.hk2:hk2-api:2.5.0-b32",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "6a576c9653832ce610b80a2f389374ef19d96171",
    )

    # io.projectreactor:reactor-test:jar:3.2.2.RELEASE got requested version
    native.maven_jar(
        name = "io_projectreactor_reactor_core",
        artifact = "io.projectreactor:reactor-core:3.2.2.RELEASE",
        repository = "https://jcenter.bintray.com/",
        sha1 = "b4202ff3469c943b94c01eb5cefc9a1646e6f151",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_jaxrs_jackson_jaxrs_json_provider",
        artifact = "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "134f1518a9516be01b25526a935d4fd68610b89c",
    )

    # com.google.guava:guava:bundle:24.0-jre
    native.maven_jar(
        name = "org_codehaus_mojo_animal_sniffer_annotations",
        artifact = "org.codehaus.mojo:animal-sniffer-annotations:1.14",
        repository = "https://jcenter.bintray.com/",
        sha1 = "775b7e22fb10026eed3f86e8dc556dfafe35f2d5",
    )

    # org.slf4j:jcl-over-slf4j:jar:1.7.25 got requested version
    # io.dropwizard:dropwizard-servlets:jar:1.3.5 got requested version
    # org.slf4j:log4j-over-slf4j:jar:1.7.25 got requested version
    # io.dropwizard:dropwizard-validation:jar:1.3.5 got requested version
    # org.liquibase:liquibase-core:jar:3.6.1 got requested version
    # io.dropwizard:dropwizard-lifecycle:jar:1.3.5 got requested version
    # io.sentry:sentry-logback:jar:1.7.13 wanted version 1.7.24
    # io.sentry:sentry:jar:1.7.13 wanted version 1.7.24
    # io.dropwizard:dropwizard-metrics:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    # org.jdbi:jdbi3-core:jar:3.2.1 got requested version
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    # org.slf4j:jul-to-slf4j:jar:1.7.25 got requested version
    native.maven_jar(
        name = "org_slf4j_slf4j_api",
        artifact = "org.slf4j:slf4j-api:1.7.25",
        repository = "https://jcenter.bintray.com/",
        sha1 = "da76ca59f6a57ee3102f8f9bd9cee742973efa8a",
    )

    # org.glassfish.jersey.containers:jersey-container-servlet:jar:2.25.1 got requested version
    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 got requested version
    # org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-inmemory:jar:2.25.1 got requested version
    # org.glassfish.jersey.test-framework:jersey-test-framework-core:jar:2.25.1 got requested version
    # org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.25.1 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_jersey_core_jersey_server",
        artifact = "org.glassfish.jersey.core:jersey-server:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "276e2ee0fd1cdabf99357fce560c5baab675b1a2",
    )

    # io.dropwizard:dropwizard-migrations:jar:1.3.5
    native.maven_jar(
        name = "org_liquibase_liquibase_core",
        artifact = "org.liquibase:liquibase-core:3.6.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "0b0b362a2e5f478a4ab549ae90e9b36dadf5f84b",
    )

    native.maven_jar(
        name = "com_fasterxml_jackson_module_jackson_module_kotlin",
        artifact = "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "9ec9b84e8af4c4f31efcbc5c21e34da8021419f1",
    )

    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 got requested version
    # org.glassfish.jersey.media:jersey-media-jaxb:jar:2.25.1 got requested version
    # org.glassfish.hk2:hk2-locator:jar:2.5.0-b32 got requested version
    # org.glassfish.jersey.core:jersey-client:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    # org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_hk2_external_javax_inject",
        artifact = "org.glassfish.hk2.external:javax.inject:2.5.0-b32",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "b2fa50c8186a38728c35fe6a9da57ce4cc806923",
    )

    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_slf4j_jcl_over_slf4j",
        artifact = "org.slf4j:jcl-over-slf4j:1.7.25",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f8c32b13ff142a513eeb5b6330b1588dcb2c0461",
    )

    # io.dropwizard:dropwizard-util:jar:1.3.5 wanted version 2.9.0
    # io.dropwizard:dropwizard-jackson:jar:1.3.5 wanted version 2.9.0
    # com.fasterxml.jackson.datatype:jackson-datatype-jsr310:bundle:2.9.7 wanted version 2.9.0
    # com.fasterxml.jackson.core:jackson-databind:bundle:2.9.7 wanted version 2.9.0
    # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7 wanted version 2.9.0
    # com.fasterxml.jackson.datatype:jackson-datatype-joda:bundle:2.9.7 wanted version 2.9.0
    # com.fasterxml.jackson.module:jackson-module-jaxb-annotations:bundle:2.9.7 wanted version 2.9.0
    native.maven_jar(
        name = "com_fasterxml_jackson_core_jackson_annotations",
        artifact = "com.fasterxml.jackson.core:jackson-annotations:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "4b838e5c4fc17ac02f3293e9a558bb781a51c46d",
    )

    # io.dropwizard:dropwizard-jetty:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_jetty9",
        artifact = "io.dropwizard.metrics:metrics-jetty9:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a6982b28c8487c84a4322a97b08b2c18ffbd011b",
    )

    # com.squareup.retrofit2:retrofit:jar:2.4.0
    native.maven_jar(
        name = "com_squareup_okhttp3_okhttp",
        artifact = "com.squareup.okhttp3:okhttp:3.10.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "7ef0f1d95bf4c0b3ba30bbae25e0e562b05cf75e",
    )

    # io.dropwizard:dropwizard-jetty:jar:1.3.5 got requested version
    # org.eclipse.jetty:jetty-servlets:jar:9.4.11.v20180605 got requested version
    # org.eclipse.jetty:jetty-server:jar:9.4.11.v20180605
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_http",
        artifact = "org.eclipse.jetty:jetty-http:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "20c35f5336befe35b0bd5c4a63e07170fe7872d7",
    )

    # org.eclipse.jetty:jetty-server:jar:9.4.11.v20180605
    native.maven_jar(
        name = "javax_servlet_javax_servlet_api",
        artifact = "javax.servlet:javax.servlet-api:3.1.0",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "3cd63d075497751784b2fa84be59432f4905bf7c",
    )

    # org.jetbrains.kotlin:kotlin-reflect:jar:1.2.51
    # org.jdbi:jdbi3-kotlin:jar:3.2.1 wanted version 1.2.31
    native.maven_jar(
        name = "org_jetbrains_kotlin_kotlin_stdlib",
        artifact = "org.jetbrains.kotlin:kotlin-stdlib:1.2.51",
        repository = "https://jcenter.bintray.com/",
        sha1 = "fa8127e505bff50fec291d0dd619d1bda5c619e0",
    )

    # org.glassfish.jersey.media:jersey-media-jaxb:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_hk2_osgi_resource_locator",
        artifact = "org.glassfish.hk2:osgi-resource-locator:1.0.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "4ed2b2d4738aed5786cfa64cba5a332779c4c708",
    )

    native.maven_jar(
        name = "io_dropwizard_dropwizard_auth",
        artifact = "io.dropwizard:dropwizard-auth:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "7b0643f7b240d0e72556a0d178a38da99c65c7f6",
    )

    # org.jetbrains.kotlin:kotlin-stdlib:jar:1.2.51
    # org.jdbi:jdbi3-kotlin:jar:3.2.1 got requested version
    native.maven_jar(
        name = "org_jetbrains_annotations",
        artifact = "org.jetbrains:annotations:13.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "919f0dfe192fb4e063e7dacadee7f8bb9a2672a9",
    )

    # org.glassfish.jersey.containers:jersey-container-servlet:jar:2.25.1 got requested version
    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 got requested version
    # org.glassfish.jersey.media:jersey-media-jaxb:jar:2.25.1 got requested version
    # org.glassfish.jersey.ext:jersey-metainf-services:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-client:jar:2.25.1 got requested version
    # org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_jersey_core_jersey_common",
        artifact = "org.glassfish.jersey.core:jersey-common:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "2438ce68d4907046095ab54aa83a6092951b4bbb",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    # io.dropwizard.metrics:metrics-servlets:bundle:4.0.2 got requested version
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_jvm",
        artifact = "io.dropwizard.metrics:metrics-jvm:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "faddf0544d674db5b6515bf39ccf9ff23114cc6c",
    )

    # io.dropwizard:dropwizard-validation:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_javax_el",
        artifact = "org.glassfish:javax.el:3.0.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "dd532526e7c8de48e40419e6af1183658a973379",
    )

    # io.dropwizard.metrics:metrics-servlets:bundle:4.0.2
    native.maven_jar(
        name = "com_papertrail_profiler",
        artifact = "com.papertrail:profiler:1.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "138093a4ed2da6f0b07a2a2335584bd5a7d53bff",
    )

    native.maven_jar(
        name = "com_h2database_h2",
        artifact = "com.h2database:h2:1.4.197",
        repository = "https://jcenter.bintray.com/",
        sha1 = "bb391050048ca8ae3e32451b5a3714ecd3596a46",
    )

    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_slf4j_jul_to_slf4j",
        artifact = "org.slf4j:jul-to-slf4j:1.7.25",
        repository = "https://jcenter.bintray.com/",
        sha1 = "0af5364cd6679bfffb114f0dec8a157aaa283b76",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_jmx",
        artifact = "io.dropwizard.metrics:metrics-jmx:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "c8c14f6d66100a6b79f5d4b6de1d50ccc7f627fb",
    )

    native.maven_jar(
        name = "org_reactivestreams_reactive_streams",
        artifact = "org.reactivestreams:reactive-streams:1.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "323964c36556eb0e6209f65c1cef72b53b461ab8",
    )

    # io.dropwizard:dropwizard-configuration:jar:1.3.5
    native.maven_jar(
        name = "org_apache_commons_commons_text",
        artifact = "org.apache.commons:commons-text:1.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "74acdec7237f576c4803fff0c1008ab8a3808b2b",
    )

    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_slf4j_log4j_over_slf4j",
        artifact = "org.slf4j:log4j-over-slf4j:1.7.25",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a87bb47468f47ee7aabbd54f93e133d4215769c3",
    )

    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "org_jdbi_jdbi3_jodatime2",
        artifact = "org.jdbi:jdbi3-jodatime2:3.2.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "9d2c47762c6a1d0d8a393a636951966368735184",
    )

    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "org_jdbi_jdbi3_guava",
        artifact = "org.jdbi:jdbi3-guava:3.2.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "aefef686d308321ba968e009086b2effdbd6088f",
    )

    native.maven_jar(
        name = "org_assertj_assertj_core",
        artifact = "org.assertj:assertj-core:3.11.1",
        sha1 = "fdac3217b804d6900fa3650f17b5cb48e620b140",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    # io.dropwizard:dropwizard-request-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_dropwizard_jetty",
        artifact = "io.dropwizard:dropwizard-jetty:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "93aa2cf132822001128509e6fe166d26858de0dc",
    )

    # org.apache.tomcat:tomcat-jdbc:jar:9.0.5
    native.maven_jar(
        name = "org_apache_tomcat_tomcat_juli",
        artifact = "org.apache.tomcat:tomcat-juli:9.0.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "cc79b348b3129752e5349f1734e9782855ef1cde",
    )

    native.maven_jar(
        name = "io_dropwizard_dropwizard_logging",
        artifact = "io.dropwizard:dropwizard-logging:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "93f3ba6f08283ba160b0fe62372dcbff5484502c",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_datatype_jackson_datatype_jsr310",
        artifact = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "cbd919f1ce67533e07b98dd493247e8dbabc26b2",
    )

    # org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-inmemory:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_jersey_test_framework_jersey_test_framework_core",
        artifact = "org.glassfish.jersey.test-framework:jersey-test-framework-core:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "9368dc18933a8b9f2526c86ab310b02781969aa3",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard.metrics:metrics-servlets:bundle:4.0.2
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_healthchecks",
        artifact = "io.dropwizard.metrics:metrics-healthchecks:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "4474ff8903f780bd937ca74a02a7a77b31df0eed",
    )

    # org.glassfish.hk2:hk2-api:jar:2.5.0-b32
    # org.glassfish.hk2:hk2-locator:jar:2.5.0-b32 got requested version
    native.maven_jar(
        name = "org_glassfish_hk2_hk2_utils",
        artifact = "org.glassfish.hk2:hk2-utils:2.5.0-b32",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "5108a926988c4ceda7f1e681dddfe3101454a002",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_request_logging",
        artifact = "io.dropwizard:dropwizard-request-logging:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "c172ad955399e8cf1bf54069da740694a3a1fcf0",
    )

    # io.dropwizard:dropwizard-db:jar:1.3.5
    native.maven_jar(
        name = "org_apache_tomcat_tomcat_jdbc",
        artifact = "org.apache.tomcat:tomcat-jdbc:9.0.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a996164f369f439ff0d382aa6c6cf3fbc75c8bf0",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_jersey_ext_jersey_bean_validation",
        artifact = "org.glassfish.jersey.ext:jersey-bean-validation:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "01971927d79cad0ad2b5a3bfda24967748a2023d",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_servlets",
        artifact = "io.dropwizard:dropwizard-servlets:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "46da4fe77874c3df3a890537511ff66cf5223a55",
    )

    # io.dropwizard.metrics:metrics-jersey2:bundle:4.0.2
    # io.dropwizard:dropwizard-servlets:jar:1.3.5 got requested version
    # io.dropwizard.metrics:metrics-jdbi3:bundle:4.0.2 got requested version
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_annotation",
        artifact = "io.dropwizard.metrics:metrics-annotation:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "1b74e21120c2a22a5b8e319271afc642cff7bba0",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_datatype_jackson_datatype_guava",
        artifact = "com.fasterxml.jackson.datatype:jackson-datatype-guava:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "3fc843def28bb7b7f7fae414cc61b347ba89e5ce",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-configuration:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-metrics:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_dropwizard_validation",
        artifact = "io.dropwizard:dropwizard-validation:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "cfb1175de83ff9f7c9f35ae283b02dafe69f938b",
    )

    # org.glassfish.hk2:hk2-api:jar:2.5.0-b32
    # org.glassfish.hk2:hk2-locator:jar:2.5.0-b32 got requested version
    native.maven_jar(
        name = "org_glassfish_hk2_external_aopalliance_repackaged",
        artifact = "org.glassfish.hk2.external:aopalliance-repackaged:2.5.0-b32",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "6af37c3f8ec6f9e9653ec837eb508da28ce443cd",
    )

    # io.dropwizard:dropwizard-request-logging:jar:1.3.5
    native.maven_jar(
        name = "ch_qos_logback_logback_access",
        artifact = "ch.qos.logback:logback-access:1.2.3",
        repository = "https://jcenter.bintray.com/",
        sha1 = "e8a841cb796f6423c7afd8738df6e0e4052bf24a",
    )

    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_jersey_bundles_repackaged_jersey_guava",
        artifact = "org.glassfish.jersey.bundles.repackaged:jersey-guava:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "a2bb4f8208e134cf2cf71dfb8824e42942f7bd06",
    )

    # org.hibernate:hibernate-validator:jar:5.4.2.Final
    native.maven_jar(
        name = "com_fasterxml_classmate",
        artifact = "com.fasterxml:classmate:1.3.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "02ad2fd09dcf5607ca96f8ef432096a96986c40a",
    )

    # io.dropwizard.metrics:metrics-servlets:bundle:4.0.2
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_json",
        artifact = "io.dropwizard.metrics:metrics-json:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "ab9443bcdb2c102240119c6fecc45d7b6eb6ff9a",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_servlets",
        artifact = "io.dropwizard.metrics:metrics-servlets:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "eb02b345a0959c9dc4c48ee5f0c5d3a1e8eb26f6",
    )

    # org.glassfish.hk2:hk2-locator:jar:2.5.0-b32 wanted version 3.20.0-GA
    # io.dropwizard:dropwizard-validation:jar:1.3.5
    native.maven_jar(
        name = "org_javassist_javassist",
        artifact = "org.javassist:javassist:3.22.0-GA",
        repository = "https://jcenter.bintray.com/",
        sha1 = "3e83394258ae2089be7219b971ec21a8288528ad",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_jersey_containers_jersey_container_servlet",
        artifact = "org.glassfish.jersey.containers:jersey-container-servlet:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "cf5f7a76fcea38158b890ab7a0142d4db709a882",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_jersey_ext_jersey_metainf_services",
        artifact = "org.glassfish.jersey.ext:jersey-metainf-services:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "83376116af614791a26f51a93af1070520345782",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_webapp",
        artifact = "org.eclipse.jetty:jetty-webapp:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "5ce28eff8338cab2a0af0e583c769567542b9558",
    )

    # com.google.guava:guava:bundle:24.0-jre
    native.maven_jar(
        name = "com_google_j2objc_j2objc_annotations",
        artifact = "com.google.j2objc:j2objc-annotations:1.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "976d8d30bebc251db406f2bdb3eb01962b5685b3",
    )

    # io.dropwizard:dropwizard-util:jar:1.3.5
    # org.jdbi:jdbi3-jodatime2:jar:3.2.1 wanted version 2.9.3
    # com.papertrail:profiler:jar:1.0.2 wanted version 2.9.1
    # com.fasterxml.jackson.datatype:jackson-datatype-joda:bundle:2.9.7 wanted version 2.7
    native.maven_jar(
        name = "joda_time_joda_time",
        artifact = "joda-time:joda-time:2.9.9",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f7b520c458572890807d143670c9b24f4de90897",
    )

    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_jersey2",
        artifact = "io.dropwizard.metrics:metrics-jersey2:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "b42ebb1111114773a3fb4fefce6895e472d42b04",
    )

    # io.dropwizard:dropwizard-migrations:jar:1.3.5
    native.maven_jar(
        name = "com_mattbertolini_liquibase_slf4j",
        artifact = "com.mattbertolini:liquibase-slf4j:2.0.0",
        repository = "https://jcenter.bintray.com/",
        sha1 = "15d0d15b546ef66caf3385a3c13aeb75663b3ba4",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_metrics",
        artifact = "io.dropwizard:dropwizard-metrics:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "fa09277207fb377d00132c38c383a8be767d711a",
    )

    # org.glassfish.jersey.ext:jersey-bean-validation:jar:2.25.1 wanted version 5.1.3.Final
    # io.dropwizard:dropwizard-validation:jar:1.3.5
    native.maven_jar(
        name = "org_hibernate_hibernate_validator",
        artifact = "org.hibernate:hibernate-validator:5.4.2.Final",
        repository = "https://jcenter.bintray.com/",
        sha1 = "80d76bfdf5243c2e70ef16839708ca2d522ec21e",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-configuration:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-metrics:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_dropwizard_jackson",
        artifact = "io.dropwizard:dropwizard-jackson:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "367264d2342ab8abedc48c4cad4502fa1eeab1be",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-servlets:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-jackson:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-validation:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    # io.dropwizard:dropwizard-lifecycle:jar:1.3.5 got requested version
    native.maven_jar(
        name = "io_dropwizard_dropwizard_util",
        artifact = "io.dropwizard:dropwizard-util:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f33457e0be3c25d059f1307505f8377b73a966a4",
    )

    # io.dropwizard:dropwizard-logging:jar:1.3.5
    # org.eclipse.jetty:jetty-xml:jar:9.4.11.v20180605 got requested version
    # org.eclipse.jetty:jetty-http:jar:9.4.11.v20180605 got requested version
    # org.eclipse.jetty:jetty-io:jar:9.4.11.v20180605 got requested version
    # org.eclipse.jetty:jetty-servlets:jar:9.4.11.v20180605 got requested version
    # io.dropwizard:dropwizard-logging:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_util",
        artifact = "org.eclipse.jetty:jetty-util:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f0f25aa2f27d618a04bc7356fa247ae4a05245b3",
    )

    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_jdbi3",
        artifact = "io.dropwizard.metrics:metrics-jdbi3:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "a795b5404c1657a098fea1148d222e9acc80b374",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-servlets:jar:1.3.5 got requested version
    # io.dropwizard.metrics:metrics-json:bundle:4.0.2 got requested version
    # io.dropwizard:dropwizard-metrics:jar:1.3.5 got requested version
    # io.dropwizard.metrics:metrics-jmx:bundle:4.0.2 got requested version
    # io.dropwizard.metrics:metrics-logback:bundle:4.0.2
    # io.dropwizard.metrics:metrics-jvm:bundle:4.0.2 got requested version
    # io.dropwizard.metrics:metrics-jdbi3:bundle:4.0.2 got requested version
    # io.dropwizard.metrics:metrics-jersey2:bundle:4.0.2 got requested version
    # io.dropwizard.metrics:metrics-servlets:bundle:4.0.2 got requested version
    # io.dropwizard.metrics:metrics-jetty9:bundle:4.0.2 got requested version
    native.maven_jar(
        name = "io_dropwizard_metrics_metrics_core",
        artifact = "io.dropwizard.metrics:metrics-core:4.0.2",
        repository = "https://jcenter.bintray.com/",
        sha1 = "ec9878842d510cabd6bd6a9da1bebae1ae0cd199",
    )

    # org.antlr:antlr-runtime:jar:3.4
    native.maven_jar(
        name = "org_antlr_stringtemplate",
        artifact = "org.antlr:stringtemplate:3.2.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "59ec8083721eae215c6f3caee944c410d2be34de",
    )

    # io.dropwizard:dropwizard-testing:jar:1.3.5
    native.maven_jar(
        name = "org_glassfish_jersey_test_framework_providers_jersey_test_framework_provider_inmemory",
        artifact = "org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-inmemory:2.25.1",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "d0bf8edcb87a8e886cf4552e9b5b9a4fddc70794",
    )

    # com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:bundle:2.9.7
    native.maven_jar(
        name = "com_fasterxml_jackson_jaxrs_jackson_jaxrs_base",
        artifact = "com.fasterxml.jackson.jaxrs:jackson-jaxrs-base:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "0d7f607b3a12e6e92b2f29c721e03c11b638cc32",
    )

    # org.jdbi:jdbi3-jodatime2:jar:3.2.1 got requested version
    # org.jdbi:jdbi3-guava:jar:3.2.1 got requested version
    # org.jdbi:jdbi3-sqlobject:jar:3.2.1 got requested version
    # org.jdbi:jdbi3-kotlin:jar:3.2.1 got requested version
    # io.dropwizard:dropwizard-jdbi3:jar:1.3.5
    native.maven_jar(
        name = "org_jdbi_jdbi3_core",
        artifact = "org.jdbi:jdbi3-core:3.2.1",
        repository = "https://jcenter.bintray.com/",
        sha1 = "e3186a153582c3a1052679916f0f9c0ea1f251ab",
    )

    # org.jetbrains.kotlin:kotlin-stdlib:jar:1.2.51
    native.maven_jar(
        name = "org_jetbrains_kotlin_kotlin_stdlib_common",
        artifact = "org.jetbrains.kotlin:kotlin-stdlib-common:1.2.51",
        repository = "https://jcenter.bintray.com/",
        sha1 = "e4a9d4b13ab19ed1e6531fce6df98e8cfa7f7301",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_configuration",
        artifact = "io.dropwizard:dropwizard-configuration:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "f57b56139fb06f6c97491a9881a08764df139bf5",
    )

    # org.glassfish.jersey.media:jersey-media-jaxb:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-client:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-server:jar:2.25.1 got requested version
    # org.glassfish.jersey.core:jersey-common:jar:2.25.1
    native.maven_jar(
        name = "org_glassfish_hk2_hk2_locator",
        artifact = "org.glassfish.hk2:hk2-locator:2.5.0-b32",
        repository = "https://maven.java.net/content/repositories/releases/",
        sha1 = "195474f8ad0a8d130e9ea949a771bcf1215fc33b",
    )

    # org.jdbi:jdbi3-kotlin:jar:3.2.1 wanted version 1.2.31
    # com.fasterxml.jackson.module:jackson-module-kotlin:bundle:2.9.7
    native.maven_jar(
        name = "org_jetbrains_kotlin_kotlin_reflect",
        artifact = "org.jetbrains.kotlin:kotlin-reflect:1.2.51",
        repository = "https://jcenter.bintray.com/",
        sha1 = "36b719a7b84452dd13eeec979d8c82bfb765c57d",
    )

    # io.dropwizard:dropwizard-jackson:jar:1.3.5
    native.maven_jar(
        name = "com_fasterxml_jackson_datatype_jackson_datatype_joda",
        artifact = "com.fasterxml.jackson.datatype:jackson-datatype-joda:2.9.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "d9feae99faf03d5a9989be2225da3baa73ba43d4",
    )

    # org.eclipse.jetty:jetty-servlets:jar:9.4.11.v20180605 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_continuation",
        artifact = "org.eclipse.jetty:jetty-continuation:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "31f1e347d013356317164b86bbbc2a6ce5c5e871",
    )

    # io.dropwizard:dropwizard-configuration:jar:1.3.5
    # org.apache.commons:commons-text:jar:1.2 got requested version
    # io.dropwizard:dropwizard-jersey:jar:1.3.5 got requested version
    native.maven_jar(
        name = "org_apache_commons_commons_lang3",
        artifact = "org.apache.commons:commons-lang3:3.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "557edd918fd41f9260963583ebf5a61a43a6b423",
    )

    # org.eclipse.jetty:jetty-servlet:jar:9.4.11.v20180605
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_security",
        artifact = "org.eclipse.jetty:jetty-security:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "926def86d31ee07ca4b4658833dc6ee6918b8e86",
    )

    native.maven_jar(
        name = "com_tylerkindy_dropwizard_dagger",
        artifact = "com.tylerkindy:dropwizard-dagger:0.1.0-alpha03",
        repository = "https://jcenter.bintray.com/",
    )

    # org.eclipse.jetty:jetty-webapp:jar:9.4.11.v20180605
    native.maven_jar(
        name = "org_eclipse_jetty_jetty_xml",
        artifact = "org.eclipse.jetty:jetty-xml:9.4.11.v20180605",
        repository = "https://jcenter.bintray.com/",
        sha1 = "883cbf629ec797bd9d8833376a0feec461628f4f",
    )

    # com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:bundle:2.9.7
    native.maven_jar(
        name = "org_yaml_snakeyaml",
        artifact = "org.yaml:snakeyaml:1.23",
        repository = "https://jcenter.bintray.com/",
        sha1 = "ec62d74fe50689c28c0ff5b35d3aebcaa8b5be68",
    )

    # io.dropwizard:dropwizard-core:jar:1.3.5 got requested version
    # io.dropwizard:dropwizard-core:jar:1.3.5
    native.maven_jar(
        name = "io_dropwizard_dropwizard_jersey",
        artifact = "io.dropwizard:dropwizard-jersey:1.3.5",
        repository = "https://jcenter.bintray.com/",
        sha1 = "2941a8c5b66d3a05a6b5196b216c1fb8d224c32c",
    )

    # io.sentry:sentry-logback:jar:1.7.13
    native.maven_jar(
        name = "io_sentry_sentry",
        artifact = "io.sentry:sentry:1.7.13",
        repository = "https://jcenter.bintray.com/",
        sha1 = "9bf79607fe6bcf52f4ce62b985588f17b6cc9acd",
    )

    # org.antlr:antlr-runtime:jar:3.4 got requested version
    # org.antlr:stringtemplate:jar:3.2.1
    native.maven_jar(
        name = "antlr_antlr",
        artifact = "antlr:antlr:2.7.7",
        repository = "https://jcenter.bintray.com/",
        sha1 = "83cd2cd674a217ade95a4bb83a8a14f351f48bd0",
    )

def generated_java_libraries():
    native.java_library(
        name = "javax_annotation_javax_annotation_api",
        visibility = ["//visibility:public"],
        exports = ["@javax_annotation_javax_annotation_api//jar"],
    )

    native.java_library(
        name = "com_tylerkindy_dropwizard_dagger",
        visibility = ["//visibility:public"],
        exports = ["@com_tylerkindy_dropwizard_dagger//jar"],
    )

    native.java_library(
        name = "org_eclipse_jetty_toolchain_setuid_jetty_setuid_java",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_toolchain_setuid_jetty_setuid_java//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_core",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_core//jar"],
        runtime_deps = [
            ":io_dropwizard_dropwizard_configuration",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_jersey",
            ":io_dropwizard_dropwizard_jetty",
            ":io_dropwizard_dropwizard_lifecycle",
            ":io_dropwizard_dropwizard_logging",
            ":io_dropwizard_dropwizard_metrics",
            ":io_dropwizard_dropwizard_request_logging",
            ":io_dropwizard_dropwizard_servlets",
            ":io_dropwizard_dropwizard_util",
            ":io_dropwizard_dropwizard_validation",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_healthchecks",
            ":io_dropwizard_metrics_metrics_jmx",
            ":io_dropwizard_metrics_metrics_jvm",
            ":io_dropwizard_metrics_metrics_servlets",
            ":net_sourceforge_argparse4j_argparse4j",
            ":org_eclipse_jetty_toolchain_setuid_jetty_setuid_java",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_server",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_server//jar"],
        runtime_deps = [
            ":javax_servlet_javax_servlet_api",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_logback",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_logback//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "org_jboss_logging_jboss_logging",
        visibility = ["//visibility:public"],
        exports = ["@org_jboss_logging_jboss_logging//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_lifecycle",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_lifecycle//jar"],
        runtime_deps = [
            ":com_google_guava_guava",
            ":io_dropwizard_dropwizard_util",
            ":javax_servlet_javax_servlet_api",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_util",
            ":org_slf4j_slf4j_api",
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
        name = "net_sourceforge_argparse4j_argparse4j",
        visibility = ["//visibility:public"],
        exports = ["@net_sourceforge_argparse4j_argparse4j//jar"],
    )

    native.java_library(
        name = "com_fasterxml_jackson_module_jackson_module_afterburner",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_module_jackson_module_afterburner//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
        ],
    )

    native.java_library(
        name = "io_sentry_sentry_logback",
        visibility = ["//visibility:public"],
        exports = ["@io_sentry_sentry_logback//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_classic",
            ":ch_qos_logback_logback_core",
            ":com_fasterxml_jackson_core_jackson_core",
            ":io_sentry_sentry",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_migrations",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_migrations//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_classic",
            ":com_mattbertolini_liquibase_slf4j",
            ":io_dropwizard_dropwizard_db",
            ":org_liquibase_liquibase_core",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "javax_validation_validation_api",
        visibility = ["//visibility:public"],
        exports = ["@javax_validation_validation_api//jar"],
    )

    native.java_library(
        name = "org_antlr_antlr_runtime",
        visibility = ["//visibility:public"],
        exports = ["@org_antlr_antlr_runtime//jar"],
        runtime_deps = [
            ":antlr_antlr",
            ":org_antlr_stringtemplate",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_servlets",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_servlets//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_continuation",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_jdbi3",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_jdbi3//jar"],
        runtime_deps = [
            ":antlr_antlr",
            ":com_google_guava_guava",
            ":io_dropwizard_dropwizard_core",
            ":io_dropwizard_dropwizard_db",
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_jdbi3",
            ":joda_time_joda_time",
            ":net_jodah_expiringmap",
            ":org_antlr_antlr_runtime",
            ":org_antlr_stringtemplate",
            ":org_apache_tomcat_tomcat_jdbc",
            ":org_apache_tomcat_tomcat_juli",
            ":org_jdbi_jdbi3_core",
            ":org_jdbi_jdbi3_guava",
            ":org_jdbi_jdbi3_jodatime2",
            ":org_jdbi_jdbi3_sqlobject",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_servlet",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_servlet//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_security",
            ":org_eclipse_jetty_jetty_server",
        ],
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
        name = "com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_dataformat_jackson_dataformat_yaml//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":org_yaml_snakeyaml",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_core_jersey_client",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_core_jersey_client//jar"],
        runtime_deps = [
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_jersey_core_jersey_common",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_kotlin",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_kotlin//jar"],
        runtime_deps = [
            ":org_jdbi_jdbi3_core",
            ":org_jetbrains_annotations",
            ":org_jetbrains_kotlin_kotlin_reflect",
            ":org_jetbrains_kotlin_kotlin_stdlib",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_kotlin_sqlobject",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_kotlin_sqlobject//jar"],
        runtime_deps = [
            ":org_jdbi_jdbi3_core",
            ":org_jdbi_jdbi3_kotlin",
            ":org_jdbi_jdbi3_sqlobject",
            ":org_jetbrains_annotations",
            ":org_jetbrains_kotlin_kotlin_reflect",
            ":org_jetbrains_kotlin_kotlin_stdlib",
        ],
    )

    native.java_library(
        name = "com_fasterxml_jackson_core_jackson_core",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_core_jackson_core//jar"],
    )

    native.java_library(
        name = "org_glassfish_jersey_media_jersey_media_jaxb",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_media_jersey_media_jaxb//jar"],
        runtime_deps = [
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_hk2_osgi_resource_locator",
            ":org_glassfish_jersey_core_jersey_common",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_db",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_db//jar"],
        runtime_deps = [
            ":io_dropwizard_dropwizard_core",
            ":org_apache_tomcat_tomcat_jdbc",
            ":org_apache_tomcat_tomcat_juli",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_sqlobject",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_sqlobject//jar"],
        runtime_deps = [
            ":org_jdbi_jdbi3_core",
        ],
    )

    native.java_library(
        name = "ch_qos_logback_logback_classic",
        visibility = ["//visibility:public"],
        exports = ["@ch_qos_logback_logback_classic//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_core",
        ],
    )

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
        name = "io_projectreactor_reactor_test",
        visibility = ["//visibility:public"],
        exports = ["@io_projectreactor_reactor_test//jar"],
        runtime_deps = [
            ":io_projectreactor_reactor_core",
        ],
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
        name = "org_eclipse_jetty_jetty_io",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_io//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "com_fasterxml_jackson_module_jackson_module_jaxb_annotations",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_module_jackson_module_jaxb_annotations//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
        ],
    )

    native.java_library(
        name = "net_jodah_expiringmap",
        visibility = ["//visibility:public"],
        exports = ["@net_jodah_expiringmap//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_testing",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_testing//jar"],
        runtime_deps = [
            ":io_dropwizard_dropwizard_core",
            ":junit_junit",
            ":org_assertj_assertj_core",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_client",
            ":org_glassfish_jersey_core_jersey_server",
            ":org_glassfish_jersey_test_framework_jersey_test_framework_core",
            ":org_glassfish_jersey_test_framework_providers_jersey_test_framework_provider_inmemory",
            ":org_hamcrest_hamcrest_core",
            ":org_objenesis_objenesis",
        ],
    )

    native.java_library(
        name = "ch_qos_logback_logback_core",
        visibility = ["//visibility:public"],
        exports = ["@ch_qos_logback_logback_core//jar"],
    )

    native.java_library(
        name = "net_bytebuddy_byte_buddy",
        visibility = ["//visibility:public"],
        exports = ["@net_bytebuddy_byte_buddy//jar"],
    )

    native.java_library(
        name = "com_fasterxml_jackson_module_jackson_module_parameter_names",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_module_jackson_module_parameter_names//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_containers_jersey_container_servlet_core",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_containers_jersey_container_servlet_core//jar"],
        runtime_deps = [
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_core_jersey_server",
        ],
    )

    native.java_library(
        name = "javax_ws_rs_javax_ws_rs_api",
        visibility = ["//visibility:public"],
        exports = ["@javax_ws_rs_javax_ws_rs_api//jar"],
    )

    native.java_library(
        name = "org_glassfish_hk2_hk2_api",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_hk2_api//jar"],
        runtime_deps = [
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_hk2_utils",
        ],
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
        name = "com_fasterxml_jackson_jaxrs_jackson_jaxrs_json_provider",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_jaxrs_jackson_jaxrs_json_provider//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":com_fasterxml_jackson_jaxrs_jackson_jaxrs_base",
            ":com_fasterxml_jackson_module_jackson_module_jaxb_annotations",
        ],
    )

    native.java_library(
        name = "org_checkerframework_checker_compat_qual",
        visibility = ["//visibility:public"],
        exports = ["@org_checkerframework_checker_compat_qual//jar"],
    )

    native.java_library(
        name = "org_codehaus_mojo_animal_sniffer_annotations",
        visibility = ["//visibility:public"],
        exports = ["@org_codehaus_mojo_animal_sniffer_annotations//jar"],
    )

    native.java_library(
        name = "org_slf4j_slf4j_api",
        visibility = ["//visibility:public"],
        exports = ["@org_slf4j_slf4j_api//jar"],
    )

    native.java_library(
        name = "org_glassfish_jersey_core_jersey_server",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_core_jersey_server//jar"],
        runtime_deps = [
            ":javax_annotation_javax_annotation_api",
            ":javax_validation_validation_api",
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_hk2_hk2_utils",
            ":org_glassfish_hk2_osgi_resource_locator",
            ":org_glassfish_jersey_bundles_repackaged_jersey_guava",
            ":org_glassfish_jersey_core_jersey_client",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_media_jersey_media_jaxb",
            ":org_javassist_javassist",
        ],
    )

    native.java_library(
        name = "org_liquibase_liquibase_core",
        visibility = ["//visibility:public"],
        exports = ["@org_liquibase_liquibase_core//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_classic",
            ":org_slf4j_slf4j_api",
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
        name = "org_glassfish_hk2_external_javax_inject",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_external_javax_inject//jar"],
    )

    native.java_library(
        name = "org_slf4j_jcl_over_slf4j",
        visibility = ["//visibility:public"],
        exports = ["@org_slf4j_jcl_over_slf4j//jar"],
        runtime_deps = [
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "com_fasterxml_jackson_core_jackson_annotations",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_core_jackson_annotations//jar"],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_jetty9",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_jetty9//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_core",
        ],
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
        name = "org_eclipse_jetty_jetty_http",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_http//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "javax_servlet_javax_servlet_api",
        visibility = ["//visibility:public"],
        exports = ["@javax_servlet_javax_servlet_api//jar"],
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
        name = "org_glassfish_hk2_osgi_resource_locator",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_osgi_resource_locator//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_auth",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_auth//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_access",
            ":ch_qos_logback_logback_classic",
            ":ch_qos_logback_logback_core",
            ":com_fasterxml_classmate",
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
            ":com_fasterxml_jackson_datatype_jackson_datatype_guava",
            ":com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
            ":com_fasterxml_jackson_datatype_jackson_datatype_joda",
            ":com_fasterxml_jackson_datatype_jackson_datatype_jsr310",
            ":com_fasterxml_jackson_jaxrs_jackson_jaxrs_base",
            ":com_fasterxml_jackson_jaxrs_jackson_jaxrs_json_provider",
            ":com_fasterxml_jackson_module_jackson_module_afterburner",
            ":com_fasterxml_jackson_module_jackson_module_jaxb_annotations",
            ":com_fasterxml_jackson_module_jackson_module_parameter_names",
            ":com_google_code_findbugs_jsr305",
            ":com_google_errorprone_error_prone_annotations",
            ":com_google_guava_guava",
            ":com_google_j2objc_j2objc_annotations",
            ":com_papertrail_profiler",
            ":io_dropwizard_dropwizard_configuration",
            ":io_dropwizard_dropwizard_core",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_jersey",
            ":io_dropwizard_dropwizard_jetty",
            ":io_dropwizard_dropwizard_lifecycle",
            ":io_dropwizard_dropwizard_logging",
            ":io_dropwizard_dropwizard_metrics",
            ":io_dropwizard_dropwizard_request_logging",
            ":io_dropwizard_dropwizard_servlets",
            ":io_dropwizard_dropwizard_util",
            ":io_dropwizard_dropwizard_validation",
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_healthchecks",
            ":io_dropwizard_metrics_metrics_jersey2",
            ":io_dropwizard_metrics_metrics_jetty9",
            ":io_dropwizard_metrics_metrics_jmx",
            ":io_dropwizard_metrics_metrics_json",
            ":io_dropwizard_metrics_metrics_jvm",
            ":io_dropwizard_metrics_metrics_logback",
            ":io_dropwizard_metrics_metrics_servlets",
            ":javax_annotation_javax_annotation_api",
            ":javax_servlet_javax_servlet_api",
            ":javax_validation_validation_api",
            ":javax_ws_rs_javax_ws_rs_api",
            ":joda_time_joda_time",
            ":net_sourceforge_argparse4j_argparse4j",
            ":org_apache_commons_commons_lang3",
            ":org_apache_commons_commons_text",
            ":org_checkerframework_checker_compat_qual",
            ":org_codehaus_mojo_animal_sniffer_annotations",
            ":org_eclipse_jetty_jetty_continuation",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_security",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_servlet",
            ":org_eclipse_jetty_jetty_servlets",
            ":org_eclipse_jetty_jetty_util",
            ":org_eclipse_jetty_jetty_webapp",
            ":org_eclipse_jetty_jetty_xml",
            ":org_eclipse_jetty_toolchain_setuid_jetty_setuid_java",
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_hk2_hk2_utils",
            ":org_glassfish_hk2_osgi_resource_locator",
            ":org_glassfish_javax_el",
            ":org_glassfish_jersey_bundles_repackaged_jersey_guava",
            ":org_glassfish_jersey_containers_jersey_container_servlet",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_client",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_core_jersey_server",
            ":org_glassfish_jersey_ext_jersey_bean_validation",
            ":org_glassfish_jersey_ext_jersey_metainf_services",
            ":org_glassfish_jersey_media_jersey_media_jaxb",
            ":org_hibernate_hibernate_validator",
            ":org_javassist_javassist",
            ":org_jboss_logging_jboss_logging",
            ":org_slf4j_jcl_over_slf4j",
            ":org_slf4j_jul_to_slf4j",
            ":org_slf4j_log4j_over_slf4j",
            ":org_slf4j_slf4j_api",
            ":org_yaml_snakeyaml",
        ],
    )

    native.java_library(
        name = "org_jetbrains_annotations",
        visibility = ["//visibility:public"],
        exports = ["@org_jetbrains_annotations//jar"],
    )

    native.java_library(
        name = "org_glassfish_jersey_core_jersey_common",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_core_jersey_common//jar"],
        runtime_deps = [
            ":javax_annotation_javax_annotation_api",
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_hk2_hk2_utils",
            ":org_glassfish_hk2_osgi_resource_locator",
            ":org_glassfish_jersey_bundles_repackaged_jersey_guava",
            ":org_javassist_javassist",
        ],
    )

    native.java_library(
        name = "com_google_code_findbugs_jsr305",
        visibility = ["//visibility:public"],
        exports = ["@com_google_code_findbugs_jsr305//jar"],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_jvm",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_jvm//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "org_glassfish_javax_el",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_javax_el//jar"],
    )

    native.java_library(
        name = "com_papertrail_profiler",
        visibility = ["//visibility:public"],
        exports = ["@com_papertrail_profiler//jar"],
        runtime_deps = [
            ":joda_time_joda_time",
        ],
    )

    native.java_library(
        name = "com_h2database_h2",
        visibility = ["//visibility:public"],
        exports = ["@com_h2database_h2//jar"],
    )

    native.java_library(
        name = "org_slf4j_jul_to_slf4j",
        visibility = ["//visibility:public"],
        exports = ["@org_slf4j_jul_to_slf4j//jar"],
        runtime_deps = [
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_jmx",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_jmx//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "org_reactivestreams_reactive_streams",
        visibility = ["//visibility:public"],
        exports = ["@org_reactivestreams_reactive_streams//jar"],
    )

    native.java_library(
        name = "org_apache_commons_commons_text",
        visibility = ["//visibility:public"],
        exports = ["@org_apache_commons_commons_text//jar"],
        runtime_deps = [
            ":org_apache_commons_commons_lang3",
        ],
    )

    native.java_library(
        name = "org_slf4j_log4j_over_slf4j",
        visibility = ["//visibility:public"],
        exports = ["@org_slf4j_log4j_over_slf4j//jar"],
        runtime_deps = [
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_jodatime2",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_jodatime2//jar"],
        runtime_deps = [
            ":joda_time_joda_time",
            ":org_jdbi_jdbi3_core",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_guava",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_guava//jar"],
        runtime_deps = [
            ":com_google_guava_guava",
            ":org_jdbi_jdbi3_core",
        ],
    )

    native.java_library(
        name = "org_assertj_assertj_core",
        visibility = ["//visibility:public"],
        exports = ["@org_assertj_assertj_core//jar"],
    )

    native.java_library(
        name = "com_google_errorprone_error_prone_annotations",
        visibility = ["//visibility:public"],
        exports = ["@com_google_errorprone_error_prone_annotations//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_jetty",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_jetty//jar"],
        runtime_deps = [
            ":io_dropwizard_dropwizard_logging",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_jetty9",
            ":org_eclipse_jetty_jetty_continuation",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_servlet",
            ":org_eclipse_jetty_jetty_servlets",
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "org_apache_tomcat_tomcat_juli",
        visibility = ["//visibility:public"],
        exports = ["@org_apache_tomcat_tomcat_juli//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_logging",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_logging//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_classic",
            ":ch_qos_logback_logback_core",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_validation",
            ":io_dropwizard_metrics_metrics_logback",
            ":org_eclipse_jetty_jetty_util",
            ":org_slf4j_jcl_over_slf4j",
            ":org_slf4j_jul_to_slf4j",
            ":org_slf4j_log4j_over_slf4j",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "com_fasterxml_jackson_datatype_jackson_datatype_jsr310",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_datatype_jackson_datatype_jsr310//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_test_framework_jersey_test_framework_core",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_test_framework_jersey_test_framework_core//jar"],
        runtime_deps = [
            ":junit_junit",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_server",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_healthchecks",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_healthchecks//jar"],
    )

    native.java_library(
        name = "org_glassfish_hk2_hk2_utils",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_hk2_utils//jar"],
    )

    native.java_library(
        name = "org_objenesis_objenesis",
        visibility = ["//visibility:public"],
        exports = ["@org_objenesis_objenesis//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_request_logging",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_request_logging//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_access",
            ":ch_qos_logback_logback_core",
            ":io_dropwizard_dropwizard_jetty",
            ":io_dropwizard_dropwizard_logging",
        ],
    )

    native.java_library(
        name = "org_apache_tomcat_tomcat_jdbc",
        visibility = ["//visibility:public"],
        exports = ["@org_apache_tomcat_tomcat_jdbc//jar"],
        runtime_deps = [
            ":org_apache_tomcat_tomcat_juli",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_ext_jersey_bean_validation",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_ext_jersey_bean_validation//jar"],
        runtime_deps = [
            ":javax_validation_validation_api",
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_core_jersey_server",
            ":org_hibernate_hibernate_validator",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_servlets",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_servlets//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_classic",
            ":io_dropwizard_dropwizard_util",
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_annotation",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_annotation//jar"],
    )

    native.java_library(
        name = "com_fasterxml_jackson_datatype_jackson_datatype_guava",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_datatype_jackson_datatype_guava//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":com_google_guava_guava",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_validation",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_validation//jar"],
        runtime_deps = [
            ":com_fasterxml_classmate",
            ":io_dropwizard_dropwizard_util",
            ":javax_validation_validation_api",
            ":org_glassfish_javax_el",
            ":org_hibernate_hibernate_validator",
            ":org_javassist_javassist",
            ":org_jboss_logging_jboss_logging",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "org_glassfish_hk2_external_aopalliance_repackaged",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_external_aopalliance_repackaged//jar"],
    )

    native.java_library(
        name = "org_hamcrest_hamcrest_core",
        visibility = ["//visibility:public"],
        exports = ["@org_hamcrest_hamcrest_core//jar"],
    )

    native.java_library(
        name = "ch_qos_logback_logback_access",
        visibility = ["//visibility:public"],
        exports = ["@ch_qos_logback_logback_access//jar"],
        runtime_deps = [
            ":ch_qos_logback_logback_core",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_bundles_repackaged_jersey_guava",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_bundles_repackaged_jersey_guava//jar"],
    )

    native.java_library(
        name = "com_fasterxml_classmate",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_classmate//jar"],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_json",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_json//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_servlets",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_servlets//jar"],
        runtime_deps = [
            ":com_papertrail_profiler",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_healthchecks",
            ":io_dropwizard_metrics_metrics_json",
            ":io_dropwizard_metrics_metrics_jvm",
            ":joda_time_joda_time",
        ],
    )

    native.java_library(
        name = "org_javassist_javassist",
        visibility = ["//visibility:public"],
        exports = ["@org_javassist_javassist//jar"],
    )

    native.java_library(
        name = "org_glassfish_jersey_containers_jersey_container_servlet",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_containers_jersey_container_servlet//jar"],
        runtime_deps = [
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_core_jersey_server",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_ext_jersey_metainf_services",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_ext_jersey_metainf_services//jar"],
        runtime_deps = [
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_glassfish_jersey_core_jersey_common",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_webapp",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_webapp//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_security",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_servlet",
            ":org_eclipse_jetty_jetty_util",
            ":org_eclipse_jetty_jetty_xml",
        ],
    )

    native.java_library(
        name = "com_google_j2objc_j2objc_annotations",
        visibility = ["//visibility:public"],
        exports = ["@com_google_j2objc_j2objc_annotations//jar"],
    )

    native.java_library(
        name = "joda_time_joda_time",
        visibility = ["//visibility:public"],
        exports = ["@joda_time_joda_time//jar"],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_jersey2",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_jersey2//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "com_mattbertolini_liquibase_slf4j",
        visibility = ["//visibility:public"],
        exports = ["@com_mattbertolini_liquibase_slf4j//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_metrics",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_metrics//jar"],
        runtime_deps = [
            ":com_google_guava_guava",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_lifecycle",
            ":io_dropwizard_dropwizard_util",
            ":io_dropwizard_dropwizard_validation",
            ":io_dropwizard_metrics_metrics_core",
            ":javax_servlet_javax_servlet_api",
            ":org_eclipse_jetty_jetty_http",
            ":org_eclipse_jetty_jetty_io",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_util",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "org_hibernate_hibernate_validator",
        visibility = ["//visibility:public"],
        exports = ["@org_hibernate_hibernate_validator//jar"],
        runtime_deps = [
            ":com_fasterxml_classmate",
            ":javax_validation_validation_api",
            ":org_jboss_logging_jboss_logging",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_jackson",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_jackson//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":com_fasterxml_jackson_datatype_jackson_datatype_guava",
            ":com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
            ":com_fasterxml_jackson_datatype_jackson_datatype_joda",
            ":com_fasterxml_jackson_datatype_jackson_datatype_jsr310",
            ":com_fasterxml_jackson_module_jackson_module_afterburner",
            ":com_fasterxml_jackson_module_jackson_module_parameter_names",
            ":com_google_guava_guava",
            ":io_dropwizard_dropwizard_util",
            ":joda_time_joda_time",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "junit_junit",
        visibility = ["//visibility:public"],
        exports = ["@junit_junit//jar"],
        runtime_deps = [
            ":org_hamcrest_hamcrest_core",
        ],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_util",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_util//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_google_code_findbugs_jsr305",
            ":com_google_errorprone_error_prone_annotations",
            ":com_google_guava_guava",
            ":com_google_j2objc_j2objc_annotations",
            ":joda_time_joda_time",
            ":org_checkerframework_checker_compat_qual",
            ":org_codehaus_mojo_animal_sniffer_annotations",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_util",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_util//jar"],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_jdbi3",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_jdbi3//jar"],
        runtime_deps = [
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
        ],
    )

    native.java_library(
        name = "io_dropwizard_metrics_metrics_core",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_metrics_metrics_core//jar"],
    )

    native.java_library(
        name = "org_antlr_stringtemplate",
        visibility = ["//visibility:public"],
        exports = ["@org_antlr_stringtemplate//jar"],
        runtime_deps = [
            ":antlr_antlr",
        ],
    )

    native.java_library(
        name = "org_glassfish_jersey_test_framework_providers_jersey_test_framework_provider_inmemory",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_jersey_test_framework_providers_jersey_test_framework_provider_inmemory//jar"],
        runtime_deps = [
            ":junit_junit",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_client",
            ":org_glassfish_jersey_core_jersey_server",
            ":org_glassfish_jersey_test_framework_jersey_test_framework_core",
        ],
    )

    native.java_library(
        name = "com_fasterxml_jackson_jaxrs_jackson_jaxrs_base",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_jaxrs_jackson_jaxrs_base//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
        ],
    )

    native.java_library(
        name = "org_jdbi_jdbi3_core",
        visibility = ["//visibility:public"],
        exports = ["@org_jdbi_jdbi3_core//jar"],
        runtime_deps = [
            ":antlr_antlr",
            ":net_jodah_expiringmap",
            ":org_antlr_antlr_runtime",
            ":org_antlr_stringtemplate",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "org_jetbrains_kotlin_kotlin_stdlib_common",
        visibility = ["//visibility:public"],
        exports = ["@org_jetbrains_kotlin_kotlin_stdlib_common//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_configuration",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_configuration//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_validation",
            ":org_apache_commons_commons_lang3",
            ":org_apache_commons_commons_text",
            ":org_yaml_snakeyaml",
        ],
    )

    native.java_library(
        name = "org_glassfish_hk2_hk2_locator",
        visibility = ["//visibility:public"],
        exports = ["@org_glassfish_hk2_hk2_locator//jar"],
        runtime_deps = [
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_utils",
            ":org_javassist_javassist",
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
        name = "com_fasterxml_jackson_datatype_jackson_datatype_joda",
        visibility = ["//visibility:public"],
        exports = ["@com_fasterxml_jackson_datatype_jackson_datatype_joda//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":joda_time_joda_time",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_continuation",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_continuation//jar"],
    )

    native.java_library(
        name = "org_apache_commons_commons_lang3",
        visibility = ["//visibility:public"],
        exports = ["@org_apache_commons_commons_lang3//jar"],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_security",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_security//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_server",
        ],
    )

    native.java_library(
        name = "com_google_guava_guava",
        visibility = ["//visibility:public"],
        exports = ["@com_google_guava_guava//jar"],
        runtime_deps = [
            ":com_google_code_findbugs_jsr305",
            ":com_google_errorprone_error_prone_annotations",
            ":com_google_j2objc_j2objc_annotations",
            ":org_checkerframework_checker_compat_qual",
            ":org_codehaus_mojo_animal_sniffer_annotations",
        ],
    )

    native.java_library(
        name = "org_eclipse_jetty_jetty_xml",
        visibility = ["//visibility:public"],
        exports = ["@org_eclipse_jetty_jetty_xml//jar"],
        runtime_deps = [
            ":org_eclipse_jetty_jetty_util",
        ],
    )

    native.java_library(
        name = "org_yaml_snakeyaml",
        visibility = ["//visibility:public"],
        exports = ["@org_yaml_snakeyaml//jar"],
    )

    native.java_library(
        name = "io_dropwizard_dropwizard_jersey",
        visibility = ["//visibility:public"],
        exports = ["@io_dropwizard_dropwizard_jersey//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_annotations",
            ":com_fasterxml_jackson_core_jackson_core",
            ":com_fasterxml_jackson_core_jackson_databind",
            ":com_fasterxml_jackson_jaxrs_jackson_jaxrs_base",
            ":com_fasterxml_jackson_jaxrs_jackson_jaxrs_json_provider",
            ":com_fasterxml_jackson_module_jackson_module_jaxb_annotations",
            ":io_dropwizard_dropwizard_jackson",
            ":io_dropwizard_dropwizard_logging",
            ":io_dropwizard_dropwizard_validation",
            ":io_dropwizard_metrics_metrics_annotation",
            ":io_dropwizard_metrics_metrics_core",
            ":io_dropwizard_metrics_metrics_jersey2",
            ":javax_annotation_javax_annotation_api",
            ":javax_validation_validation_api",
            ":javax_ws_rs_javax_ws_rs_api",
            ":org_apache_commons_commons_lang3",
            ":org_eclipse_jetty_jetty_continuation",
            ":org_eclipse_jetty_jetty_security",
            ":org_eclipse_jetty_jetty_server",
            ":org_eclipse_jetty_jetty_servlet",
            ":org_eclipse_jetty_jetty_util",
            ":org_eclipse_jetty_jetty_webapp",
            ":org_eclipse_jetty_jetty_xml",
            ":org_glassfish_hk2_external_aopalliance_repackaged",
            ":org_glassfish_hk2_external_javax_inject",
            ":org_glassfish_hk2_hk2_api",
            ":org_glassfish_hk2_hk2_locator",
            ":org_glassfish_hk2_hk2_utils",
            ":org_glassfish_hk2_osgi_resource_locator",
            ":org_glassfish_jersey_bundles_repackaged_jersey_guava",
            ":org_glassfish_jersey_containers_jersey_container_servlet",
            ":org_glassfish_jersey_containers_jersey_container_servlet_core",
            ":org_glassfish_jersey_core_jersey_client",
            ":org_glassfish_jersey_core_jersey_common",
            ":org_glassfish_jersey_core_jersey_server",
            ":org_glassfish_jersey_ext_jersey_bean_validation",
            ":org_glassfish_jersey_ext_jersey_metainf_services",
            ":org_glassfish_jersey_media_jersey_media_jaxb",
            ":org_hibernate_hibernate_validator",
            ":org_javassist_javassist",
        ],
    )

    native.java_library(
        name = "io_sentry_sentry",
        visibility = ["//visibility:public"],
        exports = ["@io_sentry_sentry//jar"],
        runtime_deps = [
            ":com_fasterxml_jackson_core_jackson_core",
            ":org_slf4j_slf4j_api",
        ],
    )

    native.java_library(
        name = "antlr_antlr",
        visibility = ["//visibility:public"],
        exports = ["@antlr_antlr//jar"],
    )
