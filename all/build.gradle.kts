plugins {
    id("java")
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(project(":common"))
    implementation(project(":server"))
    implementation(project(":client"))
}

tasks {
    test {
        useJUnitPlatform()
    }
    shadowJar {
        manifest {
            attributes["Main-Class"] = "com.github.roedermarlon.pong.GameEntrypoint"
        }
        archiveFileName = "pong.jar"
    }
}