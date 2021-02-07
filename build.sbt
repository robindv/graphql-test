import Dependencies._

ThisBuild / scalaVersion := "2.13.4"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val AkkaVersion     = "2.6.12"
val AkkaHttpVersion = "10.2.3"

scalafmtConfig := (baseDirectory in ThisBuild).value / "./.scalafmt.conf"

lazy val root = (project in file("."))
  .settings(
    name := "graphql-test",
    libraryDependencies += scalaTest              % Test,
    libraryDependencies += "org.sangria-graphql" %% "sangria"                % "2.1.0",
    libraryDependencies += "org.sangria-graphql" %% "sangria-spray-json"     % "1.0.2",
    libraryDependencies += "com.typesafe.akka"   %% "akka-persistence-typed" % AkkaVersion,
    libraryDependencies += "com.typesafe.akka"   %% "akka-http"              % AkkaHttpVersion,
    libraryDependencies += "com.typesafe.akka"   %% "akka-http-spray-json"   % AkkaHttpVersion,
    libraryDependencies += "ch.megard"           %% "akka-http-cors"         % "1.1.1"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
