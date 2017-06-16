package com.noj.eval.data.remote

import com.noj.eval.data.EvalDataSource
import com.noj.eval.model.Group
import com.noj.eval.model.User
import org.jetbrains.anko.AnkoLogger
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeRemoteDataSource @Inject internal constructor() : RemoteData, AnkoLogger {

    val fakeUser = User(id = 1, name = "Alan Flores", email = "alan10fm@gmail.com")

    override fun createUser(user: User): User {
        return fakeUser
    }

    override var groupsCreated: List<Group>
        get() = listOf(
                Group(2, "Group 2", fakeUser, listOfRequesters, listOfParticipants),
                Group(3, "Group 3", fakeUser, listOfRequesters, listOfParticipants),
                Group(4, "Group 4", fakeUser, listOfRequesters, listOfParticipants),
                Group(5, "Group 5", fakeUser, listOfRequesters, listOfParticipants),
                Group(6, "Group 6", fakeUser, listOfRequesters, listOfParticipants),
                Group(7, "Group 7", fakeUser, listOfRequesters, listOfParticipants),
                Group(8, "Group 8", fakeUser, listOfRequesters, listOfParticipants),
                Group(9, "Group 9", fakeUser, listOfRequesters, listOfParticipants),
                Group(10, "Group 10", fakeUser, listOfRequesters, listOfParticipants),
                Group(11, "Group 11", fakeUser, listOfRequesters, listOfParticipants),
                Group(12, "Group 12", fakeUser, listOfRequesters, listOfParticipants),
                Group(13, "Group 13", fakeUser, listOfRequesters, listOfParticipants),
                Group(14, "Group 14", fakeUser, listOfRequesters, listOfParticipants),
                Group(15, "Group 15", fakeUser, listOfRequesters, listOfParticipants),
                Group(16, "Group 16", fakeUser, listOfRequesters, listOfParticipants)
        )
        set(value) {}

    override var groupsAccepted: List<Group>
        get() = listOf(
                Group(id = 7, name = "Group 7", creator = User(id = 7, name = "Creator 7")),
                Group(id = 8, name = "Group 8", creator = User(id = 8, name = "Creator 8")),
                Group(id = 9, name = "Group 9", creator = User(id = 9, name = "Creator 9")),
                Group(id = 10, name = "Group 10", creator = User(id = 10, name = "Creator 10")),
                Group(id = 11, name = "Group 11", creator = User(id = 11, name = "Creator 11"))
        )
        set(value) {}

    var listOfParticipants: List<User>
        get() = listOf(
                User(id = 100, name = "Participant 100", email = "participant100@gmail.com"),
                User(id = 101, name = "Participant 101", email = "participant101@gmail.com"),
                User(id = 102, name = "Participant 102", email = "participant102@gmail.com"),
                User(id = 103, name = "Participant 103", email = "participant103@gmail.com"),
                User(id = 104, name = "Participant 104", email = "participant104@gmail.com"),
                User(id = 105, name = "Participant 105", email = "participant105@gmail.com"),
                User(id = 106, name = "Participant 106", email = "participant106@gmail.com"),
                User(id = 107, name = "Participant 107", email = "participant107@gmail.com"),
                User(id = 108, name = "Participant 108", email = "participant108@gmail.com"),
                User(id = 109, name = "Participant 109", email = "participant109@gmail.com"),
                User(id = 110, name = "Participant 110", email = "participant110@gmail.com"),
                User(id = 111, name = "Participant 111", email = "participant111@gmail.com"),
                User(id = 112, name = "Participant 112", email = "participant112@gmail.com"),
                User(id = 113, name = "Participant 113", email = "participant113@gmail.com"),
                User(id = 114, name = "Participant 114", email = "participant114@gmail.com")
        )
        set(value) {}

    var listOfRequesters: List<User>
        get() = listOf(
                User(id = 200, name = "Requester 200", email = "requester200@gmail.com"),
                User(id = 201, name = "Requester 201", email = "requester201@gmail.com"),
                User(id = 202, name = "Requester 202", email = "requester202@gmail.com"),
                User(id = 203, name = "Requester 203", email = "requester203@gmail.com"),
                User(id = 204, name = "Requester 204", email = "requester204@gmail.com"),
                User(id = 205, name = "Requester 205", email = "requester205@gmail.com")
        )
        set(value) {}

    override fun createGroup(group: Group): Group {
        return group.copy(id = Random().nextLong())
    }

}
