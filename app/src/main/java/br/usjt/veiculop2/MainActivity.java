package br.usjt.veiculop2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import br.usjt.veiculop2.R;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerAno;
    Spinner spinnerMarca;
    Spinner spinnerCategoria;
    Button btnConsultar;
    String categoria, marca, ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews() {
        ano = "";
        marca = "";
        categoria = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        spinnerAno = (Spinner) findViewById(R.id.dropdown_anos);
        spinnerAno.setOnItemSelectedListener(new AnoSelecionado());
        spinnerMarca = (Spinner) findViewById(R.id.dropdown_marcas);
        spinnerMarca.setOnItemSelectedListener(new MarcaSelecionada());
        spinnerCategoria = (Spinner) findViewById(R.id.dropdown_categorias);
        spinnerCategoria.setOnItemSelectedListener(new CategoriaSelecionado());
    }

    private class AnoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ano = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class MarcaSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            marca = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class CategoriaSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            categoria = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String MARCA = "br.usjt.MARCA";
    public final static String CATEGORIA = "br.usjt.CATEGORIA";
    public final static String ANO = "br.usjt.ANO";
    public final static String MODO = "br.usjt.MODO";
    public final static String SIMPLES = "br.usjt.SIMPLES";
    public final static String MELHOR = "br.usjt.MELHOR";
    //será chamado quando o usuário clicar em enviar
    public void consultarVeiculos(View view) {
        consultar(view, SIMPLES);
    }

    public void consultarVeiculosMelhor(View view) {
        consultar(view, MELHOR);
    }

    public void consultar(View view, String modo){
        String pAno = this.ano.equals("Escolha o ano")?"":ano;
        String pMarca = this.marca.equals("Escolha a marca")?"":marca;
        String pCategoria = this.categoria.equals("Escolha a categoria")?"":categoria;

        Intent intent = new Intent(this, ListaVeiculoActivity.class);
        intent.putExtra(MARCA, pMarca);
        intent.putExtra(CATEGORIA, pCategoria);
        intent.putExtra(ANO, pAno);
        intent.putExtra(MODO, modo);
        startActivity(intent);
    }

}
