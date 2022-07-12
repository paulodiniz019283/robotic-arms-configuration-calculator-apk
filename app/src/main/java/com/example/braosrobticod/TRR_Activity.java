package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class TRR_Activity extends AppCompatActivity {
    private TextInputEditText anguloUm, anguloDois,valorXUsuario,valorAnguloGama,valorZUsuario,valorYUsuario, anguloTres, anguloGama, juntaUm, juntaDois, juntaTres;
    private TextView ResultadoX, ResultadoY,ResultadoZ, ResultadoA1, ResultadoA2, ResultadoGama, ResultadoA3, EquacaoDireta, EquacaoInversa;
    private double x, y,z, a1, a2, a3;
    ImageButton buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trr);

        buttonInfo = findViewById(R.id.imageButtonTRRInfor);
        anguloUm = findViewById(R.id.anguloUm);
        anguloDois =findViewById(R.id.anguloDois);
        anguloTres =findViewById(R.id.anguloTresTRLR);
        juntaUm = findViewById(R.id.juntaUm);
        juntaDois = findViewById(R.id.juntaDois);
        juntaTres = findViewById(R.id.juntaTres);
        EquacaoDireta = findViewById(R.id.equacaoDiretaTRR);
        EquacaoInversa = findViewById(R.id.equacaoInversaTRR);
        ResultadoX = findViewById(R.id.valorXTRR);
        ResultadoY = findViewById(R.id.valorYTRR);
        ResultadoZ = findViewById(R.id.valorZTRR);
        ResultadoA1 = findViewById(R.id.valorA1TRR);
        ResultadoA2 = findViewById(R.id.valorA2TRR);
        ResultadoA3 = findViewById(R.id.valorA3TRR);

        valorXUsuario = findViewById(R.id.valorXUsuarioRLR);
        valorYUsuario = findViewById(R.id.valorYUsuarioRLR);
        valorZUsuario = findViewById(R.id.valorZUsuarioTRR);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Informacoes_TRR.class);
                startActivity(intent);

            }
        });

    }
    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());
        Double valorAnguloTres = Double.parseDouble(anguloTres.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());
        Double valorJuntaTres = Double.parseDouble(juntaTres.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = (valorAnguloDois*Math.cos(valorAnguloUm) + valorJuntaTres*Math.cos(valorAnguloDois +valorAnguloTres))*Math.cos(valorAnguloUm) ;
            y = (valorAnguloDois*Math.cos(valorAnguloUm) + valorJuntaTres*Math.cos(valorAnguloDois +valorAnguloTres))*Math.sin(valorAnguloUm);
            z = valorJuntaum + valorJuntaDois*Math.sin(valorAnguloUm) + valorJuntaTres*Math.sin(valorAnguloDois + valorAnguloTres);
            //
            //



            String valorX = Double.toString(x);
            String valorY = Double.toString(y);
            String valorZ = Double.toString(z);
            //String valorA1 = Double.toString(a1);
            //String valorA2 = Double.toString(a2);
            //String valorA3 = Double.toString(a3);


            EquacaoDireta.setText("Equação Direta");
            ResultadoX.setText("Valor x é " + valorX );
            ResultadoY.setText("Valor de y é " + valorY);
            ResultadoZ.setText("Valor do z é  " + valorZ);

            //ResultadoA1.setText("Valor do ângulo 1 é  " + valorA1);
            //ResultadoA2.setText("Valor do ângulo 2 é  " + valorA2);
            //ResultadoA3.setText("Valor do ângulo 3 é  " + valorA3);


        } else {
            ResultadoX.setText("Preencher Os Campos Corretamente");
        }
    }
    public void calcularCI(View view){
        Double valorXInserido = Double.parseDouble(valorXUsuario.getText().toString());
        Double valorYInserido = Double.parseDouble(valorYUsuario.getText().toString());
        Double valorZInserido = Double.parseDouble(valorZUsuario.getText().toString());
        Double valorJuntaUmCI = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDoisCI = Double.parseDouble(juntaDois.getText().toString());
        Double valorJuntaTresCI = Double.parseDouble(juntaTres.getText().toString());

        a3 = 1;
        a2 = Math.atan(((valorZInserido-valorJuntaUmCI)*(valorJuntaDoisCI + valorJuntaTresCI*Math.cos(a3))-Math.sqrt(Math.pow(valorXInserido,2) + Math.pow(valorYInserido,2))*valorJuntaTresCI*Math.sin(a3))/((Math.sqrt(Math.pow(valorXInserido,2) +Math.pow(valorYInserido,2))*(valorJuntaDoisCI + valorJuntaTresCI*Math.cos(a3))) + (valorZInserido - valorJuntaUmCI)*(valorJuntaTresCI*Math.sin(a3))));
        a1 =  Math.atan(valorYInserido/valorXInserido);

        String valorA1 = Double.toString(a1);
        String valorA2 = Double.toString(a2);
        String valorA3 = Double.toString(a3);


        ResultadoA1.setText("Valor do ângulo 1: " + valorA1);
        ResultadoA2.setText("Valor do ângulo 2: " + valorA2);
        ResultadoA3.setText("Valor do ângulo 3: " + valorA3);


    }    public boolean validarCampos() {

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

        if (!TextUtils.isEmpty(anguloTres.getText().toString())) {

            Double valoAnguloTres = Double.parseDouble(anguloTres.getText().toString());  // Converte string em número

            if (valoAnguloTres < 0 | valoAnguloTres > 380) {
                r5 = false;
                //Mostrando aonde esta o erro
                anguloTres.setError("Preencher Angulo Corretamente");
                anguloTres.requestFocus();
            } else {
                r5 = true;
            }
        } else {
            r5 = false;
            //Mostrando aonde esta o erro
            anguloTres.setError("Preencher corretamente");
            anguloTres.requestFocus();
        }


        if (!TextUtils.isEmpty(juntaTres.getText().toString())) {
            Double valorJuntaTres = Double.parseDouble(juntaTres.getText().toString());  // Converte string em número

            if (valorJuntaTres <= 0) {
                r6 = false;
                //Mostrando aonde esta o erro
                juntaTres.setError("Preencher corretamente");
                juntaTres.requestFocus();
            } else {
                r6 = true;
            }
        } else {
            r6 = false;
            //Mostrando aonde esta o erro
            juntaTres.setError("Preencher corretamente");
            juntaTres.requestFocus();
        }


        return r1 & r2 & r3 & r4 & r5 & r6;
    }
}