name := """play-roller"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "webjars" at "http://webjars.github.com/m2"
)

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.5.Final" exclude("dom4j", "dom4j"),
  "mysql" % "mysql-connector-java" % "6.0.5",
  "dom4j" % "dom4j" % "1.6.1" intransitive(),
  "org.webjars" % "webjars-play_2.11" % "2.5.0-4",
  // Downgrade to JQuery 1.8.3 so that integration tests with HtmlUnit work.
  "org.webjars" % "bootstrap" % "3.1.1-2" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "1.8.3"
)

libraryDependencies += evolutions

//fork in run := true

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"