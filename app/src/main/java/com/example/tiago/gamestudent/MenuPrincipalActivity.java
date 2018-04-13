package com.example.tiago.gamestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tiago.gamestudent.models.CadeiraMenuPrincipal;
import com.example.tiago.gamestudent.models.CustomArrayAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuPrincipalActivity extends AppCompatActivity {

    ArrayList<CadeiraMenuPrincipal> arrayItems = new ArrayList<>();
    ListView listview;
    CustomArrayAdapter itemsAdapter;
    //ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        itemsAdapter = new CustomArrayAdapter(this, arrayItems);
        listview = findViewById(R.id.lista);
        this.listview.setAdapter(this.itemsAdapter);

        carregarCadeiras();

        registerForContextMenu((ListView)findViewById(R.id.lista));
    }

    //public void fillLista(){
     //   ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

    //}

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont_1, menu);
    }


    public void carregarCadeiras() {

        String url = "http://192.168.1.69/myslim/api/testecadeirasinscritas";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, (response) -> {
                    try {
                        //((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                        JSONArray arr = response.getJSONArray(Utils.param_dados);
                        this.arrayItems.clear();
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            this.arrayItems.add(new CadeiraMenuPrincipal(obj.getInt("id"), obj.getString("nome"), obj.getInt("pontos")));
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

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position + 1;
        Toast.makeText(this, "Carregou na posicao " + listPosition, Toast.LENGTH_SHORT ).show();
        switch (item.getItemId()) {
            case R.id.reclamarPremio:

                Intent intent = new Intent(this, PremiosActivity.class);
                intent.putExtra("chavePremio",listPosition);
                startActivity(intent);
                Toast.makeText(this, "Carregou em 'Remover'", Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.solicitarCompetencia:
                Intent intent2 = new Intent(this, CompetenciasActivity.class);
                intent2.putExtra("chaveCompetencia",listPosition);
                startActivity(intent2);
                Toast.makeText(this, "Carregou em 'Remover'", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    }
