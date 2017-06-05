package itesm.mx.m1_jbbm_labo_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario;
    EditText etCotrasena;

    String usuario;
    String contrasena;

    static final int REQUEST_CODE_REGISTRAR = 1;
    static final int REQUEST_CODE_RECUPERAR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText)findViewById(R.id.edit_usuario);
        etCotrasena = (EditText)findViewById(R.id.edit_contrasena);
        TextView tcRecuperar = (TextView)findViewById(R.id.text_recuperar_contrasena);
        Button btnIniciarSesion = (Button)findViewById(R.id.button_iniciar_sesion);
        Button btnRegistrarse = (Button)findViewById(R.id.button_registrarse);

        btnIniciarSesion.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this);
        tcRecuperar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent;

        switch (v.getId()){
            case R.id.button_iniciar_sesion:
                intent = new Intent(MainActivity.this, IniciarSesionActivity.class);

                if((etUsuario.getText().toString().equals(usuario) && usuario != null) &&
                        (etCotrasena.getText().toString().equals(contrasena) &&
                                contrasena != null)){
                    intent.putExtra("usuario", usuario);
                    intent.putExtra("contrasena", contrasena);
                    startActivity(intent);
                }else {
                    Toast.makeText(this.getApplicationContext(), "Datos de acceso incorrectos",
                            Toast.LENGTH_LONG).show();
                    etUsuario.requestFocus();
                }
                break;
            case R.id.button_registrarse:
                intent = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTRAR);
                break;
            case R.id.text_recuperar_contrasena:
                if(usuario != null && contrasena != null){
                    intent = new Intent(MainActivity.this, ModificarContrasenaActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_RECUPERAR);
                    break;
                }else{
                    Toast.makeText(this.getApplicationContext(), "No existe usuario registrado",
                            Toast.LENGTH_LONG).show();
                    etUsuario.requestFocus();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_REGISTRAR){
                Bundle datos = data.getExtras();
                usuario = datos.getString("usuario");
                contrasena = datos.getString("contrasena");
            }else if(requestCode == REQUEST_CODE_RECUPERAR){
                Bundle datos = data.getExtras();
                contrasena = datos.getString("contrasena");
            }
        }
    }
}
