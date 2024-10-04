import java.util.Scanner

class ArchiveMenu {

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
        val scanner = Scanner(System.`in`)

        while (true) {
            println()
            print("Введите имя нового архива: ")
            val archiveName = scanner.nextLine()

            if(archiveName.isEmpty()) {
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