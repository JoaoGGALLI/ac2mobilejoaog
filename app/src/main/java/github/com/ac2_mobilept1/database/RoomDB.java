package github.com.ac2_mobilept1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import github.com.ac2_mobilept1.domain.MainDao;
import github.com.ac2_mobilept1.domain.MainData;


@Database(entities = {MainData.class},version = 1,exportSchema = false)

public abstract class RoomDB extends RoomDatabase {
    private static RoomDB databse;

    private static String DATABASE_NAME="database";

    public  synchronized static RoomDB getInstance(Context context){
        if(databse==null){

            databse= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return databse;
    }


    public abstract MainDao mainDao();

}
