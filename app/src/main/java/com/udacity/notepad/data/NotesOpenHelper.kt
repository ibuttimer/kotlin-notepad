package com.udacity.notepad.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.udacity.notepad.data.NotesContract.NoteTable.CREATED_AT
import com.udacity.notepad.data.NotesContract.NoteTable.ID
import com.udacity.notepad.data.NotesContract.NoteTable.IS_PINNED
import com.udacity.notepad.data.NotesContract.NoteTable.TABLE_NAME
import com.udacity.notepad.data.NotesContract.NoteTable.UPDATED_AT

import com.udacity.notepad.data.NotesContract.SQL_CREATE_ENTRIES
import com.udacity.notepad.data.NotesContract.SQL_DELETE_ENTRIES
import org.jetbrains.anko.db.*

class NotesOpenHelper(context: Context) : SQLiteOpenHelper(context, "notes.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

//        db.execSQL(SQL_CREATE_ENTRIES)

        // create table using anko
        db.createTable(TABLE_NAME, true,
                ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT + UNIQUE,
                NotesContract.NoteTable.TEXT to TEXT,
                IS_PINNED to INTEGER,
                CREATED_AT to INTEGER,
                UPDATED_AT to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL(SQL_DELETE_ENTRIES)

        // drop table using anko
        db.dropTable(TABLE_NAME, true)

        onCreate(db)
    }
}
