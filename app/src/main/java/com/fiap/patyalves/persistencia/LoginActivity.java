package com.fiap.patyalves.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenha;
    private CheckBox cbContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        etUsuario=(EditText)findViewById(R.id.etUsuario);
        etSenha=(EditText)findViewById(R.id.etSenha);
        cbContinuar=(CheckBox)findViewById(R.id.cbContinuar);
        ler();
    }

    public void login(View v){
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        if(cbContinuar.isChecked()){
            e.putString("usuario",etUsuario.getText().toString());
            e.putString("senha",etSenha.getText().toString());
            e.putBoolean("manterConecado",cbContinuar.isChecked());

            Toast.makeText(this, "Dados salvos", Toast.LENGTH_SHORT).show();
        }else{
            e.putString("usuario","");
            e.putString("senha","");
            e.putBoolean("manterConecado",false);
        }
        e.apply();
    }
    public void ler(){
        SharedPreferences sp= getPreferences(MODE_PRIVATE);
       // String username=sp.getString("usuario", null);
        System.out.println(sp.getString("usuario", null));
        etUsuario.setText(sp.getString("usuario", ""));
        etSenha.setText(sp.getString("senha",""));
        cbContinuar.setChecked(sp.getBoolean("manterConecado",false));
      //  Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

    }
}
