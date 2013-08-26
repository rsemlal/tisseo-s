package net.rsemlal.tisseos.data.objects

object Coords {
  def apply(x: Double, y: Double) =
    new Coords(x, y)

  def unapply(o: Coords) =
    Some((o.x, o.y))
}

/**
 * Coordonnées géographique.
 * @param x Latitude.
 * @param y Longitude.
 */
class Coords(val x: Double, val y: Double)