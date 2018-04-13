package com.example.tiago.gamestudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tiago.gamestudent.models.CadeiraMenuPrincipal;
import com.example.tiago.gamestudent.models.CustomArrayAdapter;
import com.example.tiago.gamestudent.models.CustomArrayAdapterPremios;
import com.example.tiago.gamestudent.models.PremiosDoAluno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PremiosActivity extends AppCompatActivity {

    ArrayList<PremiosDoAluno> arrayItems = new ArrayList<>();
    ListView listview;
    CustomArrayAdapterPremios itemsAdapter;
    //ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premios);

        carregarPremios();

        itemsAdapter = new CustomArrayAdapterPremios(this, arrayItems);
        listview = findViewById(R.id.listaPD);
        this.listview.setAdapter(this.itemsAdapter);

        registerForContextMenu((ListView)findViewById(R.id.listaPD));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ativ_1, menu);
        carregarPremios();
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont_2, menu);
    }


    public void carregarPremios() {

        String url = "http://192.168.1.69/myslim/api/premio/1";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, (response) -> {
                    try {
                        //((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                        JSONArray arr = response.getJSONArray(Utils.param_dados);
                        this.arrayItems.clear();
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            this.arrayItems.add(new PremiosDoAluno(obj.getInt("id"), obj.getString("nome"), obj.getInt("pontos_necessarios")));
                            //Toast.makeText(MenuPrincipalActivity.this, "ola", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(MenuPrincipalActivity.this, obj.getString("aluno") + ";" +
                            //obj.getString("palavrapasse"), Toast.LENGTH_SHORT).show();
                        } //Toast.makeText(MenuPrincipalActivity.this, "ola", Toast.LENGTH_SHORT).show();
                        this.itemsAdapter.notifyDataSetChanged();
                    } catch (JSONException ex) {
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ((TextView) findViewById(R.id.texto)).setText(error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        /*
        //De uma string apenas
        String url = "http://192.168.1.120/myslim/api/aluno/1";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ((TextView) findViewById(R.id.texto)).setText(response.getString("nome"));
                        } catch (JSONException ex) {
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ((TextView) findViewById(R.id.texto)).setText(error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
        */

    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.editar:
                Toast.makeText(this, "Carregou em 'Remover'", Toast.LENGTH_SHORT ).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
