package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RLR_Activity extends AppCompatActivity {
    private TextInputEditText anguloUm,valorXUsuario,valorYUsuario, anguloDois, anguloTres, anguloGama, juntaUm, juntaDois, juntaTres,anguloDoisTetaNovo,anguloUmTetaNovo;
    private TextView ResultadoX, ResultadoY, ResultadoA1, ResultadoD, ResultadoGama, ResultadoA3, EquacaoDireta, EquacaoInversa;
    private double x, y, a1, d, a3, gama;
    ImageButton buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlr);

        buttonInfo = findViewById(R.id.imageButtonRLRInfor);
        anguloUm = findViewById(R.id.anguloUmRLR);
        anguloDois =findViewById(R.id.anguloDoisRLR);
        anguloGama = findViewById(R.id.anguloGamaRLR);
        juntaUm = findViewById(R.id.juntaUmRLR);
        juntaDois = findViewById(R.id.juntaDoisRLR);
        EquacaoDireta = findViewById(R.id.equacaoDiretaRLR);
        EquacaoInversa = findViewById(R.id.equacaoInversaRLR);
        ResultadoX = findViewById(R.id.valorXRLR);
        ResultadoY = findViewById(R.id.valorYRLR);


        anguloGama = findViewById(R.id.anguloGamaRLR);
        valorXUsuario = findViewById(R.id.valorXUsuarioRLR);
        valorYUsuario = findViewById(R.id.valorYUsuarioRLR);
        ResultadoA1 = findViewById(R.id.valorA1RLR);
        ResultadoA3 = findViewById(R.id.valorA3RLR);
        ResultadoGama = findViewById(R.id.valorGamaRLR);
        ResultadoD = findViewById(R.id.valorDRLR);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Informacoes_RLR.class);
                startActivity(intent);

            }
        });
    }
    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());
        //Double valorAnguloGama = Double.parseDouble(anguloGama.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = valorJuntaum * Math.cos(valorAnguloUm) + valorJuntaDois*Math.cos(valorAnguloUm + valorAnguloDois);
            y =  valorJuntaum * Math.sin(valorAnguloUm) + valorJuntaDois*Math.sin(valorAnguloUm + valorAnguloDois);

            //
            //
            //

            String valorX = Double.toString(x);
            String valorY = Double.toString(y);
            //String valorA1 = Double.toString(a1);
            //String valorD = Double.toString(d);
            //String valorA3 = Double.toString(a3);
            //String valorGama = Double.toString(gama);

            EquacaoDireta.setText("Equação Direta");
            ResultadoX.setText("Valor x é " + valorX );
            ResultadoY.setText("Valor de y é " + valorY);
            EquacaoInversa.setText("Equação Inversa");
            //ResultadoA1.setText("Valor do ângulo 1 é  " + valorA1);
            //ResultadoD.setText("Valor de D é  " + valorD);
            //ResultadoA3.setText("Valor do ângulo 3 é  " + valorA3);
            //ResultadoGama.setText("Valor do ângulo Gama é  " + valorGama);

        } else {
            ResultadoX.setText("Preencher Os Campos Corretamente");
        }
    }
    public void calcularCI(View view){
        Double valorAnguloGama = Double.parseDouble(anguloGama.getText().toString());
        Double valorXInserido = Double.parseDouble(valorXUsuario.getText().toString());Double valorYInserido = Double.parseDouble(valorYUsuario.getText().toString());
        Double valorJuntaUmCI = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDoisCI = Double.parseDouble(juntaDois.getText().toString());

        a1 = Math.atan(valorYInserido - valorJuntaDoisCI*Math.sin(valorAnguloGama)/ valorXInserido - valorJuntaDoisCI*Math.cos(valorAnguloGama));
        a3 = valorAnguloGama - a1 ;
        gama = a1 + a3;
        d = Math.sqrt(Math.pow(valorXInserido - valorJuntaDoisCI*Math.cos(valorAnguloGama), 2) + Math.pow(valorYInserido - valorJuntaDoisCI*Math.cos(valorAnguloGama), 2));


        String valorA1 = Double.toString(a1);
        String valorA3 = Double.toString(a3);
        String valorGama = Double.toString(gama);
        String valorD = Double.toString(d);

        ResultadoA1.setText("Valor do ângulo 1: " + valorA1);
        ResultadoA3.setText("Valor do ângulo 3: " + valorA3);
        ResultadoGama.setText("Valor do ângulo gama: " + valorGama);
        ResultadoGama.setText("Valor d: " + valorD);

    }
    public boolean validarCampos() {

        boolean r1, r2, r3, r4, r5, r6, r7 = false;

        if (!TextUtils.isEmpty(anguloUm.getText().toString())) {

            Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());  // Converte string em número

            if (valorAnguloUm < 0 | valorAnguloUm > 380) {
                r1 = false;
                //Mostrando aonde esta o erro
                anguloUm.setError("Preencher Angulo Corretamente");
                anguloUm.requestFocus();
            } else {
                r1 = true;
            }
        } else {
            r1 = false;
            //Mostrando aonde esta o erro
            anguloUm.setError("Preencher corretamente");
            anguloUm.requestFocus();
        }


        if (!TextUtils.isEmpty(juntaUm.getText().toString())) {
            Double valorJuntaUm = Double.parseDouble(juntaUm.getText().toString());  // Converte string em número

            if (valorJuntaUm <= 0) {
                r2 = false;
                //Mostrando aonde esta o erro
                juntaUm.setError("Preencher corretamente");
                juntaUm.requestFocus();
            } else {
                r2 = true;
            }
        } else {
            r2 = false;
            //Mostrando aonde esta o erro
            juntaUm.setError("Preencher corretamente");
            juntaUm.requestFocus();
        }

        if (!TextUtils.isEmpty(anguloDois.getText().toString())) {

            Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());  // Converte string em número

            if (valorAnguloDois < 0 | valorAnguloDois > 380) {
                r3 = false;
                //Mostrando aonde esta o erro
                anguloDois.setError("Preencher Angulo Corretamente");
                anguloDois.requestFocus();
            } else {
                r3 = true;
            }
        } else {
            r3 = false;
            //Mostrando aonde esta o erro
            anguloDois.setError("Preencher corretamente");
            anguloDois.requestFocus();
        }


        if (!TextUtils.isEmpty(juntaDois.getText().toString())) {
            Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());  // Converte string em número

            if (valorJuntaDois <= 0) {
                r4 = false;
                //Mostrando aonde esta o erro
                juntaDois.setError("Preencher corretamente");
                juntaDois.requestFocus();
            } else {
                r4 = true;
            }
        } else {
            r4 = false;
            //Mostrando aonde esta o erro
            juntaDois.setError("Preencher corretamente");
            juntaDois.requestFocus();
        }




        if (!TextUtils.isEmpty(juntaDois.getText().toString())) {
            Double valorJuntaTres = Double.parseDouble(juntaDois.getText().toString());  // Converte string em número

            if (valorJuntaTres <= 0) {
                r6 = false;
                //Mostrando aonde esta o erro
                juntaDois.setError("Preencher corretamente");
                juntaDois.requestFocus();
            } else {
                r6 = true;
            }
        } else {
            r6 = false;
            //Mostrando aonde esta o erro
            juntaDois.setError("Preencher corretamente");
            juntaDois.requestFocus();
        }


        return r1 & r2 & r3 & r4 &  r6;
    }
}