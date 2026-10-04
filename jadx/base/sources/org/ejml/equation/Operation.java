package org.ejml.equation;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.List;
import org.ejml.MatrixDimensionException;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.NormOps_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.equation.IntegerSequence;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class Operation {
    String name;

    public static class Extents {
        int col0;
        int col1;
        int row0;
        int row1;
    }

    public static class Info {

        /* JADX INFO: renamed from: op */
        public Operation f2755op;
        public Variable output;
    }

    public abstract void process();

    protected Operation(String str) {
        this.name = str;
    }

    public String name() {
        return this.name;
    }

    protected void resize(VariableMatrix variableMatrix, int i, int i2) {
        if (variableMatrix.isTemp()) {
            variableMatrix.matrix.reshape(i, i2);
        }
    }

    public static Info multiply(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        final VariableScalar variableScalar;
        final VariableMatrix variableMatrix;
        Info info = new Info();
        boolean z = variable instanceof VariableMatrix;
        if (z && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("multiply-mm") { // from class: org.ejml.equation.Operation.1
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix2 = (VariableMatrix) variable;
                    VariableMatrix variableMatrix3 = (VariableMatrix) variable2;
                    resize(variableMatrixCreateMatrix, variableMatrix2.matrix.numRows, variableMatrix3.matrix.numCols);
                    try {
                        CommonOps_DDRM.mult(variableMatrix2.matrix, variableMatrix3.matrix, variableMatrixCreateMatrix.matrix);
                    } catch (MatrixDimensionException unused) {
                        Operation.checkThrow1x1AgainstNxM(variableMatrix2.matrix, variableMatrix3.matrix, "multiply");
                    }
                }
            };
            return info;
        }
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("multiply-ii") { // from class: org.ejml.equation.Operation.2
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableInteger variableInteger = (VariableInteger) variable;
                    VariableInteger variableInteger2 = (VariableInteger) variable2;
                    variableIntegerCreateInteger.value = variableInteger.value * variableInteger2.value;
                }
            };
            return info;
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableScalar)) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("multiply-ss") { // from class: org.ejml.equation.Operation.3
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableScalar variableScalar2 = (VariableScalar) variable;
                    VariableScalar variableScalar3 = (VariableScalar) variable2;
                    variableDoubleCreateDouble.value = variableScalar2.getDouble() * variableScalar3.getDouble();
                }
            };
            return info;
        }
        final VariableMatrix variableMatrixCreateMatrix2 = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix2;
        if (z) {
            variableMatrix = (VariableMatrix) variable;
            variableScalar = (VariableScalar) variable2;
        } else {
            VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
            variableScalar = (VariableScalar) variable;
            variableMatrix = variableMatrix2;
        }
        info.f2755op = new Operation("multiply-ms") { // from class: org.ejml.equation.Operation.4
            @Override // org.ejml.equation.Operation
            public void process() {
                variableMatrixCreateMatrix2.matrix.reshape(variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                CommonOps_DDRM.scale(variableScalar.getDouble(), variableMatrix.matrix, variableMatrixCreateMatrix2.matrix);
            }
        };
        return info;
    }

    public static Info divide(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        boolean z = variable instanceof VariableMatrix;
        if (z && (variable2 instanceof VariableMatrix)) {
            return solve(variable2, variable, managerTempVariables);
        }
        String str = "divide-ma";
        if (z && (variable2 instanceof VariableScalar)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            final VariableMatrix variableMatrix = (VariableMatrix) variable;
            final VariableScalar variableScalar = (VariableScalar) variable2;
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation(str) { // from class: org.ejml.equation.Operation.5
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.divide(variableMatrix.matrix, variableScalar.getDouble(), variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix2 = managerTempVariables.createMatrix();
            final VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
            final VariableScalar variableScalar2 = (VariableScalar) variable;
            info.output = variableMatrixCreateMatrix2;
            info.f2755op = new Operation(str) { // from class: org.ejml.equation.Operation.6
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix2.matrix.reshape(variableMatrix2.matrix.numRows, variableMatrix2.matrix.numCols);
                    CommonOps_DDRM.divide(variableScalar2.getDouble(), variableMatrix2.matrix, variableMatrixCreateMatrix2.matrix);
                }
            };
            return info;
        }
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("divide-ii") { // from class: org.ejml.equation.Operation.7
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableInteger variableInteger = (VariableInteger) variable;
                    VariableInteger variableInteger2 = (VariableInteger) variable2;
                    variableIntegerCreateInteger.value = variableInteger.value / variableInteger2.value;
                }
            };
            return info;
        }
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        info.f2755op = new Operation("divide-ss") { // from class: org.ejml.equation.Operation.8
            @Override // org.ejml.equation.Operation
            public void process() {
                VariableScalar variableScalar3 = (VariableScalar) variable;
                VariableScalar variableScalar4 = (VariableScalar) variable2;
                variableDoubleCreateDouble.value = variableScalar3.getDouble() / variableScalar4.getDouble();
            }
        };
        return info;
    }

    public static Info neg(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableInteger) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("neg-i") { // from class: org.ejml.equation.Operation.9
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableIntegerCreateInteger.value = -((VariableInteger) variable).value;
                }
            };
            return info;
        }
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("neg-s") { // from class: org.ejml.equation.Operation.10
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = -((VariableScalar) variable).getDouble();
                }
            };
            return info;
        }
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("neg-m") { // from class: org.ejml.equation.Operation.11
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.changeSign(dMatrixRMaj, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Unsupported variable " + variable);
    }

    public static Info pow(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableScalar)) {
            info.f2755op = new Operation("pow-ss") { // from class: org.ejml.equation.Operation.12
                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    double d2 = ((VariableScalar) variable2).getDouble();
                    variableDoubleCreateDouble.value = Math.pow(d, d2);
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalar to scalar power supported");
    }

    public static Info atan2(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableScalar)) {
            info.f2755op = new Operation("atan2-ss") { // from class: org.ejml.equation.Operation.13
                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    double d2 = ((VariableScalar) variable2).getDouble();
                    variableDoubleCreateDouble.value = Math.atan2(d, d2);
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalar to scalar atan2 supported");
    }

    public static Info sqrt(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableScalar) {
            info.f2755op = new Operation("sqrt-s") { // from class: org.ejml.equation.Operation.14
                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    variableDoubleCreateDouble.value = Math.sqrt(d);
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info sin(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableScalar) {
            info.f2755op = new Operation("sin-s") { // from class: org.ejml.equation.Operation.15
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.sin(((VariableScalar) variable).getDouble());
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info cos(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableScalar) {
            info.f2755op = new Operation("cos-s") { // from class: org.ejml.equation.Operation.16
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.cos(((VariableScalar) variable).getDouble());
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info atan(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableScalar) {
            info.f2755op = new Operation("atan-s") { // from class: org.ejml.equation.Operation.17
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.atan(((VariableScalar) variable).getDouble());
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info exp(final Variable variable, ManagerTempVariables managerTempVariables) {
        final Info info = new Info();
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("exp-s") { // from class: org.ejml.equation.Operation.18
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.exp(((VariableScalar) variable).getDouble());
                }
            };
            return info;
        }
        if (variable instanceof VariableMatrix) {
            info.output = managerTempVariables.createMatrix();
            info.f2755op = new Operation("exp-m") { // from class: org.ejml.equation.Operation.19
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) info.output).matrix;
                    dMatrixRMaj2.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.elementExp(dMatrixRMaj, dMatrixRMaj2);
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info log(final Variable variable, ManagerTempVariables managerTempVariables) {
        final Info info = new Info();
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("log-s") { // from class: org.ejml.equation.Operation.20
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.log(((VariableScalar) variable).getDouble());
                }
            };
            return info;
        }
        if (variable instanceof VariableMatrix) {
            info.output = managerTempVariables.createMatrix();
            info.f2755op = new Operation("log-m") { // from class: org.ejml.equation.Operation.21
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) info.output).matrix;
                    dMatrixRMaj2.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.elementLog(dMatrixRMaj, dMatrixRMaj2);
                }
            };
            return info;
        }
        throw new RuntimeException("Only scalars are supported");
    }

    public static Info add(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        final VariableScalar variableScalar;
        final VariableMatrix variableMatrix;
        Info info = new Info();
        boolean z = variable instanceof VariableMatrix;
        if (z && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("add-mm") { // from class: org.ejml.equation.Operation.22
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix2 = (VariableMatrix) variable;
                    VariableMatrix variableMatrix3 = (VariableMatrix) variable2;
                    resize(variableMatrixCreateMatrix, variableMatrix2.matrix.numRows, variableMatrix2.matrix.numCols);
                    try {
                        CommonOps_DDRM.add(variableMatrix2.matrix, variableMatrix3.matrix, variableMatrixCreateMatrix.matrix);
                    } catch (MatrixDimensionException unused) {
                        Operation.checkThrow1x1AgainstNxM(variableMatrix2.matrix, variableMatrix3.matrix, "add");
                    }
                }
            };
            return info;
        }
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger(0);
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("add-ii") { // from class: org.ejml.equation.Operation.23
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableInteger variableInteger = (VariableInteger) variable;
                    VariableInteger variableInteger2 = (VariableInteger) variable2;
                    variableIntegerCreateInteger.value = variableInteger.value + variableInteger2.value;
                }
            };
            return info;
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableScalar)) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("add-ss") { // from class: org.ejml.equation.Operation.24
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableScalar variableScalar2 = (VariableScalar) variable;
                    VariableScalar variableScalar3 = (VariableScalar) variable2;
                    variableDoubleCreateDouble.value = variableScalar2.getDouble() + variableScalar3.getDouble();
                }
            };
            return info;
        }
        final VariableMatrix variableMatrixCreateMatrix2 = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix2;
        if (z) {
            variableMatrix = (VariableMatrix) variable;
            variableScalar = (VariableScalar) variable2;
        } else {
            VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
            variableScalar = (VariableScalar) variable;
            variableMatrix = variableMatrix2;
        }
        info.f2755op = new Operation("add-ms") { // from class: org.ejml.equation.Operation.25
            @Override // org.ejml.equation.Operation
            public void process() {
                variableMatrixCreateMatrix2.matrix.reshape(variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                CommonOps_DDRM.add(variableMatrix.matrix, variableScalar.getDouble(), variableMatrixCreateMatrix2.matrix);
            }
        };
        return info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkThrow1x1AgainstNxM(Matrix matrix, Matrix matrix2, String str) {
        if ((matrix.getNumCols() == 1 && matrix.getNumRows() == 1) || (matrix2.getNumCols() == 1 && matrix2.getNumRows() == 1)) {
            throw new MatrixDimensionException("Trying to " + str + " a 1x1 matrix to every element in a MxN matrix? Turn the 1x1 matrix into a scalar by accessing its element. This is stricter than matlab to catch more accidental math errors.");
        }
    }

    public static Info subtract(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        boolean z = variable instanceof VariableMatrix;
        if (z && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("subtract-mm") { // from class: org.ejml.equation.Operation.26
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
                    resize(variableMatrixCreateMatrix, variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                    try {
                        CommonOps_DDRM.subtract(variableMatrix.matrix, variableMatrix2.matrix, variableMatrixCreateMatrix.matrix);
                    } catch (MatrixDimensionException unused) {
                        Operation.checkThrow1x1AgainstNxM(variableMatrix.matrix, variableMatrix2.matrix, "subtract");
                    }
                }
            };
            return info;
        }
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger(0);
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("subtract-ii") { // from class: org.ejml.equation.Operation.27
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableInteger variableInteger = (VariableInteger) variable;
                    VariableInteger variableInteger2 = (VariableInteger) variable2;
                    variableIntegerCreateInteger.value = variableInteger.value - variableInteger2.value;
                }
            };
            return info;
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableScalar)) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("subtract-ss") { // from class: org.ejml.equation.Operation.28
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableScalar variableScalar = (VariableScalar) variable;
                    VariableScalar variableScalar2 = (VariableScalar) variable2;
                    variableDoubleCreateDouble.value = variableScalar.getDouble() - variableScalar2.getDouble();
                }
            };
            return info;
        }
        final VariableMatrix variableMatrixCreateMatrix2 = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix2;
        if (z) {
            info.f2755op = new Operation("subtract-ms") { // from class: org.ejml.equation.Operation.29
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    double d = ((VariableScalar) variable2).getDouble();
                    variableMatrixCreateMatrix2.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.subtract(dMatrixRMaj, d, variableMatrixCreateMatrix2.matrix);
                }
            };
            return info;
        }
        info.f2755op = new Operation("subtract-sm") { // from class: org.ejml.equation.Operation.30
            @Override // org.ejml.equation.Operation
            public void process() {
                DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable2).matrix;
                double d = ((VariableScalar) variable).getDouble();
                variableMatrixCreateMatrix2.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                CommonOps_DDRM.subtract(d, dMatrixRMaj, variableMatrixCreateMatrix2.matrix);
            }
        };
        return info;
    }

    public static Info elementMult(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("elementMult-mm") { // from class: org.ejml.equation.Operation.31
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
                    resize(variableMatrixCreateMatrix, variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.elementMult(variableMatrix.matrix, variableMatrix2.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Both inputs must be matrices for element wise multiplication");
    }

    public static Info elementDivision(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("elementDivision-mm") { // from class: org.ejml.equation.Operation.32
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    VariableMatrix variableMatrix2 = (VariableMatrix) variable2;
                    resize(variableMatrixCreateMatrix, variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.elementDiv(variableMatrix.matrix, variableMatrix2.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Both inputs must be matrices for element wise multiplication");
    }

    public static Info elementPow(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        boolean z = variable instanceof VariableScalar;
        if (z && (variable2 instanceof VariableScalar)) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("elementPow-ss") { // from class: org.ejml.equation.Operation.33
                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    double d2 = ((VariableScalar) variable2).getDouble();
                    variableDoubleCreateDouble.value = Math.pow(d, d2);
                }
            };
            return info;
        }
        boolean z2 = variable instanceof VariableMatrix;
        if (z2 && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("elementPow-mm") { // from class: org.ejml.equation.Operation.34
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable2).matrix;
                    resize(variableMatrixCreateMatrix, dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.elementPower(dMatrixRMaj, dMatrixRMaj2, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if (z2 && (variable2 instanceof VariableScalar)) {
            final VariableMatrix variableMatrixCreateMatrix2 = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix2;
            info.f2755op = new Operation("elementPow-ms") { // from class: org.ejml.equation.Operation.35
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    double d = ((VariableScalar) variable2).getDouble();
                    resize(variableMatrixCreateMatrix2, dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.elementPower(dMatrixRMaj, d, variableMatrixCreateMatrix2.matrix);
                }
            };
            return info;
        }
        if (z && (variable2 instanceof VariableMatrix)) {
            final VariableMatrix variableMatrixCreateMatrix3 = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix3;
            info.f2755op = new Operation("elementPow-sm") { // from class: org.ejml.equation.Operation.36
                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable2).matrix;
                    resize(variableMatrixCreateMatrix3, dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.elementPower(d, dMatrixRMaj, variableMatrixCreateMatrix3.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Unsupport element-wise power input types");
    }

    public static Operation copy(final Variable variable, final Variable variable2) {
        if (variable instanceof VariableMatrix) {
            if (variable2 instanceof VariableMatrix) {
                return new Operation("copy-mm") { // from class: org.ejml.equation.Operation.37
                    @Override // org.ejml.equation.Operation
                    public void process() {
                        DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable2).matrix;
                        DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable).matrix;
                        dMatrixRMaj.reshape(dMatrixRMaj2.numRows, dMatrixRMaj2.numCols);
                        dMatrixRMaj.set((DMatrixD1) ((VariableMatrix) variable).matrix);
                    }
                };
            }
            if (variable2 instanceof VariableDouble) {
                return new Operation("copy-sm1") { // from class: org.ejml.equation.Operation.38
                    @Override // org.ejml.equation.Operation
                    public void process() {
                        DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                        if (dMatrixRMaj.numRows != 1 || dMatrixRMaj.numCols != 1) {
                            throw new RuntimeException("Attempting to assign a non 1x1 matrix to a double");
                        }
                        ((VariableDouble) variable2).value = dMatrixRMaj.unsafe_get(0, 0);
                    }
                };
            }
        }
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            return new Operation("copy-ii") { // from class: org.ejml.equation.Operation.39
                @Override // org.ejml.equation.Operation
                public void process() {
                    ((VariableInteger) variable2).value = ((VariableInteger) variable).value;
                }
            };
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableDouble)) {
            return new Operation("copy-ss") { // from class: org.ejml.equation.Operation.40
                @Override // org.ejml.equation.Operation
                public void process() {
                    ((VariableDouble) variable2).value = ((VariableScalar) variable).getDouble();
                }
            };
        }
        if ((variable instanceof VariableIntegerSequence) && (variable2 instanceof VariableIntegerSequence)) {
            return new Operation("copy-is-is") { // from class: org.ejml.equation.Operation.41
                @Override // org.ejml.equation.Operation
                public void process() {
                    ((VariableIntegerSequence) variable2).sequence = ((VariableIntegerSequence) variable).sequence;
                }
            };
        }
        throw new RuntimeException("Unsupported copy types; src = " + variable.getClass().getSimpleName() + " dst = " + variable2.getClass().getSimpleName());
    }

    public static Operation copy(final Variable variable, final Variable variable2, final List<Variable> list) {
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            return new Operation("copyR-mm") { // from class: org.ejml.equation.Operation.42
                Extents extents = new Extents();
                ArrayExtent rowExtent = new ArrayExtent();
                ArrayExtent colExtent = new ArrayExtent();

                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable2).matrix;
                    if (list.size() == 1) {
                        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
                            if (!Operation.extractSimpleExtents((Variable) list.get(0), this.extents, false, dMatrixRMaj2.getNumElements())) {
                                Operation.extractArrayExtent((Variable) list.get(0), dMatrixRMaj2.getNumElements(), this.colExtent);
                                if (this.colExtent.length > dMatrixRMaj.getNumElements()) {
                                    throw new IllegalArgumentException("src doesn't have enough elements");
                                }
                                for (int i = 0; i < this.colExtent.length; i++) {
                                    dMatrixRMaj2.data[this.colExtent.array[i]] = dMatrixRMaj.data[i];
                                }
                                return;
                            }
                            int i2 = (this.extents.col1 - this.extents.col0) + 1;
                            if (dMatrixRMaj.getNumElements() != i2) {
                                throw new IllegalArgumentException("Source vector not the right length.");
                            }
                            if (this.extents.col1 + 1 > dMatrixRMaj2.getNumElements()) {
                                throw new IllegalArgumentException("Requested range is outside of dst length");
                            }
                            System.arraycopy(dMatrixRMaj.data, 0, dMatrixRMaj2.data, this.extents.col0, i2);
                            return;
                        }
                        throw new ParseError("Source must be a vector for copy into elements");
                    }
                    if (list.size() == 2) {
                        if (!Operation.extractSimpleExtents((Variable) list.get(0), this.extents, true, dMatrixRMaj2.getNumRows()) || !Operation.extractSimpleExtents((Variable) list.get(1), this.extents, false, dMatrixRMaj2.getNumCols())) {
                            Operation.extractArrayExtent((Variable) list.get(0), dMatrixRMaj2.numRows, this.rowExtent);
                            Operation.extractArrayExtent((Variable) list.get(1), dMatrixRMaj2.numCols, this.colExtent);
                            CommonOps_DDRM.insert(dMatrixRMaj, dMatrixRMaj2, this.rowExtent.array, this.rowExtent.length, this.colExtent.array, this.colExtent.length);
                            return;
                        }
                        CommonOps_DDRM.extract(dMatrixRMaj, 0, (this.extents.row1 - this.extents.row0) + 1, 0, (this.extents.col1 - this.extents.col0) + 1, dMatrixRMaj2, this.extents.row0, this.extents.col0);
                        return;
                    }
                    throw new RuntimeException("Unexpected number of ranges.  Should have been caught earlier");
                }
            };
        }
        if ((variable instanceof VariableScalar) && (variable2 instanceof VariableMatrix)) {
            return new Operation("copyR-sm") { // from class: org.ejml.equation.Operation.43
                Extents extents = new Extents();
                ArrayExtent rowExtent = new ArrayExtent();
                ArrayExtent colExtent = new ArrayExtent();

                @Override // org.ejml.equation.Operation
                public void process() {
                    double d = ((VariableScalar) variable).getDouble();
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable2).matrix;
                    if (list.size() == 1) {
                        if (!Operation.extractSimpleExtents((Variable) list.get(0), this.extents, false, dMatrixRMaj.getNumElements())) {
                            Operation.extractArrayExtent((Variable) list.get(0), dMatrixRMaj.getNumElements(), this.colExtent);
                            for (int i = 0; i < this.colExtent.length; i++) {
                                dMatrixRMaj.data[this.colExtent.array[i]] = d;
                            }
                            return;
                        }
                        Arrays.fill(dMatrixRMaj.data, this.extents.col0, this.extents.col1 + 1, d);
                        return;
                    }
                    if (list.size() == 2) {
                        if (!Operation.extractSimpleExtents((Variable) list.get(0), this.extents, true, dMatrixRMaj.getNumRows()) || !Operation.extractSimpleExtents((Variable) list.get(1), this.extents, false, dMatrixRMaj.getNumCols())) {
                            Operation.extractArrayExtent((Variable) list.get(0), dMatrixRMaj.numRows, this.rowExtent);
                            Operation.extractArrayExtent((Variable) list.get(1), dMatrixRMaj.numCols, this.colExtent);
                            for (int i2 = 0; i2 < this.rowExtent.length; i2++) {
                                for (int i3 = 0; i3 < this.colExtent.length; i3++) {
                                    dMatrixRMaj.unsafe_set(this.rowExtent.array[i2], this.colExtent.array[i3], d);
                                }
                            }
                            return;
                        }
                        this.extents.row1++;
                        this.extents.col1++;
                        for (int i4 = this.extents.row0; i4 < this.extents.row1; i4++) {
                            int i5 = (dMatrixRMaj.numCols * i4) + this.extents.col0;
                            int i6 = this.extents.col0;
                            while (i6 < this.extents.col1) {
                                dMatrixRMaj.data[i5] = d;
                                i6++;
                                i5++;
                            }
                        }
                        return;
                    }
                    throw new RuntimeException("Unexpected number of ranges.  Should have been caught earlier");
                }
            };
        }
        throw new RuntimeException("Both variables must be of type VariableMatrix");
    }

    public static Info transpose(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("transpose-m") { // from class: org.ejml.equation.Operation.44
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numCols, variableMatrix.matrix.numRows);
                    CommonOps_DDRM.transpose(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Transpose only makes sense for a matrix");
    }

    public static Info inv(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("inv-m") { // from class: org.ejml.equation.Operation.45
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numRows, variableMatrix.matrix.numCols);
                    if (!CommonOps_DDRM.invert(variableMatrix.matrix, variableMatrixCreateMatrix.matrix)) {
                        throw new RuntimeException("Inverse failed!");
                    }
                }
            };
            return info;
        }
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        info.f2755op = new Operation("inv-s") { // from class: org.ejml.equation.Operation.46
            @Override // org.ejml.equation.Operation
            public void process() {
                VariableScalar variableScalar = (VariableScalar) variable;
                variableDoubleCreateDouble.value = 1.0d / variableScalar.getDouble();
            }
        };
        return info;
    }

    public static Info pinv(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("pinv-m") { // from class: org.ejml.equation.Operation.47
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numCols, variableMatrix.matrix.numRows);
                    CommonOps_DDRM.pinv(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        info.f2755op = new Operation("pinv-s") { // from class: org.ejml.equation.Operation.48
            @Override // org.ejml.equation.Operation
            public void process() {
                VariableScalar variableScalar = (VariableScalar) variable;
                variableDoubleCreateDouble.value = 1.0d / variableScalar.getDouble();
            }
        };
        return info;
    }

    public static Info rref(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("rref-m") { // from class: org.ejml.equation.Operation.49
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.rref(dMatrixRMaj, -1, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        info.f2755op = new Operation("rref-s") { // from class: org.ejml.equation.Operation.50
            @Override // org.ejml.equation.Operation
            public void process() {
                double d = ((VariableScalar) variable).getDouble();
                VariableDouble variableDouble = variableDoubleCreateDouble;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d2 = 1.0d;
                }
                variableDouble.value = d2;
            }
        };
        return info;
    }

    public static Info det(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableMatrix) {
            info.f2755op = new Operation("det-m") { // from class: org.ejml.equation.Operation.51
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    variableDoubleCreateDouble.value = CommonOps_DDRM.det(variableMatrix.matrix);
                }
            };
            return info;
        }
        info.f2755op = new Operation("det-s") { // from class: org.ejml.equation.Operation.52
            @Override // org.ejml.equation.Operation
            public void process() {
                VariableScalar variableScalar = (VariableScalar) variable;
                variableDoubleCreateDouble.value = variableScalar.getDouble();
            }
        };
        return info;
    }

    public static Info trace(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableMatrix) {
            info.f2755op = new Operation("trace-m") { // from class: org.ejml.equation.Operation.53
                @Override // org.ejml.equation.Operation
                public void process() {
                    VariableMatrix variableMatrix = (VariableMatrix) variable;
                    variableDoubleCreateDouble.value = CommonOps_DDRM.trace(variableMatrix.matrix);
                }
            };
            return info;
        }
        info.f2755op = new Operation("trace-s") { // from class: org.ejml.equation.Operation.54
            @Override // org.ejml.equation.Operation
            public void process() {
                VariableScalar variableScalar = (VariableScalar) variable;
                variableDoubleCreateDouble.value = variableScalar.getDouble();
            }
        };
        return info;
    }

    public static Info normF(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (variable instanceof VariableMatrix) {
            info.f2755op = new Operation("normF-m") { // from class: org.ejml.equation.Operation.55
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = NormOps_DDRM.normF(((VariableMatrix) variable).matrix);
                }
            };
            return info;
        }
        info.f2755op = new Operation("normF-s") { // from class: org.ejml.equation.Operation.56
            @Override // org.ejml.equation.Operation
            public void process() {
                variableDoubleCreateDouble.value = Math.abs(((VariableScalar) variable).getDouble());
            }
        };
        return info;
    }

    public static Info normP(Variable variable, Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (!(variable instanceof VariableMatrix) || !(variable2 instanceof VariableScalar)) {
            throw new RuntimeException("normP(A,p) A should be a matrix and p a scalar");
        }
        final double d = ((VariableScalar) variable2).getDouble();
        final VariableMatrix variableMatrix = (VariableMatrix) variable;
        info.f2755op = new Operation("normP") { // from class: org.ejml.equation.Operation.57
            @Override // org.ejml.equation.Operation
            public void process() {
                variableDoubleCreateDouble.value = NormOps_DDRM.normP(variableMatrix.matrix, d);
            }
        };
        return info;
    }

    public static Info max(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("max-m") { // from class: org.ejml.equation.Operation.58
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = CommonOps_DDRM.elementMax(((VariableMatrix) variable).matrix);
                }
            };
            return info;
        }
        if (variable instanceof VariableInteger) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("max-i") { // from class: org.ejml.equation.Operation.59
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableIntegerCreateInteger.value = ((VariableInteger) variable).value;
                }
            };
            return info;
        }
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble2 = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble2;
            info.f2755op = new Operation("max-s") { // from class: org.ejml.equation.Operation.60
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble2.value = ((VariableDouble) variable).getDouble();
                }
            };
        }
        return info;
    }

    public static Info max_two(Variable variable, Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if (!(variable instanceof VariableMatrix) || !(variable2 instanceof VariableScalar)) {
            throw new RuntimeException("max(A,d) A = matrix and d = scalar");
        }
        double d = ((VariableScalar) variable2).getDouble();
        final VariableMatrix variableMatrix = (VariableMatrix) variable;
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            info.f2755op = new Operation("max_rows") { // from class: org.ejml.equation.Operation.61
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numRows, 1);
                    CommonOps_DDRM.maxRows(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if (d == 1.0d) {
            info.f2755op = new Operation("max_cols") { // from class: org.ejml.equation.Operation.62
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(1, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.maxCols(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("max(A,d) expected d to be 0 for rows or 1 for columns");
    }

    public static Info min(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("min-m") { // from class: org.ejml.equation.Operation.63
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = CommonOps_DDRM.elementMin(((VariableMatrix) variable).matrix);
                }
            };
            return info;
        }
        if (variable instanceof VariableInteger) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("min-i") { // from class: org.ejml.equation.Operation.64
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableIntegerCreateInteger.value = ((VariableInteger) variable).value;
                }
            };
            return info;
        }
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble2 = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble2;
            info.f2755op = new Operation("min-s") { // from class: org.ejml.equation.Operation.65
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble2.value = ((VariableDouble) variable).getDouble();
                }
            };
        }
        return info;
    }

    public static Info min_two(Variable variable, Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if (!(variable instanceof VariableMatrix) || !(variable2 instanceof VariableScalar)) {
            throw new RuntimeException("min(A,d) A = matrix and d = scalar");
        }
        double d = ((VariableScalar) variable2).getDouble();
        final VariableMatrix variableMatrix = (VariableMatrix) variable;
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            info.f2755op = new Operation("min_rows") { // from class: org.ejml.equation.Operation.66
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numRows, 1);
                    CommonOps_DDRM.minRows(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if (d == 1.0d) {
            info.f2755op = new Operation("min_cols") { // from class: org.ejml.equation.Operation.67
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(1, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.minCols(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("min(A,d) expected d to be 0 for rows or 1 for columns");
    }

    public static Info abs(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("abs-m") { // from class: org.ejml.equation.Operation.68
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    int numElements = dMatrixRMaj.getNumElements();
                    for (int i = 0; i < numElements; i++) {
                        variableMatrixCreateMatrix.matrix.data[i] = Math.abs(dMatrixRMaj.data[i]);
                    }
                }
            };
            return info;
        }
        if (variable instanceof VariableInteger) {
            final VariableInteger variableIntegerCreateInteger = managerTempVariables.createInteger();
            info.output = variableIntegerCreateInteger;
            info.f2755op = new Operation("abs-i") { // from class: org.ejml.equation.Operation.69
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableIntegerCreateInteger.value = Math.abs(((VariableInteger) variable).value);
                }
            };
            return info;
        }
        if (variable instanceof VariableScalar) {
            final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
            info.output = variableDoubleCreateDouble;
            info.f2755op = new Operation("abs-s") { // from class: org.ejml.equation.Operation.70
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableDoubleCreateDouble.value = Math.abs(((VariableDouble) variable).getDouble());
                }
            };
        }
        return info;
    }

    public static Info eye(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if (variable instanceof VariableMatrix) {
            info.f2755op = new Operation("eye-m") { // from class: org.ejml.equation.Operation.71
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    CommonOps_DDRM.setIdentity(variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if (variable instanceof VariableInteger) {
            info.f2755op = new Operation("eye-i") { // from class: org.ejml.equation.Operation.72
                @Override // org.ejml.equation.Operation
                public void process() {
                    int i = ((VariableInteger) variable).value;
                    variableMatrixCreateMatrix.matrix.reshape(i, i);
                    CommonOps_DDRM.setIdentity(variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Unsupported variable type " + variable);
    }

    public static Info diag(final Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        if (variable instanceof VariableMatrix) {
            final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
            info.output = variableMatrixCreateMatrix;
            info.f2755op = new Operation("diag-m") { // from class: org.ejml.equation.Operation.73
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
                        int numElements = dMatrixRMaj.getNumElements();
                        variableMatrixCreateMatrix.matrix.reshape(numElements, numElements);
                        CommonOps_DDRM.diag(variableMatrixCreateMatrix.matrix, numElements, dMatrixRMaj.data);
                    } else {
                        int iMin = Math.min(dMatrixRMaj.numCols, dMatrixRMaj.numRows);
                        variableMatrixCreateMatrix.matrix.reshape(iMin, 1);
                        for (int i = 0; i < iMin; i++) {
                            variableMatrixCreateMatrix.matrix.data[i] = dMatrixRMaj.unsafe_get(i, i);
                        }
                    }
                }
            };
            return info;
        }
        throw new RuntimeException("diag requires a matrix as input");
    }

    public static Info zeros(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            info.f2755op = new Operation("zeros-ii") { // from class: org.ejml.equation.Operation.74
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(((VariableInteger) variable).value, ((VariableInteger) variable2).value);
                    CommonOps_DDRM.fill(variableMatrixCreateMatrix.matrix, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
            };
            return info;
        }
        throw new RuntimeException("Expected two integers got " + variable + " " + variable2);
    }

    public static Info ones(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if ((variable instanceof VariableInteger) && (variable2 instanceof VariableInteger)) {
            info.f2755op = new Operation("ones-ii") { // from class: org.ejml.equation.Operation.75
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(((VariableInteger) variable).value, ((VariableInteger) variable2).value);
                    CommonOps_DDRM.fill(variableMatrixCreateMatrix.matrix, 1.0d);
                }
            };
            return info;
        }
        throw new RuntimeException("Expected two integers got " + variable + " " + variable2);
    }

    public static Info kron(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            info.f2755op = new Operation("kron-mm") { // from class: org.ejml.equation.Operation.76
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable2).matrix;
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numRows * dMatrixRMaj2.numRows, dMatrixRMaj.numCols * dMatrixRMaj2.numCols);
                    CommonOps_DDRM.kron(dMatrixRMaj, dMatrixRMaj2, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Both inputs must be matrices ");
    }

    public static Info dot(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            info.f2755op = new Operation("dot-mm") { // from class: org.ejml.equation.Operation.77
                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable2).matrix;
                    if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj) || !MatrixFeatures_DDRM.isVector(dMatrixRMaj2)) {
                        throw new RuntimeException("Both inputs to dot() must be vectors");
                    }
                    variableDoubleCreateDouble.value = VectorVectorMult_DDRM.innerProd(dMatrixRMaj, dMatrixRMaj2);
                }
            };
            return info;
        }
        throw new RuntimeException("Expected two matrices got " + variable + " " + variable2);
    }

    public static Info solve(final Variable variable, final Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if ((variable instanceof VariableMatrix) && (variable2 instanceof VariableMatrix)) {
            info.f2755op = new Operation("solve-mm") { // from class: org.ejml.equation.Operation.78
                LinearSolverDense<DMatrixRMaj> solver;

                @Override // org.ejml.equation.Operation
                public void process() {
                    DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
                    DMatrixRMaj dMatrixRMaj2 = ((VariableMatrix) variable2).matrix;
                    if (this.solver == null) {
                        this.solver = LinearSolverFactory_DDRM.leastSquares(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
                    }
                    if (!this.solver.setA(dMatrixRMaj)) {
                        throw new RuntimeException("Solver failed!");
                    }
                    variableMatrixCreateMatrix.matrix.reshape(dMatrixRMaj.numCols, dMatrixRMaj2.numCols);
                    this.solver.solve(dMatrixRMaj2, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("Expected two matrices got " + variable + " " + variable2);
    }

    public static Info extract(final List<Variable> list, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if (!(list.get(0) instanceof VariableMatrix)) {
            throw new RuntimeException("First parameter must be a matrix.");
        }
        for (int i = 1; i < list.size(); i++) {
            if (!(list.get(i) instanceof VariableInteger) && list.get(i).getType() != VariableType.INTEGER_SEQUENCE) {
                throw new RuntimeException("Parameters must be integers, integer list, or array range");
            }
        }
        info.f2755op = new Operation("extract") { // from class: org.ejml.equation.Operation.79
            Extents extents = new Extents();
            ArrayExtent rowExtent = new ArrayExtent();
            ArrayExtent colExtent = new ArrayExtent();

            @Override // org.ejml.equation.Operation
            public void process() {
                DMatrixRMaj dMatrixRMaj = ((VariableMatrix) list.get(0)).matrix;
                if (list.size() == 2) {
                    if (!Operation.extractSimpleExtents((Variable) list.get(1), this.extents, false, dMatrixRMaj.getNumElements())) {
                        Operation.extractArrayExtent((Variable) list.get(1), dMatrixRMaj.getNumElements(), this.colExtent);
                        variableMatrixCreateMatrix.matrix.reshape(1, this.colExtent.length);
                        CommonOps_DDRM.extract(dMatrixRMaj, this.colExtent.array, this.colExtent.length, variableMatrixCreateMatrix.matrix);
                        return;
                    } else {
                        this.extents.col1++;
                        variableMatrixCreateMatrix.matrix.reshape(1, this.extents.col1 - this.extents.col0);
                        System.arraycopy(dMatrixRMaj.data, this.extents.col0, variableMatrixCreateMatrix.matrix.data, 0, this.extents.col1 - this.extents.col0);
                        return;
                    }
                }
                if (!Operation.extractSimpleExtents((Variable) list.get(1), this.extents, true, dMatrixRMaj.numRows) || !Operation.extractSimpleExtents((Variable) list.get(2), this.extents, false, dMatrixRMaj.numCols)) {
                    Operation.extractArrayExtent((Variable) list.get(1), dMatrixRMaj.numRows, this.rowExtent);
                    Operation.extractArrayExtent((Variable) list.get(2), dMatrixRMaj.numCols, this.colExtent);
                    variableMatrixCreateMatrix.matrix.reshape(this.rowExtent.length, this.colExtent.length);
                    CommonOps_DDRM.extract(dMatrixRMaj, this.rowExtent.array, this.rowExtent.length, this.colExtent.array, this.colExtent.length, variableMatrixCreateMatrix.matrix);
                    return;
                }
                this.extents.row1++;
                this.extents.col1++;
                variableMatrixCreateMatrix.matrix.reshape(this.extents.row1 - this.extents.row0, this.extents.col1 - this.extents.col0);
                CommonOps_DDRM.extract(dMatrixRMaj, this.extents.row0, this.extents.row1, this.extents.col0, this.extents.col1, variableMatrixCreateMatrix.matrix, 0, 0);
            }
        };
        return info;
    }

    public static Info sum_one(Variable variable, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (!(variable instanceof VariableMatrix)) {
            throw new RuntimeException("sum(A) A = matrix");
        }
        final VariableMatrix variableMatrix = (VariableMatrix) variable;
        info.f2755op = new Operation("sum_all") { // from class: org.ejml.equation.Operation.80
            @Override // org.ejml.equation.Operation
            public void process() {
                variableDoubleCreateDouble.value = CommonOps_DDRM.elementSum(variableMatrix.matrix);
            }
        };
        return info;
    }

    public static Info sum_two(Variable variable, Variable variable2, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableMatrix variableMatrixCreateMatrix = managerTempVariables.createMatrix();
        info.output = variableMatrixCreateMatrix;
        if (!(variable instanceof VariableMatrix) || !(variable2 instanceof VariableScalar)) {
            throw new RuntimeException("sum(A,p) A = matrix and p = scalar");
        }
        double d = ((VariableScalar) variable2).getDouble();
        final VariableMatrix variableMatrix = (VariableMatrix) variable;
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            info.f2755op = new Operation("sum_rows") { // from class: org.ejml.equation.Operation.81
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(variableMatrix.matrix.numRows, 1);
                    CommonOps_DDRM.sumRows(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        if (d == 1.0d) {
            info.f2755op = new Operation("sum_cols") { // from class: org.ejml.equation.Operation.82
                @Override // org.ejml.equation.Operation
                public void process() {
                    variableMatrixCreateMatrix.matrix.reshape(1, variableMatrix.matrix.numCols);
                    CommonOps_DDRM.sumCols(variableMatrix.matrix, variableMatrixCreateMatrix.matrix);
                }
            };
            return info;
        }
        throw new RuntimeException("sum(A,d) expected d to be 0 for rows or 1 for columns");
    }

    public static Info extractScalar(final List<Variable> list, ManagerTempVariables managerTempVariables) {
        Info info = new Info();
        final VariableDouble variableDoubleCreateDouble = managerTempVariables.createDouble();
        info.output = variableDoubleCreateDouble;
        if (!(list.get(0) instanceof VariableMatrix)) {
            throw new RuntimeException("First parameter must be a matrix.");
        }
        for (int i = 1; i < list.size(); i++) {
            if (!(list.get(i) instanceof VariableInteger)) {
                throw new RuntimeException("Parameters must be integers for extract scalar");
            }
        }
        info.f2755op = new Operation("extractScalar") { // from class: org.ejml.equation.Operation.83
            @Override // org.ejml.equation.Operation
            public void process() {
                DMatrixRMaj dMatrixRMaj = ((VariableMatrix) list.get(0)).matrix;
                if (list.size() == 2) {
                    int i2 = ((VariableInteger) list.get(1)).value;
                    variableDoubleCreateDouble.value = dMatrixRMaj.get(i2);
                } else {
                    int i3 = ((VariableInteger) list.get(1)).value;
                    int i4 = ((VariableInteger) list.get(2)).value;
                    variableDoubleCreateDouble.value = dMatrixRMaj.get(i3, i4);
                }
            }
        };
        return info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean extractSimpleExtents(Variable variable, Extents extents, boolean z, int i) {
        int start;
        int end;
        if (variable.getType() == VariableType.INTEGER_SEQUENCE) {
            IntegerSequence integerSequence = ((VariableIntegerSequence) variable).sequence;
            if (integerSequence.getType() == IntegerSequence.Type.FOR) {
                IntegerSequence.For r4 = (IntegerSequence.For) integerSequence;
                r4.initialize(i);
                if (r4.getStep() == 1) {
                    start = r4.getStart();
                    end = r4.getEnd();
                }
            }
            return false;
        }
        if (variable.getType() == VariableType.SCALAR) {
            start = ((VariableInteger) variable).value;
            end = start;
        } else {
            throw new RuntimeException("How did a bad variable get put here?!?!");
        }
        if (z) {
            extents.row0 = start;
            extents.row1 = end;
        } else {
            extents.col0 = start;
            extents.col1 = end;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extractArrayExtent(Variable variable, int i, ArrayExtent arrayExtent) {
        int i2 = 0;
        if (variable.getType() == VariableType.INTEGER_SEQUENCE) {
            IntegerSequence integerSequence = ((VariableIntegerSequence) variable).sequence;
            integerSequence.initialize(i - 1);
            arrayExtent.setLength(integerSequence.length());
            while (integerSequence.hasNext()) {
                arrayExtent.array[i2] = integerSequence.next();
                i2++;
            }
            return;
        }
        if (variable.getType() == VariableType.SCALAR) {
            arrayExtent.setLength(1);
            arrayExtent.array[0] = ((VariableInteger) variable).value;
            return;
        }
        throw new RuntimeException("How did a bad variable get put here?!?!");
    }

    public static Info matrixConstructor(final MatrixConstructor matrixConstructor) {
        Info info = new Info();
        info.output = matrixConstructor.getOutput();
        info.f2755op = new Operation("matrixConstructor") { // from class: org.ejml.equation.Operation.84
            @Override // org.ejml.equation.Operation
            public void process() {
                matrixConstructor.construct();
            }
        };
        return info;
    }

    public static class ArrayExtent {
        int[] array = new int[1];
        int length;

        public void setLength(int i) {
            if (i > this.array.length) {
                this.array = new int[i];
            }
            this.length = i;
        }
    }
}
