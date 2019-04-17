package org.visualdataweb.vowl.owl2vowl.model.entities.properties;

import org.visualdataweb.vowl.owl2vowl.constants.PropertyType;
import org.visualdataweb.vowl.owl2vowl.model.annotation.Annotation;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlPropertyVisitor;
import org.semanticweb.owlapi.model.IRI;

/**
 * Special property in VOWL which is colored in purple color.
 */
public class TypeOfProperty extends AbstractProperty {
	public TypeOfProperty(IRI iri) {
		super(iri, PropertyType.TYPEOF);
		getAnnotations().addLabel(new Annotation("label", "is a"));
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
