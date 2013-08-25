package net.rsemlal.tisseos.data

/**
 * Message.
 * @param mtype Type du message.
 * @param importanceLevel Niveau d'importance {normal, important}.
 * @param scope Le message concerne... liste de lignes ou 'global'.
 * @param content Contenu.
 * @param url pointe sur la source officielle de l’information : une page du site tisseo.fr.
 */
case class Message(
  mtype: String,
  importanceLevel: String,
  scope: String,
  content: String,
  url: String)