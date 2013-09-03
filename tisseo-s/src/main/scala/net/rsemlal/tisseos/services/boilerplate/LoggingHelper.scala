package net.rsemlal.tisseos.services.boilerplate

import org.eintr.loglady.Logging
import org.eintr.loglady.Logger

/**
 * Helper de logging.
 */
trait LoggingHelper {
  this: Logging =>

  implicit def toRichLogging(_log: Logger) = new {
    /**
     * Debut de section.
     */
    final def start(message: String, params: Any*) {
      _log.debug(s"start - $message", params:_*)
    }

    /**
     * Fin de section.
     */
    final def end(message: String, params: Any*) {
      _log.debug(s"end - $message", params:_*)
    }
  }
}