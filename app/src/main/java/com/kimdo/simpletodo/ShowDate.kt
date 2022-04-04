package com.kimdo.simpletodo

import javax.inject.Inject

class ShowDate @Inject constructor( private var showDependent: ShowDependent ){

    fun showName() : String{
        return showDependent.showDependent()
    }
}