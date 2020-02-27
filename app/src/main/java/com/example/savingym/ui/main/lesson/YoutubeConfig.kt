package com.example.savingym.ui.main.lesson

open class YoutubeConfig (){
    companion object{
        private const val API_KEY = "AIzaSyBxShmbuQwfNiF6c82yA_qFrKFSE8khOtU"
        fun getApiKey():String{
            return API_KEY
        }
    }
}