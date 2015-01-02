package com.example.phonehistory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists call_history(number varchar, date varchar, time varchar, duration varchar, type varchar)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS call_history");
	    onCreate(db);
	}
	
	public boolean insertdata(String number, String date, String time,String duration, String type)
	{
		SQLiteDatabase sdb=this.getWritableDatabase();
		sdb.execSQL("insert into call_history values('"+number+"','"+date+"','"+time+"','"+duration+"','"+type+"')");
		return true;
	}
	
	public Cursor getData()
	{
		SQLiteDatabase sdb=this.getReadableDatabase();
		Cursor c=sdb.rawQuery("select * from call_history", null);
		return c;
	}
	public void deleteTable()
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS call_history");
		onCreate(db);
	}

}
