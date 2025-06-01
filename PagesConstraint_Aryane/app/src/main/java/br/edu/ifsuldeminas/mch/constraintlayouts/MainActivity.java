package br.edu.ifsuldeminas.mch.constraintlayouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonBlogPost;
    private Button buttonSerie;
    private Button buttonTextosConcursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link botão Blog Post

        buttonBlogPost = findViewById(R.id.buttonCL1);
        buttonBlogPost.setOnClickListener(v -> {
            Intent intentBlogPost = new Intent(getApplicationContext(),
                    BlogPostActivity.class);
            startActivity(intentBlogPost);
        });

        // Link botão Séries

        buttonSerie = findViewById(R.id.buttonCL2);
        buttonSerie.setOnClickListener(v -> {
            Intent intentSerie = new Intent(getApplicationContext(),
                    SeriesActivity.class);
            startActivity(intentSerie);
        });

        // Link botão Concurso Textos

        buttonTextosConcursos = findViewById(R.id.buttonCL3);
        buttonTextosConcursos.setOnClickListener(v -> {
            Intent intentConcurso = new Intent(getApplicationContext(),
                    TextosConcursoActivity.class);
            startActivity(intentConcurso);
        });
    }
}
