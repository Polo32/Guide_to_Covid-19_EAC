package com.llodu.covid19guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordReset extends AppCompatActivity {
   EditText resetEmail;
   Button btnreset;
   FirebaseAuth fresetAuth;
   ProgressDialog rst_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        resetEmail = findViewById(R.id.rstemail);
        btnreset =findViewById(R.id.btn_rst);

        fresetAuth= FirebaseAuth.getInstance();
        rst_dialog= new ProgressDialog(this);
        rst_dialog.setTitle("Registering");
        rst_dialog.setMessage("please wait...");
        rst_dialog.setCancelable(false);
        rst_dialog.setCanceledOnTouchOutside(false);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                email =resetEmail.getText().toString().trim();
                if(email.isEmpty() ){

                    resetEmail.setError("Please enter an email");
                }
                else {
                    rst_dialog.show();
                    fresetAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            rst_dialog.dismiss();
                            if (task.isSuccessful()){
                            Toast.makeText(PasswordReset.this,"password reset sent to your email to"+email,Toast.LENGTH_SHORT).show();
                            } else
                            {
                                Toast.makeText(PasswordReset.this,"Password Reset failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}