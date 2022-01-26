package com.example.myapplication

class Practice3 {
}
// 3. Companion Object
// 자바의 static 대신에 사용됨.
// 정적인 메소드나 변수를 선언할때 사용.
class Book private constructor(val id : Int, var name : String){    // private constructor : 다른곳에서 객체를 생성하지 못하게 함.
    companion object BookFactory :IdProvider{   // private 이나 메소드를 읽어올 수 있게 함. :IdProvider <- 상속
        //(상속해주려면 오버라이드 해줘야함)
        override fun getId(): Int {
            return 444
        }

        //val myBook = "name" 도 가능
        fun create() = Book(0,"animal farm")
        //fun create() = Book(getId(), myBook)
    }
}

// 인터페이스 상속도 가능!
interface IdProvider {
    fun getId() : Int
}

fun main(){
    //val book = Book() 오류! 사용 못함
    val book = Book.create()  // Book.Companion.create()의 Companion 생략가능,
    println("$book.id $book.name")

    val bookId = Book.BookFactory.getId()
    println("$book.id $book.name")
}