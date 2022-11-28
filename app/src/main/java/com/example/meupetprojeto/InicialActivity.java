package com.example.meupetprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicialActivity extends AppCompatActivity {

    CardView cardviewinicial;
    Button btn_avancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        cardviewinicial = findViewById(R.id.cardviewinicial);
        btn_avancar = findViewById(R.id.btn_avancar);
    }

    public void abrirAgendar(View v){
        Intent it_tela_consulta=new Intent(this, MainActivity.class);
        startActivity(it_tela_consulta);
    }
}