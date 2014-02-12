package com.dapdm.pizza;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends Activity {
     
	private RadioButton rb1,rb2,rb3;
	private CheckBox ch1,ch2,ch3;
	private Spinner sp1;
	private EditText et1,et2,et3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		rb1=(RadioButton)findViewById(R.id.rb1);
		rb2=(RadioButton)findViewById(R.id.rb2);
		rb3=(RadioButton)findViewById(R.id.rb3);
		
		ch1=(CheckBox)findViewById(R.id.ch1);
		ch2=(CheckBox)findViewById(R.id.ch2);
		ch3=(CheckBox)findViewById(R.id.ch3);
		
		sp1=(Spinner)findViewById(R.id.sp1);
		
		String[]opciones={ "piña, jamon y pimiento","peperoni,pimiento y champiñones"
				,"rajas, chorizo y frijoles"};
		ArrayAdapter<String> adapter= new
				ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
						opciones);
		sp1.setAdapter(adapter);
		et1=(EditText) findViewById(R.id.et1);
		et2=(EditText) findViewById(R.id.et2);
		et3=(EditText) findViewById(R.id.et3);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void lanzar(View view){
		String tam="";
		if(rb1.isChecked()==true){
			tam="Chica";
		}else
			if(rb2.isChecked()==true){
				tam="mediana";	
			}
			else
				if(rb3.isChecked()==true){
					tam="Grande";	
				}
		String ori="";
		if(ch1.isChecked()==true){
			ori="orilla con queso";
		}
		if(ch2.isChecked()==true){
			ori="orilla con queso y chipotle";
		}
		if(ch3.isChecked()==true){
			ori="orilla con queso";
		}
		String selec=sp1.getSelectedItem().toString();
		String ingre="";
		if(selec.equals("piña,jamon y pimiento")){
			ingre="piña,jamon y pimiento";
			
		}else
			if(selec.equals("peperoni, pimiento y champiñones")){
				ingre="peperoni,pimiento y champiñones";
				
			}else
				if(selec.equals("rajas,chorizo y frijoles")){
					ingre="rajas,chorizo yfrijoles";
					
				}
		Intent Segundo= new Intent(this,ActivityDos.class);
		Segundo.putExtra("Tamaño", tam);
		Segundo.putExtra("Orilla", ori);
		Segundo.putExtra("Ingredientes", ingre);
		Segundo.putExtra("Nombre",et1.getText().toString());
		Segundo.putExtra("Direccion",et2.getText().toString());
		Segundo.putExtra("Telefono",et3.getText().toString());
		
		startActivity(Segundo);
	}

}




