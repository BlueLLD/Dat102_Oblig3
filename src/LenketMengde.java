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
        if (forste == null){
            forste = new Node(element);
            antall++;// ny node satt inn. Antallet må øke
            return;
        }
        if (!inneholder(element)){//Om elementet ikke finnes fra før
            Node currentNode = forste;
            while (currentNode.neste != null){
                currentNode = currentNode.neste;
            }
            currentNode.neste = new Node(element);
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

//    @Override
//    public boolean erLik(MengdeADT<T> annenMengde) {
//        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
//    }

    //Christian
    @Override
    public boolean erLik(MengdeADT<T> annenMengde){
        if (annenMengde.antallElementer() == this.antallElementer()) {
            return this.erDelmengdeAv(annenMengde);
        }
        return false;
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
        //henter ut alle elementer fra annenMengde som array
        T[] andreElementer = annenMengde.tilTabell();
        //Har en tabell med elementer. bruker for-loop for å legge de til
        for (int i = 0; i < andreElementer.length; i++){
            leggTil(andreElementer[i]);
        }
    }

    @Override
    public T fjern(T element) {
        Node gjeldende = forste;
        if (forste.data.equals(element)) {
            T data = forste.data;//Hente data som skal returneres
            forste = forste.neste;
            antall--;
            return data;

        }
        //lager Node forrige slik at forrige og neste kan knyttes sammen
        Node forrige = gjeldende;
        gjeldende = gjeldende.neste;

        //looper oppover nodelisten og sjekker om noen har elementet som skal fjernes
        while(gjeldende != null) {
            if (gjeldende.data.equals(element)) {
                T data = gjeldende.data;//henter data
                forrige.neste = gjeldende.neste;//bypasser gjeldende node
                antall--;
                return data;
            }
            //løkken kjøres videre
            forrige = gjeldende;//flytter forrige en frem
            gjeldende = gjeldende.neste;//flytter gjeldende en frem
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        Node gjeldende = forste;
        //oppretter ny tabell med generisk datatype
        T[] tabell = (T[]) new Object[antall];
        for (int i = 0; i < antall; i++) {
            tabell[i] = gjeldende.data;
            gjeldende = gjeldende.neste;
        }
        return tabell;
    }




}