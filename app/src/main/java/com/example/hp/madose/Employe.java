package com.example.hp.madose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Employe extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        final Button quitter=(Button) findViewById(R.id.button9);
        final EditText codeT=(EditText) findViewById(R.id.editCat);
        final EditText codeP=(EditText) findViewById(R.id.profil);
        final AutoCompleteTextView codeD=(AutoCompleteTextView) findViewById(R.id.autoCompDep);
        final Button codeB=(Button) findViewById(R.id.valEmp);
        final BaseDeDonne bd=new BaseDeDonne(this);

        ArrayList<String> em=bd.affiNDE();
        ArrayAdapter<String> emp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,em);
        codeD.setAdapter(emp);

        codeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x=Integer.parseInt(bd.selectDep(codeD.getText().toString()));

                bd.insertEmp(codeT.getText().toString(),x,codeP.getText().toString());
                bd.close();

                Toast.makeText(getApplicationContext(),"Employé enregistré avec succès", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Employe.this,Affichage.class);
                intent.putExtra("passage","employe");
                codeT.setText("");
                codeP.setText("");
                codeD.setText("");
                startActivity(intent);
            }
        });

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Employe.this,Acceuil.class);


                startActivity(intent);
            }
        });
    }
}
