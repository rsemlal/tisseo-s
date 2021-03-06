package net.rsemlal.tisseos.queries

import scala.collection.immutable.HashMap
import net.rsemlal.tisseos.data.objects.Id
import net.rsemlal.tisseos.data.objects.Network
import net.rsemlal.tisseos.data.objects.Srid
import net.rsemlal.tisseos.queries.consts.Bbox
import net.rsemlal.tisseos.queries.consts.QueryParams
import net.rsemlal.tisseos.queries.consts.QueryStringFormatting
import net.rsemlal.tisseos.queries.consts.QueryServices

/**
 * @define service stopAreasList
 * @define thisclass [[StopAreasListQuery]].
 */
object StopAreasListQuery {
  type QueryType = StopAreasListQuery

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
 * @define service stopAreasList
 * @define thisclass [[StopAreasListQuery]].
 */
final class StopAreasListQuery protected (
  _key: String,
  _format: TisseoQuery.ResultFormat.Value,
  _params: Map[String, String])
  extends TisseoQuery(QueryServices.stopAreasList, _key, _format, _params) {

  /**
   * Ajoute un paramètre à la requête.
   * @param param Nom du paramètre.
   * @param value Valeur du paramètre.
   * @return Nouvel objet $thisclass.
   */
  override def +(param: String, value: String) = {
    new StopAreasListQuery.QueryType(key, format, params + (param -> value))
  }

  /**
   * @param value Opérateur de transport.
   * @return Nouvel objet $thisclass.
   */
  final def network(value: Network) = {
    this.+(QueryParams.network, value.name)
  }

  /**
   * @param value Filtre sur une seule ligne.
   * @return Nouvel objet $thisclass.
   */
  final def lineId(value: Id) = {
    this.+(QueryParams.lineId, value.value)
  }

  /**
   * @param value Filtre sur les zones d’arrêts arrivant et partant de ce terminus uniquement.
   * @return Nouvel objet $thisclass.
   */
  final def terminusId(value: Id) = {
    this.+(QueryParams.terminusId, value.value)
  }

  /**
   * @param value Filtre pour les arrêts dont les données GPS sont comprises dans ce bounding box.
   * @return Nouvel objet $thisclass.
   */
  final def bbox(value: Bbox) = {
    this.+(QueryParams.bbox, QueryStringFormatting.bboxToQueryString(value))
  }

  /**
   * @param value Numéro SRID du référentiel de projection spatial.
   * @return Nouvel objet $thisclass.
   */
  final def srid(value: Srid) = {
    this.+(QueryParams.srid, value.value)
  }

  /**
   * @param value Retourne en plus les lignes de chaque arrêt.
   * @return Nouvel objet $thisclass.
   */
  final def displayLines(value: Boolean) = {
    this.+(QueryParams.displayLines, QueryStringFormatting.booleanToQueryString(value))
  }

  /**
   * @param value Retourne en plus les coordonnées de chaque arrêt. C’est le barycentre des arrêts de la zone.
   * @return Nouvel objet $thisclass.
   */
  final def displayCoordXY(value: Boolean) = {
    this.+(QueryParams.displayCoordXY, QueryStringFormatting.booleanToQueryString(value))
  }
}