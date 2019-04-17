/*
 * AbstractVowlObject.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model;

import org.visualdataweb.vowl.owl2vowl.model.annotation.Annotations;
import org.visualdataweb.vowl.owl2vowl.parser.helper.ComparisonHelper;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public abstract class AbstractVowlObject implements HasIri, HasAnnotations, VowlVisitable {
	protected IRI iri;
	protected IRI baseIri;
	private Annotations annotations = new Annotations();

	public AbstractVowlObject(IRI iri) {
		this.iri = iri;

		if (iri != null) {
			baseIri = IRI.create(ComparisonHelper.extractBaseIRI(iri.toString()));
		}
	}

	public IRI getBaseIri() {
		return baseIri;
	}

	@Override
	public Annotations getAnnotations() {
		return annotations;
	}

	@Override
	public IRI getIri() {
		return iri;
	}
}
