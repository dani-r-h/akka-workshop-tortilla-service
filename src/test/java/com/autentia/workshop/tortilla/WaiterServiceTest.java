package com.autentia.workshop.tortilla;

import org.junit.Test;

public class WaiterServiceTest {

	private static final String HOST_NAME = "5.56.60.112";
	private static int PORT_NUMBER = 5672;
	private static String EXCHANGE = "workshop_tortillas_exchange";
	
	private final WaiterService waiterService = new WaiterService(HOST_NAME, PORT_NUMBER, EXCHANGE);
	
	@Test
	public void should_serve_tortilla_sin_cebolla() {
		waiterService.serveTortilla(new TortillaSinCebolla());
	}
	
	@Test
	public void should_serve_tortilla_con_cebolla() {
		waiterService.serveTortilla(new TortillaConCebolla());
	}
}
