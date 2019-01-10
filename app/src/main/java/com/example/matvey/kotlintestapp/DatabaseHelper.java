package com.example.matvey.kotlintestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NAME = "uname";
    private static final String COLUMN_PASS = "pass";

    private  static final String TABLE_NOTICE = "notices";
    private static final String COLUMN_ID_NOTICE = "id";
    private static final String COLUMN_DATE = "noticedate";
    private static final String COLUMN_NOTICE = "notice";
    private static final String COLUMN_ID_USER= "userid";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null ,"
            +"email text not null, uname text not null, pass text not null);";

    private static final String TABLE_CREATE_NOTICE = "create table notices (id integer primary key not null ,"
            +"noticedate text not null, notice text not null, userid int not null);";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_NOTICE);
        this.db=db;
    }


    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String queryContacts ="SELECT * FROM contacts";
        Cursor cursor =db.rawQuery(queryContacts,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);

        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME,null, values);
        db.close();
    }
//---переход в мэйнактивити и после возвращения пишем

    public String searchPass(String uname)
    {
        db =this.getReadableDatabase();
        String query = "select uname, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "ничего не найдено";
        if(cursor.moveToFirst())
        {
            do
                {
            a = cursor.getString(0);
            b=cursor.getString(1);
            if(a.equals(uname))
            {
                b=cursor.getString(1);
                break;
            }
                }
                 while(cursor.moveToNext());
        }
        return b;
    }



    public String searchId(String username, String password)
    {
        db =this.getReadableDatabase();
        int searchedId=0;
        String queryId = "SELECT id, uname, pass FROM "+TABLE_NAME;
        Cursor cursorForId = db.rawQuery(queryId,null);
        String messageId= "1", messageUname, messagePass;
        if(cursorForId.moveToFirst())
        {
            do
            {
                messageId = cursorForId.getString(0);
                messageUname = cursorForId.getString(1);
                messagePass=cursorForId.getString(2);

                if(messageUname.equals(username)&(messagePass.equals(password)))
                {
                    //searchedId = Integer.parseInt(messageId);
                    break;
                }
            }
            while(cursorForId.moveToNext());
        }
        return messageId;
    }

    public String searchNotice(String date, String strUserId)
    {

        db =this.getReadableDatabase();
        String queryNotice = "SELECT noticedate, notice, userid FROM "+TABLE_NOTICE;

        //String strUserId;
        String messageDate, messageNotice, messageId;


        Cursor cursorForNotice = db.rawQuery(queryNotice,null);
        messageNotice = " ";
        if(cursorForNotice.moveToFirst())
        {
            do
            {
                messageDate = cursorForNotice.getString(0);
                //messageNotice = cursor.getString(1);
                messageId=cursorForNotice.getString(2);

                if(messageDate.equals(date)&messageId.equals(strUserId))
                {
                    messageNotice=cursorForNotice.getString(1);
                    break;
                }
            }
            while(cursorForNotice.moveToNext());
        }
        return messageNotice;
    }


    public void insertNotice(String date, String notice, int userid)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String queryNotices ="SELECT * FROM notices";
        Cursor cursor =db.rawQuery(queryNotices,null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_NOTICE,count);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_NOTICE, notice);
        values.put(COLUMN_ID_USER, userid);

        db.insert(TABLE_NOTICE,null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion)
    {
        String query1 ="DROP TABLE IF EXISTS "+TABLE_NAME;
        String query2 ="DROP TABLE IF EXISTS "+TABLE_NOTICE;
        db.execSQL(query1);
        db.execSQL(query2);
        this.onCreate(db);
    }

}
