package com.magicworld.jetpackcomposeinstagram.login.data.network.reponse

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("success") val success:Boolean)