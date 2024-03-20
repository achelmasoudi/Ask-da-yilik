package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView fromLum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splashScreenImageId);
        fromLum = findViewById(R.id.fromLumotionId);

        fromLum.setTranslationY(300);
        fromLum.setAlpha(0.0f);
        fromLum.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(30).start();


        Animation animation = AnimationUtils.loadAnimation(SplashScreenActivity.this , R.anim.splash_screen_image_animation);
        imageView.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1600);

    }
}