package homework.load.scenarios

import homework.load.Feeders
import homework.load.cases.{GetMainPage, PostLogin}
import io.gatling.core.Predef._
import io.gatling.core.structure._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val loginGroup: ChainBuilder = group("my login"){
    exec(GetMainPage.getMainPage)
      .exec(PostLogin.postLogin)
  }

  val scn: ScenarioBuilder = scenario("Login")
    .feed(Feeders.users)
    .exec(loginGroup)
    .exec { session =>
      // Вывели в консоль всю сессию
      println(session)
      session
    }
}
