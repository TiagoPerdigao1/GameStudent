package com.example.tiago.gamestudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ativ_1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.opcao1:
                Toast.makeText(this, "Opção 1 selecionada!", Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.opcao2:
                Toast.makeText(this, "Opção 2 selecionada!", Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.opcao3:
                Toast.makeText(this, "Opção 3 selecionada!", Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.opcao4:
                Toast.makeText(this, "Opção 4 selecionada!", Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.opcao5:
                Toast.makeText(this, "Opção 5 selecionada!", Toast.LENGTH_SHORT ).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
