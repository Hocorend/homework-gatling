package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetMainPage {

  val getMainPage: HttpRequestBuilder = http("GET /")
    .get("/webtours/")
    .check(status is 200)
    .header("Cookie", "MSO=SID&1744708348")
    .resources(
      http("GET /cgi-bin/welcome.pl?signOff=true")
        .get("/cgi-bin/welcome.pl?signOff=true")
        .header("Cookie", "MSO=SID&1744708348")
        .check(status is 200),
      http("GET /nav.pl?in=home")
        .get("/cgi-bin/nav.pl?in=home")
        .header("Cookie", "MSO=SID&1744708348")
        .check(
          regex("""<input type="hidden" name="userSession" value="(.*?)"/>""").saveAs("userSession")
        )
    )
}
