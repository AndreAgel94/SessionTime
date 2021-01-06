package com.andre.agel.sessiontime.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andre.agel.sessiontime.data.database.dao.ActorDao
import com.andre.agel.sessiontime.data.database.dao.FavoriteDao
import com.andre.agel.sessiontime.data.database.dao.MovieDao
import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.Movie

@Database(entities = [Movie::class, Actor::class], version=1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun actorDao() : ActorDao
 //   abstract fun favoriteDao() : FavoriteDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}