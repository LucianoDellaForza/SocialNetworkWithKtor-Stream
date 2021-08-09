package com.luka.jetpackcomposenavigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    fun withOptionalArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("?name=$arg")
            }
        }
    }

    fun withOptionalMultipleArgs(argName: String?, argSurname: String?): String {
        return buildString {
            append(route)
            argName?.let { append("?name=$argName") }
            argSurname?.let { append("?surname=$argSurname") }
        }
    }
}
