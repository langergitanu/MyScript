package org.ejml.equation;

/* JADX INFO: loaded from: classes9.dex */
public abstract class VariableScalar extends Variable {
    Type type;

    public enum Type {
        INTEGER,
        DOUBLE,
        COMPLEX
    }

    public abstract double getDouble();

    public VariableScalar(Type type) {
        super(VariableType.SCALAR);
        this.type = type;
    }

    /* JADX INFO: renamed from: org.ejml.equation.VariableScalar$1 */
    static /* synthetic */ class C91421 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$equation$VariableScalar$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$ejml$equation$VariableScalar$Type = iArr;
            try {
                iArr[Type.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$equation$VariableScalar$Type[Type.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$equation$VariableScalar$Type[Type.COMPLEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // org.ejml.equation.Variable
    public String toString() {
        int i = C91421.$SwitchMap$org$ejml$equation$VariableScalar$Type[this.type.ordinal()];
        if (i == 1) {
            return "ScalarI";
        }
        if (i == 2) {
            return "ScalarD";
        }
        if (i == 3) {
            return "ScalarC";
        }
        return "ScalarUnknown";
    }

    public Type getScalarType() {
        return this.type;
    }
}
