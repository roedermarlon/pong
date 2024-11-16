plugins {
    id("java")
}

dependencies {
    implementation(project(":"))
    implementation(libs.bundles.netty)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.annotations)

    implementation(libs.alert)
}