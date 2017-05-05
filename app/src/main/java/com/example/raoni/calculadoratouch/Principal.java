package com.example.raoni.calculadoratouch;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;



public class Principal extends AppCompatActivity {

    private String aux, textVisor, textNextVisor, string, operador;
    private double n1, n2, resultado;
    private EditText visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        visor = new EditText(this);
        visor.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        visor.setGravity(View.TEXT_ALIGNMENT_CENTER);
        visor.setTextSize(80);
        visor.setSingleLine(true);
        visor.setCursorVisible(false);



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button botao = (Button) view;
                visor.setText(tecladoCalculadora(botao.getText(). toString()));

            }
        };

        TableLayout leiaute = new TableLayout(this);


        leiaute.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        leiaute.addView(visor);
        leiaute.setStretchAllColumns(true);

        int cont = 7;
        for (int i = 0; i < 5; i++) {

            TableRow linha = new TableRow(this);

            for (int j = 0; j < 4; j++) {

                Button botao = new Button(this);
                botao.setTextSize(30);
                //botao.setPadding(6,5,6,5);
               // botao.setTextColor(Color.parseColor("#000FF"));

                if(i==0 && j==0)
                    botao.setText("C");
                else if (i==0 && j==1)
                    botao.setText("√");
                else if (i==0 && j==2)
                    botao.setText("=");
                else if (i==0 && j==3)
                    botao.setText("DEL");
                else if (i==1 && j==3)
                    botao.setText("+");
                else if (i==2 && j==3)
                    botao.setText("-");
                else if (i==3 && j==3)
                    botao.setText("/");
                else if (i==4 && j==3)
                    botao.setText("*");
                else if (i==4 && j==0)
                    botao.setText(".");
                else if (i==4 && j==1)
                    botao.setText("0");
                else if (i==4 && j==2)
                    botao.setText("%");

                else {
                    botao.setText("" + cont++);
                }
                botao.setOnClickListener(listener);
                linha.addView(botao);
            }
            if(i>0)
                cont -= 6;
                leiaute.addView(linha);
        }

        setContentView(leiaute);
    }
    public String adicao(){
        n1 = Float.parseFloat(string);
        n2 = Float.parseFloat(textVisor);
        resultado = n1 + n2;
        aux = String.valueOf(resultado);

        return aux;
    }
    public String porcentagem(){
        n1 = Float.parseFloat(string);
        n2 = Float.parseFloat(textVisor);
        resultado = n1 * (n2/100);
        aux = String.valueOf(resultado);

        return aux;
    }
    public String subtracao(){
        n1 = Float.parseFloat(string);
        n2 = Float.parseFloat(textVisor);
        resultado = n1 - n2;
        aux = String.valueOf(resultado);

        return aux;
    }
    public String divisao(){
        n1 = Float.parseFloat(string);
        n2 = Float.parseFloat(textVisor);
        resultado = n1 / n2;
        aux = String.valueOf(resultado);

        return aux;
    }
    public String multiplicacao(){
        n1 = Float.parseFloat(string);
        n2 = Float.parseFloat(textVisor);
        resultado = n1 * n2;
        aux = String.valueOf(resultado);

        return aux;
    }  public String raiz(){
        n1 = Float.parseFloat(string);
        resultado = Math.sqrt(n1);
        aux = String.valueOf(resultado);

        return aux;
    }

    public String tecladoCalculadora(String str) {
         aux = null;
        textVisor = visor.getText().toString();
        textNextVisor = str;

        if(textNextVisor == "C") {
            aux = "";
            string = aux;
            return aux;
        } else if (textNextVisor == "del") {
            aux = textVisor;
            if (!aux.isEmpty()) aux = aux.substring(0, aux.length() - 1);
            return aux;
        }else if (textNextVisor == "+") {
                operador = textNextVisor;
            aux = textVisor;
            string = aux;
            aux = "";

            return aux;
            } else if (textNextVisor =="-") {
            operador = textNextVisor;
            aux = textNextVisor;
            string = aux;
            aux = "";
            return aux;
            } else if (textNextVisor == "/"){
                operador = textNextVisor;
                aux = textVisor;
                string = aux;
                aux ="";
            return aux;
            } else if (textNextVisor == "x") {
            operador = textNextVisor;
            aux = textVisor;
            string = aux;
            aux = "";
            return aux;
            }else if (textNextVisor == "√") {
            operador = textNextVisor;
            aux = textVisor;
            string = aux;
            aux = "";
            return aux;
        } else if (operador == "%"){
            return porcentagem();
        } else if (textNextVisor == "=" && textNextVisor !="") {
            if (operador == "+")
                return adicao();
            else if(operador == "-")
                return subtracao();
            else if(operador == "/")
                return divisao();
            else if(operador == "x")
                return multiplicacao();
            else if(operador == "√")
                return raiz();

        } else if (textNextVisor == "=" || textNextVisor =="+" || textNextVisor == "-" || textNextVisor == "x" || textNextVisor == "/"
            || textNextVisor == "√" || textNextVisor == "%" && textNextVisor =="") {
            return "";
        }
        aux = textVisor +textNextVisor;
        return aux;
    }
@Override
    protected void onStop(){
    super.onStop();
    }


}
