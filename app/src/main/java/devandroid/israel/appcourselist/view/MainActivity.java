package devandroid.israel.appcourselist.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.israel.appcourselist.R;
import devandroid.israel.appcourselist.model.Person;

public class MainActivity extends AppCompatActivity {

    Person person;
    Person otherPerson;

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

        person = new Person();
        otherPerson = new Person();

        person.setFirstName("Israel");
        person.setLastName("Nicolau");
        person.setCourseName("ADS");
        person.setPhoneNumber("11-995852141");

        otherPerson.setFirstName("Alves");
        otherPerson.setLastName("Lima");
        otherPerson.setCourseName("Android");
        otherPerson.setPhoneNumber("11-995852158");

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


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}