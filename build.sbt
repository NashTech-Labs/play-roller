name := """play-roller"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.5.Final",
  "mysql" % "mysql-connector-java" % "6.0.5",
  "dom4j" % "dom4j" % "1.6.1" intransitive()
)

libraryDependencies += evolutions

fork in run := true
