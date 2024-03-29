package pto.grails



import geb.Browser
import geb.Page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Note that this is a fixture example for the BusinessUnitTest specification that 
 * has been kindly generated by the Grails Concordion plugin.
 *
 * You should change this example to adapt it conveniently to your application 
 * under test.
 */
public class BusinessUnitTest {

    private static WebDriver webDriver

    @BeforeClass
    public static void setup() {
	webDriver = new FirefoxDriver()
    }

    String grailsHomePageTitle() {
	def browser = new Browser(webDriver) 
	browser.to(GrailsHomePage)
	browser.page?.title
    }

    @AfterClass
    public static void close() {
	webDriver?.close()
    }

}

class GrailsHomePage extends Page {
    
    static url = "http://grails.org/"
    static at = { title == "Grails - The search is over." }

    public GrailsHomePage() {
    }

}