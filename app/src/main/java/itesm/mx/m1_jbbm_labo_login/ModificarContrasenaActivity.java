package itesm.mx.m1_jbbm_labo_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarContrasenaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etContrasena;
    EditText etConfirmarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contrasena);

        etContrasena = (EditText)findViewById(R.id.edit_contrasena);
        etConfirmarContrasena = (EditText)findViewById(R.id.edit_confirmar_contrasena);
        Button btnAceptar = (Button)findViewById(R.id.button_aceptar);

        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(etContrasena.getText().toString().equals(etConfirmarContrasena.getText().toString())){
            Intent intent = new Intent();
            intent.putExtra("contrasena", etContrasena.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Contraseñas no coinciden",
                    Toast.LENGTH_LONG).show();
        }
    }
}
