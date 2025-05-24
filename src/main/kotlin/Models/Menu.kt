package Models

class Menu<T: NamedItem> (
    val title:String,
    val exitText:String,
    val typeCreation: String,
    var list:List<T>,
    val onCreate: (() -> Unit)? = null,
    val onSelect: ((T) -> Unit)? = null
){
    fun start(){
        while (true){
            println("$title\n0.$exitText\n1.Создать $typeCreation")
            for ((index, item) in list.withIndex()) {
                println("${index + 2}.\"${item.name}\"")
            }

            println("Введите номер пункта: ")
            val choice = readln().toIntOrNull()
            if (choice == null) {
                println("Введите число из предложенных.")
                continue;
            }

            when (choice) {
                0 -> return
                1 -> onCreate?.invoke()
                in 2 until  list.size +2  ->{
                    val selected = list[choice - 2]
                    onSelect?.invoke(selected)}
                else -> println("Такого пункта меню нет. Попробуйте снова.")
            }
        }
    }

}