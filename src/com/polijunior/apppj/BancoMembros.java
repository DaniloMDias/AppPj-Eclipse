package com.polijunior.apppj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public final class BancoMembros extends SQLiteOpenHelper {

	public static final String NOME_BANCO = "membros";
	public static final int VERSAO_BANCO = 9;
	
	public BancoMembros(Context context) {
		super(context, NOME_BANCO, null, VERSAO_BANCO);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table membros(_id integer primary key autoincrement, nome text not null, curso text not null, celular text not null, email text not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table membros;");
		onCreate(db);
		
	}

}
