package homework.load

import homework.load.load.httpProtocol
import homework.load.scenarios.CommonScenario
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations

class Stability extends Simulation {

  setUp(
    CommonScenario().inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration, //разгон
      constantUsersPerSec(intensity.toInt) during stageDuration //полка
    )
  ).protocols(httpProtocol)
    .maxDuration(testDuration) //длительность теста = разгон + полка

}
