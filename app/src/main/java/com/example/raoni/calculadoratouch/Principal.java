package com.example.raoni.calculadoratouch;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button botao = (Button) view;

                Toast.makeText(Principal.this, "Clicou: " + botao.getText(), Toast.LENGTH_SHORT).show();
            }
        };

        TableLayout leiaute = new TableLayout(this);

        leiaute.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        leiaute.setStretchAllColumns(true);

        int cont = 7;
        for (int i = 3; i > 0; i--) {

            TableRow linha = new TableRow(this);

            for (int j = 3; j > 0; j--) {

                Button botao = new Button(this);
                botao.setText("" + cont++);
                botao.setOnClickListener(listener);
                linha.addView(botao);
            }
            cont-=6;
            leiaute.addView(linha);
        }

        setContentView(leiaute);
    }
}
