package com.aryane.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
            numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView botao_backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        // Setando os listeners para os botões numéricos e operadores
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(v -> {
            txtExpressao.setText("");
            txtResultado.setText("");
        });

        botao_backspace.setOnClickListener(v -> {
            String string = txtExpressao.getText().toString();
            if (!string.isEmpty()) {
                String novaExpressao = string.substring(0, string.length() - 1);
                txtExpressao.setText(novaExpressao);
            }
            txtResultado.setText("");
        });

        igual.setOnClickListener(v -> {
            try {
                Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                double resultado = expressao.evaluate();
                long longResult = (long) resultado;

                if (resultado == (double) longResult) {
                    txtResultado.setText(String.valueOf(longResult));
                } else {
                    txtResultado.setText(String.valueOf(resultado));
                }
            } catch (Exception e) {
                txtResultado.setText("Erro");
            }
        });
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.btn_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        botao_backspace = findViewById(R.id.btn_backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limparDados) {
        if (txtResultado.getText().toString().equals("")) {
            txtExpressao.setText("");
        }

        if (limparDados) {
            txtResultado.setText("");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0", true);
                break;
            case R.id.numero_um:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.numero_dois:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.numero_tres:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.numero_seis:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.numero_sete:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.numero_oito:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.numero_nove:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;
            case R.id.soma:
                AcrescentarUmaExpressao("+", false);
                break;
            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;
            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;
            case R.id.divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}
