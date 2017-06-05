package itesm.mx.m1_jbbm_labo_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class IniciarSesionActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvUsuario;
    TextView tvContrasena;
    TextView tvBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        tvBienvenida = (TextView)findViewById(R.id.text_bienvenida);
        tvUsuario = (TextView)findViewById(R.id.text_usuario);
        tvContrasena = (TextView)findViewById(R.id.text_contrasena);
        Button btnSalir = (Button)findViewById(R.id.button_salir);

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            tvUsuario.setText("Usuario:" + bundle.getString("usuario"));
            tvContrasena.setText("Contraseña:" + bundle.getString("contrasena"));
            tvBienvenida.setText("Bienvenido " + bundle.getString("usuario"));
        }

        btnSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Toast.makeText(this.getApplicationContext(), "Su sesión ha terminado",
                Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this.getApplicationContext(), "Su sesión ha terminado",
                    Toast.LENGTH_LONG).show();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
