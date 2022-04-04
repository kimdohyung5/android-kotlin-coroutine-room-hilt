package com.kimdo.simpletodo

import javax.inject.Inject

class ShowDependent @Inject constructor() {
    fun showDependent():String {
        return "showDependent"
    }
}