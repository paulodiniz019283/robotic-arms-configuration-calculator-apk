package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RL_Activity extends AppCompatActivity {

    private TextInputEditText anguloUm, juntaUm, valorXUsuario, valorYUsuario;
    private TextView ResultadoX,ResultadoY, Precisao, ResultadoA1,valorUmDNovo, ResultadoD,ResultadoXPC,ResultadoYPC, anguloUmTetaNovo, anguloDoisTetaNovo,EquacaoDireta, EquacaoInversa;
    private double x,y,a1,d,xt, xtt, xc, yt, ytt, yc;
    ImageButton buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rl);

        buttonInfo = findViewById(R.id.imageButtonRLInfor);
        anguloUm = findViewById(R.id.anguloUm);
        juntaUm = findViewById(R.id.anguloTresTRLR);
        EquacaoDireta = findViewById(R.id.equacaoDiretaRL);
        EquacaoInversa = findViewById(R.id.equacaoInversaRL);
        ResultadoX = findViewById(R.id.valorXRL);
        ResultadoY = findViewById(R.id.valorYRL);
        ResultadoA1 = findViewById(R.id.valorA1RL);
        ResultadoD = findViewById(R.id.valorDRL);

        ResultadoXPC = findViewById(R.id.XPCRL);
        ResultadoYPC = findViewById(R.id.YPCRL);
        Precisao = findViewById(R.id.precisaoCartersianaRL);
        anguloUmTetaNovo = findViewById(R.id.anguloUmTetaNovoRL);
        valorUmDNovo = findViewById(R.id.DUmNovoRL);

        valorXUsuario = findViewById(R.id.valorXUsuarioRL);
        valorYUsuario = findViewById(R.id.valorYUsuarioRL);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Informacoes_RL.class);
                startActivity(intent);

            }
        });
    }
    public void calcular(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        validarCampos();

        if (validarCampos()) {
            x = valorJuntaum*Math.cos(valorAnguloUm);
            y = valorJuntaum*Math.sin(valorAnguloUm);


            String valorX = Double.toString(x);
            String valorY = Double.toString(y);



            EquacaoDireta.setText("Equação Direta");
            ResultadoX.setText("Valor x:" + valorX );
            ResultadoY.setText("Valor y: " + valorY);

        } else {
            ResultadoX.setText("Preencher Os Campos Corretamente");
        }
    }

    public void calcularCI(View view){
        double valorXUsuarioCalcularIC = Double.parseDouble(valorXUsuario.getText().toString());
        double valorYUsuarioCalcularIC = Double.parseDouble(valorYUsuario.getText().toString());

        d = Math.sqrt(Math.pow(valorXUsuarioCalcularIC,2) + Math.pow(valorYUsuarioCalcularIC,2));
        a1 = Math.atan(valorYUsuarioCalcularIC/valorXUsuarioCalcularIC);

        String valorA1 = Double.toString(a1);
        String valorD = Double.toString(d);

        ResultadoD.setText("Valor de d: " + valorD);
        ResultadoA1.setText("Valor do ângulo 1: " + valorA1);

    }

    public void calcularPC(View view) {
        Double valorAnguloUm = Double.parseDouble(anguloUm.getText().toString());
        Double valorJuntaum = Double.parseDouble(juntaUm.getText().toString());
        Double valorAnguloUmNovo = Double.parseDouble(anguloUmTetaNovo.getText().toString());
        Double valorDUmNovo = Double.parseDouble(valorUmDNovo.getText().toString());
        validarCampos();


        if (validarCampos()) {
            xt = (-d * Math.sin(a1));
            xtt = (Math.cos(a1));
            if (xt < 0) {
                xt = xt * (-1);
            }
            if (xtt < 0) {
                xtt = xt * (-1);
            }
            xc = (xt*(Math.toRadians(valorAnguloUmNovo) - Math.toRadians(valorAnguloUm))) + (xtt * (valorDUmNovo - d));

            yt = (d * Math.cos(a1)) ;
            ytt = (Math.sin(a1));
            if(yt <0 ){
                yt = yt * (-1);
            }
            if(ytt <0 ){
                ytt = ytt * (-1);
            }
            yc = (yt*(Math.toRadians(valorAnguloUmNovo) - Math.toRadians(valorAnguloUm))) + (ytt *(valorAnguloUmNovo -valorAnguloUm));

            String valorXC = Double.toString(xc);
            String valorYC = Double.toString(yc);

            ResultadoXPC.setText("Valor do X da precisão cartesiana é   " + valorXC);
            ResultadoYPC.setText("Valor do y da precisão cartesiana é   " + valorYC);

        } else {
            ResultadoXPC.setText("Preencher Os Campos Corretamente");

        }
    }
    public boolean validarCampos() {

        boolean r1,r2 = false;

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

        return r1 & r2;
    }
}
