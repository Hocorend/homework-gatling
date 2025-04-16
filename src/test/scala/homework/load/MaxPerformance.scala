package homework.load

import homework.load.load.httpProtocol
import homework.load.scenarios.CommonScenario
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig.{intensity, rampDuration, stageDuration, stagesNumber}

import scala.concurrent.duration.DurationInt

class MaxPerformance extends Simulation {

  setUp(
    CommonScenario().inject(
      incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
        .times(stagesNumber) // Количество ступеней
        .eachLevelLasting(stageDuration) // Длительность полки
        .separatedByRampsLasting(rampDuration) // Длительность разгона
        .startingFrom(0) // Начало нагрузки с
    )
  ).protocols(httpProtocol)
    .maxDuration(5 minutes) // Total test duration

}
