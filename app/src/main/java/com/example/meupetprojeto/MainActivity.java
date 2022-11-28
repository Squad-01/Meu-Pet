package com.example.meupetprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_nomepet,et_qtd_hosp,et_qtd_spa,et_qtd_banhotosa,et_obs;
    Button btn_finalizaagenda,btn_agendamentos,btn_fechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nomepet = findViewById(R.id.et_nomepet);
        et_qtd_hosp = findViewById(R.id.et_qtd_hosp);
        et_qtd_spa = findViewById(R.id.et_qtd_spa);
        et_qtd_banhotosa = findViewById(R.id.et_qtd_banhotosa);
        et_obs = findViewById(R.id.et_obs);

        btn_finalizaagenda = findViewById(R.id.btn_finalizaagenda);
        btn_agendamentos = findViewById(R.id.btn_agendamentos);
        btn_fechar = findViewById(R.id.btn_fechar);

        btn_finalizaagenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.novoAgendamento(et_nomepet.getText().toString().trim(),
                        et_qtd_hosp.getText().toString().trim(),
                        et_qtd_spa.getText().toString().trim(),
                        et_qtd_banhotosa.getText().toString().trim(),
                        et_obs.getText().toString().trim());
            }
        });



    }


    public void abrir_tela_consulta(View v){
        Intent it_tela_consulta=new Intent(this, AgendamentoActivity.class);
        startActivity(it_tela_consulta);
    }

}