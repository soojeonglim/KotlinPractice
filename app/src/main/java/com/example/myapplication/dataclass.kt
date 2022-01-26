package com.example.myapplication

class dataclass {
    // 2. data class
// 데이터를 담는, 그릇이 되는 클래스
// pojo class 어떤 모델이 되는 클래스
// 메소드가 있어서 특정 행동을 하는 클래스가 아니라 비어있는 틀 역할을 하는 클래스
}

data class Ticket(val companyName : String, val name : String, var date : String, var setNum : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName : String, val name : String, var date : String, var setNum : Int)

fun main(){
    val ticketA = Ticket("koreanAir", "joyceHong", "2020-02-16", 14)
    val ticketB = TicketNormal("koreanAir", "joyceHong", "2020-02-16", 14)

    println(ticketA)
    println(ticketB)
}