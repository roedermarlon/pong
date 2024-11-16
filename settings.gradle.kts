pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pong"

include(
    "common",
    "server",
    "client",
    "all"
)

include(
    ":api",
    ":api:util",
    ":api:game",
    ":api:networking",
)