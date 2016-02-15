package de.uni_stuttgart.vis.vowl.owl2vowl.parser.vowl.classes;

import de.uni_stuttgart.vis.vowl.owl2vowl.constants.VowlAttribute;
import de.uni_stuttgart.vis.vowl.owl2vowl.model.data.VowlData;
import de.uni_stuttgart.vis.vowl.owl2vowl.model.entities.nodes.classes.AbstractClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorAdapter;

import java.util.Set;

public class OwlClassAxiomVisitor extends OWLObjectVisitorAdapter {

	private VowlData vowlData;
	private OWLClass owlClass;
	private Logger logger = LogManager.getLogger(OwlClassAxiomVisitor.class);

	public OwlClassAxiomVisitor(VowlData vowlData, OWLClass owlClass) {
		this.vowlData = vowlData;
		this.owlClass = owlClass;
	}

	@Override
	protected void handleDefault(OWLObject axiom) {
		logger.info("Unsupported axiom: " + axiom);
	}

	@Override
	public void visit(OWLEquivalentClassesAxiom axiom) {
		// TODO NamedClasses size != 1 means either
		if (axiom.getNamedClasses().size() != 1) {
			createEquivalentClass(axiom);
			return;
		}

		OWLClass referencedClass = axiom.getNamedClasses().iterator().next();

		Set<OWLClassExpression> expressionsWithoutRefClass = axiom.getClassExpressionsMinus(referencedClass);
		for (OWLClassExpression anonymExpressions : expressionsWithoutRefClass) {
			anonymExpressions.accept(new VowlClassVisitor(vowlData, referencedClass));
		}
	}

	protected void createEquivalentClass(OWLEquivalentClassesAxiom axiom) {
		AbstractClass topClass = vowlData.getClassForIri(owlClass.getIRI());

		for (OWLClassExpression owlClassExpression : axiom.getClassExpressionsMinus(owlClass)) {
			topClass.addEquivalentElement(owlClassExpression.asOWLClass().getIRI());
		}

		topClass.addAttribute(VowlAttribute.EQUIVALENT);
	}

	@Override
	public void visit(OWLSubClassOfAxiom axiom) {
		if (axiom.isGCI()) {
			// TODO anonym subclass behaviour
			logger.info("Anonym subclass: " + axiom);
			return;
		}

		OWLClass subClass = axiom.getSubClass().asOWLClass();
		AbstractClass vowlSubclass = vowlData.getClassForIri(subClass.getIRI());

		if (axiom.getSuperClass().isAnonymous()) {
			axiom.getSuperClass().accept(new OwlSubclassAnonymVisitor(vowlData, owlClass));
		} else {
			OWLClass superClass = axiom.getSuperClass().asOWLClass();
			AbstractClass vowlSuperClass = vowlData.getClassForIri(superClass.getIRI());
			vowlSubclass.addSuperEntity(vowlSuperClass.getIri());
			vowlSuperClass.addSubEntity(vowlSubclass.getIri());
		}
	}

	@Override
	public void visit(OWLDisjointClassesAxiom axiom) {
		for (OWLDisjointClassesAxiom pairwiseAxiom : axiom.asPairwiseAxioms()) {
			IRI[] domainRange = new IRI[2];
			int index = 0;

			for (OWLClass aClass : pairwiseAxiom.getClassesInSignature()) {
				domainRange[index++] = aClass.getIRI();
			}

			if (!vowlData.getSearcher().containsDisjoint(domainRange[0], domainRange[1])) {
				vowlData.getGenerator().generateDisjointProperty(domainRange[0], domainRange[1]);
			}
		}
	}

	// TODO equivalent expressions not processed
	@Override
	public void visit(OWLDisjointUnionAxiom axiom) {
		if (axiom.getOWLClass().isAnonymous()) {
			logger.info("Disjoint Union base is anonym.");
			return;
		}

		AbstractClass baseClass = vowlData.getClassForIri(axiom.getOWLClass().getIRI());
		baseClass.addAttribute(VowlAttribute.DISJOINTUNION);

		for (OWLClass disjointClass : axiom.getOWLDisjointClassesAxiom().getClassesInSignature()) {
			baseClass.addDisjointUnion(disjointClass.getIRI());
		}
	}
}
