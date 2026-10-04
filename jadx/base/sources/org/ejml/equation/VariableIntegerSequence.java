package org.ejml.equation;

/* JADX INFO: loaded from: classes9.dex */
public class VariableIntegerSequence extends Variable {
    IntegerSequence sequence;

    protected VariableIntegerSequence(IntegerSequence integerSequence) {
        super(VariableType.INTEGER_SEQUENCE);
        this.sequence = integerSequence;
    }
}
