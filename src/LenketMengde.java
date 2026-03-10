public class LenketMengde<T> implements MengdeADT<T> {

    @Override
    public boolean erTom() {
        return false;
    }

    @Override
    public boolean inneholder(T element) {
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return 0;
    }

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
}