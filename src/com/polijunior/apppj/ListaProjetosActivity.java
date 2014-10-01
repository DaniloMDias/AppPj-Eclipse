package com.polijunior.apppj;

import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;

public class ListaProjetosActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_projetos);
		
		
		Projetos bd = new Projetos(this);
		
		List<ClasseProjeto> list = bd.buscar();
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


