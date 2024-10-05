import java.util.Scanner

class NoteMenu(private val archive: Archive) {
    private val scanner = Scanner(System.`in`)
    private val menuManager = MenuManager()

    fun showMenu() {
        val menuItems = mutableListOf(
            "Создать заметку" to { createNote() },
            "Просмотреть заметку" to { showNote() }
        )

        menuManager.showMenu("Список заметок:", menuItems)
    }

    private fun createNote () {
        while (true) {



            var name: String
            var content: String


            while (true) {
                while(true) {
                    println()
                    print("Введите название заметки: ")
                    name = scanner.nextLine().trim()

                    if (name.isBlank()) {
                        println("Название заметки не может быть пустым")
                    } else {
                        break
                    }
                }

                while (true) {
                    print("Введите содержимое заметки: ")
                    content = scanner.nextLine().trim()

                    if (content.isBlank()) {
                        println("Содержимое заметки не может быть пустым")
                    } else {
                        break
                    }
                }
                archive.addNote(name, content)
                return
            }
        }
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