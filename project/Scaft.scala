import sbt._

class ScaftBuild extends Build {
  // disable logging - silences warnings from HTML Unit
  System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog")
}
