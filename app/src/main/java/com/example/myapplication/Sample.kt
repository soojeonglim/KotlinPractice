package com.example.myapplication

import java.util.*
import kotlin.collections.ArrayList


fun main(){
    HelloWorld()

    // 3. String Template
    val name = "soojeong"
    println("My name is $name I'm 24")
    val lastname = "Lim"
    println("My name is ${name + lastname}")

    println(maxBy2(4,2))
    checkNum(1)
    forAudWhile()
    nullcheck()


}
// 1. 함수
fun HelloWorld() : Unit {   // 파라미터 없음, 리턴형식 없음( : Unit), 회색 글씨는 생략 가능.
    println("HelloWorld!")
}

fun add(a : Int, b : Int) : Int {  // (변수이름 : 변수타입) : 리턴타입
    return a+b
}

// 2. val vs var
// val = value (상수, 바뀌지 않는 값), var = variable (변수, 변할 수 있는 값)
fun hi(){
    val a : Int = 10
    val c = 11  // 변수타입을 작성하지 않아도됨.
    var b : Int = 9
    var d = 12

    //a = 100   오류!
    b = 100 // 가능

    //var name : String = "soojeong"
    var last = "Lim"
}

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if(a > b){
        return a
    }
    else{
        return b
    }
}
fun maxBy2(a : Int, b : Int) : Int = if(a>b) a else b   // Expression

fun checkNum(score : Int) { // Statement
    when(score) { // switch를 대체,
        0 -> println("This is 0")
        1 -> println("This is 1")
        2,3 -> println("This is 2 or 3")
        else -> println("I don't know")
    }

    var b = when(score){    //else 필수, Expression
        1 -> 1
        2 -> 2
        else -> 3
    }

    println("b : $b")

    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not bad")
        else -> println("okay")
    }
}

// Expression(~~해서 값을 반환) vs Statement(~~ 이렇게 해, 명령, 지시하는 문장)
// 대부분의 코틀린의 함수는 Expression이며, 리턴 값이 없더라도 Unit을 반환함,

// Array and List

// Array 정해져있는 사이즈가 있음(메모리 할당되어 나옴), MutableArray(수정 가능)
// List : 1.List(수정 불가능, 읽기 전용) 2.MutableList(수정 가능, 읽기,쓰기 전용)
// Array, List 초기화
fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 : Array<Any> = arrayOf(1,"d",3.4f)
    val list2 : Array<Any> = arrayOf(1,"d",11L)

    array[0] = 3
    //list[0] = 3   오류! 수정 불가
    var result : Int = list.get(0)    // 가능

    val arrayList : ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)   // 추가 가능

    //arrayList = arrayListOf()   // 재할당 불가능

}

// 6. 반복문 For / While

fun forAudWhile(){
    val students = arrayListOf("joyce","james","jenny","jennifer")

    for(name in students){
        println("$name")
    }

    var sum : Int = 0
    for(i in 1..100 step 2){
        sum += 1
    }
    println(sum)
    for(i in 10 downTo 2){
        sum += 1
    }
    for(i in 1 until 100){  //1..99
        sum += 1
    }
    var index = 0
    while(index < 10){
        println("current index = $index")
        index++
    }

    for((index, name) in students.withIndex()){  // index와 name을 함께 사용
        println("${index+1} 번째 학생 : $name")
    }
}

// 7. Nullable / NonNull
fun nullcheck(){
    // NPE : NULL pointer Exception

    var name : String = "joyce"

    //var nullName : String = null    // NonNull타입에 null을 입력해서 오류남.
    var nullName : String? = null   // String에 ?을 붙여주면 Nullable타입이 됨.

    var nameInUpperCase = name.uppercase()

    //var nullNameInUpperCase :String = nullName.uppercase()  // 오류! nullName이 null인지 아닌지 몰라서
    var nullNameInUpperCase :String? = nullName?.uppercase() // nullName에 ?추가 nullName이 null이 아니면 .uppercase()를 하고, null이면 null을 반환함.

    // ?: 엘비스 연산자
    val lastName : String? = null
    val fullName = name+" "+ (lastName?: "No lastName")    // lastName이 null일 경우 No lastName 반환.
    println(fullName)
}
// !! (이거 Null 아니야. 보증해 줄께)
fun ignoreNulls(str : String?){
    val mNotNull : String = str!!   // !! null 아니야!

    val email : String? = "joycehongXXXX@nana.com"
    email?.let{
        //email이 null이 아니면 이거 실행해라, .let : 자신의 reciver 객체(email)를 내부로 옮겨줌
        println("my email is $email")
    }
}
