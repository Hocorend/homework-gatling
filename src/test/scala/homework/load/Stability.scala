package homework.load

import homework.load.load.httpProtocol
import homework.load.scenarios.CommonScenario
import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._

class Stability extends Simulation {

  setUp(
    CommonScenario().inject(
      rampUsersPerSec(0) to intensity during rampDuration, //разгон
      constantUsersPerSec(intensity) during stageDuration //полка
    )
  ).protocols(httpProtocol)
    .maxDuration(testDuration) //длительность теста = разгон + полка

}
