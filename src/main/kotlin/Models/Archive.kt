package Models

data class Archive(override val name: String, val notes: MutableList<Note>) : NamedItem
