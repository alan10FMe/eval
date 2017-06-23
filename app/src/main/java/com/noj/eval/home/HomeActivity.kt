package com.noj.eval.home

import android.os.Bundle
import com.noj.eval.BaseActivity
import com.noj.eval.R
import com.noj.eval.group.GroupFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        group_buttons.setOnClickListener({
            val groupFragment = GroupFragment.newInstance()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(android.R.id.content, groupFragment)
            fragmentTransaction.commit()
        })
    }

}
