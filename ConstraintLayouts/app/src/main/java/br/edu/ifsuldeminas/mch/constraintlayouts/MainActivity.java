package br.edu.ifsuldeminas.mch.constraintlayouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonBlogPost;

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