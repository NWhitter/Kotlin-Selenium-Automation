package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class BasicAuthPage(driver: WebDriver) : Page(driver) {

    fun visit() {
        visit(getBaseUrl() + "/basic_auth")
        PageFactory.initElements(driver, this)
    }

    fun dismissAlert() {
        driver.switchTo().alert().dismiss()
    }

    fun okAlert() {
        driver.switchTo().alert().accept()
    }

    fun fill() {
        driver.switchTo().alert().sendKeys("Boo")
    }
}