package com.example.p7_sharedprefrences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	 /** En este ejemplo, no se hace nada en el método onCreate. 
		 * Todo lo que se hace se hace en la clase SettingsActivity.java y los preferences
		 * se agregan en el archivo configuracion_main_activity.xml de la carpeta res/xml.
		 * 
		 * Al correr la aplicación no les saldrá solamente una pantalla en blanco. Tendrán que presionar 
		 * la tecla de opciones o de menús, para que se habra el menú de la aplicación y tendrán que seleccionar
		 * la opcion Settings, y ahí es donde se les abrirá la activity de las Preference.
		 * 
		 * Si tienen alguna duda me la pueden hacer por correo electrónico o por facebook.
		 * En facebook me encuentra como Erick Martínez o la URL es fb.com/skapunk1010
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent i = new Intent(this,SettingsActivity.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
