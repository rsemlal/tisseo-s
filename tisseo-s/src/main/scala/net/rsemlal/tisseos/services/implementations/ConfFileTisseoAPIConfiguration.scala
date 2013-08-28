package net.rsemlal.tisseos.services.implementations

import java.net.URL
import java.util.Properties

import net.rsemlal.tisseos.services.api.TisseoAPIConfiguration

object ConfFileTisseoAPIConfiguration {
  final val configFileRessource = "tisseo-api.properties"
  final val urlKey = "api.url"
  final val keyKey = "api.key"
}

class ConfFileTisseoAPIConfiguration extends TisseoAPIConfiguration {

  private val contextClassLoader = Thread.currentThread.getContextClassLoader
  private val strm = contextClassLoader.getResourceAsStream(ConfFileTisseoAPIConfiguration.configFileRessource)
  require(strm != null)
  private val props = new Properties()
  props.load(strm)
  private val _url = props.getProperty(ConfFileTisseoAPIConfiguration.urlKey)
  private val _key = props.getProperty(ConfFileTisseoAPIConfiguration.urlKey)
  require(_url != null)
  require(_key != null)

  final lazy val url = {
    new URL(_url)
  }

  final lazy val key = {
    _key
  }
}