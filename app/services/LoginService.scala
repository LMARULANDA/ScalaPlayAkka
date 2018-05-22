package services

import com.google.inject.Inject
import models.UserData
import repositories.UserRepository

class LoginService @Inject()(userRepository: UserRepository) {
  def checkLogin(user: UserData) : Boolean =
    userRepository.isValidUser(user)

}
