package css.cis3334.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WorkoutDatabase.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_WORKOUTS = "workouts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_MUSCLE = "muscle";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_WORKOUTS = "CREATE TABLE " + TABLE_WORKOUTS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_TYPE + " TEXT," +
                COLUMN_MUSCLE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_WORKOUTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        onCreate(db);
    }
}
