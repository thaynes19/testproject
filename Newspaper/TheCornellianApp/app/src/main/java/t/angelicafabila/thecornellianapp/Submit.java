package t.angelicafabila.thecornellianapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class Submit {

    private static final String DATABASE_NAME = "database.db";
    private String ok = "OK";
    private static final int DATABASE_VERSION = 1;
    private  static String getMessage="";
    public static final int NAME_COLUMN = 1;

    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table " +
            "NAME text,MESSAGE text); ";
    // Variable to hold the database instance
    private static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private static DataBaseHelper dbHelper;
    public  Submit(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Method to openthe Database
    public  Submit open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    // Method to close the Database
    public void close()
    {
        db.close();
    }
    // method returns an Instance of the Database
    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }
    // method to insert a record in Table
    public String insertEntry(String Name,String Message)
    {
        try {
            ContentValues newValues = new ContentValues();
            // Assign values for each column.
            newValues.put("NAME", Name);
            newValues.put("MESSAGE", Message);
            // Insert the row into your table
            db = dbHelper.getWritableDatabase();
            long result=db.insert("FORM", null, newValues);
            System.out.print(result);
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            System.out.println("Exceptions " +ex);
            Log.e("Note", "One row entered");
        }
        return ok;
    }

    // method to get the message  of user
    public String getSinlgeEntry(String Name)
    {
        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("FORM", null, "NAME=?", new String[]{Name}, null, null, null);
        if(cursor.getCount()<1) // Name Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        getMessage= cursor.getString(cursor.getColumnIndex("MESSAGE"));
        return getMessage;
    }
    // Method to Update an Existing
    public void  updateEntry(String Name,String Message)
    {
        //  create object of ContentValues
        ContentValues updatedValues = new ContentValues();
        // Assign values for each Column.
        updatedValues.put("NAME", Name);
        updatedValues.put("MESSAGE", Message);
        String where="NAME = ?";
        db.update("FORM",updatedValues, where, new String[]{Name});
    }

}
