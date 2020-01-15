package driver

import org.openqa.selenium.WebDriver

class DriverManager {

    private lateinit var driver: WebDriver

    fun initDriver(): WebDriver {
        driver = DriverManagerFactory().make("CHROME")
        return driver
    }

    fun close() {
        driver.close()
    }
}