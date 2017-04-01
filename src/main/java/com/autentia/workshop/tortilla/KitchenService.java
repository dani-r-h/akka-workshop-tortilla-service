package com.autentia.workshop.tortilla;

public class KitchenService {

	public HotOliveOil heatOil(final OliveOil oliveOil){
		if(oliveOil == null){
			throw new RuntimeException("There is no olive oil!!");
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		return new HotOliveOil();
	}
	
	public SlicedPotatoes slice(final Potatoes potatoes){
		if(potatoes == null) {
			throw new RuntimeException("There is no potatoes!");
		}
		 
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		return new SlicedPotatoes();
	} 
	
	public SlicedOnions slice(final Onions onions){
		if(onions == null){
			throw new RuntimeException("There is no onions!");
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new SlicedOnions();
	} 
	
	public BeatenEggs beat(final Eggs eggs){
		if(eggs == null) {
			throw new RuntimeException("There is no eggs!");
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new BeatenEggs();
	}
	
	public TortillaConCebolla cook(final HotOliveOil hotOliveOil, final SlicedPotatoes slicedPotatoes, final SlicedOnions slicedOnions, final BeatenEggs beatenEggs, final Salt salt) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new TortillaConCebolla();
	}
	
	public TortillaSinCebolla cook(final HotOliveOil hotOliveOil, final SlicedPotatoes slicedPotatoes, final BeatenEggs beatenEggs, final Salt salt) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		return new TortillaSinCebolla();
	}
}
