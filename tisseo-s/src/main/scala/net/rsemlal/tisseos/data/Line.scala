package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.additionnals.Color
import net.rsemlal.tisseos.data.additionnals.Network
import net.rsemlal.tisseos.data.additionnals.Id
import net.rsemlal.tisseos.data.ifaces.IdentifiedObject
import net.rsemlal.tisseos.data.ifaces.NetworkObject

case class Line(id: Id, name: String, shortName: String, color: Color, network: Network)
  extends IdentifiedObject
  with NetworkObject