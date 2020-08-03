package com.mohsin.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Welcone extends AppCompatActivity implements View.OnClickListener{


    public DatabaseReference d;
    public FirebaseAuth fa;
    public EditText data1,data2;
    Button save,logout;
    User u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcone);
        d= FirebaseDatabase.getInstance().getReference();
        fa=FirebaseAuth.getInstance();
        data1=findViewById(R.id.ed1);
        data2=findViewById(R.id.ed2);
        save=findViewById(R.id.save);
        logout=findViewById(R.id.welcome);
        save.setOnClickListener(this);

    }

    public void savedataconsole()
    {
        String s1=data1.getText().toString();
        String s2=data2.getText().toString();
        u1=new User(s1,s2);
        FirebaseUser fu=fa.getCurrentUser();
        d.child(fu.getUid()).setValue(u1);
        Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();


    }
    public void onClick(View v)
    {
        if(v==save)
        {
            savedataconsole();
        }
    }


}

