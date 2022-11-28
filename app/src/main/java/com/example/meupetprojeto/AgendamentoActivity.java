package com.example.meupetprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AgendamentoActivity extends AppCompatActivity {

    MyDatabaseHelper myDB;
    ArrayList<String> nomepet,hospedagem,spa,banhotosa,obs;
    RecyclerView recyclerview_agendamento;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        recyclerview_agendamento = findViewById(R.id.recyclerview_agendamento);

        myDB = new MyDatabaseHelper(AgendamentoActivity.this);
        nomepet = new ArrayList<>();
        hospedagem = new ArrayList<>();
        banhotosa = new ArrayList<>();
        spa = new ArrayList<>();
        obs = new ArrayList<>();



        customAdapter = new CustomAdapter(this, nomepet,hospedagem,spa,banhotosa,obs);

        recyclerview_agendamento.setAdapter(customAdapter);

        recyclerview_agendamento.setLayoutManager(new LinearLayoutManager(AgendamentoActivity.this));

        guardarDadosEmArray();

    }

    void guardarDadosEmArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Sem agendamentos", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                nomepet.add(cursor.getString(1));
                hospedagem.add(cursor.getString(2));
                spa.add(cursor.getString(3));
                banhotosa.add(cursor.getString(4));
                obs.add(cursor.getString(5));
            }
        }
    }

}