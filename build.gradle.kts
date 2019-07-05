plugins {
    `java-library`
    `maven-publish`
    signing

}

group = "com.spencerwi"
version = "1.0.0"

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}
tasks.withType<Test> { // Use JUnit 5
    useJUnitPlatform()
}

tasks.register<Jar>("sourcesJar"){
    classifier = "sources"
    from(sourceSets["main"].allJava)
}
tasks.register<Jar>("javadocJar"){
    classifier = "javadoc"
    from(tasks["javadoc"].outputs.files.asFileTree)
}

if (!(project.hasProperty("isTravis"))){

    val sonatypeUsername : String by extra
    val sonatypePassword : String by extra

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifactId = "junit-displayname-generators"
                from(components["java"])
                artifact(tasks["sourcesJar"])
                artifact(tasks["javadocJar"])

                pom {
                    name.set("junit-displayname-generators")
                    description.set("A set of out-of-the-box JUnit test @DisplayNameGenerator implementations")
                    url.set("http://github.com/spencerwi/junit-displayname-generators")

                    scm {
                        url.set("scm:git@github.com:spencerwi/junit-displayname-generators.git")
                        connection.set("scm:git@github.com:spencerwi/junit-displayname-generators.git")
                        developerConnection.set("scm:git@github.com:spencerwi/junit-displayname-generators.git")
                    }

                    licenses {
                        license {
                            name.set("The MIT License (MIT)")
                            url.set("https://raw.githubusercontent.com/spencerwi/junit-displayname-generators/master/LICENSE")
                            distribution.set("repo")
                        }
                    }

                    developers {
                        developer {
                            id.set("spencerwi")
                            name.set("Spencer Williams")
                        }
                    }
                    issueManagement {
                        system.set("GitHub")
                        url.set("https://github.com/spencerwi/junit-displayname-generators/issues")
                    }
                }
            }
        }
        repositories {
            maven {
                val releasesRepoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
                val snapshotsRepoUrl = "https://oss.sonatype.org/content/repositories/snapshots"
                url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

                credentials {
                    username = sonatypeUsername
                    password = sonatypePassword
                }
            }
        }
    }
    signing {
        sign(publishing.publications["mavenJava"])
    }
}
