package controllers

import com.google.inject.Inject
import models.UserData
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.LoginService

import scala.concurrent.ExecutionContext

class LoginController @Inject()(loginService: LoginService, controllerComponents: ControllerComponents)
                               (implicit executionContext: ExecutionContext)
                                extends AbstractController(controllerComponents ) with play.api.i18n.I18nSupport {

  def showLoginPage :Action[AnyContent] = Action {
    implicit request =>
      Ok(views.html.loginPage(UserData.form))
  }
  def submitLogin = Action {
    implicit request =>
      UserData.form.bindFromRequest().fold(
        formWithError => {
          BadRequest(views.html.loginPage(formWithError))
        },
        user => {
          val isValidUser = loginService.checkLogin(user)
          if(isValidUser)
            Redirect(routes.LoginController.homePage).flashing(
              "loginStatus" -> "User logged-in successfully")
          else
            Ok(views.html.loginPage(UserData.form))

        }
      )
  }
  def homePage = Action{
    implicit request =>
      Ok(views.html.homePage())
  }
}
