class Archive(val name: String) {

    val notes: MutableList<Note> = mutableListOf()

    fun showMenu () {
        val noteMenu = NoteMenu(this)
        noteMenu.showMenu()
    }
}