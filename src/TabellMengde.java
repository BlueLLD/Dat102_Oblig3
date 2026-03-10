
public class TabellMengde<T> implements MengdeADT<T> {
    //husker å ta med <T>

    private T[] elementer;//implementerer tabell elementer med generisk datatype
    private int antall;//og tallet antall

    public TabellMengde() {
        /*lager en tabell med ti plasser av typen T.
         * bruker Object[10] siden java ikke vil ha antallet
         * inne i (T[])*/
        elementer = (T[]) new Object[10];
        antall = 0;
    }


    @Override
    public boolean erTom() {
        if (antall == 0) {
            return true;
        } else {
            return false;
        }
       /*Kan og skrives
       return antall==0, som gir true
        om den er 0 og false ellers*/
    }

    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < antall; i++) {
            if (elementer[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(elementer[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }// den ene er delmengde av den andre og omvendt.

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(elementer[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(elementer[i])) {
                resultat.leggTil(elementer[i]);
            }
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            resultat.leggTil(elementer[i]);
        }
        T[] andreElementer = annenMengde.tilTabell();
        for (int i = 0; i < andreElementer.length; i++) {
            resultat.leggTil(andreElementer[i]);

        }
        return resultat;


    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(elementer[i])) {
                resultat.leggTil(elementer[i]);
            }
        }

        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {//om det ikke allerede finnes
            elementer[antall] = element;//legger elementet på første ledige plass i elementer-tabell
            antall++;
        }
    }


    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde){
        //Henter ut elementene via tilTabell
        T[] andreElementer = annenMengde.tilTabell();
        //looper gjennom alle elementene i den nye tabellen
        for (int i = 0; i < andreElementer.length; i++) {
            //bruker medoden leggTil som allerede sjekker om det finnes fra før eller ikke
            leggTil(andreElementer[i]);

        }
    }

    @Override
    public T fjern(T element){
        for (int i = 0; i < antall; i++){
            if(element.equals(elementer[i])){
                T data = elementer[i];
                /*setter elementet på index lik siste element i loopen
                Man bytter ut det man skal slette med det siste tallet
                i tabellen og sletter det siste tallet. Altså nesten som
                med en temp. Hvis plass 2 skal slettes, tar man siste element,
                kopierer over til plass to og sletter siste plass.*/
                elementer[i] = elementer[antall - 1];
                //sletter element på siste plass
                elementer[antall - 1] = null;
                //Forkorter antallet plasser
                antall--;
                //returnerer det som ble slettet
                return data;
            }


        }return null;
    }

    @Override
    public T[] tilTabell() {
        //lager ny tabell fra konstruktøren med antall plasser lik antall
        T[] tabell = (T[]) new Object[antall];
        for (int i = 0; i < antall; i++) {
            //looper gjennom og setter alle plasser i den nye tabellen lik
            //plassene i elementer (fra konstruktør)
            tabell[i] = elementer[i];
        }
        return tabell;
    }

    @Override
    public int antallElementer(){
        //Har allerede antall i konstruktøren
        return antall;
    }



}
