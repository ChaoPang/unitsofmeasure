/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl.system;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.SystemOfUnits;
import javax.measure.Unit;

import org.unitsofmeasurement.impl.AbstractUnit;


/**
 * <p> An abstract base class for unit systems.</p>
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 2.1, $Date: 2013-12-26 $
 */
public abstract class AbstractSystemOfUnits implements SystemOfUnits {
    /**
     * Holds the units.
     */
    protected final Set<Unit<?>> units = new HashSet<>(); // Diamond, Java 7+

    /**
     * Holds the mapping quantity to unit.
     */
    @SuppressWarnings("rawtypes")
	protected final Map<Class<? extends Quantity>, AbstractUnit>
            quantityToUnit = new HashMap<>(); // Diamond (Java 7+)

    
    /**
     * The natural logarithm.
     **/
    protected static final double E = 2.71828182845904523536028747135266;

    
	// ///////////////////
	// Collection View //
	// ///////////////////
    @Override
    public Set<? extends Unit<?>> getUnits() {
        return Collections.unmodifiableSet(units);
    }

    @Override
    public Set<? extends Unit<?>> getUnits(Dimension dimension) {
        final Set<Unit<?>> set = new HashSet<Unit<?>>();
        for (Unit<?> unit : this.getUnits()) {
            if (dimension.equals(unit.getDimension())) {
                set.add(unit);
            }
        }
        return set;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public <Q extends Quantity<Q>> AbstractUnit<Q> getUnit(Class<Q> quantityType) {
        return quantityToUnit.get(quantityType);
    }
	
	static class Helper {
		static Set<Unit<?>> getUnitsOfDimension(final Set<Unit<?>> units, 
				Dimension dimension) {
			if (dimension != null) {
				Set<Unit<?>>dimSet = new HashSet<Unit<?>>();
				for (Unit<?> u : units) {
					if (dimension.equals(u.getDimension())) {
						dimSet.add(u);
					}
				}
				return dimSet;
			}
			return null;
		}
	}
}