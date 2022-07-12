package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class R_Activity extends AppCompatActivity {
    private TextInputEditText anguloUm, juntaUm, XUsuarioR, YUsuarioR;
    private TextView ValorD, ResultadoX,ResultadoY,anguloTetaNovo,Precisao, ResultadoXPC, ResultadoYPC, ResultadoA1, EquacaoDireta, EquacaoInversa;
    private double x=1,y=1,a1=1,xt=1, xc=1,dr, yt=1, yc=1;
    ImageButton buttonInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ractivity);

        buttonInfo = findViewById(R.id.imagemButtonRInfo);
        anguloUm = findViewById(R.id.anguloUm);
        juntaUm = findViewById(R.id.anguloTresTRLR);
        EquacaoDireta = findViewById(R.id.equacaoDiretaUm);
        EquacaoInversa = findViewById(R.id.equacaoInversaUm);
        ResultadoX = findViewById(R.id.valorXUm);
        ResultadoY = findViewById(R.id.valorYUm);
        ResultadoA1 = findViewById(R.id.valorA1Um);

        XUsuarioR = findViewById(R.id.valorXUsuarioR);
        YUsuarioR = findViewById(R.id.valorYUsuarioR);
        ValorD = findViewById(R.id.valorRespostaDR);

        ResultadoXPC = findViewById(R.id.valorXPC);
        ResultadoYPC = findViewById(R.id.valorYPC);
        Precisao = findViewById(R.id.precisaoCatesianaR);
        anguloTetaNovo = findViewById(R.id.anguloTetaUmNovo);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), informacoes_R.class);
                startActivity(intent);

            }
        });
    }

    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = valorJuntaum*(Math.cos(valorAnguloUm));
            y = valorJuntaum*(Math.sin(valorJuntaum));


            String valorX = Double.toString(x);
            String valorY = Double.toString(y);


            EquacaoDireta.setText("Equação Direta");
            ResultadoX.setText("Valor x: " + valorX );
            ResultadoY.setText("Valor y: " + valorY);




        } else {
            x = 1;
            y = 1;


            ResultadoX.setText("Preencher Os Campos Corretamente");

        }
    }

    public void calcularCI(View view) {
        Double valorX = Double.parseDouble(XUsuarioR.getText().toString());
        Double valorY = Double.parseDouble(YUsuarioR.getText().toString());
        validarCampos();
        if (validarCampos()) {

            a1 = (Math.cos(valorX)/Math.sin(valorY));
            dr = Math.sqrt(Math.pow(valorX,2)+Math.pow(valorY,2));

            String valorA1 = Double.toString(a1);
            String valorD = Double.toString(dr);

            ResultadoA1.setText("Valor do ângulo 1: " + valorA1);
            ValorD.setText("Valor D: " + valorD);



        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

        }
    }

    public void calcularPC(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorAnguloNovo = Double.parseDouble(anguloTetaNovo.getText().toString());
        validarCampos();
        if (validarCampos()) {
            xt = valorJuntaum * Math.sin(a1);
            if (xt < 0) {
                xt = xt * (-1);
            }
            xc = xt * (Math.toRadians(valorAnguloNovo) - Math.toRadians(valorAnguloUm));

            yt = valorJuntaum*Math.cos(a1);
            if(yt <0 ){
            yt = yt * (-1);
            }
            yc = yt * (Math.toRadians(valorAnguloNovo) - Math.toRadians(valorAnguloUm));

            String valorXC = Double.toString(xc);
            String valorYC = Double.toString(yc);

            Precisao.setText("Precisão Cartesiana");
            ResultadoXPC.setText("Valor do X da precisão cartesiana: " + valorXC);
            ResultadoYPC.setText("Valor do y da precisão cartesiana: " + valorYC);

        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

        }
    }
    //Condição para validação dos dados
    public boolean validarCampos() {

        boolean r1,r2, r3 = false;
        if (!TextUtils.isEmpty(anguloUm.getText().toString())) {

            Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());  // Converte string em número

            if(valorAnguloUm < 0 | valorAnguloUm > 380) {
                r3 = false;
                //Mostrando aonde esta o erro
                anguloUm.setError("Preencher Angulo Corretamente");
                anguloUm.requestFocus();
            }else{
                r3 = true;
            }
        } else {
            r3 = false;
            //Mostrando aonde esta o erro
            anguloUm.setError("Preencher corretamente");
            anguloUm.requestFocus();
        }

        if (!TextUtils.isEmpty(anguloUm.getText().toString())) {

            Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());  // Converte string em número
            String data = anguloUm.getText().toString();
            if(valorAnguloUm < 0 || valorAnguloUm > 380 ) {
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

        return r1 & r2 & r3;
    }
}

