package com.proyectosimio.spinner_animales;

import java.util.TreeMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Actividad que muestra la descripci�n del animal seleccionado del Spinner.
 * 
 * @author ProyectoSimio
 * 
 */
public class Main extends Activity implements OnItemSelectedListener {
	private final static String[] names = {"Grafica lineal", "Grafica de barra", "Grafica de Pie",
			"Canario", "Vaca", "Cerdo" };
	private TreeMap<String, String> descrip;

	private ArrayAdapter<String> adapter;
	private Spinner spAnimals;

	private EditText etDescrip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etDescrip = (EditText) findViewById(R.id.etDescription);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, names);

		spAnimals = (Spinner) findViewById(R.id.spAnimals);
		spAnimals.setAdapter(adapter);
		spAnimals.setOnItemSelectedListener(this);

		rellenarDescripciones();
	}

	/**
	 * M�todo que rellenar� los datos del TreeMap para poder visualizar las
	 * descripciones posteriormente.
	 */
	public void rellenarDescripciones() {
		// Inicializamos la variable.
		descrip = new TreeMap<String, String>();

		// Rellenamos la variable con las descripciones.
		descrip.put("Grafica lineal","Mam�fero carn�voro ");
		descrip.put(
				"Grafica de barra",
				" Mam�fero carn�voro dom�stico, de la familia de los f�lidos, de patas cortas y u�as retr�ctiles, cabeza redonda, y pelo espeso y suave; suele tenerse como animal de compa��a: el gato es un h�bil cazador de ratones.");
		descrip.put(
				"Grafica de Pie",
				"Mam�fero �quido, macho, de cuerpo fuerte, orejas peque�as, cola cubierta de largo pelo y patas terminadas en casco; es herb�voro, se domestica con facilidad y se suele usar para montar en �l.");
		descrip.put(
				"",
				"P�jaro de plumaje amarillo, verdoso o casi blanco, muy apreciado por su canto y que se suele criar como ave dom�stica.");
		descrip.put(
				"grafica de posicion",
				"Hembra del toro. De joven se denomina ternera, becerra, vaquilla o novilla. Su leche constituye un alimento complet�simo y, despu�s de la de burra, es la m�s parecida a la de la mujer.");
		descrip.put(
				"Cerdo",
				"Mam�fero dom�stico de cuerpo grueso, patas cortas, cabeza grande, orejas ca�das, hocico chato y casi cil�ndrico y cola en forma de h�lice, que se cr�a para aprovechar su carne.");
	}

	@Override
	public void onItemSelected(AdapterView<?> adapter, View view, int position,
			long id) {
		// Recuperamos el nombre del animal.
		String name = names[position];
		// Recuperamos la descripci�n del animal.
		String description = descrip.get(name);

		// Establecemos el texto en el EditText para mostrarlo en pantalla.
		etDescrip.setText(description);

	}

	@Override
	public void onNothingSelected(AdapterView<?> adapter) {

	}

}
