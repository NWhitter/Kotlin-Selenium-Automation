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
        basicAuthPage = BasicAuthPage(DriverManager().initDriver())
    }

    @Given("a web browser is on the add basic auth page")
    fun aWebBrowserIsOnTheAddBasicAuthPage() {
        basicAuthPage.visit()
    }

    @When("the user clicks the cancel button on the login dialog")
    fun theUserClicksCancelButtonOnTheLoginDialog() {
        basicAuthPage.dismissAlert()
    }

//    @When("the user clicks the delete button {int} times")
//    fun theUserClicksOnTheDeleteButtonsTimes(deleteClicks: Int) {
//        for (i in 0 until deleteClicks) {
//            addRemoveElementsPage.clickDeleteButton(0)
//        }
//    }
//
//    @Then("{int} delete element buttons should be displayed")
//    fun deleteElementButtonsShouldBeDisplay(buttonsLeft: Int?) {
//        assert(addRemoveElementsPage.getDeleteButtons().size == buttonsLeft)
//    }

    @After
    fun closeBrowser() {
        basicAuthPage.close()
    }
}