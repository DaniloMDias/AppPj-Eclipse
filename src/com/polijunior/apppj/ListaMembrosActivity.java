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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class ListaMembrosActivity extends ListActivity implements OnItemClickListener {

	private ListView lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_membros);
		
		lista = (ListView)findViewById(android.R.id.list);
		
		lista.setOnItemClickListener(this);
		
		Membros bd = new Membros(this);
		
		List<ClasseMembro> list = bd.buscar();
		setListAdapter(new MembroAdapter(this, list));
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
			View rootView = inflater.inflate(R.layout.fragment_lista_membros,
					container, false);
			return rootView;
		}
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		
	}
	
	
}

class MembroAdapter extends BaseAdapter{
	private Context context;
	private List<ClasseMembro> list;
	
	
	public MembroAdapter(Context context, List<ClasseMembro> list){
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
		final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.membro, null);
		
		TextView nome =(TextView) layout.findViewById(R.id.nome);
		TextView email = (TextView) layout.findViewById(R.id.email);
		
		
		nome.setText(list.get(position).getNome());
		email.setText(list.get(position).getEmail());
		
		return layout;
	}
	
}