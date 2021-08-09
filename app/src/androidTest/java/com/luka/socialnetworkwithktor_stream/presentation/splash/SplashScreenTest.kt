package com.luka.socialnetworkwithktor_stream.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.luka.socialnetworkwithktor_stream.presentation.MainActivity
import com.luka.socialnetworkwithktor_stream.presentation.ui.theme.SocialNetworkWithKtorStreamTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    //make a mock of nav controller
    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this) //this initializes navController (above) as a mock
    }

    //runBlockingTest - for skipping delays inside of coroutine
    @Test
    fun splashScreen_displaysAndDisappears() = runBlockingTest {
        composeTestRule.setContent {
            SocialNetworkWithKtorStreamTheme {
                SplashScreen(navController = navController)
            }
        }
        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

//        verify {
//            navController.popBackStack()
//            navController.navigate(Screen.LoginScreen.route)
//        }
    }
}