package services

import com.google.inject.ImplementedBy
import models.HelloWorld

import scala.concurrent.Future

@ImplementedBy(classOf[HelloWorldService])
trait THelloWorldService {

  def hello() : Future[HelloWorld]

}
