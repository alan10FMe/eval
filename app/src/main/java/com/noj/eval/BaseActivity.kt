package com.noj.eval

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.progressDialog

open class BaseActivity : AppCompatActivity() {

    lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = indeterminateProgressDialog("")
    }

    fun showProgressDialog(message: String) {
        dialog.setMessage(message)
        dialog.show()
    }

    fun dismissProgressDialog() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }
}
