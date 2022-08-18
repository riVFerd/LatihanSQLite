package com.rivferd.latihansqlite.model

import android.content.Context

class Student(context: Context) : BaseModel(context) {
    override fun getTableName(): String {
        return "student"
    }
}