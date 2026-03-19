/**
 * THIS IS NOT PART OF THE ASSIGNMENT
 * This is just a class made for fun to see how easy it is to implement an abstract class for MengdeADT
 * @param <T> Containing type
 * @param <S> Self
 */
public abstract class AbstractMengde <T, S extends AbstractMengde<T,S>> implements MengdeADT<T> {
	abstract <C extends AbstractMengde<T, S>> C construct();

	@Override
	public boolean erTom() {
		return antallElementer() == 0;
	}

	@Override
	public boolean inneholder(T element) {
		for(T ourElement : tilTabell()){
			if(ourElement.equals(element)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for(T element : tilTabell()){
			if(!annenMengde.inneholder(element)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		return annenMengde.antallElementer() == antallElementer() && erDelmengdeAv(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(T element : tilTabell()){
			if(annenMengde.inneholder(element)){
				return false;
			}
		}
		return true;
	}

	@Override
	public S snitt(MengdeADT<T> annenMengde) {
		S snitt = construct();
		for(T element : tilTabell()){
			if(annenMengde.inneholder(element)){
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public S union(MengdeADT<T> annenMengde) {
		S union = construct();
		union.leggTilAlleFra(this);
		union.leggTilAlleFra(annenMengde);
		return union;
	}

	@Override
	public S minus(MengdeADT<T> annenMengde) {
		S copy = construct();
		copy.leggTilAlleFra(this);
		for(T element : annenMengde.tilTabell()){
			copy.fjern(element);
		}
		return copy;
	}

	@Override
	public abstract void leggTil(T element);

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(T element : annenMengde.tilTabell()){
			leggTil(element);
		}
	}

	@Override
	public abstract T fjern(T element);

	@Override
	public abstract T[] tilTabell();

	@Override
	public abstract int antallElementer();
}