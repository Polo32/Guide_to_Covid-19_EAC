package com.llodu.covid19guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button btn_back, mloginmain;
    EditText medtemail, medtpassword;
    TextView mtxtSignup, mtxtforgotpsswd;
   FirebaseAuth fbAuth;
   ProgressDialog dialogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        medtemail= findViewById(R.id.edt_emaillogin);
        medtpassword= findViewById(R.id.edt_psswdlogin);
        mtxtforgotpsswd = findViewById(R.id.txt_forgotpsswd);
        mtxtSignup= findViewById(R.id.txt_gotoSignup);
        mloginmain= findViewById(R.id.btn_mainlogin);
        //btn_back=findViewById(R.id.btn_bk);

        fbAuth= FirebaseAuth.getInstance();
        dialogin= new ProgressDialog(this);
        dialogin.setTitle("Registering");
        dialogin.setMessage("please wait...");
        dialogin.setCancelable(false);
        dialogin.setCanceledOnTouchOutside(false);

        FirebaseUser user= fbAuth.getCurrentUser();
        if (user!=null){
            finish();
           startActivity(new Intent(getApplicationContext(),Listview.class));
        }
        mloginmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Listview.class));

             /*  String email, password;
                email= medtemail.getText().toString().trim();
                password= medtpassword.getText().toString().trim();

                if (email.isEmpty()){
                    medtemail.setError("please enter Email");
                }
                else if (password.isEmpty()){
                    medtpassword.setError("please enter password");
                }
                else if (medtpassword.length()<6){
                    medtpassword.setError("password must be 6 or more characters");
                }
                else{
                    dialogin.show();
                    fbAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialogin.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(Login.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Listview.class));
                            } else
                            {
                                Toast.makeText(Login.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                */
            }
        });

        mtxtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });
        mtxtforgotpsswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PasswordReset.class));
            }
        });
        mtxtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
                finish();
            }
        });
        /* btn_ba8ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this, Listview.class);
                startActivity(intent);
                finish();
            }
        }
        );*/
    }
}