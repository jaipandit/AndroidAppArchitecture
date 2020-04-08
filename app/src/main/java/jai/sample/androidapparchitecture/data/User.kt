package jai.sample.androidapparchitecture.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey val userId: Int,
                val id: Int,
                val title: String,
                val body: String)