package com.example.firstdegincompose.commopnents

import android.text.InputType
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.isEnabled
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.firstdegincompose.R
import com.example.firstdegincompose.validation.FormState

@Composable
fun LabeledEditText(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle = TextStyle.Default,
    inputType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
    errorMessage: String?


) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
    val borderColor by animateColorAsState(
        targetValue = if (errorMessage == null) Color.Gray else Color.Red,
        label = "Border Color Animation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        Text(
            text = label,
            style = TextStyle(color = Color.Black, fontFamily = poppinsFontFamily), // Label Style
            modifier = Modifier.padding(bottom = 6.dp)
        )


        // Box to wrap EditText with custom background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawRoundRect(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF2193B0),
                                Color(0xFF6DD5ED)
                            ) // Gradient Background
                        ),
                        size = size,
                        cornerRadius = CornerRadius(50f, 50f) // Curved Corners
                    )
                }
                .padding(4.dp) // Padding to separate OutlinedTextField
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text(placeholder, color = Color.White) },
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                maxLines = 1,
                visualTransformation = visualTransformation,
                textStyle = textStyle.copy(color = Color.White), // White text color
                keyboardOptions = KeyboardOptions(
                    keyboardType = inputType,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth(),


                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedPlaceholderColor = Color.LightGray,
                    unfocusedPlaceholderColor = Color.LightGray
                )
            )
        }
        if (!errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }

    }
}

@Composable
fun LoginInputs() {
    var formState by remember { mutableStateOf(FormState()) }
    // Submit Button (Disabled until form is valid)
    val isFormValid = formState.nameError == null &&
            formState.passwordError == null &&
            formState.name.isNotEmpty() &&
            formState.password.isNotEmpty()


    Column(modifier = Modifier.padding(vertical = 26.dp)) {

        LabeledEditText(
            label = "UserName",
            placeholder = "Enter the username",
            value = formState.name,
            onValueChange = {
                formState = formState.copy(
                    name = it,
                    nameError = if (it.length < 3) "Minimum 3 characters required" else null
                )
            },
            errorMessage = formState.nameError
        )

        Spacer(modifier = Modifier.height(10.dp))  // Space between fields

        LabeledEditText(
            label = "Password",
            placeholder = "Enter your password",
            value = formState.password,
            onValueChange = {
                formState = formState.copy(
                    password = it,
                    passwordError = if (it.length < 6) "Minimum 6 characters required" else null
                )
            },
            inputType = KeyboardType.Password,
            errorMessage = formState.passwordError
        )


    }
}

@Composable
@Preview(showBackground = true)
fun ShowInputs() {
    var Name by remember { mutableStateOf("") }
    var Phone by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }



    Column(modifier = Modifier.padding(vertical = 26.dp)) {
        LabeledEditText(
            label = "First Name",
            placeholder = "Enter your full name",
            value = Name,
            onValueChange = {
                Name = it
                error = if (it.length < 3) "Minimum 3 characters required" else null
            },
            errorMessage = error
        )

        Spacer(modifier = Modifier.padding(5.dp))
        LabeledEditText(
            label = "Phone",
            placeholder = "Enter your phone no",
            value = Phone,
            onValueChange = {
                Phone = it
                error = if (it.length == 6) "required 10 digit phone number" else null
            },
            inputType = KeyboardType.Phone,
            errorMessage = error
        )

        Spacer(modifier = Modifier.padding(5.dp))
        LabeledEditText(
            label = "Email",
            placeholder = "Enter your Email",
            value = Email,
            onValueChange = {
                Email = it
                error = if (it.length < 3) "Enter the valid name garter the 3" else null
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Password Icon"
                )

            },
            errorMessage = error


        )
        Spacer(modifier = Modifier.padding(5.dp))
        LabeledEditText(
            label = "PassWord",
            placeholder = "Enter the password",
            value = password,
            onValueChange = {
                password = it
                error = if (it.length < 6) "Minimum 6 characters required" else null
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            },
            inputType = KeyboardType.Password,
            errorMessage = error

        )
    }

}
