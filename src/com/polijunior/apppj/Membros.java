package com.polijunior.apppj;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Membros {
	private SQLiteDatabase db;
	
	public Membros(Context context){
		BancoMembros auxdb = new BancoMembros(context);
		db = auxdb.getWritableDatabase();
	}
	
	public void inserir(ClasseMembro membro){
		ContentValues values = new ContentValues();
		values.put("nome", membro.getNome());
		values.put("celular", membro.getCelular());
		values.put("email", membro.getEmail());
		values.put("curso", membro.getCurso());
		
		
		db.insert("membros", null, values);
	}
	
	public void deletar(ClasseMembro projeto){
		db.delete("membros", "_id ="+projeto.getId(), null);
	}
	
	public List<ClasseMembro> buscar(){
		List<ClasseMembro> list = new ArrayList<ClasseMembro>();
		String[] colunas = new String[]{"_id","nome", "celular", "email", "curso"};
		Cursor cursor = db.query("membros", colunas, null, null, null, null, "nome ASC");
		
		if(cursor.getCount()>0){
			cursor.moveToFirst();
			
			do{
				ClasseMembro u = new ClasseMembro();
				u.setId(cursor.getLong(0));
				u.setNome(cursor.getString(1));
				u.setCelular(cursor.getString(2));
				u.setEmail(cursor.getString(3));
				list.add(u);
				
				
			}while(cursor.moveToNext());
		}
		
		return list;
	}

}
