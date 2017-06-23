package com.noj.eval

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast

open class BaseActivity : AppCompatActivity(), BaseView {

    val dialog: ProgressDialog by lazy {
        indeterminateProgressDialog("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showLoading() {
        dialog.show()
    }

    override fun dismissLoading() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    override fun showGeneralError() {
        toast("This was not supposed to happen")
    }

}
