package com.noj.eval.group.admin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.BaseFragment
import com.noj.eval.R
import com.noj.eval.model.User
import com.noj.eval.util.enableBackArrow
import com.noj.eval.util.evalRepositoryComponent
import com.noj.eval.util.snack
import kotlinx.android.synthetic.main.fragment_admin_group.*
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class AdminGroupFragment : BaseFragment(), AdminGroupContract.View {

    @Inject
    lateinit var presenter: AdminGroupPresenter
    private val requestersAdapter: AdminGroupAdapter
    private val participantsAdapter: AdminGroupAdapter

    init {
        requestersAdapter =
                AdminGroupAdapter(mutableListOf<User>(), true, this::acceptClicked, this::rejectClicked)
        participantsAdapter =
                AdminGroupAdapter(mutableListOf<User>(), false, this::acceptClicked, this::removedClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAdminGroupComponent.builder()
                .adminGroupPresenterModule(AdminGroupPresenterModule(this, arguments.getLong(ARG_GROUP_ID)))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_admin_group, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        enableBackArrow()
        requesters_recycler.layoutManager = LinearLayoutManager(ctx)
        requesters_recycler.adapter = requestersAdapter
        participants_recycler.layoutManager = LinearLayoutManager(ctx)
        participants_recycler.adapter = participantsAdapter
        presenter.start()
    }

    override fun displayRequesters(requesters: List<User>) {
        requestersAdapter.addAll(requesters)
    }

    override fun hideRequesters() {
        requesters_linear.visibility = View.GONE
    }

    override fun displayParticipants(participants: List<User>) {
        participantsAdapter.addAll(participants)
    }

    override fun hideParticipants() {
        participants_linear.visibility = View.GONE
    }

    override fun displayUserAccepted(user: User) {
        snack(getString(R.string.admin_gruop_user_accepted, user.name))
        requestersAdapter.remove(user)
        participantsAdapter.add(user)
        participants_linear.visibility = View.VISIBLE
    }

    override fun displayUserRejected(user: User) {
        snack(getString(R.string.admin_gruop_user_rejected, user.name))
        requestersAdapter.remove(user)
    }

    override fun displayUserRemoved(user: User) {
        snack(getString(R.string.admin_gruop_user_removed, user.name))
        participantsAdapter.remove(user)
    }

    private fun acceptClicked(userId: Long) {
        presenter.acceptUser(userId)
    }

    private fun rejectClicked(userId: Long) {
        presenter.rejectUser(userId)
    }

    private fun removedClicked(userId: Long) {
        presenter.removeParticipant(userId)
    }

    companion object {
        private val ARG_GROUP_ID = "groupId"
        fun newInstance(groupId: Long): AdminGroupFragment {
            val fragment = AdminGroupFragment()
            val args = Bundle()
            args.putLong(ARG_GROUP_ID, groupId)
            fragment.arguments = args
            return fragment
        }
    }

}
