import java.util.*;

public class JavaSetToMengde<T> implements MengdeADT<T> {
    private final Set<T> set;

    JavaSetToMengde() {
        set =  new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : set) {
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
            return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }


    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : set) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new JavaSetToMengde<>();

        for (T element : set) {
            if (annenMengde.inneholder(element)) {
                resultat.leggTil(element);
            }
        }

        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new JavaSetToMengde<>();
        for (T element : set) {
            resultat.leggTil(element);
        }
        for (T element : annenMengde.tilTabell()) {
            if (!set.contains(element)) {
                resultat.leggTil(element);
            }
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        JavaSetToMengde<T> nyMengde = new JavaSetToMengde<>();
        //set - annenmengde = svar
        for (T element : set) {
            if (!annenMengde.inneholder(element)) {
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }



    @Override
    public void leggTil(T element) {
        set.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] andreElementer = annenMengde.tilTabell();
        for (T element : andreElementer) {
            leggTil(element); //Fra add-metode. set.add sjekker om det er der fra før
        }
    }

    @Override
    public T fjern(T element) {
        if (set.remove(element)){
            return element;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        //setter størrelsen på array ved [set.size()]
        //set.size returnerer antall elementer i settet.
        T[] tabell = (T[]) new Object[set.size()];
        int i = 0;
        for (T element : set) {
            tabell[i] = element;
            i++;
        }

        return tabell;
    }

    @Override
    public int antallElementer() {
        return set.size();
    }
}
