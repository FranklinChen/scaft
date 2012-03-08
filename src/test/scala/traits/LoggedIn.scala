
package traits

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

import org.openqa.selenium.firefox.FirefoxDriver


trait LoggedIn {
 

  def login(driver: WebDriver) {

    driver.get("http://www.google.com/")

    val emailElement = driver.findElement(By.name("email"))
    emailElement.sendKeys("sample@test.com")

    val passwordElement = driver.findElement(By.name("password"))
    passwordElement.sendKeys("test")

    // we can submit the form by calling submit on any element of the form
    passwordElement.submit() 
  }

}

