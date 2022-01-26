package com.example.myapplication

class Object {
}

// 4. Object class
// 다른 클래스들과 다른점
// CarFactory라는 객체는 이 모든 앱을 실행할때 딱 한번만 만들어짐(Singleton Pattern)
object CarFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower : Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main(){
    val car1 = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car1)
    println(car2)
    println(CarFactory.cars.size.toString())
}
