package edu.cs.birzeit.android_short_cv_assignment2;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.cs.birzeit.android_short_cv_assignment2.Models.POJO.CV_Content;
import com.google.gson.Gson;

public class CVActivity2 extends AppCompatActivity {
    EditText Education,Experience,Projects,Skills;
    Button Finish;

    public static final String Shared_Prefs= "sharedPrefs" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv2);

        Education = findViewById(R.id.education);
        Experience = findViewById(R.id.work);
        Projects = findViewById(R.id.projects);
        Skills = findViewById(R.id.skills);
        Finish = (Button) findViewById(R.id.finish);
        Toast toast = new Toast(this);



        Intent intent = getIntent();

        String fullName =  intent.getStringExtra("full_name");
        String phone =  intent.getStringExtra("phone");
        String email =  intent.getStringExtra("email");
        String objective =  intent.getStringExtra("objective");
        String gender =  intent.getStringExtra("gender");
        String country =  intent.getStringExtra("country");



        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV_Content cv = gson.fromJson(str, CV_Content.class);
            if (str.trim().length() != 0) {
                Education.setText(cv.getEducation());
                Experience.setText(cv.getExperience());
                Projects.setText(cv.getProjects());
                Skills.setText(cv.getSkills());
            }

        } catch (Exception e) {
            System.out.println();
        }


        Finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                CV_Content cv = new CV_Content(fullName,email,phone,objective,gender,country,Education.getText().toString(),Experience.getText().toString(),Projects.getText().toString(),Skills.getText().toString());

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CVActivity2.this);
                SharedPreferences.Editor editor = prefs.edit();
                Gson gson = new Gson();
                String cvString = gson.toJson(cv);


                editor.putString("cv", cvString);


                editor.commit();
                Toast.makeText(CVActivity2.this, "Data Saved:\n" + cvString,Toast.LENGTH_SHORT).show();


                System.out.println(cvString);
                Log.d("object", cvString);

            }
        });

        }
}