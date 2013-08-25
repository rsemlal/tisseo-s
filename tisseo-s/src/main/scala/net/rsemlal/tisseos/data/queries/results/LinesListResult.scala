package net.rsemlal.tisseos.data.queries.results

import org.joda.time.DateTime

import net.rsemlal.tisseos.data.Line
import net.rsemlal.tisseos.data.attributes.ExprationDateAttribute
import net.rsemlal.tisseos.data.attributes.TerminusAttribute
import net.rsemlal.tisseos.data.attributes.TransportModeAttribute

/**
 * Retour du service linesList.
 * @param expirationDate Date d'expiration.
 * @param lines Liste des lignes.
 */
case class LinesListResult(expirationDate: DateTime,
  lines: List[Line with TransportModeAttribute with TerminusAttribute])
  extends ExprationDateAttribute