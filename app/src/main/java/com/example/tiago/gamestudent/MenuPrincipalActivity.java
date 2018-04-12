package com.example.tiago.gamestudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public void clickBotao2(View v) {

        String url = "https://tiagocepa.000webhostapp.com/myslim/api/cidadesdetalhe";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, (response) -> {
                    try {
                        ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                        JSONArray arr = response.getJSONArray(Utils.param_dados);
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            Toast.makeText(this, obj.getString("cidade") + ";" +
                                    obj.getString("pais"), Toast.LENGTH_SHORT).show();
                        }
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
    }

}
