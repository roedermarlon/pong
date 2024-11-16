plugins {
    id("java")
}

allprojects {
    group = "com.github.roedermarlon"
    version = "1.0"

    repositories {
        mavenCentral()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
    }
}