package com.polijunior.apppj;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class InstitucionalActivity extends Activity implements OnItemClickListener {
	
	 private String[] mListaLateral;
	 private DrawerLayout mDrawerLayout;
	 private ListView mDrawerList;
	 private ActionBarDrawerToggle mDrawerToggle;
	 private CharSequence mTitle;
	 private CharSequence mDrawerTitle;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucional);
		
		 mListaLateral = getResources().getStringArray(R.array.itens_lateral);
		 mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	     mDrawerList = (ListView) findViewById(R.id.gaveta);
	     mTitle = mDrawerTitle = getTitle();
//	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//	             android.R.layout.simple_list_item_1, values);
	     
	     
	     
	     
	     mDrawerList.setAdapter(new ArrayAdapter<String>(this,
	                R.layout.drawer_list_item, mListaLateral));
	     
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
		// TODO Auto-generated method stub
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
		Toast.makeText(this, mListaLateral[position] + " foi selecionado", Toast.LENGTH_LONG).show()
;		
	}
}


