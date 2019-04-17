/*
 * VowlPropertyVisitor.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.visitor;

import org.visualdataweb.vowl.owl2vowl.model.entities.properties.TypeOfProperty;
import org.visualdataweb.vowl.owl2vowl.model.entities.properties.VowlDatatypeProperty;
import org.visualdataweb.vowl.owl2vowl.model.entities.properties.VowlObjectProperty;

/**
 *
 */
public interface VowlPropertyVisitor {
	void visit(VowlObjectProperty vowlObjectProperty);

	void visit(VowlDatatypeProperty vowlDatatypeProperty);

	void visit(TypeOfProperty typeOfProperty);
}
