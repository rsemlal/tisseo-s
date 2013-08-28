package net.rsemlal.tisseos.queries

import scala.collection.immutable.HashMap

import net.rsemlal.tisseos.queries.consts.QueryParams

object TisseoQuery {
  /**
   * Construit une requête pour l'api temps réél tisseo (format XML).
   * @param serviceName Nom du service.
   * @param key Clé de l'api.
   * @return Objet [[TisseoQuery]].
   */
  def apply(serviceName: String, key: String) =
    new TisseoQuery(serviceName, key, ResultFormat.Default, HashMap.empty[String, String])

  /**
   * Construit une requête pour l'api temps réél tisseo.
   * @param serviceName Nom du service.
   * @param key Clé de l'api.
   * @param format Format de réponse.
   * @return Objet [[TisseoQuery]].
   */
  def apply(serviceName: String, key: String, format: ResultFormat.Value) =
    new TisseoQuery(serviceName, key, format, HashMap.empty[String, String])

  object ResultFormat {
    /**
     * Type de résultat de la requête.
     * @param value Valeur du paramètre format.
     */
    class Value(val value: String)

    /**
     * Format xml.
     */
    case object Xml extends Value("xml")

    /**
     * Format json.
     */
    case object Json extends Value("json")

    /**
     * Format par défaut.
     */
    val Default = Xml
  }
}

/**
 * Requête Tisséo immutable.
 * @param serviceName Nom du service.
 * @param key Clé de l'api.
 * @param format Format de retour de la requête (XML ou JSON).
 * @param params Paramètres additionnels de la requête.
 */
class TisseoQuery protected (
  val serviceName: String,
  val key: String,
  val format: TisseoQuery.ResultFormat.Value,
  _params: Map[String, String]) {

  /**
   * Ajoute un paramètre à la requête.
   * @param param Nom du paramètre.
   * @param value Valeur du paramètre.
   * @return Nouvel objet [[TisseoQuery]].
   */
  def +(param: String, value: String) = {
    new TisseoQuery(serviceName, key, format, _params + (param -> value))
  }

  /**
   * Paramètres de la requête.
   */
  final lazy val params = {
    _params + (QueryParams.format -> format.value) + (QueryParams.key -> key)
  }

  override final lazy val toString = {
    val strParams = for ((a, b) <- params) yield a + " = " + b
    s"${this.getClass.getSimpleName}(service = ${serviceName}, key = ${key}, ${strParams.mkString(", ")})"
  }
}