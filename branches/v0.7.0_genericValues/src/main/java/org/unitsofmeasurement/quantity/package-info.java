/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
/**
 * Provides quantitative properties or attributes of thing such as
 * mass, time, distance, heat, and angular separation.
 * Quantities of different kinds are represented by sub-types of the
 * {@link org.unitsofmeasurement.NumericQuantity.NumericQuantity} interface.
 *
 * <p> Only quantities defined in the <a href="http://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>
 *     are provided here. Users can create their own NumericQuantity types by
 *     extending the {@link org.unitsofmeasurement.NumericQuantity.NumericQuantity NumericQuantity}
 *     interface.</p>
 *
 * <p> This package supports <cite>measurable</cite> quantities, which can be
 *     expressed as ({@link java.lang.Number},
 *     {@link org.unitsofmeasurement.unit.Unit}) tuples.
 *     Those tuples are not expected to be used directly in numerically
 *     intensive code.
 *     They are more useful as metadata converted to the application internal
 *     representation (for example {@code double} primitive type with the
 *     requirement to provide values in metres) before computation begins.
 *     Example:[code]
 *        Time calculateTravelTime(Length distance, Velocity velocity) {
 *            double tile = distance.amount().doubleValue() /
 *                          velocity.amount().doubleValue();
 *            return NumericQuantityFactory.getInstance(Time.class).create(time,
 *                    distance.unit().divide(velocity.unit()).asType(Time.class));
 *        }
 *     [/code]
 * </p>
 *
 * <p> Quantities sub-types are also used as parameterized type to characterize
 * generic classes (and provide additional compile time check) as illustrated
 * here.[code]
 *        Sensor<Temperature> sensor ... // Generic sensor.
 *        Temperature temp = sensor.getValue();
 *        NumericQuantity<Mass> weight = new NumericQuantityImpl(180, 0.1, POUND);
 *        // Combination magnitude/precision/unit (measurement)
 *        Vector3D<Velocity> aircraftSpeed = new Vector3D(12.0, 34.0, -45.5, METRE_PER_SECOND);
 *     [/code]</p>
 *
 * <p> This package holds only the quantities required by the metric system.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 2.2, $Date: 2012-04-30 01:07:51 +0200 (Mo, 30 Apr 2012) $
 */
package org.unitsofmeasurement.quantity;

