package br.usjt.veiculop2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DetalheVeiculoActivity extends ActionBarActivity {
    TextView veiculoModelo;
    ImageView veiculoImageView;
    TextView veiculoKmlivre;
    TextView veiculoAno;
    TextView veiculoMarca;
    TextView veiculoCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_veiculo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaVeiculoActivity.VEICULO);
        Veiculo veiculo = (Veiculo)obj;
        setupViews(veiculo);

    }

    private void setupViews(Veiculo veiculo) {
        veiculoModelo = (TextView) findViewById(R.id.txt_veiculo_modelo);
        veiculoModelo.setText(veiculo.getModelo());
        veiculoImageView = (ImageView) findViewById(R.id.veiculo_image_view);
        Drawable drawable = Util.getDrawable(this, veiculo.getImagem());
        veiculoImageView.setImageDrawable(drawable);
        veiculoKmlivre = (TextView) findViewById(R.id.txt_veiculo_kmlivre);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        veiculoKmlivre.setText(""+formatter.format(veiculo.getKmlivre()));
        veiculoAno = (TextView) findViewById(R.id.txt_veiculo_ano);
        veiculoAno.setText(veiculo.getAno());
        veiculoMarca = (TextView) findViewById(R.id.txt_veiculo_marca);
        veiculoMarca.setText(veiculo.getMarca());
        veiculoCategoria = (TextView) findViewById(R.id.txt_veiculo_categoria);
        veiculoCategoria.setText(veiculo.getCategoria());
    }

}
