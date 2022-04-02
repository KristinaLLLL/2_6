package com.example.a2_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rn: EditText = findViewById(R.id.rndNum)
        val btn: Button = findViewById(R.id.getRnd)
        btn.setOnClickListener {
            val x = RandomSingleton.getInstance().getNum()
            rn.setText(x.toString())
        }
    }
}

class RandomSingleton
// Create a LiveData with a random number
private constructor(){
    private var currentRandomNumber : Int = 0
    fun setNum() {
        currentRandomNumber = (0..50).random()
    }
    fun getNum():Int{
        return currentRandomNumber
    }
    init {
       setNum()
       getNum()
    }
    companion object : SingletonHolder<RandomSingleton>(::RandomSingleton)
}

open class SingletonHolder<out T: Any>(constructor: () -> T){
    private var constructor: (() -> T)? = constructor
    private var instance: T? = null
    fun getInstance(): T {
        if (instance != null) {
            return instance!!
        }else {
            instance = constructor!!()
            constructor = null
            return instance!!
        }

    }
}
