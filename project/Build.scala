import sbt._
import Keys._

object ApplicationBuild extends Build {
  val appName         = "jsonparser"
  val appVersion      = "0.0.1"


  val appDependencies = Seq (
    "play"              %% "play"        % "2.0-RC1-SNAPSHOT",

    "org.scalatest"     %% "scalatest"   % "1.6.1"   % "test"
  )


  val appResolvers = Seq (
     Resolver.file("play local",
     file("/Users/aga/Work/work/Play20/repository/local"))(Resolver.ivyStylePatterns),
     "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
  )

  lazy val main = Project (
    appName,
    file("."),
    settings = Defaults.defaultSettings ++ Seq(
      organization := "net.superbaloo.zrm",
      version := appVersion,
      libraryDependencies := appDependencies,
      parallelExecution in Test := false,
      resolvers := appResolvers
    )
  )

}


// vim: set ts=2 sw=2 ft=scala et:
