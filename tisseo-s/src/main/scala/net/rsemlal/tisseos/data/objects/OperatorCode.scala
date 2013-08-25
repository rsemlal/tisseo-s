package net.rsemlal.tisseos.data.objects

import net.rsemlal.tisseos.data.attributes.NetworkAttribute

/**
 * Code opérateur d'une station.
 * @param value Valeur du code opérateur.
 * @param network Réseau de transport qui affecte ce code.
 */
case class OperatorCode(value: String, network: Network)
  extends NetworkAttribute