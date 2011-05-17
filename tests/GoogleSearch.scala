

import org.scalatest.FlatSpec
import org.openqa.selenium._
import org.openqa.selenium.htmlunit._

/**
  * Basic Test of Google Search
  * Verify basic elements
  * Verify query and results
  * Uses Headless (HTMLUnit Driver)
  */
class GoogleSearch extends FlatSpec {
 
  val driver = new HtmlUnitDriver
  driver.get("http://www.google.com")

  // verify we retrieve the page and have the title
  "Google" should "have the proper title" in {
    assert(driver.getTitle() === "Google")
  }

  it should "be able to perform a query" in {
    // do a search and confirm results
  
    // get form element
    val inputElement = driver.findElement(By.name("q"))

    // type in search query
    inputElement.sendKeys("vizsla puppies")
  
    // submit form - can be done from any form element 
    // you dont need to locate the submit button
    inputElement.submit
  }   
  
  // after a page submit, the driver object will be 
  // on the next page, so now we can test results

  it should "have a proper subtitle" in {
    // there are various ways to parse out the page
    // check to see if we are on right page [find by xpath]
    val subtitleElement = driver.findElement(By.xpath("//*[@id='search']/h2"))
    assert(subtitleElement.getText === "Search Results")
  }

  it should "have ten results" in {
    // find result set block
    val resultSet = driver.findElementById("rso")
    
    // count # of results
    val lis = resultSet.findElements(By.tagName("li"))
    assert(lis.size >= 10)
  }
  
  it should "have term in result set" in {
    val firstResult = driver.findElement(By.xpath("//*[@id='rso']/li[1]/h3"))
    assert(firstResult.getText contains "vizsla puppies")
  }

}
