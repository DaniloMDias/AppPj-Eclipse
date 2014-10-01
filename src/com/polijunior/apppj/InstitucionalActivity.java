package com.polijunior.apppj;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.database.sqlite.*;

public class InstitucionalActivity extends Activity implements OnItemClickListener {
	
//	 private String[] mListaLateral;
	 private DrawerLayout mDrawerLayout;
	 private ListView mDrawerList;
	 private ActionBarDrawerToggle mDrawerToggle;
	 private CharSequence mTitle;
	 private CharSequence mDrawerTitle;
	 private MyAdapter myAdapter;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucional);
		
//		 mListaLateral = getResources().getStringArray(R.array.itens_lateral);
		 mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	     mDrawerList = (ListView) findViewById(R.id.gaveta);
	     mTitle = mDrawerTitle = getTitle();
	     
	     myAdapter = new MyAdapter(this);
	     mDrawerList.setAdapter(myAdapter);
//	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//	             android.R.layout.simple_list_item_1, values);
	     
	     
	     
	     
//	     mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//	                R.layout.drawer_list_item, mListaLateral));
	     
	     //TODO Novo adaptador https://www.youtube.com/watch?v=rs4LW3GxOgE
	     
	     
	     
	     mDrawerList.setOnItemClickListener(this);
	     
	     mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
	                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
	    	 public void onDrawerClosed(View view){
	    		 
	    	
	    	 }
	    	 
	    	 public void onDrawerOpened(View drawerView){
	    		 
	    	 }
	     };
	     
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

	    
	     
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(mDrawerToggle.onOptionsItemSelected(item)){
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
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
			View rootView = inflater.inflate(R.layout.fragment_institucional,
					container, false);
			return rootView;
		}
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
				
				if(position == 0){
					Intent intent = new Intent(this, CadastroProjetosActivity.class);
					
					startActivity(intent);
				}
		
				else if(position == 1){
					Intent intent = new Intent(this, CadastroMembrosActivity.class);
					
					startActivity(intent);
					
				}
				else if(position == 2){
					Intent intent = new Intent(this, ListaMembrosActivity.class);
					
					startActivity(intent);
//					Toast.makeText(getApplicationContext(), "posicao 1", 
//			    		      Toast.LENGTH_SHORT).show();
				}
				
				else if(position == 3){
					Intent intent = new Intent(this, ListaProjetosActivity.class);
					
					startActivity(intent);
//					Toast.makeText(getApplicationContext(), "posicao 1", 
//			    		      Toast.LENGTH_SHORT).show();
				}
		
				else if(position == 4){
					Intent intent = new Intent(this, MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
				}
	}
	
	class MyAdapter extends BaseAdapter{
		private Context context;
		String[] mListaLateral;
		int[] images = {R.drawable.ic_action_new,R.drawable.ic_action_add_person, R.drawable.ic_action_cc_bcc,R.drawable.ic_action_edit, R.drawable.ic_action_cancel};
		
		public MyAdapter(Context context) {
			this.context = context;
			mListaLateral = context.getResources().getStringArray(R.array.itens_lateral);
			
		}
		
		@Override
		public int getCount() {
			
			return mListaLateral.length;
		}

		@Override
		public Object getItem(int position) {
			
			return mListaLateral[position];
		}

		@Override
		public long getItemId(int position) {
			
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = null;
			
			if(convertView == null){
				LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.drawer_list_item, parent, false); 
			}
			
			else{
				row = convertView;
				
			}
			TextView titleTextView =(TextView) row.findViewById(R.id.textView1);
			ImageView titleImageView = (ImageView) row.findViewById(R.id.imageView1);
			
			titleTextView.setText(mListaLateral[position]);
			titleImageView.setImageResource(images[position]);
			return row;
		}
		
	}
}


