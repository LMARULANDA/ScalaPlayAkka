package controllers

import com.google.inject.{Inject, Singleton}
import models.HelloWorld
import play.api.mvc.{AbstractController, ControllerComponents}
import services.THelloWorldService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HelloWorldDIAndScalaFutureController @Inject()(helloWorldService: THelloWorldService, controllerComponents: ControllerComponents) (implicit ec: ExecutionContext)  extends AbstractController(controllerComponents) {

  def helloWorld = Action.async {
    val helloMsg: Future[HelloWorld] = helloWorldService.hello
    helloMsg.map { msg =>

      Ok(views.html.helloWorldExtended(msg))
    }
  }

}
