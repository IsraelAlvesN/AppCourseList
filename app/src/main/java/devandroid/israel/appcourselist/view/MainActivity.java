package devandroid.israel.appcourselist.view;

import android.os.Bundle;

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

        String personData;
        personData = "Primeiro nome: ";
        personData += person.getFirstName();
        personData += " Sobrenome: ";
        personData += person.getLastName();
        personData += " Curso desejado: ";
        personData += person.getCourseName();
        personData += " Telefone: ";
        personData += person.getPhoneNumber();

        String otherPersonData;
        otherPersonData = "Primeiro nome: ";
        otherPersonData += otherPerson.getFirstName();
        otherPersonData += " Sobrenome: ";
        otherPersonData += otherPerson.getLastName();
        otherPersonData += " Curso desejado: ";
        otherPersonData += otherPerson.getCourseName();
        otherPersonData += " Telefone: ";
        otherPersonData += otherPerson.getPhoneNumber();

        int parada = 0;



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}