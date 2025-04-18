package homework.load

import homework.load.load.httpProtocol
import homework.load.scenarios.CommonScenario
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig.{intensity, rampDuration, stageDuration, stagesNumber, testDuration}

import scala.concurrent.duration.DurationInt

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
