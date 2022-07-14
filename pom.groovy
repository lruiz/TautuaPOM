/*
 * Copyright 2020 TAUTUA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

project {
    modelVersion '4.0.0'
    groupId 'org.tautua'
    artifactId 'tautua'
    version '2-SNAPSHOT'
    packaging 'pom'

    name 'Tautua POM'
    description 'Tautua Corporate POM'
    url 'http://www.tautua.org'
    inceptionYear '2020'

    organization {
        name 'Tautua'
        url 'http://www.tautua.org'
    }

    licenses {
        license {
            name 'Apache License, Version 2.0'
            url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
            distribution 'repo'
        }
    }

    developers {
        developer {
            id 'lruiz'
            name 'Larry Ruiz'
            email 'lruiz@tautua.org'
            roles {
                role 'Architect'
                role 'Lead Developer'
            }
        }
    }

    scm {
        connection 'scm:git:git@github.com:lruiz/TautuaPOM.git'
        developerConnection 'scm:git:git@github.com:lruiz/TautuaPOM.git'
        url 'https://github.com/lruiz/TautuaPOM'
    }

    distributionManagement {
        repository {
            id 'sonatype.ossrh'
            name 'Sonatype OSSRH'
            url 'https://oss.sonatype.org/service/local/staging/deploy/maven2'
        }
        snapshotRepository {
            id 'sonatype.ossrh'
            name 'Sonatype OSSRH'
            url 'https://oss.sonatype.org/content/repositories/snapshots'
        }
    }

    properties {
        encoding 'UTF-8'
        'project.build.sourceEncoding' '${encoding}'
        'project.reporting.outputEncoding' '${encoding}'
        'maven.version' '3.8.2'
        'java.version' '11'
        'maven.compiler.source' '${java.version}'
        'maven.compiler.target' '${java.version}'
    }

    build {
        pluginManagement {
            plugins {
                plugin 'org.apache.maven.plugins:maven-assembly-plugin:3.1.1'
                plugin 'org.apache.maven.plugins:maven-clean-plugin:3.2.0'
                plugin 'org.apache.maven.plugins:maven-compiler-plugin:3.10.1'
                plugin 'org.apache.maven.plugins:maven-dependency-plugin:3.3.0'
                plugin 'org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M2'

                plugin ('org.apache.maven.plugins:maven-enforcer-plugin:3.1.0') {
                    executions {
                        execution {
                            id 'enforce-rules'
                            goals 'enforce'
                            configuration {
                                rules {
                                    requireMavenVersion {
                                        version '${maven.version}'
                                    }
                                    requireJavaVersion {
                                        version '${java.version}'
                                    }
                                }
                            }
                        }
                    }
                    dependencies {
                        dependency 'org.codehaus.mojo:extra-enforcer-rules:1.6.0'
                    }
                }

                plugin 'org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M7'

                plugin ('org.apache.maven.plugins:maven-gpg-plugin:3.0.1') {
                    executions {
                        execution {
                            id 'sign-artifacts'
                            phase 'verify'
                            goals 'sign'
                        }
                    }
                }

                plugin 'org.apache.maven.plugins:maven-install-plugin:3.0.0-M1'
                plugin 'org.apache.maven.plugins:maven-jar-plugin:3.2.2'

                plugin ('org.apache.maven.plugins:maven-javadoc-plugin:3.4.0') {
                    executions {
                        execution {
                            id 'attach-javadocs'
                            goals 'jar'
                        }
                    }
                }

                plugin 'org.apache.maven.plugins:maven-project-info-reports-plugin:3.3.0'

                plugin ('org.apache.maven.plugins:maven-release-plugin:3.0.0-M6') {
                    configuration {
                        tagNameFormat 'v@{project.version}'
                        autoVersionSubmodules 'true'
                        releaseProfiles 'release'
                    }
                }

                plugin 'org.apache.maven.plugins:maven-resources-plugin:3.2.0'

                plugin ('org.apache.maven.plugins:maven-site-plugin:3.12.0') {
                    dependencies {
                        dependency 'org.apache.maven.wagon:wagon-scm:3.5.2'
                        dependency 'org.apache.maven.scm:maven-scm-api:2.0.0-M1'
                        dependency 'org.apache.maven.scm:maven-scm-provider-gitexe:2.0.0-M1'
                        dependency 'org.apache.maven.scm:maven-scm-manager-plexus:2.0.0-M1'
                    }
                }

                plugin ('org.apache.maven.plugins:maven-source-plugin:3.2.1') {
                    executions {
                        execution {
                            id 'attach-sources'
                            goals 'jar-no-fork'
                        }
                    }
                }

                plugin 'org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M7'
                plugin 'org.codehaus.mojo:license-maven-plugin:2.0.0'
                plugin 'org.codehaus.mojo:versions-maven-plugin:2.11.0'

                plugin ('org.jacoco:jacoco-maven-plugin:0.8.8') {
                    executions {
                        execution {
                            id 'pre-tests'
                            goals 'prepare-agent'
                        }
                        execution {
                            id 'post-tests'
                            goals 'report'
                        }
                    }
                }
            }
        }

        plugins {
            plugin 'org.apache.maven.plugins:maven-compiler-plugin'
            plugin 'org.apache.maven.plugins:maven-jar-plugin'
            plugin 'org.apache.maven.plugins:maven-install-plugin'
            plugin 'org.apache.maven.plugins:maven-release-plugin'
        }
    }

    reporting {
        plugins {
            plugin {
                groupId 'org.codehaus.mojo'
                artifactId 'license-maven-plugin'
                reportSets {
                    reportSet {
                        reports 'third-party-report'
                    }
                }
                configuration {
                    excludedScopes 'test,provided,system'
                }
            }
            plugin {
                groupId 'org.codehaus.mojo'
                artifactId 'versions-maven-plugin'
                reportSets {
                    reportSet {
                        reports 'dependency-updates-report',
                                'plugin-updates-report',
                                'property-updates-report'
                    }
                }
            }
        }
    }

    profiles {
        profile {
            id 'release'
            build {
                plugins {
                    plugin 'org.apache.maven.plugins:maven-enforcer-plugin'
                    plugin 'org.apache.maven.plugins:maven-failsafe-plugin'
                    plugin 'org.apache.maven.plugins:maven-surefire-plugin'
                }
            }
        }

        profile {
            id 'live'
            build {
                plugins {
                    plugin 'org.apache.maven.plugins:maven-source-plugin'
                    plugin 'org.apache.maven.plugins:maven-javadoc-plugin'
                    plugin 'org.apache.maven.plugins:maven-gpg-plugin'
                }
            }
        }

        profile {
            id 'coverage'
            build {
                plugins {
                    plugin 'org.jacoco:jacoco-maven-plugin'
                }
            }
        }
    }
}
