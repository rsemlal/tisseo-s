package net.rsemlal.tisseos.data.queryresults

import org.joda.time.DateTime
import net.rsemlal.tisseos.data.Departure
import net.rsemlal.tisseos.data.StopArea
import net.rsemlal.tisseos.data.Stop

/**
 * Retour du service stopPointsList.
 * @param expirationDate Date d'expiration.
 * @param stopArea Zone d'arrêt.
 * @param stop Arrêt.
 * @param departures Liste des départs.
 */
case class DepartureBoardListResult(expirationDate: DateTime,
  stopArea: StopArea,
  stop: Stop,
  departures: List[Departure])