package model;

import java.io.Serializable;

public class PublisherBag implements Serializable {
	private Publisher[] publisherArray;
	private int nElems;
	
	public PublisherBag(int maxSize) {
		publisherArray= new Publisher[maxSize];
		nElems=0;
	}
	
	public Publisher emitAPublisher() {
		int randomNumber=(int) (nElems*Math.random());
		return publisherArray[randomNumber];
	}
	
	public void insert(Publisher p) {
		publisherArray[nElems++]=p;
	}
}
