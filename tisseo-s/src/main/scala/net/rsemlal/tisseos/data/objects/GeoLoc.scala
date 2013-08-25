package net.rsemlal.tisseos.data.objects

/**
 * Position géographique.
 * @param x Latitude.
 * @param y Longitude.
 * @param srid SRID (http://en.wikipedia.org/wiki/SRID).
 */
case class GeoLoc(x: Double, y: Double, srid: String)