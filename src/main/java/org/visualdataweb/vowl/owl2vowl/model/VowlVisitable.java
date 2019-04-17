/*
 * VowlVisitable.java
 *
 */

package org.visualdataweb.vowl.owl2vowl.model;

import org.visualdataweb.vowl.owl2vowl.model.visitor.VowlElementVisitor;

/**
 *
 */
public interface VowlVisitable {

	void accept(VowlElementVisitor visitor);
}
