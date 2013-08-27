package net.rsemlal.tisseos.queries.results

import org.joda.time.DateTime

import net.rsemlal.tisseos.data.attributes.ExprationDateAttribute
import net.rsemlal.tisseos.data.attributes.PosAttribute
import net.rsemlal.tisseos.data.places.Place

/**
 * Retour du service placesList.
 * @param expirationDate Date d'expiration.
 * @param places Liste des places.
 */
case class PlacesListResult(
  expirationDate: DateTime,
  places: List[Place with PosAttribute])
  extends ExprationDateAttribute