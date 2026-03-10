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
}