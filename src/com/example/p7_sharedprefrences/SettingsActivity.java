package com.example.p7_sharedprefrences;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.preference.SwitchPreference;

public class SettingsActivity extends PreferenceActivity implements OnPreferenceChangeListener{
	/*Definimos todos nuestros objetos a utilizar*/
	
	/*  Definiré los preferences como los definí en el archivo .xml*/
	private PreferenceCategory primerCategory;
	private CheckBoxPreference checkBox;
	private EditTextPreference editText;
	
	private PreferenceCategory segundaCategory;
	private RingtonePreference ringtone;
	private SwitchPreference switchPreference;
	private ListPreference list;

	private PreferenceCategory tercerCategory;
	private PreferenceScreen subScreen;
	private PreferenceCategory subCategory;
	private CheckBoxPreference nuevoCheckbox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.configuracion_main_activity);
		
		/** Igual que las otras clases, instanciamos cada elemento con cada objeto que definimos
		 * en nuestra clase. En este caso, usaremos otro metodo diferente pero muy parecido.
		 * el método es findPreference(key); . Key será la llave que le damos al definorlo en el xml.
		 * */
		/* Elementos del primer PreferenceCategory*/
		primerCategory 	= (PreferenceCategory) this.getPreferenceScreen().findPreference("primerCategory");
		checkBox 		= (CheckBoxPreference) this.getPreferenceScreen().findPreference("check");
		editText 		= (EditTextPreference) this.getPreferenceScreen().findPreference("edit");
		
		/* Elementos del segundo PreferenceCategory */
		segundaCategory 	= (PreferenceCategory) this.getPreferenceScreen().findPreference("segundoCategory");
		ringtone 			= (RingtonePreference) this.getPreferenceScreen().findPreference("ringtone");
		switchPreference	= (SwitchPreference) this.getPreferenceScreen().findPreference("switch");
		list				= (ListPreference) this.getPreferenceScreen().findPreference("list");
		
		/* Elementos del tercer PreferenceCategory */
		tercerCategory 		= (PreferenceCategory) this.getPreferenceScreen().findPreference("tercerCategory");
		subScreen 			= (PreferenceScreen) this.getPreferenceScreen().findPreference("subScreen");
		subCategory 		= (PreferenceCategory) subScreen.findPreference("categoryEnScreenNuevo");
		nuevoCheckbox		= (CheckBoxPreference) subScreen.findPreference("checkNuevo");
		
		/**
		 * En la línea donde declaramos la clase, hicimos un "implements OnPreferenceChangeListener":
		 * Ahora agregamos a cade elemento que deseamos agregar este evento. Este evento es básicamente 
		 * el que escuchará cuando un Preference cambie y ahí indicamos lo que desemos hacer. Yo únicamente
		 * haré que cuando alguno cambie, el valor que se inserte lo inserte en el cambo "Summary" , que es
		 * un pequeño campo abajo del título. Cuando se ejecute se comprenderá un poco mejor.
		 */
		
		checkBox.setOnPreferenceChangeListener(this);
		editText.setOnPreferenceChangeListener(this);
		
		ringtone.setOnPreferenceChangeListener(this);
		switchPreference.setOnPreferenceChangeListener(this);
		list.setOnPreferenceChangeListener(this);
		
		nuevoCheckbox.setOnPreferenceChangeListener(this);
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		preference.setSummary(newValue.toString());
		
		/* Con esta línea hacemos que el valor nuevo se guarde automáticamente. Si no se invocan a esos métodos
		 * el valor será temporal y cuando se salga no se guardará en las preferences.
		 */
		preference.getEditor().commit(); 
		return true;
	}

}
