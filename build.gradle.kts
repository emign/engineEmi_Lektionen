buildscript {
    val engineEmiVersion = "0.55"

    repositories {
        maven {
            url = uri("https://dl.bintray.com/emign/engineEmi")
        }
        maven { url = uri("https://dl.bintray.com/korlibs/korlibs") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath("me.emig:engineEmiGradlePlugin:$engineEmiVersion")
    }
}
