/*
 * ConsoleExporter.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.export.types;

/**
 * Prints the passed text to the console
 */
public class ConsoleExporter implements Exporter {
	@Override
	public void write(String text) {
		System.out.println(text);
	}
}
