package homework.load.scenarios

import homework.load.Feeders
import homework.load.cases.{GetFindFlights, GetMainPage, GetSignOff, PostLogin, PostReservationFlights}
import io.gatling.core.Predef._
import io.gatling.core.structure._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val loginGroup: ChainBuilder = group("login") {
    exec(GetMainPage.getMainPage)
      .exec(GetMainPage.getUserSession)
      .exec(PostLogin.postLogin)
  }

  val findFlights: ChainBuilder = group("find flights") {
    exec(GetFindFlights.getFindFlights)
  }

  val reservationFlights: ChainBuilder = group("reservation flights") {
    exec(PostReservationFlights.postSelectCities)
      .exec(PostReservationFlights.postSelectDepartureTime)
      .exec(PostReservationFlights.postPaymentFlights)
  }

  val signOff: ChainBuilder = group("sign off") {
    exec(GetSignOff.getSignOff)
  }

  val scn: ScenarioBuilder = scenario("webtours.load-test.ru")
    .feed(Feeders.users)
    .exec(loginGroup)
    .exec(findFlights)
    .exec(reservationFlights)
    .exec(signOff)
}
