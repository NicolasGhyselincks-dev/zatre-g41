module ZatreG41 {
	exports persistentie;
	exports application;
	exports gui;
	exports domein;
	exports testen;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens gui to javafx.graphics;
}