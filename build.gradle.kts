plugins {
    application
    checkstyle
    jacoco
    id("io.freefair.lombok") version "9.0.0"
    id("org.sonarqube") version "6.3.1.5724"
}

group = "org.example"
version = "1.0-SNAPSHOT"

sonar {
    properties {
        property("sonar.projectKey", "dreik84_diff")
        property("sonar.organization", "dreik84")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

application { mainClass.set("org.example.App") }

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.19.2")
    implementation("info.picocli:picocli:4.7.7")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}