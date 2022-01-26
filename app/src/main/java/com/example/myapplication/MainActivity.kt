package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // 앱을 최초로 시작될때 실행되는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // activity_main.xml파일이 View형식으로 받아냄. R : res의 약자

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // to do..
            }

        })

        // 버튼에 람다식을 이용하는 방법
        // 1. 코틀린 인터페이스가 아닌 자바 인터페이스여야함.
        // 2. 그 인터페이스는 딱 하나의 메소드만 가져야함.
        button.setOnClickListener{
            // to do..      위의 button.setOnClickListener(object : View.OnClickListener {} 과 같음.
        }
    }
    // onCreate 다음 실행되는 함수
    //override fun onStart() {
    //    super.onStart() // 부모 클래스 그 자체(MainActivity)를 호출함
    //}
}