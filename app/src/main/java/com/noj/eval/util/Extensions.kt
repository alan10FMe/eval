@file:JvmName("Extensions")

package com.noj.eval.util

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import org.jetbrains.anko.support.v4.act

fun Fragment.disableBackArrow() {
    (act as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    (act as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
}

fun Fragment.enableBackArrow() {
    (act as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    (act as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
}

fun Activity.hideKeyboard() {
    if (currentFocus != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}


