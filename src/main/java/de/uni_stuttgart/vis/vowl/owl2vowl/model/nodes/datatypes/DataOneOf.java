/*
 * DataOneOf.java
 *
 */

package de.uni_stuttgart.vis.vowl.owl2vowl.model.nodes.datatypes;

import de.uni_stuttgart.vis.vowl.owl2vowl.model.nodes.BaseNode;
import org.semanticweb.owlapi.io.RDFLiteral;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataOneOf extends BaseDatatype {
	protected List<RdfsLiteral> oneOf;

	public DataOneOf() {
		super();
		//setType(...); TODO
		oneOf = new ArrayList<RdfsLiteral>();
		setName("Data One Of");
		setComment("Dummy implementation. Not the real extracted element because not supported currently.");
	}

	public List<RdfsLiteral> getOneOf() {
		return oneOf;
	}

	@Override
	protected void setID() {
		id = "dataoneof" + counterObjects;
		counterObjects++;
	}
}
