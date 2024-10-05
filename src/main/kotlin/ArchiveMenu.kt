import java.util.Scanner

class ArchiveMenu {
    private val scanner = Scanner(System.`in`)

    private val menuManager = MenuManager()
    private val archives = mutableListOf<Archive>()

    fun showMenu() {
        val menuItems = mutableListOf(
            "Cоздать архив" to { createArchive() },
            "Выбрать архив" to { selectArchive() }
        )
        menuManager.showMenu("Список архивов:", menuItems)
    }

    private fun createArchive() {
        while (true) {
            println()
            print("Введите имя нового архива: ")
            val archiveName = scanner.nextLine().trim()

            if(archiveName.isBlank()) {
                println("Имя архива не может быть пустым")
            } else {
                archives.add(Archive(archiveName))
                return
            }
        }
    }

    private fun selectArchive() {
        if(archives.isEmpty()) {
            println("Архивы отсутствуют.")
            return
        }
        val menuItems = archives.mapIndexed { index, archive -> archive.name to {archive.showMenu()} }.toMutableList()
        menuManager.showMenu("Выберите архив:", menuItems)
    }
}