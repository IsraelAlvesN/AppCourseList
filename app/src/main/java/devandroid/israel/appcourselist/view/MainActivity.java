package devandroid.israel.appcourselist.view;

import android.os.Bundle;
import android.util.Log;

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

        Log.i("AndroidPessoa", person.toString());
        Log.i("AndroidPessoa", otherPerson.toString());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}