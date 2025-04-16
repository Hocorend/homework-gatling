package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object PostLogin {

  val postLogin: HttpRequestBuilder = http("POST /cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "#{username}")
    .formParam("password", "#{password}")
    .check(status is 200)
    .resources(
      http("GET /cgi-bin/nav.pl?page=menu&in=home")
        .get("/cgi-bin/nav.pl?page=menu&in=home")
        .check(status is 200),
      http("GET /cgi-bin/login.pl?intro=true")
        .get("/cgi-bin/login.pl?intro=true")
        .check(status is 200)


    )
}
