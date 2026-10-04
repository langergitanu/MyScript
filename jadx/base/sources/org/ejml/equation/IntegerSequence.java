package org.ejml.equation;

import java.util.ArrayList;
import java.util.List;
import org.ejml.equation.TokenList;

/* JADX INFO: loaded from: classes9.dex */
public interface IntegerSequence {

    public enum Type {
        EXPLICIT,
        FOR,
        COMBINED,
        RANGE
    }

    Type getType();

    boolean hasNext();

    void initialize(int i);

    int length();

    int next();

    boolean requiresMaxIndex();

    public static class Explicit implements IntegerSequence {
        List<VariableInteger> sequence;
        int where;

        @Override // org.ejml.equation.IntegerSequence
        public boolean requiresMaxIndex() {
            return false;
        }

        public Explicit(TokenList.Token token, TokenList.Token token2) {
            this.sequence = new ArrayList();
            while (true) {
                this.sequence.add((VariableInteger) token.getVariable());
                if (token == token2) {
                    return;
                } else {
                    token = token.next;
                }
            }
        }

        public Explicit(TokenList.Token token) {
            ArrayList arrayList = new ArrayList();
            this.sequence = arrayList;
            arrayList.add((VariableInteger) token.getVariable());
        }

        @Override // org.ejml.equation.IntegerSequence
        public int length() {
            return this.sequence.size();
        }

        @Override // org.ejml.equation.IntegerSequence
        public void initialize(int i) {
            this.where = 0;
        }

        @Override // org.ejml.equation.IntegerSequence
        public int next() {
            List<VariableInteger> list = this.sequence;
            int i = this.where;
            this.where = i + 1;
            return list.get(i).value;
        }

        @Override // org.ejml.equation.IntegerSequence
        public boolean hasNext() {
            return this.where < this.sequence.size();
        }

        @Override // org.ejml.equation.IntegerSequence
        public Type getType() {
            return Type.EXPLICIT;
        }

        public List<VariableInteger> getSequence() {
            return this.sequence;
        }
    }

    public static class For implements IntegerSequence {
        VariableInteger end;
        int length;
        VariableInteger start;
        VariableInteger step;
        int valEnd;
        int valStart;
        int valStep;
        int where;

        @Override // org.ejml.equation.IntegerSequence
        public boolean requiresMaxIndex() {
            return false;
        }

        public For(TokenList.Token token, TokenList.Token token2, TokenList.Token token3) {
            this.start = (VariableInteger) token.getVariable();
            this.step = token2 == null ? null : (VariableInteger) token2.getVariable();
            this.end = (VariableInteger) token3.getVariable();
        }

        @Override // org.ejml.equation.IntegerSequence
        public int length() {
            return this.length;
        }

        @Override // org.ejml.equation.IntegerSequence
        public void initialize(int i) {
            this.valStart = this.start.value;
            this.valEnd = this.end.value;
            VariableInteger variableInteger = this.step;
            if (variableInteger == null) {
                this.valStep = 1;
            } else {
                this.valStep = variableInteger.value;
            }
            int i2 = this.valStep;
            if (i2 <= 0) {
                throw new IllegalArgumentException("step size must be a positive integer");
            }
            int i3 = this.valEnd;
            int i4 = this.valStart;
            if (i3 < i4) {
                throw new IllegalArgumentException("end value must be >= the start value");
            }
            this.where = 0;
            this.length = ((i3 - i4) / i2) + 1;
        }

        @Override // org.ejml.equation.IntegerSequence
        public int next() {
            int i = this.valStart;
            int i2 = this.valStep;
            int i3 = this.where;
            this.where = i3 + 1;
            return i + (i2 * i3);
        }

        @Override // org.ejml.equation.IntegerSequence
        public boolean hasNext() {
            return this.where < this.length;
        }

        public int getStart() {
            return this.valStart;
        }

        public int getStep() {
            return this.valStep;
        }

        public int getEnd() {
            return this.valEnd;
        }

