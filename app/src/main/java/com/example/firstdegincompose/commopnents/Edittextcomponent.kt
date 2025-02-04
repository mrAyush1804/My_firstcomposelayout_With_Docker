package com.example.firstdegincompose.commopnents

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Edittextcomponent(
    lable: String,
    placeholder: String,
    value: String,
    onvaluchange: (String) -> Unit,
    inputype: KeyboardType = KeyboardType.Text,
    modifier: Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,


    ) {
    OutlinedTextField(
        label = { Text(lable) },
        placeholder = { Text(placeholder) },
        value = value,
        onValueChange = onvaluchange,
        maxLines = 1,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 5.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = inputype,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )


    )


}

@Preview(showBackground = true)
@Composable
fun showEditText() {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()


    ) {
        Edittextcomponent(
            lable = "Name",
            placeholder = "Enter The First Name",
            value = firstname,
            onvaluchange = { firstname = it },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Filled.Person, "") }


        )
        Edittextcomponent(
            lable = "LastName",
            placeholder = "Enter The Last Name",
            value = lastname,
            onvaluchange = { lastname = it },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Filled.Person, "") }
        )
        Edittextcomponent(
            lable = "Email",
            placeholder = "Enter The Email",
            value = Email,
            onvaluchange = { Email = it },
            modifier = Modifier.fillMaxWidth(),
            inputype = KeyboardType.Email,
            leadingIcon = { Icon(imageVector = Icons.Filled.Email, "") }
        )
        Edittextcomponent(
            lable = "Phone",
            placeholder = "Enter The Password",
            value = Password,
            onvaluchange = { Password = it },
            modifier = Modifier.fillMaxWidth(),
            inputype = KeyboardType.Phone,
            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, "") },

            )

    }
}
