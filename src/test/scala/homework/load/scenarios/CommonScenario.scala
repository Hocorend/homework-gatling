package homework.load.scenarios

import homework.load.cases.GetMainPage
import io.gatling.core.Predef._
import io.gatling.core.structure._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().root
}

class CommonScenario {

  val root = scenario("Root_Page")
    .exec(GetMainPage.getMainPage)
}
