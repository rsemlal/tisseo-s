package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.additionnals.Destination

trait DestinationsAttribute {
  val destinations: Set[Destination]
}