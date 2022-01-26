package com.example.myapplication

// 9. class 정의 및 상속, 구조
open class ClassPractice(name : String = "Anonymous") {  // 주생성자 : name : String = "Anonymous"

    // java의 오버로딩 -> kotlin constructor 부호생성자 사용.
    //constructor(name : String, age : Int) 오류! 부호생성자는 주생성자의 위임을 받아야함.
    constructor(name : String, age : Int) : this(name) {
        println("My name is $name, $age years old")
    }

    val name = "joyce"

    fun eatingCake(){
        println("This is so yummyyy~~")
    }

    open fun singASong(){    // 하나의 메소드
        println("lalala~")
    }
}

// 객체를 생성할때 정의하고 싶다면? constructor 생성자 이용.
class ClassPractice2 constructor(name : String = "Anonymous"){  // = " " Default값
    // 생성자에서 코드블록을 실행할 수 없음. 코드블록을 넣고 싶으면 init 사용.
    init{   // ClassPractice2 클래스의 인스턴스를 생성할때 어떤 동작을 하고 싶은지 적어줄 수 있음. 주생성자의 일부 이므로 먼저 실행됨.
        println("New human has been born!!")
    }
    val name : String = name
}

// 상속
class Korean : ClassPractice(){
    //오버라이딩 : 부모 클래스를 자식 클래스에 새로 덮어 씌움.
    //override fun singASong()    오류! java에서 사용하던 방법임. 사용하는 부모 메소드에 open을 붙여줘야함.
    override fun singASong(){
        println("랄랄라~")
        super.singASong()   // 원래 부모 클래스 메소드 그대로 사용
        println("My name is : $name")
    }
}

fun main(){
    val human = ClassPractice() // 객체 생성 new 키워드 필요 없음.
    human.eatingCake()
    println("This human's name is ${human.name}")

    val human2 = ClassPractice2("mainsu")
    val stranger = ClassPractice2() // = " " Default값
    human.eatingCake()
    println("This human's name is ${human.name}")

    val mom = ClassPractice("Kuri", 52)
    println("This human's name is ${human.name}")

    val korean = Korean()
    korean.singASong()
}