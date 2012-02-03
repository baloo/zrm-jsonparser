package net.superbaloo.zrm
package jsonparser


import play.api.libs.json.{Json,
                           JsValue,
                           JsObject,
                           JsString,
                           JsNumber,
                           Writes,
                           Format}

object UserLight {
  object UserLightFormat extends Writes[User] {
    def writes(user: User): JsValue = JsObject(List(
      "login" -> JsString(user.login),
      "id" -> JsNumber(user.id)
    ))
  }
}

// vim: set ts=2 sw=2 ft=scala et:
