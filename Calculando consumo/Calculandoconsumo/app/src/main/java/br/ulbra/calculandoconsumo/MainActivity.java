package br.ulbra.calculandoconsumo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputPower, inputHours, inputPrice;
    TextView resultText;
    Button calculateButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos elementos de UI
        inputPower = findViewById(R.id.editPotenc);
        inputHours = findViewById(R.id.editTemp);
        inputPrice = findViewById(R.id.editPreco);
        resultText = findViewById(R.id.txtResult);
        calculateButton = findViewById(R.id.btnCalc);

        // Ação para o botão de cálculo
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os valores inseridos pelo usuário
                String powerStr = inputPower.getText().toString();
                String hoursStr = inputHours.getText().toString();
                String priceStr = inputPrice.getText().toString();

                if (!powerStr.isEmpty() && !hoursStr.isEmpty() && !priceStr.isEmpty()) {
                    // Converter os valores para double
                    double power = Double.parseDouble(powerStr);
                    double hours = Double.parseDouble(hoursStr);
                    double pricePerKWh = Double.parseDouble(priceStr);

                    // Calcular o consumo de energia (kWh)
                    double energyConsumption = (power * hours) / 1000;

                    // Calcular o custo da energia
                    double totalCost = energyConsumption * pricePerKWh;

                    // Exibir os resultados
                    resultText.setText(String.format("Consumo de Energia: %.2f kWh\nCusto Total: R$ %.2f", energyConsumption, totalCost));
                } else {
                    // Exibir mensagem de erro
                    resultText.setText("Por favor, preencha todos os campos corretamente.");
                }
            }
        });
    }
}