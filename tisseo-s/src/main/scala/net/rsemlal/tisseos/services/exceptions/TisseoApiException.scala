package net.rsemlal.tisseos.services.exceptions

class TisseoApiException(message: String, innerException: Throwable)
  extends Exception(message, innerException) {

  def this(message: String) =
    this(message, null)

  def this(innerException: Throwable) =
    this("", innerException)

  def this() =
    this("", null)
}