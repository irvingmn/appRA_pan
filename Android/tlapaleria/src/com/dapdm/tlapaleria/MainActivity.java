package com.dapdm.tlapaleria;

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
import android.widget.Toast;

public class MainActivity extends Activity {
private TextView tv1, tv2, tv3,tv4,tv5,tv6,tv7, tv8,tv9,tv10;
private EditText ed1, ed2,ed3;
private Spinner sp1;
private Button b1;
private RadioGroup rg1;
private RadioButton rb1, rb2;
private CheckBox ch1, ch2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	tv1=(TextView) findViewById(R.id.tv1);
	tv2=(TextView) findViewById(R.id.tv2);
	tv3=(TextView) findViewById(R.id.tv3);
	tv4=(TextView) findViewById(R.id.tv4);
	tv5=(TextView) findViewById(R.id.tv5);
	tv6=(TextView) findViewById(R.id.tv6);
	tv7=(TextView) findViewById(R.id.tv7);
	tv8=(TextView) findViewById(R.id.tv8);
	tv9=(TextView) findViewById(R.id.tv9);
	tv10=(TextView) findViewById(R.id.tv10);
	ed1=(EditText) findViewById(R.id.ed1);
	ed2=(EditText) findViewById(R.id.ed2);
	ed3=(EditText) findViewById(R.id.ed3);
	sp1=(Spinner)  findViewById(R.id.sp1);
	rg1=(RadioGroup)  findViewById(R.id.rg1);
	rb1=(RadioButton)  findViewById(R.id.rb1);
	rb2=(RadioButton)  findViewById(R.id.rb2);
	ch1=(CheckBox)  findViewById(R.id.ch1);
	ch2=(CheckBox)  findViewById(R.id.ch2);
	b1=(Button) findViewById(R.id.b1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
public void mostrar(View view ) {
	
	String nom=ed1.getText().toString();
	String rfc=ed2.getText().toString();
	String dir=ed3.getText().toString();
	

	tv5.setText("EL NOMBRE ES:  "+nom);
	tv6.setText("EL RFC ES:  "+rfc);
	tv7.setText("LA DIRECCION ES:  "+dir);
	
		if(rb1.isChecked()==true)
		{
			tv8.setText("EL PAGO ES POR TARJETA DE CREDITO");
		}
		
		else
		if(rb2.isChecked()==true)
		{
			tv8.setText("EL PAGO ES EN EFECTIVO");
		}
	
		if(ch1.isChecked()==true)
		{
			
			tv9.setText("SE REALIZO COMPRA");
			
		}
		else if(ch2.isChecked()==true)
		{
			
			tv9.setText("SE REALIZO VENTA");
			
		}
}
		}




