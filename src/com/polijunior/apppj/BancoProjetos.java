package com.polijunior.apppj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public final class BancoProjetos extends SQLiteOpenHelper {

	public static final String NOME_BANCO = "projetos";
	public static final int VERSAO_BANCO = 1;
	
	public BancoProjetos(Context context) {
		super(context, NOME_BANCO, null, VERSAO_BANCO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table projetos(_id integer primary key autoincrement, cliente text not null, telefone text not null, email text not null, descricao text not null, conheceu text not null, atendente text not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table projetos;");
		onCreate(db);
		
	}

}
