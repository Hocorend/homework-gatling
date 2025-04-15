package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object PostLogin {

  val postLogin: HttpRequestBuilder = http("POST /")
    .post("/webtours/")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "#{username}")
    .formParam("password", "#{password}")
    .check(status is 200)
}
