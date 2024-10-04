import java.util.Scanner

class NoteMenu(private val archive: Archive) {

    private val menuManager = MenuManager()

    fun showMenu() {
        val menuItems = mutableListOf(
            "Создать заметку" to { createNote() },
            "Просмотреть заметку" to { showNote() }
        )

        menuManager.showMenu("Список заметок:", menuItems)
    }

    private fun createNote () {
        val scanner = Scanner(System.`in`)

        while (true) {
            println()
            print("Введите название заметки: ")
            val name = scanner.nextLine()

            print("Введите содержимое заметки: ")
            val content = scanner.nextLine()

            if (name.isEmpty() || content.isEmpty()) {
                println("Название или содержимое заметки не может быть пустым:")
            } else {
                archive.notes.add(Note(name, content))
                return
            }
        }
    }

    private fun showNote() {
        if (archive.notes.isEmpty()) {
            println("В архиве нет заметок")
            return
        }
        val menuItems = archive.notes.mapIndexed { _, note ->
            note.title to {
                println();
                println("Название заметки: ${note.title}");
                println("Содержимое заметки: ${note.content}")
            }
        }.toMutableList()
        menuManager.showMenu("Список заметок:", menuItems)
    }
}