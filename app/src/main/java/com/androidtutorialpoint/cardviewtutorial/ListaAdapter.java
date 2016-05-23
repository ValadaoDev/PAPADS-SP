package com.androidtutorialpoint.cardviewtutorial;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by renat on 22/05/2016.
 */
public class ListaAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<SerieLista> series;
    private List<SerieDetalhada> seriesDetalhadas;
    public ListaAdapter(Context context, List<SerieLista> series, List<SerieDetalhada> seriesDetalhadas){
        this.context = context;
        this.series = series;
        this.seriesDetalhadas = seriesDetalhadas;
    }
    @Override
    public int getGroupCount() {
        return series.size();
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }
    @Override
    public Object getGroup(int groupPosition) {
        return series.get(groupPosition);
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return seriesDetalhadas.get(childPosition);
    }
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(context, R.layout.list_grupo, null);
        }
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        SerieLista serie = series.get(groupPosition);
        titulo.setText(serie.titulo);
        return convertView;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(context, R.layout.list_item, null);
        }
        CheckBox favorito = (CheckBox) convertView.findViewById(R.id.favorito);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView sinopse = (TextView) convertView.findViewById(R.id.sinopse);
        ImageView imagem = (ImageView) convertView.findViewById(R.id.imagem);
        SerieDetalhada serieDetalhada = seriesDetalhadas.get(groupPosition);
        favorito.setChecked(serieDetalhada.favorito);
        titulo.setText(serieDetalhada.titulo);
        sinopse.setText(serieDetalhada.sinopse);
        imagem.setImageBitmap(serieDetalhada.imagem);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
