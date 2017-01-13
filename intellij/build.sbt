name := "spark-sql-examples"
 
version := "1.0"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

scalaVersion := "2.10.6"
 
resolvers += "jitpack" at "https://jitpack.io"

// still want to be able to run in sbt
// https://github.com/sbt/sbt-assembly#-provided-configuration
run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))

fork in run := true
javaOptions in run ++= Seq(
  "-Dlog4j.debug=true",
  "-Dlog4j.configuration=log4j.properties")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.2" % "provided",
  "org.apache.spark" %% "spark-sql" % "1.6.2" % "provided",
  "com.databricks" %% "spark-csv" % "1.5.0",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.5.0",
  "org.apache.spark" %% "spark-hive" % "1.6.2",
  "mysql" % "mysql-connector-java" % "5.1.12"
)