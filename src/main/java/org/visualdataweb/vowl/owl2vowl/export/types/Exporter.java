package org.visualdataweb.vowl.owl2vowl.export.types;

/**
 * Has a method for writing the string into a specific destination
 */
public interface Exporter {

	/**
	 * Writes the passed string into a specific target.
	 *
	 * @param text The generated text.
	 */
	void write(String text) throws Exception;
}
