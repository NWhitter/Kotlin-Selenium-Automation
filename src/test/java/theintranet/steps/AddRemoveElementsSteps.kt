package theintranet.steps

import driver.DriverManager
import io.cucumber.java.After
import io.cucumber.java.Before
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

    @Given("the user adds {int} delete buttons")
    @When("the user clicks on the add element button {int} times")
    fun theUserClicksOnTheAddElementButtonTimes(noClicks: Int) {
        addRemoveElementsPage.clickAddButton(noClicks)
    }

    @When("the user clicks the delete button {int} times")
    fun theUserClicksOnTheDeleteButtonsTimes(noClicks: Int) {
        val i = 0
        while (i < noClicks) {
            val button = addRemoveElementsPage.getDeleteButtons().first()
            addRemoveElementsPage.clickDeleteButton(button)
        }
    }

    @Then("{int} delete element buttons should be displayed")
    fun deleteElementButtonsShouldBeDisplay(noClicks: Int?) {
        assert(addRemoveElementsPage.getDeleteButtons().size == 32)
    }

    @After
    fun closeBrowser() {
        addRemoveElementsPage.close()
    }
}