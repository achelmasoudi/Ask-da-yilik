package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments.GirisFragment;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout editTextEmail;
    private Button gonder;
    private FirebaseAuth auth;
    private ProgressBar progressBarOfForgotPassId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail = findViewById(R.id.ForgotPasswordEpostaGirId);
        gonder = findViewById(R.id.ForgotPasswordSendButtonId);

        progressBarOfForgotPassId = findViewById(R.id.progressBarOfForgotPassId);

        //Initialize auth Variable for FirebaseAuth
        auth = FirebaseAuth.getInstance();

        gonder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = editTextEmail.getEditText().getText().toString();

        if(email.isEmpty()) {
            editTextEmail.setError("Lütfen e-mail gir");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Lütfen geçerli bir e-mail gir");
            editTextEmail.requestFocus();
            return;
        }

        progressBarOfForgotPassId.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this , "Şifreni sıfırlamak için e-mailini kontrol et" , Toast.LENGTH_SHORT).show();
                    progressBarOfForgotPassId.setVisibility(View.GONE);
                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this , "Tekrar dene, yanlış bir şey oldu !" , Toast.LENGTH_SHORT).show();
                    progressBarOfForgotPassId.setVisibility(View.GONE);
                }
            }
        });

    }
}