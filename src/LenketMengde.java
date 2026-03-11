public class LenketMengde<T> implements MengdeADT<T> {

    private class Node {
        T data;//implementerer variabel data av typen generisk T (Verdien)
        Node neste;//og variabel neste av typen Node(peker til neste node)

        Node(T data){//konstruktør med
            this.data = data;//data
            this.neste = null;//og neste satt til null siden den ikke peker på noe ennå
        }

    }
    private Node forste;//den første noden
    private int antall;//antall elementer

    public LenketMengde(){
        forste = null;
        antall = 0;

    }
    @Override
    public void leggTil(T element) {
        if (!inneholder(element)){//Om elementet ikke finnes fra før
            Node nyNode = new Node(element);//lager ny node
            nyNode.neste = forste;//Peker på den gamle første
            forste = nyNode;//første er nå nyNode
            antall++;// ny node satt inn. Antallet må øke
        }
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public int antallElementer() {
        return antall;
    }


    @Override
    public boolean inneholder(T element) {
        Node gjeldende = forste;
        while (gjeldende != null){
            if (gjeldende.data.equals(element)){
                return true;
            }
            gjeldende = gjeldende.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node gjeldende = forste;
        while(gjeldende != null) {
            if (!annenMengde.inneholder(gjeldende.data)) {
                return false;
            }
            gjeldende = gjeldende.neste;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node gjeldende = forste;
        while (gjeldende != null){
            if (annenMengde.inneholder(gjeldende.data)) {
                return false;
            }
            gjeldende = gjeldende.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        LenketMengde<T> lm = new LenketMengde<>();
        Node gjeldende = forste;
        while (gjeldende != null){
            if (annenMengde.inneholder(gjeldende.data)){
                lm.leggTil(gjeldende.data);
            }
            gjeldende = gjeldende.neste;
        }
        return lm;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        LenketMengde<T> lm = new LenketMengde<>();
        Node gjeldende = forste;
        while (gjeldende != null){
            lm.leggTil(gjeldende.data);
            gjeldende = gjeldende.neste;
            }
        lm.leggTilAlleFra(annenMengde);
        return lm;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        LenketMengde<T> lm = new LenketMengde<>();
        Node gjeldende = forste;
        while (gjeldende != null) {
            if (!annenMengde.inneholder(gjeldende.data)) {
                lm.leggTil(gjeldende.data);
            }
            gjeldende = gjeldende.neste;
        }
        return lm;

    }


    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        Node gjeldende = forste;
        if (forste.data.equals(element)) {
            T data = forste.data;
            forste = forste.neste;
            antall--;
            return data;
            //ikke ferdig
        }



        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }




}