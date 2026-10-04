package org.ejml.equation;

/* JADX INFO: loaded from: classes9.dex */
public class Variable {
    public VariableType type;

    protected Variable(VariableType variableType) {
        this.type = variableType;
    }

    public VariableType getType() {
        return this.type;
    }

    public String toString() {
        return "VAR_" + this.type;
    }
}
