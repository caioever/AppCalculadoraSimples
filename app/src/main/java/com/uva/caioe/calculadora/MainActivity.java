package com.uva.caioe.calculadora;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends MenuActivity {

    //Teclado numerico calculadora
    private EditText etNumber;
    private Button btZero;
    private Button btOne;
    private Button btTwo;
    private Button btThree;
    private Button btFour;
    private Button btFive;
    private Button btSix;
    private Button btSeven;
    private Button btEight;
    private Button btNine;
    private Button btEqualTo;
    private Button btDecimal;
    private Button btClear;
    private Button btDelete;
    private Button btPlus;
    private Button btMinus;
    private Button btMultiply;
    private Button btDivide;
    private TextView tvDisplay;
    private double number;

    //Operações elaboradas
    private Button btSqrt;
    private Button btExp;

    //Botões função calculadora
    private boolean soma;
    private boolean subtracao;
    private boolean multiplicacao;
    private boolean divisao;

    /*private boolean exp;
    private boolean sqrt;*/

    //Layout
    private TableLayout layoutCalculadora;

    private LinearLayout layoutDisplay;

    //Calculadora
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);
        etNumber = (EditText) findViewById(R.id.etNumber);

        layoutDisplay = (LinearLayout) findViewById(R.id.actCalculator_layoutDisplay);
        layoutCalculadora = (TableLayout) findViewById(R.id.layoutCalculadora);

        //botões calculadora
        btZero = (Button) findViewById(R.id.btZero);
        btOne = (Button) findViewById(R.id.btOne);
        btTwo = (Button) findViewById(R.id.btTwo);
        btThree = (Button) findViewById(R.id.btThree);
        btFour = (Button) findViewById(R.id.btFour);
        btFive = (Button) findViewById(R.id.btFive);
        btSix = (Button) findViewById(R.id.btSix);
        btSeven = (Button) findViewById(R.id.btSeven);
        btEight = (Button) findViewById(R.id.btEight);
        btNine = (Button) findViewById(R.id.btNine);
        btDecimal = (Button) findViewById(R.id.btDecimal);
        btEqualTo = (Button) findViewById(R.id.btResult);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        //operações
        btPlus = (Button) findViewById(R.id.btPlus);
        btMultiply = (Button) findViewById(R.id.btMultiply);
        btMinus = (Button) findViewById(R.id.btMinus);
        btDivide = (Button) findViewById(R.id.btDivide);

        /*btSqrt = (Button) findViewById(R.id.btSqrt);
        btExp = (Button) findViewById(R.id.btExp);*/
        //funções
        btClear = (Button) findViewById(R.id.btClear);
        btDelete = (Button) findViewById(R.id.btDelete);

        //Eventos
        etNumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etNumber.setInputType(InputType.TYPE_NULL);
                return false;
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("");
                etNumber.setText("");
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNumber.getText().toString().isEmpty()) {
                    etNumber.setText(etNumber.getText().toString().subSequence(0, etNumber.getText().length() - 1));
                }
            }
        });

        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btOne.getText().toString()));
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btTwo.getText().toString()));
            }
        });

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btThree.getText().toString()));
            }
        });

        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btFour.getText().toString()));
            }
        });

        btFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btFive.getText().toString()));
            }
        });

        btSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btSix.getText().toString()));
            }
        });

        btSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btSeven.getText().toString()));
            }
        });

        btEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btEight.getText().toString()));
            }
        });

        btNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btNine.getText().toString()));
            }
        });

        btZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText(etNumber.getText().toString().concat(btZero.getText().toString()));
            }
        });

        //Realizando operações calculadora simples
        btEqualTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado;
                double lastNumber;

                if (!etNumber.getText().toString().isEmpty()) {
                    lastNumber = getResultFromEquation(etNumber.getText().toString());
                } else {
                    lastNumber = 0;
                }

                Log.e("firstNumber:", String.valueOf(number));
                Log.e("lastNumber:", String.valueOf(lastNumber));

                if (soma) {
                    resultado = lastNumber;
                    Log.e("Resultado", String.valueOf(resultado));
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    etNumber.setText(String.valueOf(resultado));
                    soma = false;
                } else if (multiplicacao) {
                    resultado = lastNumber;
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    etNumber.setText(String.valueOf(resultado));
                    multiplicacao = false;
                } else if (subtracao) {
                    resultado = lastNumber;
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    etNumber.setText(String.valueOf(resultado));
                    subtracao = false;
                } else if (divisao) {
                    resultado = lastNumber;
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    etNumber.setText(String.valueOf(resultado));
                    divisao = false;
                } /*else if (sqrt) {
                    //int Ressqrt = Integer.parseInt(etNumber.getText().toString()); Math.sqrt(Ressqrt);
                    resultado = lastNumber;
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    sqrt = false;
                } else if (exp) {
                    resultado = lastNumber;
                    tvDisplay.append(" " + etNumber.getText().toString() + " " + btEqualTo.getText().toString() + " " + String.valueOf(resultado));
                    sqrt = false;
                }*/

            }
        });

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtracao = true;
                etNumber.setText(etNumber.getText().toString() + " " + btMinus.getText().toString() + " ");
            }
        });

        btDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divisao = true;
                etNumber.setText(etNumber.getText().toString() + " " + "/" + " ");
            }
        });

        btMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicacao = true;
                etNumber.setText(etNumber.getText().toString() + " " + "*" + " ");
            }
        });

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soma = true;
                etNumber.setText(etNumber.getText().toString() + " " + btPlus.getText().toString() + " ");
            }
        });


        btDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNumber.getText().toString().contains(".")) {
                    etNumber.setText(etNumber.getText().toString().concat("."));
                }
            }
        });


       /* btSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqrt = true;
                etNumber.setText("√" + " " + etNumber.getText().toString() + " ");
            }
        });
        btExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp = true;
                etNumber.setText(etNumber.getText().toString() + " " + "^" + " ");
            }
        });*/

    }

    static double getResultFromEquation(String equation) {
        double result = 0.0;
        String noMinus = equation.replace(" - ", "+-");
        String[] byPluses = noMinus.split("\\+");

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");

            double multiplResult = 1.0;

            for (String operand : byMultipl) {
                if (operand.contains("/")) {

                    String[] division = operand.split("\\/");

                    double divident = Double.parseDouble(division[0]);

                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }
}