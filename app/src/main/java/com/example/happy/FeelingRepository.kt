package com.example.happy

import androidx.lifecycle.LiveData

class FeelingRepository (private val feelingDao: FeelingDao) {

    val allFeelings: LiveData<List<Feeling>> = feelingDao.getAllRecords()

    suspend fun insertFeeling (feeling: Feeling) {
        feelingDao.insertFeeling(feeling)
    }
}