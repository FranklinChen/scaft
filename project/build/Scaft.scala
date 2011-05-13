import sbt._

class ScaftProject(info: ProjectInfo) extends DefaultProject(info) {

  override def mainScalaSourcePath = "src"
  override def mainResourcesPath = "resources"
  override def testScalaSourcePath = "tests"
  override def testResourcesPath = "test-resources"

  // disable logging - silences warnings from HTML Unit
  System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog")

}
