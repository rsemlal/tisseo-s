package net.rsemlal.tisseos.data.objects

object Network {
  /**
   * Réseau Tisseo.
   */
  object Tisseo extends Network("Tisséo")

  /**
   * Réseau par défaut.
   */
  val Default = Tisseo
}

/**
 * Réseau.
 * @param name Nom du réseau de transport.
 */
case class Network(name: String)