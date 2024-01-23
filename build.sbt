import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "P2 TAP",
    libraryDependencies ++= Seq(
      munit % Test,
      "com.google.guava" % "guava" % "30.1-jre"
    ),
    Compile / unmanagedSourceDirectories += baseDirectory.value / "src" / "main" / "java",
    Compile / javacOptions ++= Seq(
      "-source", "1.8",
      "-target", "1.8"
    )
  )
