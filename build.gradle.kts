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

dependencies {
    implementation("dev.httpmarco:osgan-netty:1.0.35-SNAPSHOT")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")

    // jetbrains annotations
    compileOnly("org.jetbrains:annotations:22.0.0")
}

tasks.test {
    useJUnitPlatform()
}