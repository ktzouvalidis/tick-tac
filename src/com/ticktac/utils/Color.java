package com.ticktac.utils;

public enum Color {
	CONCERT("#66c9ff"),
	FESTIVAL("#ff2828"),
	EXPEDITION("#bb56ff"),
	THEATER("#fc9649");
	
	String hexColor;
	
	private Color(String hexColor) {
		this.hexColor = hexColor;
	}
	
	public String getColor() {
		return hexColor;
	}
}
