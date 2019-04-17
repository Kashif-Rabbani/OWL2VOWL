/*
 * VowlDatatypeProperty.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.entities.properties;

import org.visualdataweb.vowl.owl2vowl.constants.PropertyType;
import org.visualdataweb.vowl.owl2vowl.constants.VowlAttribute;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlPropertyVisitor;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public class VowlDatatypeProperty extends AbstractProperty {
	public VowlDatatypeProperty(IRI iri) {
		super(iri, PropertyType.DATATYPE);
		addAttribute(VowlAttribute.DATATYPE);
	}

	@Override
	public void accept(VowlElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void accept(VowlPropertyVisitor visitor) {
		visitor.visit(this);
	}
}
