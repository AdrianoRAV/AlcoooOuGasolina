package com.mora.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool,editPrecoGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.precoAlcool);
        editPrecoGasolina = findViewById(R.id.precoGasolina);
        textoResultado = findViewById(R.id.textResultado);

    }

    public  void calculaPreco(View view)
    {
        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos digitados

        Boolean camposValidados = validarCampos(precoAlcool,precoGasolina);
//        if(  ){
//                // Nesse if colocaria a condição para o valor ser preenchido e no metodo abaixo chama ela
//        }
            if (camposValidados ){

                //convertendo String para números
                Double valorAlcool = Double.parseDouble(precoAlcool);
                Double valorGasolina = Double.parseDouble(precoGasolina);
                Double calculo;
               calculo =  (valorAlcool/valorGasolina);
               if (calculo >= 0.7){
                   textoResultado.setText("Melhor usar gasolina");
               }else{
                   textoResultado.setText("Melhor usar Álcool");
               }
                /*fazer calculo de menor preço
                *se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar o Álcool
                 */

            }else {
                textoResultado.setText("Preencha os preços primeiro!");
            }
    }
    public  Boolean validarCampos(String pAlcool, String pGasolina){
        //public  String validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidadeos = true;
      //  String campo = "preenchido";

        if( pAlcool == null || pAlcool.equals("")){
           // campo = "Àlcool";
            camposValidadeos = false;
        }else
            if( pGasolina == null || pGasolina.equals("")){
           // campo "Gasolina";
            camposValidadeos = false;
        }

        return camposValidadeos;
        //return campo;
    }

}