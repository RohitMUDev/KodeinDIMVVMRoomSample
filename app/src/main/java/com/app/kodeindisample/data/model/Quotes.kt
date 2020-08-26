package com.app.kodeindisample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes_table")
data class Quotes(val text : String, val author : String){


        @PrimaryKey(autoGenerate = true)
        var id: Int? = null

    override fun toString(): String {
        return "$text - $author"
    }
}