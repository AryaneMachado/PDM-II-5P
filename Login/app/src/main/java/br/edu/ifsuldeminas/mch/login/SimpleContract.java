package br.edu.ifsuldeminas.mch.login;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimpleContract extends ActivityResultContract<String, String> {

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String userName) {

        Intent bemVindo = new Intent(context, WelcomeActivity.class);

        bemVindo.putExtra("nome_usuario", userName);

        return bemVindo;
    }

    @Override
    public String parseResult(int resultCode, @Nullable Intent resultIntent) {
         if ((resultCode == MainActivity.RESULT_OK) && resultIntent != null) {
                resultIntent.getStringExtra("retorno");
         }

        return "";
    }




}
