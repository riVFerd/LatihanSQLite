package com.rivferd.latihansqlite

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_NAME = "student_database"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE students(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT
            );
        """.trimIndent()
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlDrop = "DROP TABLE IF EXIST students;"
        val sqlCreate = """
            CREATE TABLE students(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT
            );
        """.trimIndent()
        val sql = sqlDrop + sqlCreate
        db?.execSQL(sql)
    }

    fun executeReadSQl(sql: String, args: Array<String>): Cursor {
        val db = readableDatabase
        val cursor = db.rawQuery(sql, args)
        return cursor
    }

    fun executeWriteSQL(sql: String) {
        val db = writableDatabase
        db.execSQL(sql)
    }
}