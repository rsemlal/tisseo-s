package net.rsemlal.tisseos.data.attributes

import org.joda.time.DateTime

trait ExprationDateAttribute {
  /**
   * Date d'expiration.
   */
  val expirationDate: DateTime
}