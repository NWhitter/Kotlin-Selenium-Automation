package pages

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


abstract class Page(internal var driver: WebDriver) {
    val wait: WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(10))

    fun visit(url: String) {
        driver.get(url)
        waitUntilPageIsReady(driver)
    }

    private fun waitUntilPageIsReady(driver: WebDriver) {
        val executor = driver as JavascriptExecutor
        wait.until { executor.executeScript("return document.readyState") == "complete" }
    }

    fun close() {
        driver.quit()
    }
}