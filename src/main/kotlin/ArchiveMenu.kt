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
        archives.add(menuManager.archiveInput())
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