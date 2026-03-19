package DataStructures;

import java.util.Objects;

public class LenketMengde <T> implements MengdeADT<T>{
	Node<T> startNode = new Node<>(null);

	@Override
	public boolean erTom() {
		return antallElementer() == 0;
	}

	@Override
	public boolean inneholder(T element) {
		return startNode.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for(Node<T> node : startNode){
			if(!annenMengde.inneholder(node.data)){
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
		for(T element : this.tilTabell()){
			if(annenMengde.inneholder(element)){
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		LenketMengde<T> snitt = new LenketMengde<>();
		for(T element : this.tilTabell()){
			if(annenMengde.inneholder(element)){
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		LenketMengde<T> union = new LenketMengde<>();
		union.leggTilAlleFra(this);
		union.leggTilAlleFra(annenMengde);
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		LenketMengde<T> minus = new LenketMengde<>();
		minus.leggTilAlleFra(this);
		for(T element : annenMengde.tilTabell()){
			minus.fjern(element);
		}
		return minus;
	}

	@Override
	public void leggTil(T element) {
		if(startNode.contains(element)) return;
		startNode.addToLast(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(T element : annenMengde.tilTabell()){
			leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		int index = startNode.find(element);
		if(index == -1) return null;
		startNode.removeNode(index);
		return element;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] tilTabell() {
		return startNode.toDataStream().filter(Objects::nonNull).toArray(amount->(T[])new Object[amount]);
	}

	@Override
	public int antallElementer() {
		return startNode.nodeAmount();
	}
}
