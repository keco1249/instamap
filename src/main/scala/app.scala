import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import spray.routing.HttpService
import akka.io.IO
import spray.can.Http

object Application extends App {
  implicit val system = ActorSystem("instamap")

  val apiService = system.actorOf(Props(classOf[APIActor]),
   	  name = "APIServiceActor")

  IO(Http) ! Http.Bind(apiService, interface = "0.0.0.0", port = 8000)
}

trait RestAPIService extends HttpService {

  val route = {
    path("hub") {
      get {
        parameter("hub.challenge") { challenge: String =>
          complete {
            challenge
          }
        }
      }~
      post {
        entity(as[String]) { request =>
          println(request)
          complete {
            "OK"
          }
        }
      }
    }
  }
}

class APIActor extends Actor with RestAPIService{

  implicit val actorRefFactory = context
  def receive = runRoute(route)
}
