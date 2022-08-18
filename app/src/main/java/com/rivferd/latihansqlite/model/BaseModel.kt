package com.rivferd.latihansqlite.model

import android.content.Context
import com.rivferd.latihansqlite.DatabaseHelper

abstract class BaseModel(
    context: Context,
    protected var dbHelper: DatabaseHelper = DatabaseHelper(context)
) {
    protected abstract fun getTableName(): String

    fun insert(model: BaseModel) {

    }

    fun update(model: BaseModel) {

    }

    fun delete(model: BaseModel) {

    }

    fun selectAll(): ArrayList<BaseModel>? {
        return null
    }

    fun selectOne(): BaseModel? {
        return null
    }
}