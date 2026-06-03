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

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-kafka")
//	implementation("org.springframework.boot:springD-boot-starter-restclient")
	implementation("org.springframework.boot:spring-boot-starter-web:4.0.6")
//	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
//	testImplementation("org.springframework.boot:spring-boot-starter-kafka-test")
//	testImplementation("org.springframework.boot:spring-boot-starter-restclient-test")
//	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("org.springframework.boot:spring-boot-starter-test:4.0.6")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
