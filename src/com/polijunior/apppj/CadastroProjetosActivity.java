package com.polijunior.apppj;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CadastroProjetosActivity extends Activity {
	
	ClasseProjeto projeto = new ClasseProjeto();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_projetos);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void cadastrar(View view){
		
		 EditText cliente = (EditText)findViewById(R.id.editText1);
		 EditText telefone = (EditText)findViewById(R.id.editText2);
		 EditText email = (EditText)findViewById(R.id.editText3);
		 EditText descricao = (EditText)findViewById(R.id.editText4);
		 EditText conheceu = (EditText)findViewById(R.id.editText5);
		 EditText atendente = (EditText)findViewById(R.id.editText6);
		 
		 projeto.setCliente(cliente.getText().toString());
		 projeto.setTelefone(telefone.getText().toString());
		 projeto.setEmail(email.getText().toString());
		 projeto.setDescricao(descricao.getText().toString());
		 projeto.setConheceu(conheceu.getText().toString());
		 projeto.setAtendente(atendente.getText().toString());
		 
		 
		
		Projetos db = new Projetos(this);
		db.inserir(projeto);
		
		Toast.makeText(getApplicationContext(), "Projeto Cadastrado", 
  		      Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, InstitucionalActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
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
			View rootView = inflater.inflate(
					R.layout.fragment_cadastro_projetos, container, false);
			return rootView;
		}
	}
}
