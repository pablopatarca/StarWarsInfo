package com.example.starwars


interface BaseView<T> {

    fun setPresenter(presenter: T)
}