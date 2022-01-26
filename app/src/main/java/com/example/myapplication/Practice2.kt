package com.example.myapplication

class Practice2 {
}
// 1. Lamda
// 우리가 마치 value 처럼 다룰 수 있는 익명함수이다. 변수에 함수를 넣을 수 있음.
// value 처럼 다룰 수 있는?
// 1) 메소드의 파라미터로 넘겨줄 수가 있다. fun maxBy(a : Int), a : Int <- 파라미터, argumentList
// 2) return 값으로 사용할 수가 있다.
// 람다의 기본정의
// ** val lamdaName : Type -> outputType = {argumentList -> codeBody(or return값)}
val square : (Int) -> (Int) = {number -> number*number}

val nameAge = {name : String, age : Int -> "My name is $name I'm $age" }

fun main(){
    println(square(12))
    println(nameAge("joyce", 23))

    val a = "joyce said"
    val b = "mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 27))

    println(calculateGrade(97))
    println(calculateGrade(971))

    val lamda : (Double) -> Boolean = {number : Double -> number == 4.3213}
    println(invokeLamda(lamda))
    println(invokeLamda ({ it > 3.22 }))  // it <- 파라미터 double 한개이므로 it = double

}

// 확장 함수
// 클래스를 확장함, 원래 클래스에 코드를 추가함.
// String 클래스에 뭔가 하나를 추가하고 싶을때
val pizzaIsGreat : String.() -> String = {
    //this가 가리키는 것 : String.(), String 오브젝트 그 자체를 가리킴. // String.() <- 파라미터 없음
    this + "Pizza is the best"
}
fun extendString(name : String, age : Int) : String {
    // lamda 식으로
    val introduceMyself : String.(Int) -> String = {"I am $this and $it years old"}   // 파라미터가 하나일때.(int)는 it 이라는 것을 사용해줌
    return name.introduceMyself(age)
}

// 람다의 Return
val calculateGrade : (Int) -> String = {
    when(it){   // else 필수
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(5.2343)
}