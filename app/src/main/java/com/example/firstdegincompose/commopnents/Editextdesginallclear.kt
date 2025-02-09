package com.example.firstdegincompose.commopnents

import android.text.InputType
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        Text(
            text = label,
            style = TextStyle(color = Color.Black), // Label Style
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
    }
}

@Composable
@Preview(showBackground = true)
fun ShowInputs() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(vertical = 26.dp)) {
        LabeledEditText(
            label = "First Name",
            placeholder = "Enter your first name",
            value = firstName,
            onValueChange = { firstName = it }
        )

        Spacer(modifier = Modifier.padding(5.dp))
        LabeledEditText(
            label = "Last Name",
            placeholder = "Enter your last name",
            value = lastName,
            onValueChange = { lastName = it }
        )

        Spacer(modifier = Modifier.padding(5.dp))
        LabeledEditText(
            label = "Password",
            placeholder = "Enter your password",
            value = password,
            onValueChange = { password = it },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            },
            inputType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
