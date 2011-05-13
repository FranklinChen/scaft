

import org.scalatest.FlatSpec
import org.openqa.selenium._
import org.openqa.selenium.htmlunit._

/**
  * Basic Test of BabyCenter Community Home - Logged out
  * Verify basic elements exist on page
  * Uses Headless (HTMLUnit Driver)
  */
class CommunityHomeLoggedOut extends FlatSpec {
 
  val driver = new HTMLUnitDriver
  driver.get("http://community.babycenter.com")

  "Community Home Page (Logged Out)" should "have the proper title" in {
    assert(driver.getTitle() === "BabyCenter - Community")
  }

  it should "have a login link" in {
    assert(driver.findElementById("page_header_login_link").getText === "Login")
  }

  it should "have a sign up link" in {
    assert(driver.findElementById("page_header_signup_link").getText === "Sign Up")
  }

  it should "have 10 community activity elements" in {
    val elem = driver.findElementById("comm_activity")
    val dls = elem.findElements(By.tagName("dl"))
    assert(dls.size === 10)
  }

  it should "have the Latest Birth Announcement" in {
    val elem = driver.findElementById("birth_announcement_promo_module")
    assert(elem != null)
  }

  it should "have at least 5 top groups" in {
    val elem = driver.findElementById("bgm_top_groups")
    val trs = elem.findElements(By.tagName("tr"))
    assert(trs.size >= 5)
  }

  it should "have at least 5 popular posts" in {
    val elem = driver.findElementById("bgm_popular_talks")
    val divs = elem.findElements(By.tagName("div"))
    assert(divs.size >= 5)
  }

  it should "have a non-empty footer" in {
    val elem = driver.findElementById("footer")
    val links = elem.findElements(By.tagName("a"))
    assert(links.size >= 3)
  }

  /* at bottom of page, good sign if we got this far */
  it should "have an empty user stage" in {
    assert(driver.findElementById("hidden_user_stage").getText == "")
  }

}
