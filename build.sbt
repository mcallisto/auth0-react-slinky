/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.4"
name := "auth0-react-slinky"
version := "0.1.0"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.42",
  "@types/react-dom" -> "16.9.8",
  "@auth0/auth0-react" -> "1.4.0"
)

Test / npmDependencies ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1"
)

libraryDependencies ++= Seq(
  "org.scalatest" %%% "scalatest" % "3.1.2" % Test
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

// say we want custom code for slinky
stFlavour := Flavour.SlinkyNative

// focus only on these libraries
stMinimize := Selection.AllExcept("@auth0/auth0-react", "@auth0/auth0-spa-js")

// shade into another package
stOutputPackage := "vision.id.auth0react.facade"

ThisBuild / organization := "vision.id"
ThisBuild / organizationName := "vision.id"
ThisBuild / organizationHomepage := Some(url("http://id.vision/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/mcallisto/auth0-react"),
    "scm:git@github.com:mcallisto/auth0-react.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "mcallisto",
    name  = "Mario Càllisto",
    email = "mario.callisto@gmail.com",
    url   = url("https://github.com/mcallisto")
  )
)

ThisBuild / description := "auth0-react bindings for slinky (powered by ScalablyTyped)."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/mcallisto/auth0-react"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true