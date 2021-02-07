package example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import spray.json.JsValue
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  implicit val system = ActorSystem("graphql-test")

  val route = cors() {
    (post & path("graphql")) {
      entity(as[JsValue]) { requestJson =>
        GraphQLServer.endpoint(requestJson)
      }
    }
  }

  Http()
    .newServerAt("0.0.0.0", 8086)
    .bindFlow(route)

}
