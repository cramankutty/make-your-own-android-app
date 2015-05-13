package com.myswot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "sirsuspect";
	private static final String TABLE_NAME = "info";
	private static final String _id = "_id";
	private static final String name = "name";
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table " + TABLE_NAME + "(" + _id
				+ " INTEGER PRIMARY KEY," + name + " TEXT)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + TABLE_NAME);
		onCreate(db);
	}
	public void insertData(String label) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(name, label);
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	public Set<String> getAllData() {
		Set<String> set = new HashSet<String>();

		String selectQuery = "select * from " + TABLE_NAME;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				set.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return set;
	}
}
