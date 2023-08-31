import java.util.Scanner

fun main(){
    //1. membuat model yang akan menampung data
    var model: Array<String?> = arrayOfNulls(10)

    //2. Businness Logic

    //menampilkan todolist
    fun showTodolist(): Unit{
        for(i in 0..model.size-1){
            var todo = model[i]
            var nomor = i + 1
            if(todo != null){
                println("$nomor. $todo")
            }
        }
    }

    //test fun showTodolist
    fun testShowTodolist(){
        model.set(0,"Belajar kotlin dasar")
        model.set(1,"Belajar kotlin OOP")
        showTodolist()
    }

    //menambahkan todolist
    fun addTodolist(todo: String):Unit{
        //cek apakah model penuh??
        var isFull: Boolean = true;

        for (i in 0 until model.size -1){
            if(model.get(i) == null){
                //model masih ada yang kosong
                isFull = false;
            }
        }

        if(isFull){
            val temp = model
            model = arrayOfNulls(model.size * 2)
            for(i in 0 until temp.size -1){
                model[i] = temp.get(i)
            }
        }

        for(i in 0 until model.size-1){
            if(model.get(i) == null){
                model.set(i,todo)
                break
            }
        }
    }

    //test addTodolist
    fun testAddTodolist(){
        for(i in 1..25){
            addTodolist("todo ke - $i")
        }
        showTodolist()
    }


    //remove todolist
    fun removeTodoList(number: Int): Boolean {
        //jika melebihi
        return if(number-1 >= model.size){
             false
        }else if(model[number - 1] == null){
             false
        }else{
            for(i in number-1 until model.size-1){
                //data tidak dihapus, hanya ditimpa dengan nilai selanjutnya
                //untuk data terahir kita ubah dulu menjadi null
                if(i == (model.size-1)){
                    model[i] = null
                }else{
                    model[i] = model[i+1]
                }
            }
            true
        }
    }
    fun testRemoveTodolist(){
        addTodolist("satu")
        addTodolist("dua")
        addTodolist("tiga")
        addTodolist("empat")
        addTodolist("lima")
        addTodolist("enam")

        var result = removeTodoList(3)
        println(result)
        showTodolist()

        result = removeTodoList(8)
        println(result)
        showTodolist()

        result = removeTodoList(20)
        println(result)
        showTodolist()

        result = removeTodoList(3)
        println(result)
        showTodolist()
    }

    //INPUT
    fun input(info: String):String{
        val scanner = Scanner(System.`in`)
        print("$info : ")
        val data = scanner.nextLine()
        return data
    }

    fun testInput(){
        val name = input("nama")
        println("Hi $name")
    }

    //3. View
    fun viewAddTodolist(){
        println("Menambah todolist")

        var input = input("Masukan input, tekan (x) untuk keluar")
        if(input != "x"){
            addTodolist(input)
        }else{
            //
        }
    }

    fun viewRemoveTodolist(){
        println("Menghapus todolist")

        val input = input("Masukan input, tekan (x) untuk keluar")
        if(input != "x"){
            val remove = removeTodoList(input.toInt())
            if(!remove){
                println("Gagal menghapus todolist di nomor $input")
            }
        }else{
            //
        }
    }


    fun viewTodolist(){
       while(true){
           println("TODOLIST")

           showTodolist()
           println("-----------")
           println("MENU")
           println("1. Menambah todolist")
           println("2. Menghapus todolist")
           println("3. keluar")
           var input = input("Pilih")

           if(input == "3"){
               println("Terimakasih")
               break
           }else if(input == "1"){
               viewAddTodolist()
           }else if(input == "2"){
               viewRemoveTodolist()
           }else{
               println("Pilihan tidak dimengerti")
           }
       }
    }

    fun testViewShowTodolist(){
        addTodolist("belajar kotlin Dasar")
        addTodolist("belajar kotlin OOP")
        addTodolist("belajar kotlin Generic")

        viewTodolist()
    }

    viewTodolist()
}
