package com.canerkaya.instaclonefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SıgnActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    EditText mailText,passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        firebaseAuth=FirebaseAuth.getInstance();
        mailText=findViewById(R.id.mailText);
        passwordText=findViewById(R.id.passwordText);
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            Intent intent=new Intent(SıgnActivity.this,FeedActivity.class);
            finish();
            startActivity(intent);
        }

    }
    public void signUpClick(View view){
        String mail=mailText.getText().toString();
        String password=passwordText.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SıgnActivity.this,"Kayıt Başarılı!",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SıgnActivity.this,FeedActivity.class);
                finish();
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SıgnActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void sıgnInClick(View view){
        String mail=mailText.getText().toString();
        String password=passwordText.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(mail,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent=new Intent(SıgnActivity.this,FeedActivity.class);
                finish();
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SıgnActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
