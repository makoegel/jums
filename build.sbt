lazy val commonSettings = Seq(
  organization := "com.koegel",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.4"
)

val scalacOptions = taskKey[Seq[String]]("Options for the Scala compiler.")
val checksums = settingKey[Seq[String]]("The list of checksums to generate and to verify for dependencies.")

lazy val root = (project in file("."))
    .settings(
      commonSettings,
      name := "JUMS",
      scalacOptions := List("-encoding", "utf8", "-Xfatal-warnings", "-deprecation", "-unchecked"),
      scalacOptions := {
        val old = scalacOptions.value
        scalaBinaryVersion.value match {
          case "2.12" => old
          case _      => old filterNot (Set("-Xfatal-warnings", "-deprecation").apply)
        }
      }
    )
