package net.rsemlal.tisseos.data

import net.rsemlal.tisseos.data.ifaces.IdentifiedObject
import net.rsemlal.tisseos.data.additionnals.Id

case class TransportMode(id: Id, article: String, name: String)
  extends IdentifiedObject