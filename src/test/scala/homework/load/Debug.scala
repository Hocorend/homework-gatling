package homework.load

import homework.load.load.httpProtocol
import io.gatling.core.Predef._
import homework.load.scenarios.CommonScenario
import scala.concurrent.duration.DurationInt

class Debug extends Simulation {

  // proxy is required on localhost:8888

  setUp(
    CommonScenario().inject(atOnceUsers(1))
  ).protocols(
      httpProtocol
    )
    .maxDuration(10 seconds)
}
