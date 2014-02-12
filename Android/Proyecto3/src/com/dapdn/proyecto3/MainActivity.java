
package com.dapdn.proyecto3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Paint;
public class MainActivity extends Activity {
 private TextView tv1,tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
public void Mision (View view){
	String Mision="Mision\nEducar con resposabilidad y exelencia, para formar a personas competitivas en el ambito social-laboral, con un modelo educativo de vanguardia que busca el quilibrio de enseñanza en tecnologia y etiqueta.";
	tv2.setText(Mision);
}
public void Vision(View view){
	String Vision="Vision \n Ser una institucion de nivel superior reconocida por su modelo, que forma a sus egresados con una actitud humana: de liderazgo y cualidad, que sean capaces de hacer aportaciones tecnologicas, innovadoras y vanguardistas tanto el sector productivo, como en el de servicio.";
	tv2.setText(Vision);
	
}
public void Quienes(View view){
	String Quienes="¿Quines somos? \nEl Instituto Tecnologico de Gustavo A. Madero es una Institucion de Educacion Superior dependiente de la subsecretaria de Educacion Superir de la Secretaria de Educacion Publica, creada para formar profesionistas capaces de enlazar existosamente a mexico con el mundo, a fin de proporcionar el desarrollo tecnologico en distancia aereas en beneficio del ser humano, concentrados en planes y programas de estudio congruenes con la realidad del pais, apegado a los estandares de calidad tanto nacionales e internacionales de las diversas disiplinas que se interpretan en el programa del sistema Nacional de Educacion Superior Tecnologicas.(SNEST).";
	tv2.setText(Quienes);
}
public void Requisitos(View view){
	String mision="Requisitos\n 1.-Acta de nacimiento original y copia y 1 copia tamaño carta.\n2.-Certificado de estudio de bachillerato original y copia tamaño carta.\n3.-Curp original y 1 copia tamaño carta \n4.-Fotografias tamaño infantil resientes \n5.-Pago de una cuota de inscripcion de $1500 \n6.-Haber tomado el curso induccion.";
	tv2.setText(mision);
}
}
