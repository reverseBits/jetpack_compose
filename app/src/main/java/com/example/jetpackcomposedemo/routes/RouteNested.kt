

import kotlinx.serialization.Serializable
@Serializable
sealed class RouteNested {
    @Serializable
    object Auth {
        @Serializable
        object EmailSignUp

        @Serializable
        object EmailLogIn
    }

    @Serializable
    object App {
        @Serializable
        data class Home(
            val name: String = "default",
        )
    }
}