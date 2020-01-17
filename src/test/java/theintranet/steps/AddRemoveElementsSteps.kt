package theintranet.steps

import driver.DriverManager
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.AddRemoveElementsPage

class AddRemoveElementsSteps {

    private lateinit var addRemoveElementsPage: AddRemoveElementsPage

    @Before
    fun openBrowser() {
        addRemoveElementsPage = AddRemoveElementsPage(DriverManager().initDriver())
    }

    @Given("a web browser is on the add remove elements page")
    fun aWebBrowserIsOnTheAddRemoveElementsPage() {
        addRemoveElementsPage.visit()
    }

    @And("the user adds {int} delete buttons")
    @When("the user clicks on the add element button {int} times")
    fun theUserClicksOnTheAddElementButtonTimes(noClicks: Int) {
        addRemoveElementsPage.clickAddButton(noClicks)
    }

    @When("the user clicks the delete button {int} times")
    fun theUserClicksOnTheDeleteButtonsTimes(deleteClicks: Int) {
        for (i in 0 until deleteClicks) {
            addRemoveElementsPage.clickDeleteButton(0)
        }
    }

    @Then("{int} delete element buttons should be displayed")
    fun deleteElementButtonsShouldBeDisplay(buttonsLeft: Int?) {
        assert(addRemoveElementsPage.getDeleteButtons().size == buttonsLeft)
    }

    @After
    fun closeBrowser() {
        addRemoveElementsPage.close()
    }
}