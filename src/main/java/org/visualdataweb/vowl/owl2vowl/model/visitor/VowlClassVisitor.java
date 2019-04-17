/*
 * VowlClassVisitor.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.visitor;

import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.classes.VowlClass;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.classes.VowlThing;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes.VowlDatatype;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes.VowlLiteral;

/**
 *
 */
public interface VowlClassVisitor {
	void visit(VowlThing vowlThing);

	void visit(VowlClass vowlClass);

	void visit(VowlLiteral vowlLiteral);

	void visit(VowlDatatype vowlDatatype);
}
