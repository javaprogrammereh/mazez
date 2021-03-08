package com.example.maze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maze.model.SharedPreferencesManager;
import com.example.maze.model.userApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class signup extends AppCompatActivity {

    userApp user = new userApp();

    /*create object for xml*/
    private Button btnSingUp;
    private EditText edtUName, edtPasword, edtEmail, edtPhone;
    TextView txtGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /* Get object from xml file*/
        btnSingUp = findViewById(R.id.ok_sing_up);
        edtUName = findViewById(R.id.edtunamesingup);
        edtPasword = findViewById(R.id.edtpnamesingup);
        edtEmail = findViewById(R.id.edtemailsingup);
        edtPhone = findViewById(R.id.edtphonesingup);
        txtGoToLogin = findViewById(R.id.txtgotologin);

        /*1.text click to go login page*/
        txtGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, login.class));
                signup.this.finish();
            }
        });

        /*3.click buttton to singup and save vlue user write*/
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*2.set true first time to SharedPreferences*/
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getApplicationContext());
                user = sharedPreferencesManager.get_shared_preferences();
                user.setFirst_time_run(true);
                sharedPreferencesManager.set_false_first_time(user);

                /*4.get value user write to edit text*/
                String userName = edtUName.getText().toString();
                String password = edtPasword.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                /*5.check edit text is empty or no*/
                if (!userName.equals("") && !password.equals("") && isEmailValid(email)==true && !phone.equals("")) {

                    /*6.Save UserName with SharedPreferences*/
                    SharedPreferences userDetails = getApplicationContext().getSharedPreferences("User", MODE_PRIVATE);
                    SharedPreferences.Editor edit = userDetails.edit();
                    edit.putString(userName, userName);
                    edit.putString(password, password);
                    edit.apply();

                    SharedPreferences userDetails2 = getApplicationContext().getSharedPreferences("TITLE", MODE_PRIVATE);
                    SharedPreferences.Editor edit2 = userDetails2.edit();
                    edit2.putString("title", userName);
                    edit2.apply();

                    /*7.open main activity*/
                    startActivity(new Intent(signup.this, MainActivity.class));
                    signup.this.finish();

                    /*8.set false More than once to SharedPreferences*/
                    user.setFirst_time_run(false);
                    sharedPreferencesManager.set_false_first_time(user);
                }
                else {
                    if (!isEmailValid(email)==true) {
                        Toast.makeText(getApplicationContext(), "الگوی ایمیل اشتباه است! ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(signup.this, "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    /*method to return email is valid or no*/
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    //======================change font===============================
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }
}
