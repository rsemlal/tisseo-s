package net.rsemlal.tisseos.data.queryresults

import org.joda.time.DateTime

import net.rsemlal.tisseos.data.Message
import net.rsemlal.tisseos.data.attributes.ExprationDateAttribute

/**
 * Résultat de la requête messagesList.
 * @param expirationDate Date d'expiration.
 * @param messages Messages.
 */
case class MessagesListResult(expirationDate: DateTime,
  messages: List[Message])
  extends ExprationDateAttribute