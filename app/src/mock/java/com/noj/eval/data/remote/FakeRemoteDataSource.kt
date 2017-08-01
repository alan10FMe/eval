package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.Post
import com.noj.eval.model.Search
import com.noj.eval.model.User
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeRemoteDataSource @Inject internal constructor() : RemoteData, AnkoLogger {

    val user = User(id = 1, name = "Alan Flores", email = "alan10fm@gmail.com")

    override fun createUser(user: User): User {
        return user
    }

    override fun getGroupsCreated(userId: Long): List<Group> {
        return listOfGroupsCreated
    }

    override fun getGroupsAccepted(userId: Long): List<Group> {
        return listOfGroupsAccepted
    }


    override fun createGroup(userId: Long, group: Group): Group {
        val groupCreated = group.copy(id = Random().nextLong())
        return groupCreated
    }

    override fun getGroup(userId: Long, groupId: Long): Group {
        return Group(2, "Group 2", user, listOfRequesters, listOfParticipants)
    }

    override fun acceptUser(userId: Long, groupId: Long) {
        info("Accepting user: $userId in Group: $groupId")
    }

    override fun rejectUser(userId: Long, groupId: Long) {
        info("Rejecting user: $userId in Group: $groupId")
    }

    override fun searchGroupsByEmail(search: Search): List<Group> {
        when (search.value) {
            "1@gmail.com" -> return groupsUserOne
            "2@gmail.com" -> return groupsUserTwo
            else -> return emptyList()
        }
    }

    override fun requestAccess(userId: Long, groupId: Long) {
        info("Requesting access for user: $userId in Group: $groupId")
    }

    override fun createPosts(userId: Long, post: Post): Post {
        return post.copy(id = Random().nextLong())
    }

    override fun createAnswer(userId: Long, postId: Long, answer: Post): Post {
        return answer.copy(id = Random().nextLong())
    }

    override fun getPosts(userId: Long, groupId: Long): List<Post> {
        return listOfPosts
    }

    override fun getPost(userId: Long, postId: Long): Post {
        return Post(
                id = postId,
                title = "Tarea para examen",
                message = "Hacer un resumen del libro que se vio en clase esta semana",
                createdDate = "25-05-2017 10:00",
                answers = listOfAnswers,
                readers = listOfParticipants
        )
    }

    private val listOfGroupsCreated: List<Group>
        get() = listOf(
                Group(2, "Group 2", user),
                Group(3, "Group 3", user),
                Group(4, "Group 4", user),
                Group(5, "Group 5", user),
                Group(6, "Group 6", user),
                Group(7, "Group 7", user),
                Group(8, "Group 8", user),
                Group(9, "Group 9", user),
                Group(10, "Group 10", user),
                Group(11, "Group 11", user),
                Group(12, "Group 12", user),
                Group(13, "Group 13", user),
                Group(14, "Group 14", user),
                Group(15, "Group 15", user),
                Group(16, "Group 16", user),
                Group(17, "Group 17", user),
                Group(18, "Group 18", user),
                Group(19, "Group 19", user),
                Group(20, "Group 20", user)
        )

    private val listOfGroupsAccepted: List<Group>
        get() = listOf(
                Group(id = 7, name = "Group 7", creator = User(id = 7, name = "Creator 7", email = "7@gmail.com")),
                Group(id = 8, name = "Group 8", creator = User(id = 8, name = "Creator 8", email = "8@gmail.com")),
                Group(id = 9, name = "Group 9", creator = User(id = 9, name = "Creator 9", email = "9@gmail.com")),
                Group(id = 10, name = "Group 10", creator = User(id = 10, name = "Creator 10", email = "10@gmail.com")),
                Group(id = 11, name = "Group 11", creator = User(id = 11, name = "Creator 11", email = "11@gmail.com"))
        )

    private val listOfParticipants: List<User>
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

    private val listOfRequesters: List<User>
        get() = listOf(
                User(id = 200, name = "Participant 200", email = "participant200@gmail.com"),
                User(id = 201, name = "Participant 201", email = "participant201@gmail.com"),
                User(id = 202, name = "Participant 202", email = "participant202@gmail.com"),
                User(id = 203, name = "Participant 203", email = "participant203@gmail.com"),
                User(id = 204, name = "Participant 204", email = "participant204@gmail.com"),
                User(id = 205, name = "Participant 205", email = "participant205@gmail.com"),
                User(id = 206, name = "Participant 206", email = "participant206@gmail.com"),
                User(id = 207, name = "Participant 207", email = "participant207@gmail.com"),
                User(id = 208, name = "Participant 208", email = "participant208@gmail.com"),
                User(id = 209, name = "Participant 209", email = "participant209@gmail.com"),
                User(id = 210, name = "Participant 210", email = "participant210@gmail.com"),
                User(id = 211, name = "Participant 211", email = "participant211@gmail.com"),
                User(id = 212, name = "Participant 212", email = "participant212@gmail.com"),
                User(id = 213, name = "Participant 213", email = "participant213@gmail.com"),
                User(id = 214, name = "Participant 214", email = "participant214@gmail.com")
        )

    private val groupsUserOne: List<Group>
        get() = listOf(
                Group(id = 1, name = "Group 1", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 2, name = "Group 2", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 3, name = "Group 3", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 4, name = "Group 4", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 5, name = "Group 5", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 6, name = "Group 6", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 7, name = "Group 7", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 8, name = "Group 8", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 9, name = "Group 9", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 10, name = "Group 10", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com")),
                Group(id = 11, name = "Group 11", creator = User(id = 1, name = "Creator 1", email = "1@gmail.com"))
        )

    private val groupsUserTwo: List<Group>
        get() = listOf(
                Group(id = 1, name = "Group 1", creator = User(id = 1, name = "Creator 2", email = "2@gmail.com"))
        )

    private val listOfPosts: List<Post>
        get() = listOf(
                Post(id = 1, title = "Tarea", message = "Hacer un resumen del libro", createdDate = "30-05-2017 10:10"),
                Post(id = 2, title = "Comprar", message = "Llevar las monografias", createdDate = "29-05-2017 14:16"),
                Post(id = 3, title = "No ir", message = "No hay clases manana", createdDate = "28-05-2017 17:30"),
                Post(id = 4, title = "Tarea", message = "Dibujar un arbol", createdDate = "27-05-2017 9:58"),
                Post(id = 5, title = "Excursion", message = "Pedir permiso para ir", createdDate = "26-05-2017 11:16"),
                Post(id = 6, title = "Tarea", message = "Hacer las operaciones", createdDate = "25-05-2017 18:12"),
                Post(id = 7, title = "Junta", message = "Junta de padres", createdDate = "24-05-2017 23:23"),
                Post(id = 8, title = "Tarde", message = "Se retrasa la clase 15 minutos", createdDate = "23-05-2017 17:50")
        )

    private val listOfAnswers: List<Post>
        get() = listOf(
                Post(id = 1, message = "Cuantas hojas deben ser?", createdDate = "25-05-2017 10:10"),
                Post(id = 2, message = "De las primeras 25", createdDate = "25-05-2017 10:12"),
                Post(id = 3, message = "Se pueden poner fotos?", createdDate = "25-05-2017 10:14"),
                Post(id = 4, message = "Si pero no cuentan como hojas", createdDate = "25-05-2017 10:16"),
                Post(id = 5, message = "Puedo escoger otro libro?", createdDate = "25-05-2017 10:18")
        )

}
