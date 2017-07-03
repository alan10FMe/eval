package com.noj.eval.group.search

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Group
import com.noj.eval.model.Search
import javax.inject.Inject

class SearchGroupPresenter @Inject() internal constructor(
        override val view: SearchGroupContract.View,
        private val repository: EvalRepository
) : SearchGroupContract.Presenter {

    override fun start() {
        //No implementation
    }

    override fun onSearchGroupByEmail(email: String) {
        if (email.isNotBlank()) {
            val search = Search(value = email)
            view.displayGroups(repository.searchGroupsByEmail(search))
        }
    }

    override fun onRequestAccess(group: Group) {
        repository.requestAccess(group.id)
        view.removeGroup(group.id)
        view.displayAccessRequested(group.name)
    }

}
