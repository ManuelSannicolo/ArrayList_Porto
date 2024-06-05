import java.util.*;
public class Porto {
    private ArrayList<Imbarcazione> porto;
    private final double costoVela = 10;
    private final double costoMotore = 20;
    private String statoPorto="aperto";

    public Porto(){
        this(30);
    }

    public Porto (int inizializzazione){
        if(inizializzazione>20)
            porto=new ArrayList<>(inizializzazione);
        else
            porto=new ArrayList<>(20);
        inizializzazioneNull();
    }


    public Porto(Porto other){
        for(Imbarcazione imb : other.porto)
            addImbarcazione( new Imbarcazione(imb));
    }


    public String getStatoPorto() {
        return statoPorto;
    }


    public int getDimensione(){
        return porto.size();
    }

    public int getNumeroBarche(){
        int conta=0;
        for(Imbarcazione imb : porto){
            if(imb!=null)
                conta++;
        }

        return conta;
    }


    public Imbarcazione getImbarcazione(int pos){
        if(porto.get(pos)!=null)
            return new Imbarcazione (porto.get(pos));
        return null;
    }


    public void setStatoPorto(String statoPorto) {
        this.statoPorto = statoPorto;
    }

    public void addImbarcazione(Imbarcazione imb){
        if(imb !=null){
            int pos = puòOspitare(imb);
            if(pos!=-1)
                porto.set(pos, imb);
        }
    }


    private void inizializzazioneNull(){
        for (int i = 0; i < porto.size(); i++) {
            porto.set(i, null);
        }
    }


    private int puòOspitare(Imbarcazione imb){
        int pos = -1; 
        double lunghezza = imb.getLunghezza();
        int start=0;
        int finish=0;
        if(lunghezza>10){
            start=21;
            finish=getDimensione();
        }else{
            start=0;
            finish=20;
        }

        for(int i = start; i<finish; i++){
            if(porto.get(i)==null)
                pos=i;
        }

        return pos;
    }

    public double calcPrezzoVela (Imbarcazione imb, int giorni){
        if(giorni>0)
            return imb.getLunghezza()*costoVela*giorni;
        
        return 0.0;
    }

    public double calcPrezzoMotore (Imbarcazione imb, int giorni){
        if(giorni>0)
            return imb.getStazza()*costoMotore*giorni;
        
        return 0.0;
    }

    public double liberaPorto(Imbarcazione imb, int giorni){
        double prezzo=0.0;
        if(imb != null && porto.indexOf(imb) != -1){
            if(imb.getAMotore())
                 prezzo=calcPrezzoVela(imb, giorni);
            else
                prezzo=calcPrezzoMotore(imb, giorni);
            
            porto.set(porto.indexOf(imb), null);
        }
        return prezzo;
    }


    public Porto ricercaNazionalità(String nation){
        Porto result = new Porto(porto.size());

        for(Imbarcazione imb : porto){
            if(imb.getNation().equalsIgnoreCase(nation))
                result.addImbarcazione(imb);
        }
        return result;
    }

     



    public boolean equals(Object obj){
        boolean result=false;
        if(this==obj)
            result=true;
        else{
            if(obj instanceof Porto){
                Porto other = (Porto) obj;
                if(other.getNumeroBarche() == getNumeroBarche()){
                    if(porto.containsAll(other.porto))
                        result=true;
                }
            }
        }
        return result;
    }


    public String toString(){
        String s="";

        int pos=0;
        for (Imbarcazione imb : porto){
            s+=pos+". ";
            s+=imb;
        }

        return s;
    }




}
