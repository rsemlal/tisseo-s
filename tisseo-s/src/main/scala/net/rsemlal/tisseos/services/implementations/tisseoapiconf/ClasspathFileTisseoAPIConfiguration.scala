package net.rsemlal.tisseos.services.implementations.tisseoapiconf

import java.io.IOException
import java.net.MalformedURLException
import java.net.URL
import java.util.Properties
import org.eintr.loglady.Logging
import net.rsemlal.tisseos.services.exceptions.TisseoApiException
import net.rsemlal.tisseos.services.boilerplate.LoggingHelper

object ClasspathFileTisseoAPIConfiguration {
  final val configFileRessource = "tisseo-api.properties"
  final val urlKey = "tisseo.api.url"
  final val keyKey = "tisseo.api.key"
}

/**
 * Implémentation de [[TisseoAPIConfiguration]] qui charge la configuration depuis un fichier dans le classpath.
 */
class ClasspathFileTisseoAPIConfiguration
  extends WrappedTisseoAPIConfiguration with Logging with LoggingHelper {

  protected val stub = readFile(ClasspathFileTisseoAPIConfiguration.configFileRessource)

  private def readFile(classpathFile: String) = {
    log.start("Lecture de la configuration depuis le fichier [%s] dans le classpath", classpathFile)
    try {
      val props = loadProperties(classpathFile)

      val result = new MutableTisseoAPIConfiguration

      val _url = readProperty(props, ClasspathFileTisseoAPIConfiguration.urlKey)
      result.url = new URL(_url)

      result.key = readProperty(props, ClasspathFileTisseoAPIConfiguration.keyKey)

      result
    } catch {
      case t: IOException => throw TisseoApiException(t)
      case t: MalformedURLException => throw TisseoApiException(t)
    }
  }

  private def loadProperties(classpathFile: String): java.util.Properties = {
    val contextClassLoader = Thread.currentThread.getContextClassLoader

    val strm = contextClassLoader.getResourceAsStream(classpathFile)
    if (strm == null)
      throw TisseoApiException(s"Cannot find any file [$classpathFile] in the classpath")

    try {
      log.debug("Le fichier [%s] existe dans le classpath, il sera charge", classpathFile)
      val props = new Properties()
      props.load(strm)
      props
    } finally {
      strm.close()
    }
  }

  private def readProperty(props: Properties, key: String) = {
    log.debug("Lecture de la propiete [%s]", key)
    val value = props.getProperty(key)
    log.debug("Propriete lue [%s] = [%s]", key, value)
    if (value == null)
      throw TisseoApiException(s"Property [$key] is not defined")
    value
  }

}