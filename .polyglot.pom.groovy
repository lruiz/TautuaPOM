<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.tautua</groupId>
  <artifactId>tautua</artifactId>
  <version>3-SNAPSHOT</version>
  <packaging>pom</packaging>
  <name>Tautua POM</name>
  <description>Tautua Corporate POM</description>
  <url>http://www.tautua.org</url>
  <inceptionYear>2020</inceptionYear>
  <organization>
    <name>Tautua</name>
    <url>http://www.tautua.org</url>
  </organization>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <developers>
    <developer>
      <id>lruiz</id>
      <name>Larry Ruiz</name>
      <email>lruiz@tautua.org</email>
      <roles>
        <role>Architect</role>
        <role>Lead Developer</role>
      </roles>
    </developer>
  </developers>
  <scm>
    <connection>scm:git:git@github.com:lruiz/TautuaPOM.git</connection>
    <developerConnection>scm:git:git@github.com:lruiz/TautuaPOM.git</developerConnection>
    <url>https://github.com/lruiz/TautuaPOM</url>
    <tag>HEAD</tag>
  </scm>
  <distributionManagement>
    <repository>
      <id>sonatype.ossrh</id>
      <name>Sonatype OSSRH</name>
      <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
    </repository>
    <snapshotRepository>
      <id>sonatype.ossrh</id>
      <name>Sonatype OSSRH</name>
      <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    </snapshotRepository>
  </distributionManagement>
  <properties>
    <project.reporting.outputEncoding>${encoding}</project.reporting.outputEncoding>
    <java.version>11</java.version>
    <encoding>UTF-8</encoding>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.version>3.8.2</maven.version>
    <project.build.sourceEncoding>${encoding}</project.build.sourceEncoding>
    <maven.compiler.target>${java.version}</maven.compiler.target>
  </properties>
  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-assembly-plugin</artifactId>
          <version>3.1.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.2.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.10.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-dependency-plugin</artifactId>
          <version>3.3.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>3.0.0-M2</version>
        </plugin>
        <plugin>
          <artifactId>maven-enforcer-plugin</artifactId>
          <version>3.1.0</version>
          <executions>
            <execution>
              <id>enforce-rules</id>
              <goals>
                <goal>enforce</goal>
              </goals>
              <configuration>
                <rules>
                  <requireMavenVersion>
                    <version>${maven.version}</version>
                  </requireMavenVersion>
                  <requireJavaVersion>
                    <version>${java.version}</version>
                  </requireJavaVersion>
                </rules>
              </configuration>
            </execution>
          </executions>
          <dependencies>
            <dependency>
              <groupId>org.codehaus.mojo</groupId>
              <artifactId>extra-enforcer-rules</artifactId>
              <version>1.6.0</version>
            </dependency>
          </dependencies>
        </plugin>
        <plugin>
          <artifactId>maven-failsafe-plugin</artifactId>
          <version>3.0.0-M7</version>
        </plugin>
        <plugin>
          <artifactId>maven-gpg-plugin</artifactId>
          <version>3.0.1</version>
          <executions>
            <execution>
              <id>sign-artifacts</id>
              <phase>verify</phase>
              <goals>
                <goal>sign</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>3.0.0-M1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-javadoc-plugin</artifactId>
          <version>3.4.0</version>
          <executions>
            <execution>
              <id>attach-javadocs</id>
              <goals>
                <goal>jar</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.3.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-release-plugin</artifactId>
          <version>3.0.0-M6</version>
          <configuration>
            <tagNameFormat>v@{project.version}</tagNameFormat>
            <autoVersionSubmodules>true</autoVersionSubmodules>
            <releaseProfiles>release</releaseProfiles>
          </configuration>
        </plugin>
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.2.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.12.0</version>
          <dependencies>
            <dependency>
              <groupId>org.apache.maven.wagon</groupId>
              <artifactId>wagon-scm</artifactId>
              <version>3.5.2</version>
            </dependency>
            <dependency>
              <groupId>org.apache.maven.scm</groupId>
              <artifactId>maven-scm-api</artifactId>
              <version>2.0.0-M1</version>
            </dependency>
            <dependency>
              <groupId>org.apache.maven.scm</groupId>
              <artifactId>maven-scm-provider-gitexe</artifactId>
              <version>2.0.0-M1</version>
            </dependency>
            <dependency>
              <groupId>org.apache.maven.scm</groupId>
              <artifactId>maven-scm-manager-plexus</artifactId>
              <version>2.0.0-M1</version>
            </dependency>
          </dependencies>
        </plugin>
        <plugin>
          <artifactId>maven-source-plugin</artifactId>
          <version>3.2.1</version>
          <executions>
            <execution>
              <id>attach-sources</id>
              <goals>
                <goal>jar-no-fork</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.0.0-M7</version>
        </plugin>
        <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>license-maven-plugin</artifactId>
          <version>2.0.0</version>
        </plugin>
        <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>versions-maven-plugin</artifactId>
          <version>2.11.0</version>
        </plugin>
        <plugin>
          <groupId>org.jacoco</groupId>
          <artifactId>jacoco-maven-plugin</artifactId>
          <version>0.8.8</version>
          <executions>
            <execution>
              <id>pre-tests</id>
              <goals>
                <goal>prepare-agent</goal>
              </goals>
            </execution>
            <execution>
              <id>post-tests</id>
              <goals>
                <goal>report</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </pluginManagement>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
      </plugin>
      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
      </plugin>
      <plugin>
        <artifactId>maven-install-plugin</artifactId>
      </plugin>
      <plugin>
        <artifactId>maven-release-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>license-maven-plugin</artifactId>
        <reportSets>
          <reportSet>
            <reports>
              <report>third-party-report</report>
            </reports>
          </reportSet>
        </reportSets>
        <configuration>
          <excludedScopes>test,provided,system</excludedScopes>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>versions-maven-plugin</artifactId>
        <reportSets>
          <reportSet>
            <reports>
              <report>dependency-updates-report</report>
              <report>plugin-updates-report</report>
              <report>property-updates-report</report>
            </reports>
          </reportSet>
        </reportSets>
      </plugin>
    </plugins>
  </reporting>
  <profiles>
    <profile>
      <id>release</id>
      <build>
        <plugins>
          <plugin>
            <artifactId>maven-enforcer-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-failsafe-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-source-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-javadoc-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-gpg-plugin</artifactId>
          </plugin>
        </plugins>
      </build>
    </profile>
    <profile>
      <id>snapshot</id>
      <build>
        <plugins>
          <plugin>
            <artifactId>maven-source-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-javadoc-plugin</artifactId>
          </plugin>
          <plugin>
            <artifactId>maven-gpg-plugin</artifactId>
          </plugin>
        </plugins>
      </build>
    </profile>
    <profile>
      <id>coverage</id>
      <build>
        <plugins>
          <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
          </plugin>
        </plugins>
      </build>
    </profile>
  </profiles>
</project>