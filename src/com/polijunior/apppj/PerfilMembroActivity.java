package com.polijunior.apppj;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PerfilMembroActivity extends Activity {
	
	private String teste;
	private SQLiteDatabase db;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_perfil_membro);
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		

		
		Intent intent = getIntent();
		
		TextView nome = (TextView)findViewById(R.id.nome);
		TextView email = (TextView)findViewById(R.id.email);
		TextView celular = (TextView)findViewById(R.id.celular);
		TextView curso = (TextView)findViewById(R.id.curso);
		
//		String textonome = intent.getStringExtra(ListaMembrosActivity.EXTRA_NOME);
		
//		Toast.makeText(getApplicationContext(),"O email é " + textonome, 
//	  		      Toast.LENGTH_SHORT).show();
		
		nome.setText(intent.getStringExtra(ListaMembrosActivity.EXTRA_NOME));
		email.setText(intent.getStringExtra(ListaMembrosActivity.EXTRA_EMAIL));
		celular.setText(intent.getStringExtra(ListaMembrosActivity.EXTRA_CELULAR));
		curso.setText(intent.getStringExtra(ListaMembrosActivity.EXTRA_CURSO));
		
		
		
		
		
		
		
		
	}

	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_perfil_membro,
					container, false);
			return rootView;
		}
	}
}
