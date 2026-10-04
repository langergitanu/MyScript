package org.ejml.equation;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class ManagerTempVariables {
    public VariableMatrix createMatrix() {
        return VariableMatrix.createTemp();
    }

    public VariableDouble createDouble() {
        return new VariableDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public VariableDouble createDouble(double d) {
        return new VariableDouble(d);
    }

    public VariableInteger createInteger() {
        return createInteger(0);
    }

    public VariableInteger createInteger(int i) {
        return new VariableInteger(i);
    }

    public VariableIntegerSequence createIntegerSequence(IntegerSequence integerSequence) {
        return new VariableIntegerSequence(integerSequence);
    }
}
