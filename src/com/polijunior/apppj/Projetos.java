package com.polijunior.apppj;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Projetos {
	private SQLiteDatabase db;
	
	public Projetos(Context context){
		BancoProjetos auxdb = new BancoProjetos(context);
		db = auxdb.getWritableDatabase();
	}
	
	public void inserir(ClasseProjeto projeto){
		ContentValues values = new ContentValues();
		values.put("cliente", projeto.getCliente());
		values.put("telefone", projeto.getTelefone());
		values.put("email", projeto.getEmail());
		values.put("descricao", projeto.getDescricao());
		values.put("conheceu", projeto.getConheceu());
		values.put("atendente", projeto.getAtendente());
		
		db.insert("projetos", null, values);
	}
	
	public void deletar(ClasseProjeto projeto){
		db.delete("projetos", "_id ="+projeto.getId(), null);
	}
	
	public List<ClasseProjeto> buscar(){
		List<ClasseProjeto> list = new ArrayList<ClasseProjeto>();
		String[] colunas = new String[]{"_id","cliente", "telefone", "email", "descricao", "conheceu", "atendente"};
		Cursor cursor = db.query("projetos", colunas, null, null, null, null, "cliente ASC");
		
		if(cursor.getCount()>0){
			cursor.moveToFirst();
			
			do{
				ClasseProjeto u = new ClasseProjeto();
				u.setId(cursor.getLong(0));
				u.setCliente(cursor.getString(1));
				u.setTelefone(cursor.getString(2));
				u.setEmail(cursor.getString(3));
				list.add(u);
				
				
			}while(cursor.moveToNext());
		}
		
		return list;
	}

}
