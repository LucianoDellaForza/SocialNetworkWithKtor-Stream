package com.luka.socialnetworkwithktor_stream.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.input.KeyboardType
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.luka.socialnetworkwithktor_stream.presentation.MainActivity
import com.luka.socialnetworkwithktor_stream.presentation.util.TestTags
import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp

@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun enterTooLongString_maxLengthNotExceeded() {
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
                    maxLength = 5,
                    modifier = Modifier
                        .semantics {
                            testTag = TestTags.STANDARD_TEXT_FIELD
                        }
                )
            }
        }

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
                    maxLength = 5,
                    modifier = Modifier
                        .semantics {
                            testTag = TestTags.STANDARD_TEXT_FIELD
                        }
                )
            }
        }

        val expectedString = "12345"
        composeTestRule
            .onNodeWithTag(TestTags.STANDARD_TEXT_FIELD)
            .performTextClearance()
        composeTestRule
            .onNodeWithTag(TestTags.STANDARD_TEXT_FIELD)
            .performTextInput(expectedString)
        composeTestRule
            .onNodeWithTag(TestTags.STANDARD_TEXT_FIELD)
            .performTextInput("6")

        composeTestRule
            .onNodeWithTag(TestTags.STANDARD_TEXT_FIELD)
            .assertTextEquals(expectedString)
    }

    @Test
    fun enterPassword_toggleVisibility_passwordVisible() {
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
                    maxLength = 5,
                    keyboardType = KeyboardType.Password
                )
            }
        }

        composeTestRule
            .onNodeWithTag(TestTags.STANDARD_TEXT_FIELD)
            .performTextInput("12345")


    }
}