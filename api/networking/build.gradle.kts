plugins {
    id("java")
}

dependencies {
    implementation(libs.bundles.netty)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}