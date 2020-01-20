package driver

class DriverManager {

    fun initDriver() = DriverManagerFactory().make("CHROME")
}