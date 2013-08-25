package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.attributes.IdAttribute
import net.rsemlal.tisseos.data.additionnals.Id

/**
 * Zone d'arrêt.
 * @param id Identifiant.
 * @param name Nom de la zone d'arrêt.
 */
case class StopArea(id: Id, name: String)
  extends IdAttribute