package br.edu.ifsuldeminas.mch.constraintlayouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBlogPost = findViewById(R.id.buttonCL1);
        buttonBlogPost.setOnClickListener(v -> {
            Intent intentBlogPost = new Intent(getApplicationContext(),
                    BlogPostActivity.class);

            startActivity(intentBlogPost);
        });

    }

}