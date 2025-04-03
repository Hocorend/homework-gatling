package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetMainPage {

  val getMainPage = http("GET /")
    .get("/")
    .check(status is 200)

}
