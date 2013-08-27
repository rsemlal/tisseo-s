package net.rsemlal.tisseos.queries

import scala.collection.immutable.HashMap

import net.rsemlal.tisseos.data.objects.Id
import net.rsemlal.tisseos.data.objects.Network
import net.rsemlal.tisseos.queries.consts.QueryParams
import net.rsemlal.tisseos.queries.consts.QueryStringFormatting

/**
 * @define service linesList
 * @define thisclass [[LinesListQuery]].
 */
object LinesListQuery {
  type QueryType = LinesListQuery

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
 * @define service linesList
 * @define thisclass [[LinesListQuery]].
 */
final class LinesListQuery protected (
  _key: String,
  _format: TisseoQuery.ResultFormat.Value,
  _params: Map[String, String])
  extends TisseoQuery("linesList", _key, _format, _params) {

  /**
   * Ajoute un paramètre à la requête.
   * @param param Nom du paramètre.
   * @param value Valeur du paramètre.
   * @return Nouvel objet $thisclass.
   */
  override def +(param: String, value: String) = {
    new LinesListQuery.QueryType(key, format, params + (param -> value))
  }

  /**
   * @param value Opérateur de transport.
   * @return Nouvel objet $thisclass.
   */
  final def network(value: Network) = {
    this.+(QueryParams.network, value.name)
  }

  /**
   * Opérateur de transport.
   */
  final def network = this.params.get(QueryParams.network).map { value =>
    Network(value)
  }

  /**
   * @param value Filtre sur une seule ligne.
   * @return Nouvel objet $thisclass.
   */
  final def lineId(value: Id) = {
    this.+(QueryParams.lineId, value.value)
  }

  /**
   * Filtre sur une seule ligne.
   */
  final def lineId = this.params.get(QueryParams.lineId).map { value =>
    Id(value)
  }

  /**
   * @param value Retourne en plus les arrêts logiques terminus de chaque ligne.
   * @return Nouvel objet $thisclass.
   */
  final def displayTerminus(value: Boolean) = {
    this.+(QueryParams.displayTerminus, QueryStringFormatting.booleanToQueryString(value))
  }

  /**
   * Retourne en plus les arrêts logiques terminus de chaque ligne.
   */
  final def displayTerminus =
    this.params
      .get(QueryParams.displayTerminus)
      .flatMap(QueryStringFormatting.queryStringToBoolean _)
}