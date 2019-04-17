/*
 * VowlDatatype.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes;

import org.visualdataweb.vowl.owl2vowl.constants.NodeType;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public class VowlDatatype extends AbstractDatatype {
	public VowlDatatype(IRI iri) {
		super(iri, NodeType.TYPE_DATATYPE);
	}

	@Override
	public void accept(VowlElementVisitor visitor) {
		visitor.visit(this);
	}
}
