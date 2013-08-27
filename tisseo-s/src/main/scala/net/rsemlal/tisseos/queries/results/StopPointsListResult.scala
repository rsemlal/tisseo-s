package net.rsemlal.tisseos.queries.results

import org.joda.time.DateTime

import net.rsemlal.tisseos.data.Stop
import net.rsemlal.tisseos.data.attributes.DestinationsAttribute
import net.rsemlal.tisseos.data.attributes.ExprationDateAttribute
import net.rsemlal.tisseos.data.attributes.OperatorCodesAttribute
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Retour du service stopPointsList.
 * @param expirationDate Date d'expiration.
 * @param stopPoints Liste des arrêts.
 */
case class StopPointsListResult(expirationDate: DateTime,
  stopPoints: List[Stop with PosAttribute with OperatorCodesAttribute with DestinationsAttribute])
  extends ExprationDateAttribute