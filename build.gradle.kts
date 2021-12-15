import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    `java-library`
}

group = "me.ieva"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    withSourcesJar()
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to "Golay",
            "Implementation-Version" to "1.0.0",
            "Main-Class" to "MainKt"
        ))
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile)) {
            exclude("META-INF/MANIFEST.MF", "META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        }
    }
}

