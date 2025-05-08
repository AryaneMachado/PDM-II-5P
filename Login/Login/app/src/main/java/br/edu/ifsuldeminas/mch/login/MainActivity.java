package br.edu.ifsuldeminas.mch.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SAM
        Button buttonLogar = findViewById(R.id.buttonUserLoginId);
        buttonLogar.setOnClickListener(view -> {
            Toast toast = Toast.makeText(this,
                    "Botão logar clicado",
                    Toast.LENGTH_LONG);

            toast.show();
        });

        ButtonRegisterClick buttonRegisterClick = new ButtonRegisterClick(this);
        Button buttonRegister = findViewById(R.id.buttonMainUserRegisterId);
        buttonRegister.setOnClickListener(buttonRegisterClick);
    }

    public void forgotPWClick(View view) {
        Toast.makeText(this,
                "Botão logar esqueci a senha clicado",
                Toast.LENGTH_SHORT).show();
    }
}