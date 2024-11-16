plugins {
    id("java")
}

dependencies {
    implementation(project(":api:util"))
    implementation(project(":api:game"))
    implementation(project(":api:networking"))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.annotations)
}