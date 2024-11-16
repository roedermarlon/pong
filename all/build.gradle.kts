plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
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
            attributes["Main-Class"] = "de.marlonr.game.GameEntrypoint"
        }
        archiveFileName = "pong.jar"
    }
}