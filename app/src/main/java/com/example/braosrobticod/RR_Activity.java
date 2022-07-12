package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RR_Activity extends AppCompatActivity {
    private TextInputEditText anguloUm, anguloDois, juntaUm, juntaDois, XUsuarioRR, YUsuarioRR,anguloUmCI, anguloDoisCI,juntaUmCI, juntaDoisCI;
    private TextView ValorD, ResultadoX,ResultadoY, ResultadoA1,ResultadoA2,Precisao,ResultadoXPC,ResultadoYPC, anguloUmTetaNovo, anguloDoisTetaNovo, EquacaoDireta, EquacaoInversa;
    private double x,y,a1,a2,a3, xt, xtt,drr, xc, yt, ytt, yc;
    private boolean teste;
    ImageButton buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rr);

        buttonInfo = findViewById(R.id.imageButtonRRInfor);
        anguloUm = findViewById(R.id.anguloUm);
        anguloDois =findViewById(R.id.anguloDois);
        juntaUm = findViewById(R.id.anguloTresTRLR);

        juntaDois = findViewById(R.id.juntaDois);
        anguloUmCI = findViewById(R.id.anguloUm);
        anguloDoisCI =findViewById(R.id.anguloDois);
        juntaUmCI = findViewById(R.id.anguloTresTRLR);
        juntaDoisCI = findViewById(R.id.juntaDois);

        EquacaoDireta = findViewById(R.id.equacaoDiretaR);
        EquacaoInversa = findViewById(R.id.equcacaoInversaR);
        ResultadoX = findViewById(R.id.valorXR);
        ResultadoY = findViewById(R.id.valorYR);
        ResultadoA1 = findViewById(R.id.valorA1R);
        ResultadoA2 = findViewById(R.id.valorA2R);
        ValorD = findViewById(R.id.valorRespostaDRR);

        XUsuarioRR = findViewById(R.id.valorXUsuarioRR);
        YUsuarioRR = findViewById(R.id.valorYUsuarioRR);

        ResultadoXPC = findViewById(R.id.XPCRR);
        ResultadoYPC = findViewById(R.id.YPCRR);
        Precisao = findViewById(R.id.precisaoCartesianaRR);
        anguloUmTetaNovo = findViewById(R.id.anguloUmTetaNovoRR);
        anguloDoisTetaNovo = findViewById(R.id.anguloDoisTetaNovoRR);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Informacoes_RR.class);
                startActivity(intent);

            }
        });
    }
    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDois.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDois.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = valorJuntaum*(Math.cos(valorAnguloUm)) + valorJuntaDois*(Math.cos(valorAnguloUm + valorAnguloDois));
            y = valorJuntaum*(Math.sin(valorAnguloUm)) + valorJuntaDois*(Math.sin(valorAnguloUm + valorAnguloDois));

            String valorX = Double.toString(x);
            String valorY = Double.toString(y);

            ResultadoX.setText("Valor x: " + valorX );
            ResultadoY.setText("Valor de y: " + valorY);

        } else {
            ResultadoX.setText("Preencher Os Campos Corretamente");
        }
    }

    public void calcularCI(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUmCI.getText().toString());
        Double valorAnguloDois = Double.parseDouble(anguloDoisCI.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUmCI.getText().toString());
        Double valorJuntaDois = Double.parseDouble(juntaDoisCI.getText().toString());
        Double valorXUsuario = Double.parseDouble(XUsuarioRR.getText().toString());
        Double valorYUsuario = Double.parseDouble(YUsuarioRR.getText().toString());

        validarCampos();
        if (validarCampos()) {
            a3 = (Math.pow(valorXUsuario,2) + Math.pow(valorYUsuario,2)- Math.pow(valorJuntaum,2) - Math.pow(valorJuntaDois,2))/(2 * valorJuntaum * valorJuntaDois);
            a2 = Math.acos(a3);
            a1 = Math.atan(( valorYUsuario * (valorJuntaum * valorJuntaDois * Math.cos(a2) - valorXUsuario * valorJuntaDois * Math.sin(a2))) / (valorXUsuario * (valorJuntaum + valorJuntaDois * Math.cos(a2) + valorYUsuario * valorJuntaDois * Math.sin(a2))));
            drr = Math.sqrt(Math.pow(valorXUsuario,2)+Math.pow(valorYUsuario,2));

            String valorA1 = Double.toString(a1);
            String valorA2 = Double.toString(a2);
            String valorD = Double.toString(drr);

            ResultadoA1.setText("Valor do ângulo 1: " + valorA1);
            ResultadoA2.setText("Valor do ângulo 2:  " + valorA2);
            ValorD.setText("Valor D:  " + valorD);

        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

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


            ResultadoXPC.setText("Valor do X: " + valorXC);
            ResultadoYPC.setText("Valor do y: " + valorYC);

        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

        }
    }

    public boolean validarCampos() {

        boolean r1,r2,r3,r4 = false;

        if (!TextUtils.isEmpty(anguloUm.getText().toString())) {

            Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());  // Converte string em número

            if(valorAnguloUm < 0 | valorAnguloUm > 380) {
                r1 = false;
                //Mostrando aonde esta o erro
                anguloUm.setError("Preencher Angulo Corretamente");
                anguloUm.requestFocus();
            }else{
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

            if(valorJuntaUm<=0) {
                r2 = false;
                //Mostrando aonde esta o erro
                juntaUm.setError("Preencher corretamente");
                juntaUm.requestFocus();
            }else{
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

            if(valorAnguloDois < 0 | valorAnguloDois > 380) {
                r3 = false;
                //Mostrando aonde esta o erro
                anguloDois.setError("Preencher Angulo Corretamente");
                anguloDois.requestFocus();
            }else{
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

            if(valorJuntaDois<=0) {
                r4 = false;
                //Mostrando aonde esta o erro
                juntaDois.setError("Preencher corretamente");
                juntaDois.requestFocus();
            }else{
                r4 = true;
            }
        } else {
            r4 = false;
            //Mostrando aonde esta o erro
            juntaDois.setError("Preencher corretamente");
            juntaDois.requestFocus();
        }


        return r1 & r2 & r3 & r4;
    }
}