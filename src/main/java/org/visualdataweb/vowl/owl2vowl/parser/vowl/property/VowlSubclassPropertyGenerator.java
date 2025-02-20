package org.visualdataweb.vowl.owl2vowl.parser.vowl.property;

import org.visualdataweb.vowl.owl2vowl.model.data.VowlData;
import org.visualdataweb.vowl.owl2vowl.model.entities.AbstractEntity;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.classes.VowlClass;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.classes.VowlThing;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes.VowlDatatype;
import org.visualdataweb.vowl.owl2vowl.model.entities.nodes.datatypes.VowlLiteral;
import org.visualdataweb.vowl.owl2vowl.model.entities.properties.TypeOfProperty;
import org.visualdataweb.vowl.owl2vowl.model.entities.properties.VowlDatatypeProperty;
import org.visualdataweb.vowl.owl2vowl.model.entities.properties.VowlObjectProperty;
import org.visualdataweb.vowl.owl2vowl.model.individuals.VowlIndividual;
import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;
import org.semanticweb.owlapi.model.IRI;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Eduard
 */
public class VowlSubclassPropertyGenerator implements VowlElementVisitor {
	private VowlData vowlData;

	public VowlSubclassPropertyGenerator(VowlData vowlData) {
		this.vowlData = vowlData;
	}

	public void execute() {
		Set<AbstractEntity> entities = new HashSet<>(vowlData.getEntityMap().values());

		for (AbstractEntity abstractEntity : entities) {
			abstractEntity.accept(this);
		}
	}

	@Override
	public void visit(VowlThing vowlThing) {

	}

	@Override
	public void visit(VowlClass vowlClass) {
		if (vowlClass.getSubEntities().size() != 0) {
			for (IRI iri : vowlClass.getSubEntities()) {
				vowlData.getGenerator().generateSubclassProperty(iri, vowlClass.getIri());
			}
		}
	}

	@Override
	public void visit(VowlLiteral vowlLiteral) {

	}

	@Override
	public void visit(VowlDatatype vowlDatatype) {

	}

	@Override
	public void visit(VowlObjectProperty vowlObjectProperty) {

	}

	@Override
	public void visit(VowlDatatypeProperty vowlDatatypeProperty) {

	}

	@Override
	public void visit(VowlIndividual vowlIndividual) {

	}

	@Override
	public void visit(TypeOfProperty typeOfProperty) {

	}
}
