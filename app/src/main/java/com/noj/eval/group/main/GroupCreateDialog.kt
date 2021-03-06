package com.noj.eval.group.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import com.noj.eval.R
import com.noj.eval.model.Group
import com.noj.eval.util.enableBackArrow
import com.noj.eval.util.hideKeyboard
import kotlinx.android.synthetic.main.dialog_create_group.*

@SuppressLint("ValidFragment")
class GroupCreateDialog(
        private val listenerSuccess: (Group) -> Unit
) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.dialog_create_group, container, false)
        enableBackArrow()
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        hideKeyboard()
        when (item.itemId) {
            android.R.id.home -> fragmentManager.popBackStack()
            R.id.create_menu -> {
                if (name_group_edit.text.toString().isBlank()) {
                    name_group_edit.setText("")
                    name_group_edit.requestFocus()
                } else {
                    listenerSuccess(Group(name = name_group_edit.text.toString()))
                    fragmentManager.popBackStack()
                }
            }
            else -> error("Operation not supported")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_create_dialog, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
