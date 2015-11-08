package br.usjt.veiculop2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import br.usjt.veiculop2.R;

public class ListaVeiculoActivity extends ActionBarActivity {
    ListView listView;
    Activity atividade;
    public final static String VEICULO = "br.usjt.VEICULO";
    Veiculo[] veiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculo);
        atividade = this;

        Especialista especialista = new Especialista();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String marca = intent.getStringExtra(MainActivity.MARCA);
        String categoria = intent.getStringExtra(MainActivity.CATEGORIA);
        String ano = intent.getStringExtra(MainActivity.ANO);
        String modo = intent.getStringExtra(MainActivity.MODO);

        veiculos = especialista.listarMarcas(ano, marca, categoria).toArray(new Veiculo[0]);
        String[] lista = null;

        if(modo.equals(MainActivity.SIMPLES)) {
            lista = new String[veiculos.length];

            for (int i = 0; i < veiculos.length; i++) {
                lista[i] = veiculos[i].getModelo();
            }
        }
        //cria a lista de veiculos
        listView = (ListView) findViewById(R.id.view_lista_veiculo);
        BaseAdapter adapter;
        if(modo.equals(MainActivity.SIMPLES)) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        } else {
            adapter = new VeiculoAdapter(this, veiculos);
        }
        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheVeiculoActivity.class);
                intent.putExtra(VEICULO, veiculos[position]);

                startActivity(intent);

            }

        });
    }

}