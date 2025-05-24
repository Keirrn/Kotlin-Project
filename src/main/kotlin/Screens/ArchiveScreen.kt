package Screens

import Models.Archive
import Models.Archives
import Models.Menu

fun ArchiveMenu(){
    val menu = Menu(
        title = "Архивы",
        exitText = "Выход",
        typeCreation= "архив",
        list = Archives.archives,
        onCreate = { createArchive() },
        onSelect = { archive ->  NoteScreen(archive) }
    )
    menu.start()
}
fun createArchive(){
    while (true) {
        print("Введите название архива: ")
        var nameArchive: String = readln().trim()
        if (nameArchive.isBlank()) {
            println("Название архива не может быть пустым")
            continue
        } else {
            Archives.archives.add(Archive(nameArchive, mutableListOf()))
            println("Архив \"$nameArchive\" успешно создан.")
            break
        }
    }
}