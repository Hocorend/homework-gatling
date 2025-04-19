package homework.load

import homework.load.load.httpProtocol
import homework.load.scenarios.CommonScenario
import io.gatling.core.Predef._
import org.galaxio.gatling.config.SimulationConfig._

class MaxPerformance extends Simulation {

  setUp(
    CommonScenario().inject(
      incrementUsersPerSec(intensity / stagesNumber) // интенсивность на ступень
        .times(stagesNumber) // Количество ступеней
        .eachLevelLasting(stageDuration) // Длительность полки
        .separatedByRampsLasting(rampDuration) // Длительность разгона
        .startingFrom(0) // Начало нагрузки с
    )
  )
    .protocols(httpProtocol)
    .maxDuration(testDuration) // Total test duration

}
