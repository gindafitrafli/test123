plugins {
	java
	id("org.springframework.boot") version "4.0.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

configurations.all {
	exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:4.0.6")
	implementation("org.springframework.boot:spring-boot-starter-actuator:4.0.6")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:4.0.6")
	implementation("org.springframework.boot:spring-boot-starter-log4j2:4.0.6")
	implementation("org.springframework.boot:spring-boot-starter-web:4.0.6")
	implementation("org.springframework.kafka:spring-kafka:4.0.5")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test:4.0.6")

	compileOnly("org.projectlombok:lombok:1.18.34")
	testCompileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok:1.18.34")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
