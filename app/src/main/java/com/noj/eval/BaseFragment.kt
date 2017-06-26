package com.noj.eval

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem

open class BaseFragment : Fragment(), BaseView {

    lateinit var baseActivity: BaseActivity

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
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

    fun replaceFragment(fragment: Fragment) {
        fragmentManager
                .beginTransaction()
                .replace(android.R.id.content, fragment)
                .addToBackStack(null).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> fragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

}
