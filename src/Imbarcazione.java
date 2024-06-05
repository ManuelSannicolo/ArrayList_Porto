public class Imbarcazione {
    private String name = "undefined";
    private String nation="undefined";
    private double lunghezza=0.0;
    private boolean aMotore=false;
    private double stazza=0.0; //in tonnellate

    public Imbarcazione(){};
    public Imbarcazione(String name, String nation, double lungheza, boolean aMotore, double stazza){
        setName(name);
        setNation(nation);
        setLunghezza(lungheza);
        setaMotore(aMotore); 
        setStazza(stazza);
    }


    public Imbarcazione(Imbarcazione imb){
        this(imb.name, imb.nation, imb.lunghezza, imb.aMotore, imb.stazza);
    }


    public double getLunghezza() {
        return lunghezza;
    }

    public String getName() {
        return name;
    }

    public double getStazza() {
        return stazza;
    }


    public boolean getAMotore(){
        return aMotore;
    }


    public String getNation() {
        return nation;
    }


    public void setLunghezza(double lunghezza) {
        if(lunghezza>0)
            this.lunghezza = lunghezza;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setaMotore(boolean aMotore) {
        this.aMotore = aMotore;
    }

    public void setStazza(double stazza) {
        if(stazza>0)
            this.stazza = stazza;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }



    public boolean equals(Object obj){
        boolean result=false;
        if(this==obj)
            result=true;
        else{
            if(obj instanceof Imbarcazione){
                Imbarcazione imb = (Imbarcazione) obj;
                if(imb.name.equalsIgnoreCase(name) && imb.nation.equalsIgnoreCase(nation)){
                    if(imb.lunghezza==lunghezza && imb.stazza==stazza && imb.aMotore==aMotore)
                        result=true;
                }
            }
        }

        return result;
    }


    public String toString(){
        String s="";

        s+=String.format("nome imbarcazione %s", name);
        
        s+=String.format("lunghezza %.2f", lunghezza);
        
        s+=String.format("stazza %.2f", stazza);

        return s;
    }
}

