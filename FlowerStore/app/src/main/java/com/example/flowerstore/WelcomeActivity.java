package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeText;
    ImageView welcomeImage;
    Button checkItOutButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();

        checkItOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class  );
                startActivity(intent);

            }
        });

    }

    private void initViews(){
        welcomeText=findViewById(R.id.welcome_text);
        welcomeImage=findViewById(R.id.welcome_image);
        checkItOutButton=findViewById(R.id.welcome_button);
    }
}
