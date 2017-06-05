package itesm.mx.m1_jbbm_labo_login;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsuario;
    EditText etContrasena;
    EditText etConfirmarCntrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        etUsuario = (EditText)findViewById(R.id.edit_usuario);
        etContrasena = (EditText)findViewById(R.id.edit_contrasena);
        etConfirmarCntrasena = (EditText)findViewById((R.id.edit_confirmar_contrasena));

        Button registarse  = (Button) findViewById(R.id.button_registrarse);
        registarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(etUsuario.getText() != null&& etContrasena.getText() != null &&
                etConfirmarCntrasena.getText() != null && etContrasena.getText().toString().equals(
                etConfirmarCntrasena.getText().toString())){
            Toast.makeText(this.getApplicationContext(),"El usuario se a registrado exitosamente",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent();
            intent.putExtra("usuario", etUsuario.getText().toString());
            intent.putExtra("contrasena", etContrasena.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Datos de acceso incorrectos",
                    Toast.LENGTH_LONG).show();
        }
    }
}
