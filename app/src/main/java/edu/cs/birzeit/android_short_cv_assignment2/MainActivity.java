package edu.cs.birzeit.android_short_cv_assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import edu.cs.birzeit.android_short_cv_assignment2.Models.POJO.CV_Content;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText FullName, Email, Objective, PhoneNumber;
    Button Next;
    RadioButton MaleRB;
    RadioButton FemaleRB;
    Spinner spinner;
    String SpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullName = findViewById(R.id.full_name);
        Email = findViewById(R.id.email);
        Objective = findViewById(R.id.objective);
        PhoneNumber = findViewById(R.id.phone_number);
        MaleRB = findViewById(R.id.rb_male);
        FemaleRB = findViewById(R.id.rb_female);
        spinner = findViewById(R.id.spinner);
        Next = findViewById(R.id.next);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                if (SpinnerValue.equals("Country")) {
                    SpinnerValue = "";
                }
                Intent displayDataIntent = new Intent(MainActivity.this, CVActivity2.class);
                displayDataIntent.putExtra("full_name", FullName.getText().toString());
                displayDataIntent.putExtra("email", Email.getText().toString());
                displayDataIntent.putExtra("phone", PhoneNumber.getText().toString());
                displayDataIntent.putExtra("objective", Objective.getText().toString());


                if (MaleRB.isChecked()) {
                    displayDataIntent.putExtra("gender", MaleRB.getText().toString());

                } else if (FemaleRB.isChecked()) {
                    displayDataIntent.putExtra("gender", FemaleRB.getText().toString());
                }
                displayDataIntent.putExtra("country", SpinnerValue);

                startActivity(displayDataIntent);

            }
        });


        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV_Content cv = gson.fromJson(str, CV_Content.class);
            if (str.trim().length() != 0) {
                FullName.setText(cv.getFullName());
                Email.setText(cv.getEmail());
                PhoneNumber.setText(cv.getPhoneNumber());
                Objective.setText(cv.getObjective());

                System.out.println(cv.getGender().toLowerCase());
                System.out.println("here");

                if (cv.getGender().toLowerCase().equals("male")) {
                    MaleRB.setChecked(true);
                }
                else if (cv.getGender().toLowerCase().equals("female")) {
                    FemaleRB.setChecked(true);
                }
                for(int i=0;i<6;i++) {
                    if (cv.getCountry().equals(spinner.getItemAtPosition(i).toString())) {
                        spinner.setSelection(i);
                        break;
                    }
                }
//                Gender.set;
//                spinner.settex;
            }
        } catch (Exception e) {
            System.out.println();
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        SpinnerValue = spinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
