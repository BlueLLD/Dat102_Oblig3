package DataStructures;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Node<T> implements Iterable<Node<T>>{
	public T data;
	public Node<T> nextNode;

	public Node(T data){
		this(data,null);
	}
	public Node(T data, Node<T> nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}

	public static<T> Node<T> makeTree(T[] data){
		Node<T> node = null;
		for(int i = data.length-1; i >= 0; i--){
			node = new Node<>(data[i],node);
		}
		return node;
	}

	@Override
	public String toString() {
		if (this.nextNode == null && this.data == null) return "null";
		if (this.nextNode == null) return this.data.toString();
		return this.data + " -> " + this.nextNode + " ";
	}

	public T get(int index){
		if(index < 0) index = nodeAmount()+index;
		int count = 0;
		for(Node<T> element : this){
			if(count == index) return element.data;
			count++;
		}
		return null;
	}

	public Node<T> getNode(int index){
		if(index < 0) index = nodeAmount()+index;
		int count = 0;
		for(Node<T> element : this){
			if(count == index) return element;
			count++;
		}
		return null;
	}

	public int find(T element){
		int count = 0;
		for(Node<T> nestedElement : this){
			if(element != null && element.equals(nestedElement.data)) return count;
			count++;
		}
		return -1;
	}

	public void addToLast(T element){
		if(this.data == null && this.nextNode == null){
			this.data = element;
			return;
		}
		Node<T> node = this;
		while (true){
			if(node.nextNode == null){
				node.nextNode = new Node<>(element,null);
				return;
			}
			node = node.nextNode;
		}
	}

	public int nodeAmount(){
		if(this.data == null && this.nextNode == null) return 0;
		int count = 0;
		for(Node<T> _ : this){
			count++;
		}
		return count;
	}

	public Stream<T> toDataStream(){
		return toStream().map(n->n.data);
	}
	public Stream<Node<T>> toStream(){
		return StreamSupport.stream(this.spliterator(),false);
	}

	public boolean removeNode(int index){
		Node<T> prev = this;
		int l_index = -1;
		for(Node<T> node : this){
			l_index++;
			// Dumb fix for this implementation
			if(index == 0){
				this.data = this.nextNode.data;
				this.nextNode = nextNode.nextNode;
				return true;
			}
			if(index == l_index){
				prev.nextNode = node.nextNode;
				return true;
			}
			prev = node;
		}
		return false;
	}

	public boolean removeNodeWithData(T data){
		Node<T> prev = this;
		for(Node<T> node : this){
			// Dumb fix for this implementation
			if(node == this && node.data.equals(data)){
				this.data = this.nextNode.data;
				this.nextNode = nextNode.nextNode;
				return true;
			}
			if(node.data.equals(data)){
				prev.nextNode = node.nextNode;
				return true;
			}
			prev = node;
		}
		return false;
	}

	public boolean contains(T element){
		return find(element) != -1;
	}

	@Override
	public Iterator<Node<T>> iterator() {
		return new NodeIterator<>(this);
	}
	private static class NodeIterator<T> implements Iterator<Node<T>> {
		Node<T> node;
		public NodeIterator(Node<T> node){

			this.node = (node.data == null && node.nextNode == null) ? null : node;
		}


		@Override
		public boolean hasNext() {
			return this.node != null;
		}

		@Override
		public Node<T> next() {
			Node<T> oldNode = node;
			node = node.nextNode;
			return oldNode;
		}

	}
}