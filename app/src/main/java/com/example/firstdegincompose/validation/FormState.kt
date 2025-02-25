package com.example.firstdegincompose.validation


data class FormState(
    var name: String = "",
    var nameError: String? = null,
    var phone: String = "",
    var phoneError: String? = null,
    var email: String = "",
    var emailError: String? = null,
    var password: String = "",
    var passwordError: String? = null
)
