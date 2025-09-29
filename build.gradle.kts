plugins {
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

application { mainClass.set("org.example.App") }

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.2")
    implementation("info.picocli:picocli:4.7.7")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}