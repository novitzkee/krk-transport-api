ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.2.2"

// Run tests sequentially to ensure readable output
Global / concurrentRestrictions += Tags.limit(Tags.Test, 1)

lazy val root = (project in file("."))
  .settings(
    name := "krk-transport-api",
    description := "API serving as proxy for Cracow public transport web services",
    idePackagePrefix := Some("com.github.novitzkee"),
    // scalacOptions := Seq("-Yexplicit-nulls"),
    libraryDependencies := Seq(
      "dev.zio" %% "zio" % "2.0.13",
      "dev.zio" %% "zio-json" % "0.5.0",
      "dev.zio" %% "zio-http" % "3.0.0-RC1",
      "dev.zio" %% "zio-test" % "2.0.13" % Test,

      "io.getquill" %% "quill-jdbc-zio" % "4.6.0.1",
      "org.xerial" % "sqlite-jdbc" % "3.40.1.0",

      "com.github.tototoshi" %% "scala-csv" % "1.3.10",
    )
  )