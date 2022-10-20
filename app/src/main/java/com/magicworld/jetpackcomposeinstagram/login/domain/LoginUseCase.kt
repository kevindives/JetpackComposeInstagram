package com.magicworld.jetpackcomposeinstagram.login.domain

import com.magicworld.jetpackcomposeinstagram.login.data.LoginRepository

class LoginUseCase {
    val repository =  LoginRepository()

    suspend operator fun invoke(user:String ,  password:String):Boolean{
        return repository.doLogin(user , password )
    }
}