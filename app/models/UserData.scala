package models

import play.api.data.Form
import play.api.data.Forms._

case class UserData(username: String, password: String)
object UserData {
  val form = Form (
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText(minLength = 6, maxLength = 8)

    )(UserData.apply)(UserData.unapply)
  )
}