        @Override // org.ejml.equation.IntegerSequence
        public Type getType() {
            return Type.FOR;
        }
    }

    public static class Combined implements IntegerSequence {
        List<IntegerSequence> sequences = new ArrayList();
        int which;

        public Combined(TokenList.Token token, TokenList.Token token2) {
            do {
                if (token.getVariable().getType() == VariableType.SCALAR) {
                    this.sequences.add(new Explicit(token));
                } else if (token.getVariable().getType() == VariableType.INTEGER_SEQUENCE) {
                    this.sequences.add(((VariableIntegerSequence) token.getVariable()).sequence);
                } else {
                    throw new RuntimeException("Unexpected token type");
                }
                token = token.next;
                if (token == null) {
                    return;
                }
            } while (token.previous != token2);
        }

        @Override // org.ejml.equation.IntegerSequence
        public int length() {
            int length = 0;
            for (int i = 0; i < this.sequences.size(); i++) {
                length += this.sequences.get(i).length();
            }
            return length;
        }

        @Override // org.ejml.equation.IntegerSequence
        public void initialize(int i) {
            this.which = 0;
            for (int i2 = 0; i2 < this.sequences.size(); i2++) {
                this.sequences.get(i2).initialize(i);
            }
        }

        @Override // org.ejml.equation.IntegerSequence
        public int next() {
            int next = this.sequences.get(this.which).next();
            if (!this.sequences.get(this.which).hasNext()) {
                this.which++;
            }
            return next;
        }

        @Override // org.ejml.equation.IntegerSequence
        public boolean hasNext() {
            return this.which < this.sequences.size();
        }

        @Override // org.ejml.equation.IntegerSequence
        public Type getType() {
            return Type.COMBINED;
        }

        @Override // org.ejml.equation.IntegerSequence
        public boolean requiresMaxIndex() {
            for (int i = 0; i < this.sequences.size(); i++) {
                if (this.sequences.get(i).requiresMaxIndex()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class Range implements IntegerSequence {
        int length;
        VariableInteger start;
        VariableInteger step;
        int valEnd;
        int valStart;
        int valStep;
        int where;

        @Override // org.ejml.equation.IntegerSequence
        public boolean requiresMaxIndex() {
            return true;
        }

        public Range(TokenList.Token token, TokenList.Token token2) {
            this.start = token == null ? null : (VariableInteger) token.getVariable();
            this.step = token2 != null ? (VariableInteger) token2.getVariable() : null;
        }

        @Override // org.ejml.equation.IntegerSequence
        public int length() {
            return this.length;
        }

        @Override // org.ejml.equation.IntegerSequence
        public void initialize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Range sequence being used inside an object without a known upper limit");
            }
            this.valEnd = i;
            VariableInteger variableInteger = this.start;
            if (variableInteger != null) {
                this.valStart = variableInteger.value;
            } else {
                this.valStart = 0;
            }
            VariableInteger variableInteger2 = this.step;
            if (variableInteger2 == null) {
                this.valStep = 1;
            } else {
                this.valStep = variableInteger2.value;
            }
            int i2 = this.valStep;
            if (i2 <= 0) {
                throw new IllegalArgumentException("step size must be a positive integer");
            }
            this.where = 0;
            this.length = ((this.valEnd - this.valStart) / i2) + 1;
        }

        @Override // org.ejml.equation.IntegerSequence
        public int next() {
            int i = this.valStart;
            int i2 = this.valStep;
            int i3 = this.where;
            this.where = i3 + 1;
            return i + (i2 * i3);
        }

        @Override // org.ejml.equation.IntegerSequence
        public boolean hasNext() {
            return this.where < this.length;
        }

        public int getStart() {
            return this.valStart;
        }

        public int getStep() {
            return this.valStep;
        }

        public int getEnd() {
            return this.valEnd;
        }

        @Override // org.ejml.equation.IntegerSequence
        public Type getType() {
            return Type.RANGE;
        }
    }
}
