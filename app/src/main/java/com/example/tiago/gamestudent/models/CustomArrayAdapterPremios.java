package com.example.tiago.gamestudent.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiago.gamestudent.R;

import java.util.ArrayList;

public class CustomArrayAdapterPremios extends ArrayAdapter<PremiosDoAluno> {
    public CustomArrayAdapterPremios(Context context, ArrayList<PremiosDoAluno> premios) {
        super(context, 0, premios);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PremiosDoAluno premio = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_linha_premios, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.nomePremio)).setText(premio.getNome());
        ((TextView) convertView.findViewById(R.id.pontosPremio)).setText(""+premio.getPontos_necessarios());

        return convertView;
    }

}
