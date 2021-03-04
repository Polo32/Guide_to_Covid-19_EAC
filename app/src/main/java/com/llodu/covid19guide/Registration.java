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
import com.google.firebase.auth.FirebaseAuthException;

public class Registration extends AppCompatActivity {
    EditText regFulname, regEmail, regPswd, regphone;
    TextView signIn;
    Button buttonbak, btnregLogin;
    ProgressDialog dialog;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regFulname =findViewById(R.id.edtFname);
        regEmail   =findViewById(R.id.edtregEmail);
        regPswd    = findViewById(R.id.edtregpswd);
        regphone   = findViewById(R.id.edtregphone);
        signIn     = findViewById(R.id.reg2Login);
        btnregLogin= findViewById(R.id.regSignIn);
       // buttonbak= findViewById(R.id.btn_bakreg);
        fAuth= FirebaseAuth.getInstance();
        dialog= new ProgressDialog(this);
        dialog.setTitle("Registering");
        dialog.setMessage("please wait...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        btnregLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),Listview.class));
              /*  String email, password;
                email= regEmail.getText().toString().trim();
                password= regPswd.getText().toString().trim();

                if (email.isEmpty()){
                    regEmail.setError("please enter Email");
                }
                else if (password.isEmpty()){
                    regPswd.setError("please enter password");
                }
                else if (regPswd.length()<6){
                    regPswd.setError("password must be 6 or more characters");
                }
                else{
                    dialog.show();
                    fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(Registration.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Listview.class));
                            } else
                            {
                                Toast.makeText(Registration.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                */
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
       /* buttonbak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,Listview.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}