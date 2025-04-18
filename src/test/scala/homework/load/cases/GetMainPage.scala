package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetMainPage {

  val getMainPage: HttpRequestBuilder = http("GET /webtours/")
    .get("/webtours/")
    .check(status is 200)
    .resources(
      http("GET /cgi-bin/welcome.pl?signOff=true")
        .get("/cgi-bin/welcome.pl?signOff=true")
        .check(status is 200)
    )

  val getUserSession: HttpRequestBuilder = http("GET /cgi-bin/nav.pl?in=home")
    .get("/cgi-bin/nav.pl?in=home")
    .check(status is 200)
    .check(
            regex("""<input type="hidden" name="userSession" value="(.*?)"/>""").saveAs("userSession")
          )
}
