package com.example.calculadora3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_igual;
    private Button btn_mais;
    private Button btn_menos;
    private Button btn_divisao;
    private Button btn_vezes;

    private TextView Numeros;

    private Integer numero1 = 0;
    private Integer numero2 = 0;
    private String operador = "";

    private static final String TAG = "Print";
    private static String evento = "PRIMEIRO";
    private static String visor = "";
    private static Boolean ja_teve_operador = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);
        btn_0 = findViewById(R.id.button_0);
        btn_mais = findViewById(R.id.button_mais);
        btn_menos = findViewById(R.id.button_menos);
        btn_vezes = findViewById(R.id.button_vezes);
        btn_igual = findViewById(R.id.button_igual);
        btn_divisao = findViewById(R.id.button_divisao);
        Numeros = findViewById(R.id.Numeros);

        btn_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 1;

                realizaOperacao(valor, visor);
            }

        });

        btn_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 2;

                realizaOperacao(valor, visor);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 3;

                realizaOperacao(valor, visor);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 4;

                realizaOperacao(valor, visor);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 5;

                realizaOperacao(valor, visor);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 6;

                realizaOperacao(valor, visor);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 7;

                realizaOperacao(valor, visor);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 8;

                realizaOperacao(valor, visor);
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 9;

                realizaOperacao(valor, visor);
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer valor = 0;

                realizaOperacao(valor, visor);
            }
        });

        btn_mais.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String valor = "MAIS";

                realizaOperacao(valor, visor);
            }
        });

        btn_menos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String valor = "MENOS";

                realizaOperacao(valor, visor);
            }
        });

        btn_vezes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String valor = "VEZES";

                realizaOperacao(valor, visor);
            }
        });

        btn_divisao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String valor = "DIVISAO";

                realizaOperacao(valor, visor);
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String valor = "IGUAL";

                realizaOperacao(valor, visor);
            }
        });

    }

    private void realizaOperacao(Integer valor, String visor) {
        Log.d(TAG, "Operacao");

        String numero = null;

        if (operador.equals("IGUAL")) {
            visor = "";
            operador = "";
        }

        if (evento.equals("PRIMEIRO")) {
            numero = numero1.toString();
            numero += valor.toString();
            numero1 = Integer.parseInt(numero);
            visor += numero1.toString();
        }
        else if (evento.equals("SEGUNDO")) {
            numero = numero2.toString();
            numero += valor.toString();
            numero2 = Integer.parseInt(numero);
            visor += numero2.toString();
        }

        Numeros.setText(visor);
    }

    private void realizaOperacao(String operacao, String visor) {
        Log.d(TAG, "Operacao");
        if (operacao.equals("IGUAL")) {
            if (ja_teve_operador == true) {

                if (operador.equals("MAIS")) {
                    Integer result = numero1 + numero2;
                    visor = result.toString();
                }
                else if (operador.equals("MENOS")) {
                    Integer result = numero1 - numero2;
                    visor = result.toString();
                }
                else if (operador.equals("DIVISAO")) {
                    Boolean executa = true;
                    if (numero1 == 0) {
                        executa = false;
                    }
                    else if (numero2 == 0) {
                        executa = false;
                    }

                    if (executa) {
                        Integer result = numero1 / numero2;
                        visor = result.toString();
                    }
                }
                else if (operador.equals("VEZES")) {
                    Integer result = numero1 * numero2;
                    visor = result.toString();
                }

            }
            ja_teve_operador = false;
            numero1 = 0;
            numero2 = 0;
            evento = "PRIMEIRO";
            operador = "IGUAL";
        }
        else if (operacao.equals("MAIS")) {
            ja_teve_operador = true;
            operador = "MAIS";
            evento = "SEGUNDO";
            visor += "+";
        }
        else if (operacao.equals("MENOS")) {
            ja_teve_operador = true;
            operador = "MENOS";
            evento = "SEGUNDO";
            visor += "-";
        }
        else if (operacao.equals("DIVISAO")) {
            ja_teve_operador = true;
            operador = "DIVISAO";
            evento = "SEGUNDO";
            visor += "/";
        }
        else if (operacao.equals("VEZES")) {
            ja_teve_operador = true;
            operador = "VEZES";
            evento = "SEGUNDO";
            visor += "*";
        }
        Numeros.setText(visor);
    }

}