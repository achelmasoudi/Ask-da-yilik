package org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.askidaiyilik.newfrojectfromLumotion2022.R;

import model.User;

public class UyeOlFragment extends Fragment {

    private TextInputLayout adSoyad , email , tcKimlik , telefonNum , sosyalYarNum , sifre;
    private Button uyeOl;

    private ProgressBar progressBarOfUyeOlId;

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.uye_ol_register_fragment , container , false);

        adSoyad = view.findViewById(R.id.RegisterFragment_AdSoyadId);
        email = view.findViewById(R.id.RegisterFragment_EpostaId);
        tcKimlik = view.findViewById(R.id.RegisterFragment_TCkimlikId);
        telefonNum = view.findViewById(R.id.RegisterFragment_telefonNoId);
        sosyalYarNum = view.findViewById(R.id.RegisterFragment_SosyalYardimNoId);
        sifre = view.findViewById(R.id.RegisterFragment_SifregirId);

        progressBarOfUyeOlId = view.findViewById(R.id.progressBarOfUyeOlId);

        uyeOl = view.findViewById(R.id.RegisterFragment_UyeOlId);

        mAuth = FirebaseAuth.getInstance();

        //UyeOl Button Listener Func
        uyeOlButtonFunc();
        
        return view;
    }

    private void uyeOlButtonFunc() {

        uyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String benimadSoyad = adSoyad.getEditText().getText().toString();
                String benimemail = email.getEditText().getText().toString();
                String benimtcKimlik = tcKimlik.getEditText().getText().toString();
                String benimtelefonNum = telefonNum.getEditText().getText().toString();
                String benimsosyalYarNum = sosyalYarNum.getEditText().getText().toString();
                String benimsifre = sifre.getEditText().getText().toString();

                if(benimadSoyad.isEmpty()) {
                    adSoyad.getEditText().setError("Lütfen ad-soyad gir");
                    adSoyad.requestFocus();
                    return;
                }
                if(benimemail.isEmpty()) {
                    email.getEditText().setError("Lütfen e-mail gir");
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(benimemail).matches()) {
                    email.getEditText().setError("Lütfen geçerli bir e-mail gir");
                    return;
                }
                if(benimtcKimlik.isEmpty()) {
                    tcKimlik.getEditText().setError("Lütfen TcKimlik gir");
                    tcKimlik.requestFocus();
                    return;
                }
                if(benimtelefonNum.isEmpty()) {
                    telefonNum.getEditText().setError("Lütfen telefon-no gir");
                    telefonNum.requestFocus();
                    return;
                }
                if(benimsosyalYarNum.isEmpty()) {
                    sosyalYarNum.getEditText().setError("Lütfen sosyal-no gir");
                    sosyalYarNum.requestFocus();
                    return;
                }
                if(benimsifre.isEmpty()) {
                    sifre.getEditText().setError("Lütfen şifre   gir");
                    sifre.requestFocus();
                    return;
                }


                progressBarOfUyeOlId.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(benimemail , benimsifre)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    User user = new User(benimadSoyad , benimemail , benimsifre , benimtcKimlik , benimsosyalYarNum);
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                Toast.makeText(getContext() , "Kullanıcı başarıyla kaydedildi !" , Toast.LENGTH_SHORT).show();
                                                progressBarOfUyeOlId.setVisibility(View.GONE);
                                            }
                                            else {
                                                Toast.makeText(getContext() , "Kayıt başarısız! Tekrar dene" , Toast.LENGTH_SHORT).show();
                                                progressBarOfUyeOlId.setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                }
                                else {
                                    Toast.makeText(getContext() , "Kayıt başarısız! Tekrar dene" , Toast.LENGTH_SHORT).show();
                                    progressBarOfUyeOlId.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });

    }

}
