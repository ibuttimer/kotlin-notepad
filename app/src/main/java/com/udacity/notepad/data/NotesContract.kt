package com.udacity.notepad.data

import android.provider.BaseColumns

import com.udacity.notepad.data.NotesContract.NoteTable.CREATED_AT
import com.udacity.notepad.data.NotesContract.NoteTable.IS_PINNED
import com.udacity.notepad.data.NotesContract.NoteTable.TEXT
import com.udacity.notepad.data.NotesContract.NoteTable.UPDATED_AT
import com.udacity.notepad.data.NotesContract.NoteTable.ID

import com.udacity.notepad.data.NotesContract.NoteTable.TABLE_NAME
object NotesContract {

    object NoteTable {
        const val ID = BaseColumns._ID
        const val TABLE_NAME = "notes"
        const val TEXT = "text"
        const val IS_PINNED = "is_pinned"
        const val CREATED_AT = "created_at"
        const val UPDATED_AT = "updated_at"
    }

    val SQL_CREATE_ENTRIES = """CREATE TABLE $TABLE_NAME (
        $ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
        $TEXT TEXT,
        $IS_PINNED INTEGER,
        $CREATED_AT INTEGER,
        $UPDATED_AT INTEGER
    )""".trimMargin()

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"

    val SQL_QUERY_ALL = "SELECT * FROM $TABLE_NAME ORDER BY $CREATED_AT DESC"
}
