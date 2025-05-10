package br.edu.ifsuldeminas.mch.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String USER = "aryane";
    private static final String PW = "123";

    private static final String TAG = "br.edu.ifsuldeminas.mch.login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SAM
        Button buttonLogar = findViewById(R.id.buttonUserLoginId);
        buttonLogar.setOnClickListener(view -> {

            EditText editTextUsuario = findViewById(R.id.editTextUserLoginId);
            EditText editTextSenha = findViewById(R.id.editTextUserPWId);

            String usuario = editTextUsuario.getText().toString();
            String senha = editTextSenha.getText().toString();

            if (USER.equals(usuario) && PW.equals(senha)) {

                //Toast toast = Toast.makeText(this,
                        //"Usuário logado com sucesso",
                        //Toast.LENGTH_LONG);

                //toast.show();

                Intent welcomeIntent = new Intent(getApplicationContext(), WelcomeActivity.class); // fazendo pedido com Intent

                welcomeIntent.putExtra("nome_usuario", usuario);

                startActivity(welcomeIntent);


            } else {
                Toast toast = Toast.makeText(this,
                        "Usuário ou senha incorretos!",
                        Toast.LENGTH_LONG);

                toast.show();
            }
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