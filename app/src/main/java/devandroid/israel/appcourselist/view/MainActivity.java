package devandroid.israel.appcourselist.view;

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

    Person person;
    Person otherPerson;
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

        person = new Person();
        otherPerson = new Person();
        personController = new PersonController();

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

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFirstName.setText("");
                etLastname.setText("");
                etCourseName.setText("");
                etPhone.setText("");
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