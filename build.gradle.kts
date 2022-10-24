import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

group = "com.example"
version = PluginVersions.PROJECT_VERSION

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.SPRING_DATA_JPA)
    implementation(Dependencies.SPRING_WEB)
    implementation(Dependencies.VALIDATION)
    implementation(Dependencies.JACKSON)
    implementation(Dependencies.KTLINT)
    runtimeOnly(Dependencies.MYSQL_DRIVER)
    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.KOTLIN_REFLECT)
    implementation(Dependencies.SPRING_SECURITY)
    implementation(Dependencies.SPRING_TEST)
}

allOpen {
    annotation("javax.persistence.Entity")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
