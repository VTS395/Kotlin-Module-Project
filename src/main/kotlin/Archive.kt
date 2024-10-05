class Archive(val name: String) {

    private val notes: MutableList<Note> = mutableListOf()

    fun getNotes(): List<Note> {
        return notes.toList()
    }

    fun showMenu () {
        val noteMenu = NoteMenu(this)
        noteMenu.showMenu()
    }

    fun addNote (title: String, content: String) {
        notes.add(Note(title, content))
    }

    fun isNotesEmpty() : Boolean {
        return notes.isEmpty()
    }
}