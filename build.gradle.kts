plugins {
    id("java")
}

group = "de.marlonr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("dev.httpmarco:osgan-netty:1.0.35-SNAPSHOT")
    implementation("io.netty:netty5-common:5.0.0.Alpha5")
    implementation("io.netty:netty5-transport:5.0.0.Alpha5")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")

    // jetbrains annotations
    compileOnly("org.jetbrains:annotations:22.0.0")
    testCompileOnly("org.jetbrains:annotations:22.0.0")

    implementation("me.obsilabor:alert:1.0.8")
    testImplementation("me.obsilabor:alert:1.0.8")
}

tasks.test {
    useJUnitPlatform()
}