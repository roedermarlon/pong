plugins {
    id("java")
}


dependencies {
    implementation("dev.httpmarco:osgan-netty:1.1.0-SNAPSHOT")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")

    // jetbrains annotations
    compileOnly("org.jetbrains:annotations:26.0.1")
}