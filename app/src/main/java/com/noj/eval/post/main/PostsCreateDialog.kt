package com.noj.eval.post.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import com.noj.eval.R
import com.noj.eval.util.enableBackArrow
import com.noj.eval.util.hideKeyboard
import kotlinx.android.synthetic.main.dialog_create_post.*

@SuppressLint("ValidFragment")
class PostsCreateDialog(
        private val listenerSave: (String, String) -> Unit
) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.dialog_create_post, container, false)
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
                if (validForm()) {
                    listenerSave(post_title_edit.text.toString().trim(), post_message_edit.text.toString().trim())
                    fragmentManager.popBackStack()
                }
            }
            else -> error("Operation not supported")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun validForm(): Boolean {
        when {
            post_title_edit.text.toString().trim().isBlank() -> {
                post_title_edit.requestFocus()
                return false
            }
            post_message_edit.text.toString().trim().isBlank() -> {
                post_message_edit.requestFocus()
                return false
            }
            else -> return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_create_dialog, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
