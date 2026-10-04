package org.ejml.equation;

import org.ejml.equation.VariableScalar;

/* JADX INFO: loaded from: classes9.dex */
public class VariableInteger extends VariableScalar {
    public int value;

    public VariableInteger(int i) {
        super(VariableScalar.Type.INTEGER);
        this.value = i;
    }

    @Override // org.ejml.equation.VariableScalar
    public double getDouble() {
        return this.value;
    }
}
