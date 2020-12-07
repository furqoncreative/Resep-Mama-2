package id.furqoncreatice.resepmama2.data

import id.furqoncreatice.resepmama2.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            if (username == "user@resepmama.com" && password == "123456"){
                val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
                Result.Success(fakeUser)
            } else {
                Result.Error(IOException("Email atau password salah"))
            }
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}