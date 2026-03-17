package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JavaSetToMengde <T> implements MengdeADT<T> {
	HashSet<T> set = new HashSet<>();

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
		for(T element : set){
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
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> snitt = new JavaSetToMengde<>();
		for(T element : tilTabell()){
			if(annenMengde.inneholder(element)){
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> union = new JavaSetToMengde<>();
		union.leggTilAlleFra(this);
		union.leggTilAlleFra(annenMengde);
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> copy = new JavaSetToMengde<>();
		copy.leggTilAlleFra(this);
		for(T element : annenMengde.tilTabell()){
			copy.fjern(element);
		}
		return copy;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		set.addAll(List.of(annenMengde.tilTabell()));
	}

	@Override
	public T fjern(T element) {
		set.remove(element);
		return element;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] tilTabell() {
		return (T[]) set.toArray(Object[]::new);
	}

	@Override
	public int antallElementer() {
		return set.size();
	}
}
