@file:JvmName("Extensions")

package com.noj.eval.util

import android.app.Activity
import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.inputmethod.InputMethodManager
import com.google.firebase.auth.FirebaseUser
import com.noj.eval.model.User
import org.jetbrains.anko.support.v4.act

/**
 * Extensions for Fragments
 */
fun Fragment.disableBackArrow() {
    (act as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    (act as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
}

fun Fragment.enableBackArrow() {
    (act as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    (act as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
}

fun Fragment.snack(message: String) {
    act.snack(message)
}

/**
 * Extensions for Activities
 */
fun Activity.hideKeyboard() {
    if (currentFocus != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}

fun Activity.snack(message: String) {
    Snackbar.make(findViewById(android.R.id.content), Html.fromHtml(message), Snackbar.LENGTH_SHORT).show()
}

/**
 * Extensions for FirebaseUser
 */
fun FirebaseUser?.toUser(): User {
    if (this != null) {
        return User(uid = uid, name = displayName ?: "", email = email ?: "")
    } else {
        error("FireBase user should not be null")
    }
}
