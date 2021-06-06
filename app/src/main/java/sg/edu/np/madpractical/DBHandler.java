package sg.edu.np.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE = "users.db";

    public DBHandler(@Nullable Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE user (name TEXT, description TEXT, id INTEGER PRIMARY KEY AUTOINCREMENT, followed INTEGER)";
        db.execSQL(create);

        for (int i = 0; i<20; i++){
            ContentValues content = new ContentValues();
            content.put("name", "Name" + new Random().nextInt());
            content.put("description", "Description" + new Random().nextInt());
            content.put("followed", new Random().nextBoolean());
            db.insert("user", null, content);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user", null);
        while(cursor.moveToNext()){
            User user = new User();
            user.name = cursor.getString(0);
            user.description = cursor.getString(1);
            user.id = cursor.getInt(2);
            user.followed = cursor.getInt(3)==0?false:true;
            userlist.add(user);
        }
        cursor.close();
        db.close();
        return userlist;
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("followed", user.followed);
        int count = db.update("user", content, "id = ?", new String[]{"" + user.id});
        db.close();
    }
}
