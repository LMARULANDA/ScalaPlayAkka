package services

import com.google.inject.Inject
import models.HelloWorld

import scala.concurrent.{ExecutionContext, Future}


class HelloWorldService @Inject() (implicit ec:ExecutionContext) extends  THelloWorldService {
  override def hello(): Future[HelloWorld] = {
    Future(HelloWorld(message = "Hello Future"))
  }

}
