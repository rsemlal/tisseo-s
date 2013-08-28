package net.rsemlal.tisseos.queries

import scala.collection.immutable.HashMap
import net.rsemlal.tisseos.data.objects.Id
import net.rsemlal.tisseos.data.objects.Network
import net.rsemlal.tisseos.data.objects.OperatorCode
import net.rsemlal.tisseos.queries.consts.QueryParams
import net.rsemlal.tisseos.queries.consts.QueryStringFormatting

/**
 * @define service departureBoard
 * @define thisclass [[DepartureBoardQuery]].
 */
object DepartureBoardQuery {
  type QueryType = DepartureBoardQuery

  /**
   * Construit une requête $service pour l'api temps réél tisseo (format XML).
   * @param key Clé de l'api.
   * @return Objet $thisclass.
   */
  def apply(key: String) =
    new QueryType(key, TisseoQuery.ResultFormat.Default, HashMap.empty[String, String])

  /**
   * Construit une requête $service pour l'api temps réél tisseo.
   * @param key Clé de l'api.
   * @param format Format de réponse.
   * @return Objet $thisclass.
   */
  def apply(key: String, format: TisseoQuery.ResultFormat.Value) =
    new QueryType(key, format, HashMap.empty[String, String])
}

/**
 * Requête pour le service $service.
 *
 * @param _key Clé de l'api.
 * @param _format Format de retour de la requête (XML ou JSON).
 * @param _params Paramètres additionnels de la requête.
 *
 * @define service departureBoard
 * @define thisclass [[DepartureBoardQuery]].
 */
final class DepartureBoardQuery protected (
  _key: String,
  _format: TisseoQuery.ResultFormat.Value,
  _params: Map[String, String])
  extends TisseoQuery("departureBoard", _key, _format, _params) {

  /**
   * Ajoute un paramètre à la requête.
   * @param param Nom du paramètre.
   * @param value Valeur du paramètre.
   * @return Nouvel objet $thisclass.
   */
  override def +(param: String, value: String) = {
    new DepartureBoardQuery.QueryType(key, format, params + (param -> value))
  }

  /**
   * @param value Opérateur de transport.
   * @return Nouvel objet $thisclass.
   */
  final def network(value: Network) = {
    this.+(QueryParams.network, value.name)
  }

  /**
   * @param value Désigne le code opérateur.
   * @return Nouvel objet $thisclass.
   */
  final def operatorCode(value: OperatorCode) = {
    this.+(QueryParams.operatorCode, value.value).network(value.network)
  }

  /**
   * @param value Filtre sur une seule ligne.
   * @return Nouvel objet $thisclass.
   */
  final def lineId(value: Id) = {
    this.+(QueryParams.lineId, value.value)
  }

  /**
   * @param value Désigne le numéro de l’arrêt physique ou poteau.
   * @return Nouvel objet $thisclass.
   */
  final def stopPointId(value: Id) = {
    this.+(QueryParams.stopPointId, value.value)
  }

  /**
   * @param value Filtre sur le nb maxi de résultats à retourner.
   * @return Nouvel objet $thisclass.
   */
  final def number(value: Int) = {
    this.+(QueryParams.number, value.toString)
  }

  /**
   * @param value Permet de spécifier si on souhaite des horaires « théoriques » ([[Boolean.False]]) ou « temps réels » ([[Boolean.True]]).
   * @return Nouvel objet $thisclass.
   */
  final def displayRealTime(value: Boolean) = {
    this.+(QueryParams.displayRealTime, QueryStringFormatting.booleanToQueryString(value))
  }
}