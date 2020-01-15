package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.BrowserType.CHROME
import org.openqa.selenium.remote.BrowserType.FIREFOX
import java.util.concurrent.TimeUnit

class DriverManagerFactory {

    private val windowSize: Dimension = Dimension(1280, 1080)

    fun make(type: String?): WebDriver {

        when (type) {
            CHROME -> {
                WebDriverManager.chromedriver().setup()

                val options = ChromeOptions()
                options.addArguments("--no-sandbox")
                options.addArguments(
                        "--window-size=" + windowSize.getWidth() + "," + windowSize.getHeight())

                val driver = ChromeDriver(options)
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

                return driver
            }
            FIREFOX -> {
                WebDriverManager.firefoxdriver().setup()
                return FirefoxDriver()
            }
            else -> {
                WebDriverManager.chromedriver().setup()

                val options = ChromeOptions()
                options.addArguments("--no-sandbox")
                options.addArguments(
                        "--window-size=" + windowSize.getWidth() + "," + windowSize.getHeight())

                return ChromeDriver()
            }
        }
    }
}