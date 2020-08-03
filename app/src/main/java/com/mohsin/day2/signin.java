package com.mohsin.day2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    EditText emailid,pass;
    Button login;
    FirebaseAuth f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        emailid=findViewById(R.id.edit1);
        pass=findViewById(R.id.edit2);
        login=findViewById(R.id.login);
        f=FirebaseAuth.getInstance();
    }
    public void calllogin(View v)
    {
        String email,password;
        email=emailid.getText().toString();
        password=pass.getText().toString();
        f.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {

                if(f.getCurrentUser().isEmailVerified())
                {
                    startActivity(new Intent(signin.this, Welcone.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please verify emial", Toast.LENGTH_LONG).show();
                }
            }
                else
                {
                   Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
