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
        archive.addNote(menuManager.noteInput())
    }

    private fun showNote() {
        if (archive.isNotesEmpty()) {
            println("В архиве нет заметок")
            return
        }
        val menuItems = archive.getNotes().mapIndexed { _, note ->
            note.title to {
                println();
                println("Название заметки: ${note.title}");
                println("Содержимое заметки: ${note.content}")
            }
        }.toMutableList()
        menuManager.showMenu("Список заметок:", menuItems)
    }
}