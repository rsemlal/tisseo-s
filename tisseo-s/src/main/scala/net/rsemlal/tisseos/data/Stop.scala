package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.additionnals.Id
import net.rsemlal.tisseos.data.attributes.IdAttribute

/**
 * Arrêt.
 * @param id Identifiant.
 * @param name Nom de l'arrêt.
 */
case class Stop(id: Id, name: String)
  extends IdAttribute

