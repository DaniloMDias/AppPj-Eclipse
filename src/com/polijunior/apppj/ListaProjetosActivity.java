package com.polijunior.apppj;

import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class ListaProjetosActivity extends ListActivity implements OnItemClickListener {
	
	public final static String EXTRA_ID = "com.polijunior.apppj.ID";
	public final static String EXTRA_CLIENTE = "com.polijunior.apppj.CLIENTE";
	public final static String EXTRA_TELEFONE = "com.polijunior.apppj.TELEFONE";
	public final static String EXTRA_EMAIL = "com.polijunior.apppj.EMAIL";
	public final static String EXTRA_DESCRICAO = "com.polijunior.apppj.DESCRICAO";
	public final static String EXTRA_CONHECEU = "com.polijunior.apppj.CONHECEU";
	public final static String EXTRA_ATENDENTE = "com.polijunior.apppj.ATENDENTE";
	
	public ListView lista;
	List<ClasseProjeto> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_projetos);
		
		lista = (ListView)findViewById(android.R.id.list);
		
		lista.setOnItemClickListener(this);
		
		Projetos bd = new Projetos(this);
		
		list = bd.buscar();
		setListAdapter(new ProjetoAdapter(this, list));
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
			View rootView = inflater.inflate(R.layout.fragment_lista_projetos,
					container, false);
			return rootView;
		}
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		Intent intent = new Intent(this, DetalhesProjetoActivity.class);

		
		intent.putExtra(EXTRA_ID, String.valueOf(id));
		intent.putExtra(EXTRA_CLIENTE, list.get(position).getCliente());
		intent.putExtra(EXTRA_EMAIL, list.get(position).getEmail());
		intent.putExtra(EXTRA_TELEFONE, list.get(position).getTelefone());
		intent.putExtra(EXTRA_DESCRICAO, list.get(position).getDescricao());
		intent.putExtra(EXTRA_ATENDENTE, list.get(position).getAtendente());
		intent.putExtra(EXTRA_CONHECEU, list.get(position).getConheceu());
		
		
		
		
		
		startActivity(intent);
		
	}
}

class ProjetoAdapter extends BaseAdapter{
	private Context context;
	private List<ClasseProjeto> list;
	
	
	public ProjetoAdapter(Context context, List<ClasseProjeto> list){
		this.context = context;
		this.list = list;
	}
	
	
	
	@Override
	public int getCount() {
		
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		
		return list.get(arg0).getId();
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		final int auxPosition = position;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.projeto, null);
		
		TextView cliente =(TextView) layout.findViewById(R.id.cliente);
		//TextView telefone = (TextView) layout.findViewById(R.id.telefone);
		
		cliente.setText(list.get(position).getCliente());
		//telefone.setText(list.get(position).getTelefone());
		
		return layout;
	}
	
}


