name := """play-roller"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.5.Final" exclude("dom4j", "dom4j"),
  "mysql" % "mysql-connector-java" % "6.0.5",
  "dom4j" % "dom4j" % "1.6.1" intransitive(),
  "org.mockito" % "mockito-all" % "1.10.19"
)

libraryDependencies += evolutions

//fork in run := true

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"