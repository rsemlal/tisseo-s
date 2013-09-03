package net.rsemlal.tisseos.services.api

import net.rsemlal.tisseos.queries.TisseoQuery

trait TisseoConnection {
  /**
   * Envoi la requête passée en paramètre et retourne le résultat.
   * @param query Requête.
   * @return Résultat de la requête.
   */
  def send(query: TisseoQuery): String
}