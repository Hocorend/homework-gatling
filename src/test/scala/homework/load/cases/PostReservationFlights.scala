package homework.load.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object PostReservationFlights {

  val postSelectCities: HttpRequestBuilder = http("POST /cgi-bin/reservations.pl SelectCities")
    .post("/cgi-bin/reservations.pl")
    .header("Cookie", "#{MSO}")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{cities.random()}")
    .formParam("departDate", "06/16/2025")
    .formParam("arrive", "#{cities.random()}")
    .formParam("returnDate", "06/17/2025")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "50")
    .formParam("findFlights.y", "14")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(
      regex("""name="outboundFlight" value="(.*?)"""").findAll.saveAs("outboundFlights")
    )

  val postSelectDepartureTime: HttpRequestBuilder = http("POST /cgi-bin/reservations.pl SelectDepartureTime")
    .post("/cgi-bin/reservations.pl")
    .header("Cookie", "#{MSO}")
    .formParam("outboundFlight", "#{outboundFlights.random()}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "69")
    .formParam("reserveFlights.y", "9")
    .check(status is 200)
    .check(bodyString.saveAs("responseBody"))
    .check(
      regex("""name="outboundFlight" value="(.*?)"""").saveAs("outboundFlight")
    )

  val postPaymentFlights: HttpRequestBuilder = http("POST /cgi-bin/reservations.pl PaymentFlights")
    .post("/cgi-bin/reservations.pl")
    .header("Cookie", "#{MSO}")
    .formParam("firstName", "")
    .formParam("lastName", "")
    .formParam("address1", "")
    .formParam("address2", "")
    .formParam("pass1", " ")
    .formParam("creditCard", "creditcard")
    .formParam("expDate", "expCa")
    .formParam("saveCC", "on")
    .formParam("oldCCOption", "on")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "16")
    .formParam("buyFlights.y", "11")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)
}