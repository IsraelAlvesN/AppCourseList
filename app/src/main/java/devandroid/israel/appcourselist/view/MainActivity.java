package devandroid.israel.appcourselist.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.israel.appcourselist.R;
import devandroid.israel.appcourselist.controller.PersonController;
import devandroid.israel.appcourselist.model.Person;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    Person person;
    PersonController personController;

    EditText etFirstName;
    EditText etLastname;
    EditText etCourseName;
    EditText etPhone;
    Button btClear;
    Button btSave;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        person = new Person();
        personController = new PersonController();

        person.setFirstName(preferences.getString("firstName", ""));
        person.setLastName(preferences.getString("lastName", ""));
        person.setCourseName(preferences.getString("courseName", ""));
        person.setPhoneNumber(preferences.getString("phone", ""));

        etFirstName = findViewById(R.id.ptFirstName);
        etLastname = findViewById(R.id.ptLastname);
        etCourseName = findViewById(R.id.ptCourseName);
        etPhone = findViewById(R.id.phPhone);
        btClear = findViewById(R.id.btClear);
        btSave = findViewById(R.id.btSave);
        btSubmit = findViewById(R.id.btSubmit);

        etFirstName.setText(person.getFirstName());
        etLastname.setText(person.getLastName());
        etCourseName.setText(person.getCourseName());
        etPhone.setText(person.getPhoneNumber());

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFirstName.setText("");
                etLastname.setText("");
                etCourseName.setText("");
                etPhone.setText("");

                listaVip.clear();
                listaVip.apply();
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Até mais", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setFirstName(etFirstName.getText().toString());
                person.setLastName(etLastname.getText().toString());
                person.setCourseName(etCourseName.getText().toString());
                person.setPhoneNumber(etPhone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + person.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("firstName", person.getFirstName());
                listaVip.putString("lastName", person.getLastName());
                listaVip.putString("courseName", person.getCourseName());
                listaVip.putString("phone", person.getPhoneNumber());
                listaVip.apply();

                personController.save(person);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}