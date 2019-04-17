package org.visualdataweb.vowl.owl2vowl;

import org.semanticweb.owlapi.model.IRI;

public class Constants {

	public static final String OWL2VOWL_NAMESPACE = "https://owl2vowl.de/";

	public static IRI getIRIWithTestNamespace(String entityIRI) {
		return IRI.create(OWL2VOWL_NAMESPACE + entityIRI);
	}
}
