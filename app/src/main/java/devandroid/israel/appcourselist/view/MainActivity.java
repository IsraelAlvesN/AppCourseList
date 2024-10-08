package devandroid.israel.appcourselist.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import devandroid.israel.appcourselist.R;
import devandroid.israel.appcourselist.controller.CourseController;
import devandroid.israel.appcourselist.controller.PersonController;
import devandroid.israel.appcourselist.model.Person;

public class MainActivity extends AppCompatActivity {

    Person person;
    List<String> courseNames;

    PersonController personController;
    CourseController courseController;

    EditText etFirstName;
    EditText etLastname;
    EditText etCourseName;
    EditText etPhone;
    Button btClear;
    Button btSave;
    Button btSubmit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        person = new Person();
        personController = new PersonController(MainActivity.this);
        personController.search(person);

        courseController = new CourseController();
        courseNames = courseController.dataToSpinner();

        etFirstName = findViewById(R.id.ptFirstName);
        etLastname = findViewById(R.id.ptLastname);
        etCourseName = findViewById(R.id.ptCourseName);
        etPhone = findViewById(R.id.phPhone);
        btClear = findViewById(R.id.btClear);
        btSave = findViewById(R.id.btSave);
        btSubmit = findViewById(R.id.btSubmit);
        spinner = findViewById(R.id.spinner);

        etFirstName.setText(person.getFirstName());
        etLastname.setText(person.getLastName());
        etCourseName.setText(person.getCourseName());
        etPhone.setText(person.getPhoneNumber());

        //Adapter
        //Layout
        //Injetar adapter ao Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseController.dataToSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFirstName.setText("");
                etLastname.setText("");
                etCourseName.setText("");
                etPhone.setText("");

                personController.clear();
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

                personController.save(person);
                Toast.makeText(MainActivity.this, "Salvo" + person.toString(), Toast.LENGTH_LONG).show();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}