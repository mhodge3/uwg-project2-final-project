package com.cs6920.view;

public abstract class ViewControl {
	private ViewControl theConcreteImplementation;
	
	public void setConcreteViewControl(ViewControl theConcreteImplementation) {
		this.theConcreteImplementation = theConcreteImplementation;
	}
	
	public ViewControl getConcreteViewControl() {
		return this.theConcreteImplementation;
	}
}
