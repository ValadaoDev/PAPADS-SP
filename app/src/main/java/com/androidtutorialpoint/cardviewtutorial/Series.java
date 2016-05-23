package com.androidtutorialpoint.cardviewtutorial;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Series extends Fragment {



    public Series() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_series, container, false);

       /* AcessoRest ar = new AcessoRest();

        String chamadaWS = "http://192.168.0.3:23917/WSpap/webresources/series/Lista/Sinopses";
        String resultado = ar.exemploGet(chamadaWS);

        Log.i("JSON",resultado);


        TextView texto = (TextView)myFragmentView.findViewById(R.id.tv_brand);

        texto.setText(resultado); */

        ExpandableListView lista = (ExpandableListView)v.findViewById(R.id.listaExp);
        List<SerieLista> series = new ArrayList<SerieLista>();
        SerieLista b = new SerieLista();
        b.titulo = "BreakingBad";
        SerieLista f = new SerieLista();
        f.titulo = "The flash";
        SerieLista s = new SerieLista();
        s.titulo = "Supernatural";

        series.add(b);
        series.add(f);
        series.add(s);

        List<SerieDetalhada> serieDetalhada = new ArrayList<SerieDetalhada>();
        SerieDetalhada sd = new SerieDetalhada();
        sd.favorito = true;
        sd.imagem = BitmapFactory.decodeResource(getResources(), R.drawable.bb);
        sd.sinopse = "Sinopse: Walter White é um professor de química na casa dos 50 anos que trabalha em uma escola secundária no Novo México. Para atender às necessidades de Skyler, sua esposa grávida, e Walt Junior, seu filho deficiente físico, ele tem que trabalhar duplamente. Sua vida fica ainda mais complicada quando descobre que está sofrendo de um câncer de pulmão incurável. Para aumentar rapidamente a quantidade de dinheiro que deixaria para sua família após sua morte, Walter usa seu conhecimento de química para fazer e vender metanfetamina, uma droga sintética. Ele conta com a ajuda do ex-aluno e pequeno traficante Jesse e enfrenta vários desafios, incluindo o fato de seu concunhado ser um importante nome dentro da Agência Anti-Drogas da região.";
        serieDetalhada.add(sd);

        SerieDetalhada fl = new SerieDetalhada();
        fl.favorito = true;
        fl.sinopse = "Sinopse: Barry Allen (Grant Gustin) era um funcionário da Polícia Científica que, ao sofrer um acidente, foi banhado por produtos químicos em seu laboratório e, em seguida, atingido por um raio. Foi a partir disso que ele começou a ser capaz de canalizar os poderes vindos do \"Campo de Velocidade\", e se locomover em altíssimas velocidades. Usando uma máscara e um uniforme vermelho, ele começa a usar suas habilidades para patrulhar Central City com a ajuda dos cientistas da S.T.A.R. Labs, e detém vilões ao mesmo tempo em que procura descobrir quem foi o assassino de sua mãe.";
        fl.imagem = BitmapFactory.decodeResource(getResources(), R.drawable.flash);
        serieDetalhada.add(fl);

        SerieDetalhada sn = new SerieDetalhada();
        sn.favorito= false;
        sn.sinopse ="Desde que era pequeno, Sam Winchester (Jared Padalecki) tentava escapar do próprio passsado. Após a misteriosa morte de Mary (Samantha Smith), o pai de Sam passou a procurar vingança contra as forças do mal que mataram a esposa, destruindo qualquer ser maligno que cruze o seu caminho. Ao contrário de Sam, Dean (Jensen Ackles), irmão mais velho, sempre quis seguir os passos do pai. Sam está determinado a se livrar do negócio da família, mas sua vida está prestes a tomar os rumos que ele não desejava, quando ele fica sem escolhas a não ser unir-se ao irmão";
        sn.imagem = BitmapFactory.decodeResource(getResources(),R.drawable.supernatural);
        serieDetalhada.add(sn);

        ListaAdapter adaptador = new ListaAdapter(getContext(), series, serieDetalhada);
        lista.setAdapter(adaptador);

    return v;
    }

}
