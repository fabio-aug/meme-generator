package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class NovoTextoActivity extends AppCompatActivity {
    public static String EXTRA_TEXTO_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual";
    public static String EXTRA_NOVO_TEXTO = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto";
    public static String EXTRA_FONTE_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.fonte_atual";
    public static String EXTRA_FONTE_NOVA = "br.ifmg.edu.bsi.progmovel.shareimage1.fonte_nova";
    private EditText etTexto;
    private TextView fontSizeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_texto);

        etTexto = findViewById(R.id.etTexto);
        fontSizeView = (TextView) findViewById(R.id.font_size_view);

        Intent intent = getIntent();
        String textoAtual = intent.getStringExtra(EXTRA_TEXTO_ATUAL);
        etTexto.setText(textoAtual);

        String fontSizeAtual = Float.toString(intent.getFloatExtra(EXTRA_FONTE_ATUAL, 0));
        fontSizeView.setText(fontSizeAtual);
    }

    public void enviarNovoTexto(View v) {
        String novoTexto = etTexto.getText().toString();
        float currentFont = Float.parseFloat(fontSizeView.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVO_TEXTO, novoTexto);
        intent.putExtra(EXTRA_FONTE_NOVA, currentFont);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void increaseFont(View v) {
        float currentFont = Float.parseFloat(fontSizeView.getText().toString());
        String fontSizeAtual = Float.toString(currentFont + 1);
        fontSizeView.setText(fontSizeAtual);
    }

    public void dencrementFont(View v) {
        float currentFont = Float.parseFloat(fontSizeView.getText().toString());
        String fontSizeAtual = Float.toString(currentFont - 1);
        fontSizeView.setText(fontSizeAtual);
    }
}