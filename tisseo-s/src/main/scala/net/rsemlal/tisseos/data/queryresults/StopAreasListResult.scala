package net.rsemlal.tisseos.data.queryresults

import org.joda.time.DateTime

import net.rsemlal.tisseos.data.StopArea
import net.rsemlal.tisseos.data.attributes.ExprationDateAttribute
import net.rsemlal.tisseos.data.attributes.LinesAttribute
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Retour du service stopAreasList.
 * @param expirationDate Date d'expiration.
 * @param stopAreas Liste des zones d'arrêt.
 */
case class StopArerasListResult(expirationDate: DateTime,
  stopAreas: List[StopArea with PosAttribute with LinesAttribute])
  extends ExprationDateAttribute