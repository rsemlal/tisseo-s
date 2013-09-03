package net.rsemlal.tisseos.services.exceptions

import net.rsemlal.tisseos.services.boilerplate.ExceptionHelper

object TisseoApiException extends ExceptionHelper[TisseoApiException] {
  def apply(message: String, innerException: Throwable) = {
    new TisseoApiException(message, innerException)
  }
}

/**
 * Exception d'utilisation l'api tisseo.
 * @param message Message.
 * @param innerException Erreur imbriquée.
 */
class TisseoApiException(message: String, innerException: Throwable)
  extends Exception(message, innerException)