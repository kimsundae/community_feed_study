plugins {
    id("java")
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "org.fastcampus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("com.mysql:mysql-connector-j")

    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

tasks.test {
    useJUnitPlatform()
}

val querydslDir = "${layout.projectDirectory}/build/generated/querydsl"

sourceSets{
    getByName("main").java.srcDirs(querydslDir)
}

tasks.withType<JavaCompile>{
    options.generatedSourceOutputDirectory = file(querydslDir)
}

tasks.named("clean"){
    doLast{
        file(querydslDir).deleteRecursively()
    }
}