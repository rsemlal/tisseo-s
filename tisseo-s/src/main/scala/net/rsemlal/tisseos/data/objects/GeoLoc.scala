package net.rsemlal.tisseos.data.objects

/**
 * Position géographique.
 * @param x Latitude.
 * @param y Longitude.
 * @param srid [[SRID]].
 */
case class GeoLoc(override val x: Double, override val y: Double, srid: Srid)
  extends Coords(x, y)