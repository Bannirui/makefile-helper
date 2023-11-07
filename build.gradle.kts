plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
}

group = "com.github.bannirui"
version = "1.0.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("2022.2.5")
	// IC - IntelliJ IDEA Community Edition.
	// IU - IntelliJ IDEA Ultimate Edition.
	// CL - CLion.
	// PY - PyCharm Professional Edition.
	// PC - PyCharm Community Edition.
	// RD - Rider.
	// GO - GoLand.
	// JPS - JPS-only.
    type.set("CL")
    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
