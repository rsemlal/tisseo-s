package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.additionnals.Color
import net.rsemlal.tisseos.data.additionnals.Network
import net.rsemlal.tisseos.data.additionnals.Id
import net.rsemlal.tisseos.data.attributes.IdAttribute
import net.rsemlal.tisseos.data.attributes.NetworkAttribute

/**
 * Ligne.
 * @param id Identifiant.
 * @param name Nom de la ligne.
 * @param shortName Nom court de la ligne.
 * @param color Couleur de la ligne.
 * @param network Réseau de transport.
 */
case class Line(id: Id, name: String, shortName: String, color: Color, network: Network)
  extends IdAttribute
  with NetworkAttribute