package com.luka.socialnetworkwithktor_stream.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.luka.socialnetworkwithktor_stream.presentation.MainActivity
import com.luka.socialnetworkwithktor_stream.presentation.login.LoginScreen
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.reflect.Modifier

@RunWith(AndroidJUnit4::class)
class StandardTextFieldKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5
                )
            }
        }
    }

    @Test
    fun enterTooLongString_maxLengthNotExceeded() {
        composeTestRule
            .onNodeWithTag("standard_text_field")
            .performTextInput("123456")
        composeTestRule
            .onNodeWithTag("standard_text_field")
            .assertTextEquals("12345")
    }
}