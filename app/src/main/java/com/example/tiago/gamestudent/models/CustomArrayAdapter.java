package com.example.tiago.gamestudent.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiago.gamestudent.R;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<CadeiraMenuPrincipal> {

    public CustomArrayAdapter(Context context, ArrayList<CadeiraMenuPrincipal> cadeiras) {
        super(context, 0, cadeiras);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CadeiraMenuPrincipal cadeira = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_linha, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.nome)).setText(cadeira.getNome());
        ((TextView) convertView.findViewById(R.id.pontos)).setText(""+cadeira.getPontos());

        return convertView;
    }

}
