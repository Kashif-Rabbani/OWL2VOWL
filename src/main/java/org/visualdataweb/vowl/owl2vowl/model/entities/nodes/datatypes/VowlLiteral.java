/*
 * VowlLiteral.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes;

import org.visualdataweb.vowl.owl2vowl.constants.NodeType;
import org.visualdataweb.vowl.owl2vowl.model.annotation.Annotation;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public class VowlLiteral extends AbstractDatatype {
	public static final String LITERAL_IRI = "http://www.w3.org/2000/01/rdf-schema#Literal";

	public VowlLiteral(IRI iri) {
		super(iri, NodeType.TYPE_LITERAL);
		getAnnotations().addLabel(new Annotation("label", "Literal"));
	}

	public String getGenericIri() {
		return LITERAL_IRI;
	}

	@Override
	public void accept(VowlElementVisitor visitor) {
		visitor.visit(this);
	}
}
