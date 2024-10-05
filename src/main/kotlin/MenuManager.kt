import java.util.Scanner

class MenuManager {
    private val scanner = Scanner(System.`in`)

    fun showMenu(title: String, menuItems: List<Pair<String, () -> Unit>>) {
        while (true) {
            println()
            println(title)

            for ((index, item) in menuItems.withIndex()) {
                println("${index}. ${item.first}")
            }
            println("${menuItems.size}. Выход")

            println()
            print("Введите номер команды: ")
            val input = scanner.nextLine().toIntOrNull()
            if (input == null) {
                println("Некорректный ввод, введите цифру")
            } else if (input < 0 || input > menuItems.size + 1) {
                println("Несуществующее значение")
            } else if (input in menuItems.indices) {
                menuItems[input].second()
            } else {
                break
            }
        }
    }

    private fun <T> universalInputRequest(
        firstRequest: String,
        secondRequest: String = "",
        createObject: (String, String) -> T
    ): T {
        var name: String
        var content: String

        while (true) {
            println()
            print(firstRequest)

            name = scanner.nextLine().trim()
            if (name.isBlank()) {
                println("Название не может быть пустым")
            } else {
                break
            }
        }

        if (secondRequest.isBlank()) {
            return createObject(name, "")
        } else {
            while (true) {
                println()
                print(secondRequest)

                content = scanner.nextLine().trim()
                if (content.isBlank()) {
                    println("Содержимое не может быть пустым")
                } else {
                    return createObject(name, content)
                }
            }
        }
    }

    fun noteInput(): Note {
        val firstRequest = "Введите имя заметки: "
        val secondRequest = "Введите содержимое заметки: "
        return universalInputRequest(firstRequest, secondRequest) { name, content ->
            Note(name, content)
        }
    }

    fun archiveInput(): Archive {
        val firstRequest = "Введите имя архива: "
        return universalInputRequest(firstRequest) { name, _ ->
            Archive(name)
        }
    }
}