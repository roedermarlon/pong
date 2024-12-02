plugins {
    id("java")
}

dependencies {
    implementation("dev.httpmarco:osgan-netty:1.1.1-SNAPSHOT")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")

    // jetbrains annotations
    compileOnly("org.jetbrains:annotations:26.0.1")
}