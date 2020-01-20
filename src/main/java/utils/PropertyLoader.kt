package utils

import java.util.*


class PropertyLoader {

    val baseUrl = "baseUrl"

    private val propsFile = "/config.properties"
    private val props = Properties()

    init {
        props.load(this.javaClass.getResourceAsStream(propsFile))
        props.putAll(System.getProperties()) // Override properties with command line arguments
    }

    fun getProperty(name: String?): String? {
        return props.getProperty(name)
    }
}