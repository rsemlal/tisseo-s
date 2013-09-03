package net.rsemlal.tisseos.services.implementations

import java.io.IOException
import org.apache.commons.io.IOUtils
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.eintr.loglady.Logging
import net.rsemlal.tisseos.queries.TisseoQuery
import net.rsemlal.tisseos.services.api.TisseoAPIConfiguration
import net.rsemlal.tisseos.services.api.TisseoConnection
import net.rsemlal.tisseos.services.exceptions.TisseoApiException
import net.rsemlal.tisseos.services.boilerplate.LoggingHelper

object TisseoConnectionImpl {
  final val HTTP_STATUS_OK = 200
}

class TisseoConnectionImpl(val tisseoApiConfiguration: TisseoAPIConfiguration)
  extends TisseoConnection with Logging with LoggingHelper {
  // TODO Proxy mec

  def send(query: TisseoQuery) = {
    log.start("Sending query %s", query)
    
    val uri = buildRequest(query)
    log.debug("query translated to url [%s]", uri)

    log.debug("sending http get request to [%s]", uri)
    val (response, statusCode) = getHttpResponse(uri)
    log.debug("http get request to [%s] returned [%s] status code", uri, statusCode)
    if (statusCode != TisseoConnectionImpl.HTTP_STATUS_OK)
      throw TisseoApiException(s"Request return code id different from ${TisseoConnectionImpl.HTTP_STATUS_OK}")

    log.debug("reading content of the response as string")
    val result = readResponse(response)
    
    log.end("response to query %s readed successfully, it has [%s] chars", query, result.size)

    result
  }

  private def buildRequest(query: TisseoQuery) = {
    val paramsStringList = for ((a, b) <- query.params) yield s"$a=$b"
    val paramsString = paramsStringList.mkString("&")
    val serviceName = query.serviceName
    s"${tisseoApiConfiguration.url}/${serviceName}?${paramsString}"
  }

  private def readResponse(response: org.apache.http.HttpResponse): String = {
    val entity = response.getEntity
    try {
      val content = entity.getContent
      try {
        IOUtils.toString(content)
      } finally {
        IOUtils.closeQuietly(content)
      }
    } catch {
      case t: IOException => throw TisseoApiException(t)
    }
  }

  private def getHttpResponse(uri: String) = try {
    val httpget = new HttpGet(uri)
    val httpclient = new DefaultHttpClient()

    val response = httpclient.execute(httpget)
    val statusCode = response.getStatusLine.getStatusCode

    (response, statusCode)
  } catch {
    case t: IllegalArgumentException => throw TisseoApiException(t)
    case t: ClientProtocolException => throw TisseoApiException(t)
  }

}