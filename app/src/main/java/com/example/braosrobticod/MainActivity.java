package com.example.braosrobticod;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonR, imageButtonRR,imageButtonInfo, imageButtonRLR, imageButtonRL, imageButtonRRR, imageButtonTRR, imageButtonTRLR;
    private Button btnScanner;
    private TextView tvBarScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonR =  findViewById(R.id.imageButtonR);
        imageButtonRR =  findViewById(R.id.imageButtonRR);
        imageButtonRLR = findViewById(R.id.imageButtonRLR);
        imageButtonRL = findViewById(R.id.imageButtonRL);
        imageButtonRRR = findViewById(R.id.imageButtonRRR);
        imageButtonTRR = findViewById(R.id.imageButtonTRR);
        imageButtonTRLR = findViewById(R.id.imageButtonTRLR);
        imageButtonInfo = findViewById(R.id.imageBtnMain);

        btnScanner = findViewById(R.id.btnQrCode);
        btnScanner.setOnClickListener(mOnClickListener);
        tvBarScanner = findViewById(R.id.sc);

        imageButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Informacoes_Main.class);
                startActivity(intent);

            }
        });
        imageButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), R_Activity.class);
                startActivity(intent);

            }
        });

        imageButtonRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RR_Activity.class);
                startActivity(intent);

            }
        });

        imageButtonRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RL_Activity.class);
                startActivity(intent);

            }
        });

        imageButtonRLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RLR_Activity.class);
                startActivity(intent);

            }
        });
        imageButtonRRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RRR_Activity.class);
                startActivity(intent);

            }
        });
        imageButtonTRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TRR_Activity.class);
                startActivity(intent);

            }
        });
        imageButtonTRLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TRLR_Activity.class);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
            if(result.getContents() != null){
                tvBarScanner.setText(result.getContents());
                if(tvBarScanner.getText().toString().equals("R")) {
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), R_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("RR")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), RR_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("RL")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), RL_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("RLR")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), RLR_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("RRR")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), RRR_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("TRR")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), TRR_Activity.class);
                    startActivity(intent);
                }
                if(tvBarScanner.getText().toString().equals("TRRR")){
                    tvBarScanner.setText(result.getContents());
                    Intent intent = new Intent(getApplicationContext(), TRLR_Activity.class);
                    startActivity(intent);
                }
            }else{
                tvBarScanner.setText("");
            }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnQrCode:
                    new IntentIntegrator(MainActivity.this).initiateScan();
            }
        }
    };
}