package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class AddRemoveElementsPage(driver: WebDriver) : Page(driver) {
    // lateinit => variable where null is an invalid state, but variable cannot be populated in the constructor (maybe initialized via dependency injection/setup method, use only when your sure it will be initialized!
    @FindBy(css = "#content > div > button")
    private lateinit var addButton: WebElement
    private val deleteButtonsLocator = By.className("added-manually")

    init {
        visit()
        PageFactory.initElements(driver, this)
    }

    fun visit() {
        visit("https://the-internet.herokuapp.com/add_remove_elements/")
    }

    fun clickAddButton(noClicks: Int = 1) {
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