package org.ejml.equation;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ejml.equation.Operation;

/* JADX INFO: loaded from: classes9.dex */
public class ManagerFunctions {
    Map<String, Input1> input1 = new HashMap();
    Map<String, InputN> inputN = new HashMap();
    protected ManagerTempVariables managerTemp;

    public interface Input1 {
        Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables);
    }

    public interface InputN {
        Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables);
    }

    public ManagerFunctions() {
        addBuiltIn();
    }

    public boolean isFunctionName(String str) {
        return this.input1.containsKey(str) || this.inputN.containsKey(str);
    }

    public Operation.Info create(String str, Variable variable) {
        Input1 input1 = this.input1.get(str);
        if (input1 == null) {
            return null;
        }
        return input1.create(variable, this.managerTemp);
    }

    public Operation.Info create(String str, List<Variable> list) {
        InputN inputN = this.inputN.get(str);
        if (inputN == null) {
            return null;
        }
        return inputN.create(list, this.managerTemp);
    }

    public Operation.Info create(char c, Variable variable) {
        if (c == '\'') {
            return Operation.transpose(variable, this.managerTemp);
        }
        throw new RuntimeException("Unknown operation " + c);
    }

    /* JADX INFO: renamed from: org.ejml.equation.ManagerFunctions$32 */
    static /* synthetic */ class C904932 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$equation$Symbol;

        static {
            int[] iArr = new int[Symbol.values().length];
            $SwitchMap$org$ejml$equation$Symbol = iArr;
            try {
                iArr[Symbol.PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.TIMES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.RDIVIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.LDIVIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.POWER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ELEMENT_DIVIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ELEMENT_TIMES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ELEMENT_POWER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Operation.Info create(Symbol symbol, Variable variable, Variable variable2) {
        switch (C904932.$SwitchMap$org$ejml$equation$Symbol[symbol.ordinal()]) {
            case 1:
                return Operation.add(variable, variable2, this.managerTemp);
            case 2:
                return Operation.subtract(variable, variable2, this.managerTemp);
            case 3:
                return Operation.multiply(variable, variable2, this.managerTemp);
            case 4:
                return Operation.divide(variable, variable2, this.managerTemp);
            case 5:
                return Operation.divide(variable2, variable, this.managerTemp);
            case 6:
                return Operation.pow(variable, variable2, this.managerTemp);
            case 7:
                return Operation.elementDivision(variable, variable2, this.managerTemp);
            case 8:
                return Operation.elementMult(variable, variable2, this.managerTemp);
            case 9:
                return Operation.elementPow(variable, variable2, this.managerTemp);
            default:
                throw new RuntimeException("Unknown operation " + symbol);
        }
    }

    public void setManagerTemp(ManagerTempVariables managerTempVariables) {
        this.managerTemp = managerTempVariables;
    }

    public void add(String str, Input1 input1) {
        this.input1.put(str, input1);
    }

    public void add(String str, InputN inputN) {
        this.inputN.put(str, inputN);
    }

    private void addBuiltIn() {
        this.input1.put("inv", new Input1() { // from class: org.ejml.equation.ManagerFunctions.1
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.inv(variable, managerTempVariables);
            }
        });
        this.input1.put("pinv", new Input1() { // from class: org.ejml.equation.ManagerFunctions.2
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.pinv(variable, managerTempVariables);
            }
        });
        this.input1.put("rref", new Input1() { // from class: org.ejml.equation.ManagerFunctions.3
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.rref(variable, managerTempVariables);
            }
        });
        this.input1.put("eye", new Input1() { // from class: org.ejml.equation.ManagerFunctions.4
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.eye(variable, managerTempVariables);
            }
        });
        this.input1.put("det", new Input1() { // from class: org.ejml.equation.ManagerFunctions.5
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.det(variable, managerTempVariables);
            }
        });
        this.input1.put("normF", new Input1() { // from class: org.ejml.equation.ManagerFunctions.6
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.normF(variable, managerTempVariables);
            }
        });
        this.input1.put("sum", new Input1() { // from class: org.ejml.equation.ManagerFunctions.7
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.sum_one(variable, managerTempVariables);
            }
        });
        this.input1.put("trace", new Input1() { // from class: org.ejml.equation.ManagerFunctions.8
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.trace(variable, managerTempVariables);
            }
        });
        this.input1.put("diag", new Input1() { // from class: org.ejml.equation.ManagerFunctions.9
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.diag(variable, managerTempVariables);
            }
        });
        this.input1.put("min", new Input1() { // from class: org.ejml.equation.ManagerFunctions.10
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.min(variable, managerTempVariables);
            }
        });
        this.input1.put("max", new Input1() { // from class: org.ejml.equation.ManagerFunctions.11
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.max(variable, managerTempVariables);
            }
        });
        this.input1.put("abs", new Input1() { // from class: org.ejml.equation.ManagerFunctions.12
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.abs(variable, managerTempVariables);
            }
        });
        this.input1.put("sin", new Input1() { // from class: org.ejml.equation.ManagerFunctions.13
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.sin(variable, managerTempVariables);
            }
        });
        this.input1.put("cos", new Input1() { // from class: org.ejml.equation.ManagerFunctions.14
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.cos(variable, managerTempVariables);
            }
        });
        this.input1.put("atan", new Input1() { // from class: org.ejml.equation.ManagerFunctions.15
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.atan(variable, managerTempVariables);
            }
        });
        this.input1.put("exp", new Input1() { // from class: org.ejml.equation.ManagerFunctions.16
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.exp(variable, managerTempVariables);
            }
        });
        this.input1.put("log", new Input1() { // from class: org.ejml.equation.ManagerFunctions.17
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.log(variable, managerTempVariables);
            }
        });
        this.input1.put("sqrt", new Input1() { // from class: org.ejml.equation.ManagerFunctions.18
            @Override // org.ejml.equation.ManagerFunctions.Input1
            public Operation.Info create(Variable variable, ManagerTempVariables managerTempVariables) {
                return Operation.sqrt(variable, managerTempVariables);
            }
        });
        this.inputN.put("normP", new InputN() { // from class: org.ejml.equation.ManagerFunctions.19
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.normP(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("max", new InputN() { // from class: org.ejml.equation.ManagerFunctions.20
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("One or two inputs expected");
                }
                return Operation.max_two(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("min", new InputN() { // from class: org.ejml.equation.ManagerFunctions.21
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("One or two inputs expected");
                }
                return Operation.min_two(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("sum", new InputN() { // from class: org.ejml.equation.ManagerFunctions.22
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("One or two inputs expected");
                }
                return Operation.sum_two(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("zeros", new InputN() { // from class: org.ejml.equation.ManagerFunctions.23
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.zeros(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("ones", new InputN() { // from class: org.ejml.equation.ManagerFunctions.24
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.ones(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("kron", new InputN() { // from class: org.ejml.equation.ManagerFunctions.25
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.kron(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, new InputN() { // from class: org.ejml.equation.ManagerFunctions.26
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.dot(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("pow", new InputN() { // from class: org.ejml.equation.ManagerFunctions.27
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.pow(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("atan2", new InputN() { // from class: org.ejml.equation.ManagerFunctions.28
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.atan2(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("solve", new InputN() { // from class: org.ejml.equation.ManagerFunctions.29
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() != 2) {
                    throw new RuntimeException("Two inputs expected");
                }
                return Operation.solve(list.get(0), list.get(1), managerTempVariables);
            }
        });
        this.inputN.put("extract", new InputN() { // from class: org.ejml.equation.ManagerFunctions.30
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                return Operation.extract(list, managerTempVariables);
            }
        });
        this.inputN.put("extractScalar", new InputN() { // from class: org.ejml.equation.ManagerFunctions.31
            @Override // org.ejml.equation.ManagerFunctions.InputN
            public Operation.Info create(List<Variable> list, ManagerTempVariables managerTempVariables) {
                if (list.size() == 2 || list.size() == 3) {
                    return Operation.extractScalar(list, managerTempVariables);
                }
                throw new RuntimeException("Two or three inputs expected");
            }
        });
    }

    public ManagerTempVariables getManagerTemp() {
        return this.managerTemp;
    }
}
