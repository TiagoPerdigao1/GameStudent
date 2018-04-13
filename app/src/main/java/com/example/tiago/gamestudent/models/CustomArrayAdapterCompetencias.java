package com.example.tiago.gamestudent.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiago.gamestudent.R;

import java.util.ArrayList;

public class CustomArrayAdapterCompetencias extends ArrayAdapter<CompetenciasDoALuno> {
    public CustomArrayAdapterCompetencias(Context context, ArrayList<CompetenciasDoALuno> competencias) {
        super(context, 0, competencias);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CompetenciasDoALuno competencia = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_linha_competencias, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.descricaoCompetencia)).setText(competencia.getDescricao());
        ((TextView) convertView.findViewById(R.id.pontosAcumular)).setText(""+competencia.getPontos_acumular());

        return convertView;
    }

}
