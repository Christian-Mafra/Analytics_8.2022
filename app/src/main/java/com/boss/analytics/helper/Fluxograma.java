package com.boss.analytics.helper;

import com.boss.analytics.R;

public class Fluxograma {
    private String passo;
    private String exp;
    private String txtAzul;
    private String txtAmarelo;
    private String resultado;
    private int img;
    private String nome;


    private String resultadoG1[] = {
            "Não há "
    };



    public int getImg(int i) {
        if(i==1){img = R.drawable.cloretoprata;}
        if(i==2){img = R.drawable.centrifuga;}
        if(i==3){img = R.drawable.dicrtomatodechumbo;}
        if(i==4){img = R.drawable.mercuriozero;}
        if(i==5){img = R.drawable.centrifuga;}
        if(i==6){img = R.drawable.cloretoprata;}
        return img;
    }

    public String getPasso(int i) {
        passo = "Passo "+i;
        return passo;
    }
    public String getNome(int i) {
        if(i==1){nome="Cloretos insolúveis";}
        if(i==2){nome="Sulfetos insolúveis em meio ácido";};
        if(i==3){nome="Sulfetos insolúveis em meio básico";}
        if(i==4){nome="Carbonatos insolúveis";}
        if(i==5){nome="Cátions solúveis";}
        return nome;
    }

    public String getTxtAzul(int i) {
        if(i==1){txtAzul="Em 1mL de amostra adicione 2mL de HCl 3 molar";}
        if(i==2){txtAzul="Promova a separação entre o sobrenadante e o precipitado";};
        if(i==3){txtAzul="Ao sobrenadante, adicione 3 gotas de K2CrO4 3 molar";}
        if(i==4){txtAzul="Ao precipitado, adicione 8 gotas de NH4OH concentrado";}
        if(i==5){txtAzul="Promova a separação entre o sobrenadante e o precipitado";}
        if(i==6){txtAzul="Ao sobrenadante, adicione 3mL de HNO3 concentrado e 1mL de NaCl";}

        return txtAzul;
    }

    public String getExp(int i) {
        if(i==1){exp="Os cátions do Grupo 1 são identificados pela adição do ácido clorídrico diluído," +
                " já que a Ag+, Pb2+ e Hg22+ formam precipitado ao entrar em contato com o íon cloreto," +
                " independentemente do valor de pH.";}
        if(i==2){exp="Observando a formação de um sólido branco, promova a centrifugação. " +
                "Separe o sobrenadante em um tubo e reserve, pois neste pode conter cátions dos grupos 2, 3, 4 e 5.\n \n " +
                "Ao precipitado adicione água destilada aquecida à 100ºC e agite ultilizando um bastão de vidro.\n \n" +
                "Novamente, leve o tubo de ensaio para a centrífuga e separe o sobrenadante do precipidado.";}
        if(i==3){exp="Nesta etapa, os íons Ag+ e Hg22+ já não compõe mais o sobrenadante, visto que estes mantiveram-se insolúveis " +
                "à 100ºC e foram separados na centrifugação. \n\n" +
                "Ao reagir cromato de potássio com íons de Pb2+, é formado o cromato de chumbo (II) (PbCrO4) que possui cor amarela";}
        if(i==4){exp="Ao adicionar NH4OH em uma mistura contendo o sal de cloreto de mercúrio (I), " +
                "haverá uma reação de oxirredução, onde ocorre o desproporcionamento do Hg+, que se reduz a Hg0(l) e " +
                "se oxida a HgNH2Cl(s), que é chamado de amidocloreto de mercúrio. Visualmente há a predominância da cor preta, " +
                "entretanto, estes precipitados possuem cores destintas. O Hg0 apresenta coloração preta enquanto o " +
                "amidocloreto de mercúrio (II) apresenta a coloração cinza.\n\n" +
                "Diferente do mercúrio, a prata forma um complexo solúvel ao reagir com o hidróxido de amônia";}
        if(i==5){exp="Observando a formação de um sólido preto, leve a mistura para a centrífuga e separe o sobrenadante do precipidado. \n" +
                "Separe o sobrenadante em um tubo e reserve, pois ele será necessário para o próximo passo.";}
        if(i==6){exp= "Como foi informado no item anterior, o complexo formado entre a amônia e a prata é solúvel, portanto," +
                " é necessário desfazer este complexo para promover a precipitação da prata. Ao adicionar o ácido nítrico," +
                " os ligantes amônia do complexo são protonados, se desligando do complexo na forma de íons amônio. " +
                "Dessa forma, os íons Ag+ ficam livres para reagir com o coreto oriundo do NaCl, gerando precipitado de AgCl.";}
        return exp;
    }

    public String getTxtAmarelo(int i) {
        if(i==1){txtAmarelo="Formou um precipitado branco?";}
        if(i==2){txtAmarelo="Formou um precipitado amarelo?";};
        if(i==3){txtAmarelo="Formou um precipitado preto?";}
        if(i==4){txtAmarelo="Formou um precipitado branco?";}
        if(i==5){txtAmarelo="Promova a separação entre o sobrenadante e o precipitado";}
        if(i==6){txtAmarelo="Ao sobrenadante, adicione 3mL de HNO3 concentrado e 1mL de NaCl";}



        return txtAmarelo;
    }

    public String getResultado(int i) {
        resultado = resultadoG1[i-1];
        return resultado;
    }

}

