package com.example.braosrobticod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Informacoes_Main extends AppCompatActivity {
    private Button buttonCompras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_main);

        buttonCompras = findViewById(R.id.button14);

        buttonCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Compras_Activity.class);
                startActivity(intent);

            }
        });
    }
}