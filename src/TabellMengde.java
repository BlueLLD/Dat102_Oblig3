public class TabellMengde<T> implements MengdeADT<T> {

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
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < antall; i++) {
            if (element.equals(elementer[i])) {
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
        if (this.antallElementer() == annenMengde.antallElementer()) {
        return this.erDelmengdeAv(annenMengde);
        }

        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return !this.erDelmengdeAv(annenMengde) && !annenMengde.erDelmengdeAv(this);
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (this.inneholder(elementer[i])) {
                resultat.leggTil(elementer[i]);
            }
        }
        return resultat;
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

        elementer[antall] = element;
        antall++;

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
}
