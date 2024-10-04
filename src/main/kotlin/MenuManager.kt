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
            } else if(input < 0 || input > menuItems.size + 1) {
                println("Несуществующее значение")
            } else if (input in menuItems.indices){
                menuItems[input].second()
            } else {
                break
            }
        }
    }
}