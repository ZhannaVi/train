import kotlin.random.Random

class train{
    var startCity = ""
    var endCity = ""
    var passengers = 0
    var van = 0
    val passengersVan: Array<Int>

    constructor(startCity_:String, endCity_:String, passengers_:Int, van_:Int, passengersVan_:Array<Int>)
    {
        startCity = startCity_
        endCity = endCity_
        passengers = passengers_
        van = van_
        passengersVan = passengersVan_
    }

    fun showInfo()
    {
        println("Направление поезда: " + startCity + " - " + endCity)
        println("Кол-во пассажиров: " + passengers)
        println("Кол-во вагонов: " + van)
    }
}

fun main() {
    val cities = listOf("Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
        "Нижний Новгород", "Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа",
        "Красноярск", "Воронеж", "Пермь", "Волгоград")

    var continueWork = true
    var startCity = ""
    var endCity = ""
    var passengers = 0
    var van = 0
    val passengersVan: Array<Int> = arrayOf()
    var train_:train = train(startCity, endCity, passengers, van, passengersVan)
    while (continueWork) {
        println("Что вы хотите сделать?")
        println("1. Создать направление")
        println("2. Продать билеты")
        println("3. Сформировать поезд")
        println("4. Отправить поезд")
        println("5. Закончить работу")
        print("Введите номер выбранного действия: ")
        val action = readLine()

        when (action) {
            "1" -> createDirection(cities, train_)
            "2" -> sellTickets(train_)
            "3" -> formTrain(train_)
            "4" -> sendTrain(train_)
            "5" -> continueWork = false
            else -> println("Некорректный ввод. Пожалуйста, повторите попытку.")
        }

        println()
    }
}

fun createDirection(cities: List<String>, train_: train) {
    val startCity = cities.random()
    var endCity = cities.random()

    while (endCity == startCity) {
        endCity = cities.random()

    }
    train_.startCity = startCity
    train_.endCity = endCity
    println("Направление создано:" + startCity + " - " + endCity)
}

fun sellTickets(train_: train) {
    val passengers = Random.nextInt(5, 201)
    train_.passengers = passengers
    println("Продано билетов:" + passengers)
}

fun formTrain(trainClass_: train) {
    val passengers = Random.nextInt(5, 201)
    val train = mutableListOf<Int>()

    var capacitySum = 0
    var wagonCount = 0

    while (capacitySum < passengers) {
        val capacity = Random.nextInt(5, 26)
        train.add(capacity)
        capacitySum += capacity
        wagonCount++

    }
    trainClass_.van = wagonCount

    println("Поезд состоит из " + wagonCount + " вагонов")
    for (i in train.indices) {
        trainClass_.passengersVan.plus(train[i])
        println("Вагон " + i+1 + ": вместимость - " + train[i])
    }
}

fun sendTrain(train_: train) {
    println("Поезд отправлен")
    train_.showInfo()
}