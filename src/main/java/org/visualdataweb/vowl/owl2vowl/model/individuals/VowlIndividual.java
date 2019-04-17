/*
 * VowlIndividual.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.individuals;

import org.visualdataweb.vowl.owl2vowl.model.AbstractVowlObject;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public class VowlIndividual extends AbstractVowlObject {
	public VowlIndividual(IRI iri) {
		super(iri);
	}

	@Override
	public void accept(VowlElementVisitor visitor) {
		visitor.visit(this);
	}
}
