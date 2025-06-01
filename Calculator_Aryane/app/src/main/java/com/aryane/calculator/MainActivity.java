package com.aryane.calculator; // pacote que define a minha aplicação
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // minhas variáveis de instância:
    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
            numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            ponto, soma, subtracao, multiplicacao, divisao, igual, porcentagem, botaoLimpar;

    private TextView txtExpressao, txtResultado;
    private ImageView botaoBackspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide(); // lig variáveis com os componentes view
        }

        // Set listeners
        setListeners(); // eventos
    }

    private void setListeners() { // aç de cada botão
        Button[] botoesNumericos = {
                numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
                numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto
        };

        for (Button botao : botoesNumericos) {
            botao.setOnClickListener(this); // detecta click
        }

        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        botaoLimpar.setOnClickListener(v -> {
            txtExpressao.setText("");
            txtResultado.setText("");
        });

        botaoBackspace.setOnClickListener(v -> {
            String expressao = txtExpressao.getText().toString();
            if (!expressao.isEmpty()) {
                txtExpressao.setText(expressao.substring(0, expressao.length() - 1));
            }
            txtResultado.setText("");
        });

        igual.setOnClickListener(v -> {
            try {
                Calculable expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                double resultado = expressao.calculate();
                long resultadoLong = (long) resultado;

                if (resultado == resultadoLong) {
                    txtResultado.setText(String.valueOf(resultadoLong));
                } else {
                    txtResultado.setText(String.valueOf(resultado));
                }
            } catch (Exception e) {
                txtResultado.setText("Erro");
            }
        });
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero); // busca e ligações
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
        porcentagem = findViewById(R.id.porcentagem);
        igual = findViewById(R.id.igual);
        botaoLimpar = findViewById(R.id.btn_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        botaoBackspace = findViewById(R.id.btn_backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limparDados) {
        if (txtResultado.getText().length() > 0) {
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
    public void onClick(View v) { // id de cada click
        int id = v.getId();

        if (id == R.id.numero_zero) {
            AcrescentarUmaExpressao("0", true);

        } else if (id == R.id.numero_um) {
            AcrescentarUmaExpressao("1", true);

        } else if (id == R.id.numero_dois) {
            AcrescentarUmaExpressao("2", true);

        } else if (id == R.id.numero_tres) {
            AcrescentarUmaExpressao("3", true);

        } else if (id == R.id.numero_quatro) {
            AcrescentarUmaExpressao("4", true);

        } else if (id == R.id.numero_cinco) {
            AcrescentarUmaExpressao("5", true);

        } else if (id == R.id.numero_seis) {
            AcrescentarUmaExpressao("6", true);

        } else if (id == R.id.numero_sete) {
            AcrescentarUmaExpressao("7", true);

        } else if (id == R.id.numero_oito) {
            AcrescentarUmaExpressao("8", true);

        } else if (id == R.id.numero_nove) {
            AcrescentarUmaExpressao("9", true);

        } else if (id == R.id.ponto) {
            AcrescentarUmaExpressao(".", true);

        } else if (id == R.id.soma) {
            AcrescentarUmaExpressao("+", false);

        } else if (id == R.id.subtracao) {
            AcrescentarUmaExpressao("-", false);

        } else if (id == R.id.multiplicacao) {
            AcrescentarUmaExpressao("*", false);

        } else if (id == R.id.divisao) {
            AcrescentarUmaExpressao("/", false);

        } else if (id == R.id.porcentagem) {
            AcrescentarUmaExpressao("/100" + "*", false);
        }

    }
}

