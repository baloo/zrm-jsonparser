// vim: foldmethod=marker :
package net.superbaloo.zrm
package jsonparser


import play.api.libs.json.{Json,
                           JsValue,
                           JsObject,
                           JsString,
                           JsNumber,
                           Format}

/*
{
  "login": "octocat",
  "id": 1,
  "avatar_url": "https://github.com/images/error/octocat_happy.gif",
  "gravatar_id": "somehexcode",
  "url": "https://api.github.com/users/octocat",
  "name": "monalisa octocat",
  "company": "GitHub",
  "blog": "https://github.com/blog",
  "location": "San Francisco",
  "email": "octocat@github.com",
  "hireable": false,
  "bio": "There once was...",
  "public_repos": 2,
  "public_gists": 1,
  "followers": 20,
  "following": 0,
  "html_url": "https://github.com/octocat",
  "created_at": "2008-01-14T04:33:35Z",
  "type": "User"
}
*/

object User {
  implicit object UserFormat extends Format[User] {
    def reads(json: JsValue): User = User(
      (json \ "login").as[String],
      (json \ "id").as[Int],
      (json \ "name").as[String]
      )

    def writes(user: User): JsValue = JsObject(List(
      "login" -> JsString(user.login),
      "id" -> JsNumber(user.id),
      "name" -> JsString(user.name),
      "type" -> JsString("User")
    ))
  }

  def fromJson(j: JsValue) = Json.fromJson(j)
  def fromJson(j: String) = Json.fromJson(Json.parse(j))
}


case class User(
  login: String,
  id: Long,
  name: String) {

  def toJson: JsValue = Json.toJson(this)


  // {{{ Light
  def toJsonLight: JsValue = Json.toJson(this)(UserLight.UserLightFormat)
  // }}}
}


// vim: ts=2 sw=2 ft=scala et foldmethod=marker:
