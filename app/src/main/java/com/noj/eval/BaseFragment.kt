package com.noj.eval

import android.os.Bundle
import android.support.v4.app.Fragment

open class BaseFragment : Fragment(), BaseView {

    lateinit var baseActivity: BaseActivity

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        baseActivity = activity as BaseActivity
    }

    override fun showLoading() {
        baseActivity.showLoading()
    }

    override fun dismissLoading() {
        baseActivity.dismissLoading()
    }

    override fun showGeneralError() {
        baseActivity.showGeneralError()
    }

}