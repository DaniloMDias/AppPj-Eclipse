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
import com.polijunior.apppj.BancoMembros;


public class CadastroMembrosActivity extends Activity {
	
	ClasseMembro membro = new ClasseMembro();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_membros);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	public void cadastrar(View view){
		
		EditText nome = (EditText)findViewById(R.id.editText1);
		EditText celular = (EditText)findViewById(R.id.editText2);		
		EditText curso = (EditText)findViewById(R.id.editText4);
		EditText email = (EditText)findViewById(R.id.editText3);
		
		membro.setCurso(curso.getText().toString());
		membro.setNome(nome.getText().toString());
		membro.setCelular(celular.getText().toString());
		membro.setEmail(email.getText().toString());
		
		
		Membros db = new Membros(this);
		db.inserir(membro);
		
		Toast.makeText(getApplicationContext(), "Membro Cadastrado" + curso.getText().toString(), 
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
					R.layout.fragment_cadastro_membros, container, false);
			return rootView;
		}
	}
}
