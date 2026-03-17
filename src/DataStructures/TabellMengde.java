package DataStructures;

import java.util.Arrays;

public class TabellMengde <T> implements MengdeADT<T> {
	private T[] array;
	public TabellMengde(){
		this(10);
	}

	@SuppressWarnings("unchecked")
	private TabellMengde(int size){
		array = (T[])new Object[size];
	}

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
		return antallElementer() == annenMengde.antallElementer() && erDelmengdeAv(annenMengde);
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
		TabellMengde<T> snitt = new TabellMengde<>();
		for(T element : tilTabell()){
			if(annenMengde.inneholder(element)){
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		TabellMengde<T> copy = new TabellMengde<>(this.antallElementer());
		copy.leggTilAlleFra(this);
		for(T element : annenMengde.tilTabell()){
			copy.leggTil(element);
		}
		return copy;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		TabellMengde<T> copy = new TabellMengde<>(this.antallElementer());
		copy.leggTilAlleFra(this);
		for(T element : annenMengde.tilTabell()){
			copy.fjern(element);
		}
		return copy;
	}

	@Override
	public void leggTil(T element) {
		if(inneholder(element)) return;
		if(array.length == 0){
			array = Arrays.copyOf(array,1);
		}
		else if(array.length == antallElementer()){
			array = Arrays.copyOf(array,array.length*2);
		}

		for (int i = 0; i < array.length; i++) {
			if(array[i] == null){
				array[i] = element;
				return;
			}
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(T element : annenMengde.tilTabell()){
			if(element != null){
				leggTil(element);
			}
		}
	}

	@Override
	public T fjern(T element) {
		for(int i = 0;i < array.length; i++){
			if(array[i] != null && array[i].equals(element)){
				array[i] = null;
				return element;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		T[] newArray = (T[]) new Object[antallElementer()];
		int count = 0;
		for(T element : array){
			if(element != null){
				newArray[count++] = element;
			}
		}
		return newArray;
	}

	@Override
	public int antallElementer() {
		int count = 0;
		for(T element : array){
			if(element != null){
				count++;
			}
		}
		return count;
	}
}
