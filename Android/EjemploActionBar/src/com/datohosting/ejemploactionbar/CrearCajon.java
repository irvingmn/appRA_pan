package com.datohosting.ejemploactionbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.datohosting.ejemploactionbar.R;

public class CrearCajon extends ActionBarActivity implements ListView.OnItemClickListener, DrawerListener {
	
	
	private ActionBar actionBar;
	private DrawerLayout cajon;
	private ListView opciones;
	private ActionBarDrawerToggle toggle;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cajon);
		
		actionBar = getSupportActionBar();
		
		/**INDICAR TITULO Y SUBTITULO**/
		actionBar.setTitle("EJ ActionBar");
		actionBar.setSubtitle("8.Crear cajon");
		
		/**CONFIGURAR CAJON**/
		String[] valores = getResources().getStringArray(R.array.cajon);
		cajon = (DrawerLayout) findViewById(R.id.drawer_layout);
		opciones = (ListView) findViewById(R.id.left_drawer);
		opciones.setAdapter(new ArrayAdapter<String>(this, R.layout.plantilla_cajon, valores));
		opciones.setOnItemClickListener(this);
		
		/**APLICAR SOMBRA AL CAJON**/
		cajon.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		
		/**HABILITAR ICONO DE LA APLICACION PARA EL MENU DE NAVEGACION**/
		toggle = new ActionBarDrawerToggle(this, cajon, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    getSupportActionBar().setHomeButtonEnabled(true);
	    
	    
		cajon.setDrawerListener(this);
	}
	
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switch (arg2) {
			case 0:
				Toast.makeText(getApplicationContext(), "BUSCAR", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(getApplicationContext(), "CORTAR", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(getApplicationContext(), "COPIAR", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(getApplicationContext(), "ELIMINAR", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(getApplicationContext(), "COMPARTIR", Toast.LENGTH_SHORT).show();
				break;
		}
		cajon.closeDrawer(opciones);
	}


	/**METODOS PARA MANEJAR LA APERTURA Y CIERRE DEL NAVIGATION DRAWER DESDE EL ICONO DE LA APLICACION**/
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
          return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**METODOS PARA MANEJAR LOS EVENTOS DE APERTURA Y CIERRE DEL NAVIGATION DRAWER**/
	@Override
	public void onDrawerClosed(View arg0) {
		//actionBar.setTitle("EJ ActionBar");
	}
	@Override
	public void onDrawerOpened(View arg0) {
		//actionBar.setTitle("Menu Principal");
	}
	@Override
	public void onDrawerSlide(View arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDrawerStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}