package devandroid.israel.appcourselist.controller;

import android.content.SharedPreferences;

import devandroid.israel.appcourselist.model.Person;
import devandroid.israel.appcourselist.view.MainActivity;

public class PersonController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PersonController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void save(Person person) {
        listaVip.putString("firstName", person.getFirstName());
        listaVip.putString("lastName", person.getLastName());
        listaVip.putString("courseName", person.getCourseName());
        listaVip.putString("phone", person.getPhoneNumber());
        listaVip.apply();
    }

    public Person search(Person person) {
        person.setFirstName(preferences.getString("firstName", "NA"));
        person.setLastName(preferences.getString("lastName", "NA"));
        person.setCourseName(preferences.getString("courseName", "NA"));
        person.setPhoneNumber(preferences.getString("phone", "NA"));

        return person;
    }

    public void clear() {
        listaVip.clear();
        listaVip.apply();
    }
}
