package com.noj.eval

interface BasePresenter<T : BaseView> {

    val view: T

    fun start()

}