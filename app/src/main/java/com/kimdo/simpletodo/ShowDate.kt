package com.kimdo.simpletodo

import javax.inject.Inject

class ShowDate @Inject constructor( ){

    var showDependent: ShowDependent? = null
    fun showName() : String{
        return "kimdo"
    }
}