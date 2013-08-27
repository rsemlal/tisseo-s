package net.rsemlal.tisseos.queries

import net.rsemlal.tisseos.data.objects.Coords
package object consts {
  /**
   * Objet Bbox
   */
  type Bbox = (Coords, Coords)

  final val QueryFalse = "0"
  final val QueryTrue = "1"
}