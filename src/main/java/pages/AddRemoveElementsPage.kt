package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class AddRemoveElementsPage(driver: WebDriver) : Page(driver) {
    // lateinit => variable where null is an invalid state, but variable cannot be populated in the constructor (maybe initialized via dependency injection/setup method, use only when your sure it will be initialized!
    private val addButtonLocator = By.cssSelector("#content > div > button")
    private val deleteButtonsLocator = By.className("added-manually")

    fun visit() {
        visit(getBaseUrl() + "add_remove_elements/")
        PageFactory.initElements(driver, this)
    }

    fun clickAddButton(noClicks: Int = 1) {
        val addButton = driver.findElement(addButtonLocator)
        for (i in 0 until noClicks) {
            addButton.click()
        }
    }

    fun clickDeleteButton(buttonNo: Int = 0) {
        getDeleteButtons()[buttonNo].click()
    }

    fun getDeleteButtons(): List<WebElement> {
        return driver.findElements(deleteButtonsLocator)
    }
}