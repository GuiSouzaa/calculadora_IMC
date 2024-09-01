package br.com.aula.text;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularImc(View view){
        TextInputEditText campoNome = findViewById(R.id.textinputNome);
        TextInputEditText campoPeso = findViewById(R.id.textinputPeso);
        TextInputEditText campoAltura = findViewById(R.id.textEditAltura);

        TextView resultado = findViewById(R.id.textResultado2);
        TextView resultado2 = findViewById(R.id.textResultado3);

        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();

        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numImc = numPeso / (numAltura * numAltura);

        DecimalFormat df = new DecimalFormat("##.##");
        String imc = df.format(numImc);

        // Determinar a classificação do IMC
        String classificacao;

        if (numImc < 17) {
            classificacao = "Muito abaixo do peso";
        } else if (numImc >= 17 && numImc <= 18.4) {
            classificacao = "Abaixo do peso";
        } else if (numImc >= 18.5 && numImc <= 24.9) {
            classificacao = "Peso normal";
        } else if (numImc >= 25 && numImc <= 29.9) {
            classificacao = "Acima do peso";
        } else if (numImc >= 30 && numImc <= 34.9) {
            classificacao = "Obesidade Grau I";
        } else if (numImc >= 35 && numImc <= 40) {
            classificacao = "Obesidade Grau II";
        } else {
            classificacao = "Obesidade Grau III";
        }

        // Exibir o resultado e a classificação
        resultado.setText("IMC: " + imc);
        resultado2.setText("Classificação: " + classificacao);
    }

    public void limpaDados(View view){
        // Adicionar lógica para limpar os campos de entrada
    }
}