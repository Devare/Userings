package mx.com.devare.userings;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_plurales;
    Button btn_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentesUI();
        iniciarSetOnClickListener();
    }
    
    private void iniciarComponentesUI() {
        tv_plurales = (TextView) findViewById(R.id.tv_plurales);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);
    }

    private void iniciarSetOnClickListener() {
        btn_buscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_buscar:
                buscarAlumnos();
                break;
        }
    }

    private void buscarAlumnos() {
        Random random = new Random();
        int numAlumnos = random.nextInt(100);
        Resources recurso = getResources();

        if (numAlumnos == 0) {
            tv_plurales.setText(R.string.zero);
        } else {
            String mensaje = recurso.getQuantityString(
                    R.plurals.num_alumnos_encontrados,
                    numAlumnos,
                    numAlumnos);
            tv_plurales.setText(mensaje);
        }
    }
}
