package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class TRLR_Activity extends AppCompatActivity {
    private TextInputEditText anguloUm,anguloUmTetaNovo,anguloDoisTetaNovo, anguloDois, anguloTres, anguloGama, juntaUm, juntaDois, juntaTres;
    private TextView ResultadoX ,ResultadoXPC,ResultadoYPC, Precisao, ResultadoY,ResultadoZ, ResultadoD1, ResultadoA1, ResultadoA2,ResuldadoD, ResultadoGama,CondicaoInicial, ResultadoA3, EquacaoDireta, EquacaoInversa;
    private double x,xc, yc, xt, xtt, yt, ytt, y,z, a1, a2, a3, d, gama;
    ImageButton buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trlr);

        buttonInfo = findViewById(R.id.imageButtonTRLRInfor);
        anguloUm = findViewById(R.id.anguloUm);
        anguloDois =findViewById(R.id.anguloDois);
        anguloTres =findViewById(R.id.anguloTresTRLR);
        anguloGama = findViewById(R.id.anguloGamaRRR);
        juntaUm = findViewById(R.id.juntaUm);
        juntaDois = findViewById(R.id.juntaDois);
        juntaTres = findViewById(R.id.juntaTres);
        EquacaoDireta = findViewById(R.id.equacaoDiretaTRLR);
        EquacaoInversa = findViewById(R.id.equacaoInversaTRLR);
        ResultadoX = findViewById(R.id.valorXTRLR);
        ResultadoY = findViewById(R.id.valorYTRLR);
        ResultadoZ = findViewById(R.id.valorZTRLR);
        ResultadoA1 = findViewById(R.id.valorA1TRLR);
        ResultadoA2 = findViewById(R.id.valorA2TRLR);
        ResultadoA3 = findViewById(R.id.valorA3TRLR);
        CondicaoInicial = findViewById(R.id.condicaoInicialTRLR);
        ResuldadoD = findViewById(R.id.valorZTRLR2D);
        ResultadoD1 = findViewById(R.id.valorDTRLR);
        ResultadoGama = findViewById(R.id.valorGamaTRLR);
        Precisao = findViewById(R.id.precisaoCartersianaTRLR);
        ResultadoXPC = findViewById(R.id.XPCTRLR);
        ResultadoYPC = findViewById(R.id.YPCTRLR);

    }
    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());
        Double valorAnguloTres = Double.parseDouble(anguloTres.getText().toString());
        Double valorAnguloGama = Double.parseDouble(anguloGama.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());
        Double valorJuntaTres = Double.parseDouble(juntaTres.getText().toString());
        Double valorCondicaoInicial = Double.parseDouble(CondicaoInicial.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = ((valorJuntaDois * Math.cos(valorAnguloDois) ) + (valorJuntaTres * Math.cos(valorAnguloDois + valorAnguloTres))) * Math.cos(valorAnguloUm) ;
            y = ((valorJuntaDois * Math.cos(valorAnguloDois) ) + (valorJuntaTres * Math.cos(valorAnguloDois + valorAnguloTres))) * Math.sin(valorAnguloUm);
            z = valorJuntaum + valorJuntaDois*Math.sin(valorAnguloDois) + valorAnguloDois*Math.sin(valorAnguloDois + valorAnguloTres);
            d = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) - Math.pow(valorJuntaDois,2));
            a1 = Math.atan(y/x);
            a2 = Math.atan((z-valorJuntaTres*Math.sin(valorAnguloGama) - valorJuntaum)/(Math.sqrt(Math.pow(x,2) + Math.pow(y,2 ))) - valorJuntaTres*Math.cos(valorAnguloGama));
            a3 = valorAnguloGama - valorAnguloDois;
            gama = a1 + a2 + valorCondicaoInicial;

            String valorX = Double.toString(x);
            String valorY = Double.toString(y);
            String valorZ = Double.toString(z);
            String valorD = Double.toString(d);
            String valorA1 = Double.toString(a1);
            String valorA2 = Double.toString(a2);
            String valorA3 = Double.toString(a3);
            String valorGama = Double.toString(gama);



            EquacaoDireta.setText("Equação Direta");
            ResultadoX.setText("Valor x é: " + valorX );
            ResultadoY.setText("Valor de y é: " + valorY);
            ResultadoZ.setText("Valor do z é:  " + valorZ);
            ResultadoD1.setText("Valor do z é:  " + valorD);
            EquacaoInversa.setText("Equação Inversa");
            ResultadoA1.setText("Valor do ângulo 1 é:  " + valorA1);
            ResultadoA2.setText("Valor do ângulo 2 é:  " + valorA2);
            ResultadoA3.setText("Valor do ângulo 3 é:  " + valorA3);
            ResultadoGama.setText("Valor do ângulo Gama é:  " + valorGama);


        } else {
            ResultadoX.setText("Preencher Os Campos Corretamente");
        }

    }
    public void calcularPC(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());
        Double valorAnguloUmNovo = Double.parseDouble(anguloUmTetaNovo.getText().toString());
        Double valorAnguloDoisNovo = Double.parseDouble(anguloDoisTetaNovo.getText().toString());
        validarCampos();


        if (validarCampos()) {
            xt = valorJuntaum * Math.sin(a1) + valorJuntaDois*Math.sin(a1 + a2);
            xtt = valorJuntaDois*Math.sin(a1 + a2);
            if (xt < 0) {
                xt = xt * (-1);
            }
            if (xtt < 0) {
                xtt = xt * (-1);
            }
            xc = xt*(valorAnguloUmNovo - valorAnguloUm) + xtt*(valorAnguloDoisNovo - valorAnguloDois);

            yt = valorJuntaum * Math.cos(a1) + valorJuntaDois*Math.cos(a1 + a2);
            ytt = valorJuntaDois*Math.cos(a1 + a2);
            if (yt < 0) {
                yt = yt * (-1);
            }
            if (ytt < 0) {
                ytt = ytt * (-1);
            }
            yc = yt*(valorAnguloUmNovo - valorAnguloUm) + ytt*(valorAnguloDoisNovo - valorAnguloDois);;

            String valorXC = Double.toString(xc);
            String valorYC = Double.toString(yc);

            Precisao.setText("Precisão Cartesiana");
            ResultadoXPC.setText("Valor do X da precisão cartesiana é   " + valorXC);
            ResultadoYPC.setText("Valor do y da precisão cartesiana é   " + valorYC);

        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

        }
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