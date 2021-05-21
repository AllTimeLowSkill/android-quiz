package com.example.todoapp

class Question(_t: String, ans: Boolean) {
    private var title:String

    private var answer:Boolean

    init {
        title = _t
        answer = ans
    }

    fun getTitle(): String {
        return title.toString()
    }

    fun getAnswer(): Boolean {
        return answer
    }

    fun stAnswer(answ: Boolean){
        answer = answ
    }
}