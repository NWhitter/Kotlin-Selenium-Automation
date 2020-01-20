package theintranet.steps

import driver.DriverManager
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import pages.BasicAuthPage

class BasicAuthSteps {

    private lateinit var basicAuthPage: BasicAuthPage

    @Before
    fun openBrowser() {
        val driver = DriverManager().initDriver()
        basicAuthPage = BasicAuthPage(driver)
    }

    @Given("a web browser is on the add basic auth page")
    fun aWebBrowserIsOnTheAddBasicAuthPage() {
        basicAuthPage.visit()
    }

    @When("the user clicks the cancel button on the login dialog")
    fun theUserClicksCancelButtonOnTheLoginDialog() {
        basicAuthPage.dismissAlert()
    }

    @After
    fun closeBrowser() {
        basicAuthPage.close()
    }
}