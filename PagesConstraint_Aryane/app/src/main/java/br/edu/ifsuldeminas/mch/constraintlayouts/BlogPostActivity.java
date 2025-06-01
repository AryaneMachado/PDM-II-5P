package br.edu.ifsuldeminas.mch.constraintlayouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BlogPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_post);

        // Encontrar o botão "Anterior" pelo id

        Button buttonAnterior = findViewById(R.id.buttonAcaoAnterior);

        // Definir o clique para redirecionar para a Página Inicial

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BlogPostActivity.this, MainActivity.class);
                startActivity(intent);

                // Metodo para fechar essa activity para não voltar ao clicar no botão "Anterior":

                finish();
            }
        });
    }
}
