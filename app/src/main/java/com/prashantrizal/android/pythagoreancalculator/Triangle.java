package com.prashantrizal.android.pythagoreancalculator;

import java.util.ArrayList;

/**
 * Represents a triangle object.
 */

public class Triangle {
    private ArrayList<Double> sides = new ArrayList<>(3);
    private ArrayList<Double> angles = new ArrayList<>(2);

        // Constructor.
        public Triangle(
                Double side1,
                Double side2,
                Double side3,
                Double angle1,
                Double angle2
        ) {
        addSide(side1);
        addSide(side2);
        addSide(side3);
        addAngle(angle1);
        addAngle(angle2);
    }

    private void addSide(Double side) {
        if (side != null) {
            sides.add(side);
        }
    }

    private void addAngle(Double angle) {
        if (angle != null) {
            angles.add(angle);
        }
    }

    public void compute() throws IllegalArgumentException {
        if (!enoughData()) {
            throw new IllegalArgumentException("Not enough information to continue.");
        }

        // assert: we have enough info.

    }

    public boolean enoughData() {
        if (sides.size() == 0) {
            return false;
        }
        // assert: we have at least one side

        // one side. we need at least one angle
        if (sides.size() == 1 && angles.size() == 0) {
            return false;
        }

        // We have at least one side and one angle
        return true;
    }
}