package org.ejml.equation;

import org.ejml.equation.VariableScalar;

/* JADX INFO: loaded from: classes9.dex */
public class VariableDouble extends VariableScalar {
    public double value;

    public VariableDouble(double d) {
        super(VariableScalar.Type.DOUBLE);
        this.value = d;
    }

    @Override // org.ejml.equation.VariableScalar
    public double getDouble() {
        return this.value;
    }
}
