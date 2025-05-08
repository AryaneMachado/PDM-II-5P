package br.edu.ifsuldeminas.mch.login;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ButtonRegisterClick implements View.OnClickListener {

    private Context context;

    public ButtonRegisterClick(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Botão de Cadastrar clicado",
                Toast.LENGTH_LONG).show();
    }
}
