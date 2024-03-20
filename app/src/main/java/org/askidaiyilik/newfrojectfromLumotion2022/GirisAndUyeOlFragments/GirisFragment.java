package org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.askidaiyilik.newfrojectfromLumotion2022.ForgotPasswordActivity;
import org.askidaiyilik.newfrojectfromLumotion2022.R;
import org.askidaiyilik.newfrojectfromLumotion2022.YardimIsteyenKisiActivity;

public class GirisFragment extends Fragment {

    private TextInputLayout ePosta , sifre;
    private Button girisYap;
    private TextView sifreUnuttum;

    private ProgressBar progressBarOfGirisId;

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.giris_login_fragment , container , false);
        //Initialize Views
        ePosta = view.findViewById(R.id.loginFragmnet_EpostaYadaTcId);
        sifre = view.findViewById(R.id.loginFragmnet_SifreId);
        girisYap = view.findViewById(R.id.loginFragmnet_GirisYapId);
        sifreUnuttum = view.findViewById(R.id.loginFragmnet_sifreUnuttumId);

        progressBarOfGirisId = view.findViewById(R.id.progressBarOfGirisId);

        mAuth = FirebaseAuth.getInstance();

        //Calling Of Sifre Unuttun Function
        sifreUnuttumFunc();

        //Animation For The Edit Text Function
        animationFunc();

        //Login To The Application
        loginToTheApp();



        return view;
    }

    private void loginToTheApp() {
        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ePosta.getEditText().getText().toString();
                String password = sifre.getEditText().getText().toString();

                if(email.isEmpty()) {
                    ePosta.getEditText().setError("Lütfen Email gir");
                    ePosta.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    ePosta.setError("Lütfen e-mail gir");
                    ePosta.requestFocus();
                    return;
                }
                if(password.isEmpty()) {
                    sifre.setError("Lütfen Şifre gir");
                    sifre.requestFocus();
                    return;
                }

                progressBarOfGirisId.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email , password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Intent intent = new Intent(getActivity() , YardimIsteyenKisiActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getContext() , "Uygulamaya hoş geldin" , Toast.LENGTH_SHORT).show();
                                    getActivity().finish();
                                    progressBarOfGirisId.setVisibility(View.GONE);
                                }
                                else {
                                    Toast.makeText(getContext() , "Giriş başarısız! Lütfen bilgilerini kontrol et" , Toast.LENGTH_SHORT).show();
                                    progressBarOfGirisId.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });
    }

    private void animationFunc() {
        ePosta.setTranslationX(800);
        sifre.setTranslationX(800);
        sifreUnuttum.setTranslationX(800);
        girisYap.setTranslationX(800);

        ePosta.setAlpha(0.0f);
        sifre.setAlpha(0.0f);
        sifreUnuttum.setAlpha(0.0f);
        girisYap.setAlpha(0.0f);

        ePosta.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        sifre.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        sifreUnuttum.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        girisYap.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

    }


    //Sifre Unuttun Function
    private void sifreUnuttumFunc() {
        sifreUnuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
