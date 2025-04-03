package homework.load

import homework.load.load.httpProtocol
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import homework.load.scenarios.CommonScenario
class Debug extends Simulation {

  // proxy is required on localhost:8888

  setUp(
    CommonScenario().inject(atOnceUsers(1))
  ).protocols(
      httpProtocol
    )
    .maxDuration(testDuration)

}
