package com.autentia.workshop.tortilla;

public class ShopService {

	public Onions buyOnions() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new Onions(); 
	}
	
	public Potatoes buyPotatoes() {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new Potatoes();
	}
	
	public Eggs buyEggs(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new Eggs();
	}
	
	public OliveOil buyOliveOil(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new OliveOil();
	}
	
	public Salt buySalt(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new Salt();
	}
	
}
