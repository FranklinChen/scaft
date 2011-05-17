

import org.scalatest.FlatSpec
import org.openqa.selenium._
import org.openqa.selenium.firefox._

/**
  * Test of Google Maps - Firefox Driver
  * verify map search and ajax result
  */
class GoogleMaps extends FlatSpec {
 
  val driver = new FirefoxDriver
  driver.get("http://maps.google.com")

  // verify we retrieve the page and have the title
  "Google Maps" should "have the proper title" in {
    assert(driver.getTitle() === "Google Maps")
  }

  it should "be able to perform a query" in {
  
    // get form element
    val inputElement = driver.findElement(By.name("q"))

    // type in search query
    inputElement.sendKeys("San Francisco")
  
    // submit form
    inputElement.submit
  }

  // find span with place title
  it should "have the proper location title" in {
    val titleElement = driver.findElement(By.xpath("//span[@class='pp-place-title']/span"))
    assert(titleElement.getText == "San Francisco, CA")
  }
  
}
