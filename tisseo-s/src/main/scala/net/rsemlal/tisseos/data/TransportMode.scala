package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.objects.Id
import net.rsemlal.tisseos.data.attributes.IdAttribute

/**
 * Mode de transport.
 * @param id Identifiant.
 * @param article Article.
 * @param name Nom du mode de transport.
 */
case class TransportMode(id: Id, article: String, name: String)
  extends IdAttribute