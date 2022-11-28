package com.example.meupetprojeto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.meupetprojeto.AgendamentoActivity;
import com.example.meupetprojeto.MainActivity;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "MeuPetDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "agendamento";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOMEPET = "nomepet";
    private static final String COLUMN_HOSPEDAGEM = "hospedagem";
    private static final String COLUMN_SPA = "spa";
    private static final String COLUMN_BANHOTOSA = "banhotosa";
    private static final String COLUMN_OBS = "obs";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                            COLUMN_NOMEPET + " TEXT , " +
                            COLUMN_HOSPEDAGEM + " TEXT , " +
                            COLUMN_SPA + " TEXT , " +
                            COLUMN_BANHOTOSA + " TEXT , " +
                            COLUMN_OBS + " TEXT) ; " ;
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void novoAgendamento(String nomepet, String hospedagem, String spa, String banhotosa, String obs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOMEPET, nomepet);
        cv.put(COLUMN_HOSPEDAGEM, hospedagem);
        cv.put(COLUMN_SPA, spa);
        cv.put(COLUMN_BANHOTOSA, banhotosa);
        cv.put(COLUMN_OBS, obs);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Falha ao criar agendamento", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Agendamento realizado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
