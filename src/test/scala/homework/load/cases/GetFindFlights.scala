package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetFindFlights {

  val getFindFlights: HttpRequestBuilder = http("GET /cgi-bin/welcome.pl?page=search")
    .get("/cgi-bin/welcome.pl?page=search")
    .check(status is 200)
    .resources(
      http("GET /cgi-bin/reservations.pl?page=welcome")
        .get("/cgi-bin/reservations.pl?page=welcome")
        .check(
          regex(""">(.*?)</option>""").findAll.saveAs("cities")
        ),
      http("GET /cgi-bin/nav.pl?page=menu&in=flights")
        .get("/cgi-bin/nav.pl?page=menu&in=flights")
        .check(status is 200)
    )
}
