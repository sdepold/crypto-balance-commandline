name := "crypto-balance"

version := "0.1"

scalaVersion := "2.12.4"

val hasherVersion = "1.2.0"
val scalajHttpVersion = "2.3.0"
val json4sVersion = "3.5.3"
val circeVersion = "0.9.0"
val typesafeConfigVersion = "1.3.1"

libraryDependencies ++= Seq(
  "com.roundeights" %% "hasher" % hasherVersion,
  "org.scalaj" %% "scalaj-http" % scalajHttpVersion,
  "org.json4s" %% "json4s-jackson" % json4sVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.typesafe" % "config" % typesafeConfigVersion
)

