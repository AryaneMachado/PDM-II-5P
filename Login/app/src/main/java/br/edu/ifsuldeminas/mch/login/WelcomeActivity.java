package br.edu.ifsuldeminas.mch.login;

import android.app.ComponentCaller;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "br.edu.ifsuldeminas.mch.login.WelcomeActivity";

    private Intent resultIntent;

    private static final int PIC_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        Intent intentChamadora = getIntent();

        String userName = intentChamadora.getStringExtra("nome_usuario");

        String message = String.format("Bem-vindo %s", userName); // printando na tela

        View layout = findViewById(R.id.activity_welcome_id); // aproveitando layout activity welcome

        Snackbar snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_LONG);
        snackbar.show();

        Log.d(TAG, "WelcomeActivity.onCreate");

        Button takePic = findViewById(R.id.buttonFotoId);
        takePic.setOnClickListener(view -> {

            Intent intentTakePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intentTakePic, PIC_CODE);
        });

        resultIntent = new Intent();
        resultIntent.putExtra("retorno", "Não tirou a foto!");
        setResult(RESULT_OK, resultIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PIC_CODE && data != null && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();

            // Bundle bundle = data.getExtras();

            Bitmap img = (Bitmap) bundle.get("data");

            ImageView imageView = findViewById(R.id.imageViewId);
            imageView.setImageBitmap(img);

            resultIntent.putExtra("retorno", "Tirou a foto!");
        }
    }

    // delcarando métodos do ciclo de vida:

    @Override
    protected void onStart() { // iniciar
        super.onStart();

        Log.d(TAG, "WelcomeActivity.onStart");
    }

    @Override
    protected void onResume() { // exibir activity
        super.onResume();

        Log.d(TAG, "WelcomeActivity.onResume");
    }

    @Override
    protected void onStop() { // pausar, jogar no 2º plano
        super.onStop();

        Log.d(TAG, "WelcomeActivty.onStop");
    }

    @Override
    protected void onRestart() { // retomar
        super.onRestart();

        Log.d(TAG, "WelcomeActivity.onRestart");
    }

    @Override
    protected void onDestroy() { // voltar
        super.onDestroy();

        Log.d(TAG, "Welcome.onDestroy");
    }

    @Override
    public boolean onSupportNavigateUp() {

        getOnBackPressedDispatcher().onBackPressed();

        return true;
    }
}