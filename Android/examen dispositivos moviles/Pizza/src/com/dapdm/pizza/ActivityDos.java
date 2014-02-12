package com.dapdm.pizza;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.Menu;
import android.view.View;


public class ActivityDos extends Activity {
	Bundle a,b,c,d,e,f;
	String tamaño,orilla,ingredientes,nombre,telefono,direccion;
	TextView tv3,tv5,tv7,tv9,tv11,tv13;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitydos);
		tv3=(TextView)findViewById(R.id.tv3);
		tv5=(TextView)findViewById(R.id.tv5);
		tv7=(TextView)findViewById(R.id.tv7);
		tv9=(TextView)findViewById(R.id.tv9);
		tv11=(TextView)findViewById(R.id.tv11);
		tv13=(TextView)findViewById(R.id.tv13);
		
		a=getIntent().getExtras();
		b=getIntent().getExtras();
		c=getIntent().getExtras();
		d=getIntent().getExtras();
		e=getIntent().getExtras();
		f=getIntent().getExtras();
		
		tamaño=a.getString("Tamaño");
		orilla=b.getString("Orilla");
		ingredientes=c.getString("Ingredientes");
		nombre=d.getString("Nombre");
		direccion=d.getString("Direccion");
		telefono=d.getString("Telefono");
}
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void cerrar(View view){
		finish();
	}
}
