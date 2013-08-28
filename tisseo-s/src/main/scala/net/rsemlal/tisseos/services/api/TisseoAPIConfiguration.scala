package net.rsemlal.tisseos.services.api

import java.net.URL

/**
 * Configuration de l'api.
 */
trait TisseoAPIConfiguration {
  /**
   * Url de l'api.
   */
  def url: URL

  /**
   * Clé de l'api.
   */
  def key: String
}