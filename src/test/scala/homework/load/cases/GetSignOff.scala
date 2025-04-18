package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetSignOff {


  val getSignOff: HttpRequestBuilder = http("GET /cgi-bin/welcome.pl?signOff=1")
    .get("/cgi-bin/welcome.pl?signOff=1")
    .check(status is 200)
    .resources(
      http("GET /cgi-bin/nav.pl?in=home")
        .get("/cgi-bin/nav.pl?in=home")
        .check(status is 200),
      http("GET /WebTours/home.html")
        .get("/WebTours/home.html")
        .check(status is 200)
    )
}
