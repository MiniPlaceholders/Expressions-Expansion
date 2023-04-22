dependencies {
    compileOnly(projects.expressionsCommon)
    compileOnly(libs.krypton.api)
    compileOnly(libs.miniplaceholders)
    annotationProcessor(libs.krypton.annotation.processor)
}
