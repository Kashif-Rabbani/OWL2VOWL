/*
 * VowlElementVisitor.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model.visitor;

import org.visualdataweb.vowl.owl2vowl.model.individuals.VowlIndividual;

/**
 *
 */
public interface VowlElementVisitor extends VowlClassVisitor, VowlPropertyVisitor {
	void visit(VowlIndividual vowlIndividual);
}
