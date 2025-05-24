package Screens

import Models.Archive
import Models.Menu
import Models.Note

fun NoteScreen(archive: Archive) {
    val menu = Menu(
        title = "Заметки",
        exitText = "Назад",
        typeCreation= "заметку",
        list = archive.notes,
        onCreate = { createNote(archive) },
        onSelect = { note ->
            println("\nЗаметка: ${note.name}")
            println("${note.content}")
            println("\nНажмите Enter для возврата в меню")
            readln()
        }
    )
    menu.start()
}
fun createNote(archive: Archive) {
    var nameNote: String
    while (true) {
        print("Введите название заметки: ")
        nameNote = readln().trim()
        if (nameNote.isBlank()) {
            println("Название заметки не может быть пустым")
        } else {
            break
        }
    }
    var content: String
    while (true) {
        print("Введите текст: ")
        content = readln().trim()
        if (content.isBlank()) {
            println("Текст заметки не может быть пустым")
        } else {
            break
        }
    }
    archive.notes.add(Note(nameNote, content))
    println("Заметка \"$nameNote\" успешно создана.")
}