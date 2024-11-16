pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.20"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pong"

include(
    "server",
    "client",
    "all"
)

include("server")
include("client")
include("all")
