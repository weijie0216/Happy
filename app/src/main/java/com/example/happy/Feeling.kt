package com.example.happy

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "feeling")
class Feeling (
    @PrimaryKey (autoGenerate = true) val id: Int,
    val mode: Int,
    val remarks: String,
    val created_at: Long = System.currentTimeMillis()
)