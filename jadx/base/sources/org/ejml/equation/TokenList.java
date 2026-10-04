package org.ejml.equation;

import org.ejml.equation.VariableScalar;

/* JADX INFO: loaded from: classes9.dex */
class TokenList {
    Token first;
    Token last;
    int size = 0;

    public enum Type {
        FUNCTION,
        VARIABLE,
        SYMBOL,
        WORD
    }

    public TokenList() {
    }

    public TokenList(Token token, Token token2) {
        this.first = token;
        this.last = token2;
        while (token != null) {
            this.size++;
            token = token.next;
        }
    }

    public Token add(Function function) {
        Token token = new Token(function);
        push(token);
        return token;
    }

    public Token add(Variable variable) {
        Token token = new Token(variable);
        push(token);
        return token;
    }

    public Token add(Symbol symbol) {
        Token token = new Token(symbol);
        push(token);
        return token;
    }

    public Token add(String str) {
        Token token = new Token(str);
        push(token);
        return token;
    }

    public void push(Token token) {
        this.size++;
        if (this.first == null) {
            this.first = token;
            this.last = token;
            token.previous = null;
            token.next = null;
            return;
        }
        this.last.next = token;
        token.previous = this.last;
        token.next = null;
        this.last = token;
    }

    public void insert(Token token, Token token2) {
        if (token == null) {
            if (this.size == 0) {
                push(token2);
                return;
            }
            this.first.previous = token2;
            token2.previous = null;
            token2.next = this.first;
            this.first = token2;
            this.size++;
            return;
        }
        Token token3 = this.last;
        if (token == token3 || token3 == null) {
            push(token2);
            return;
        }
        token2.next = token.next;
        token2.previous = token;
        token.next.previous = token2;
        token.next = token2;
        this.size++;
    }

    public void remove(Token token) {
        Token token2 = this.first;
        if (token == token2) {
            this.first = token2.next;
        }
        Token token3 = this.last;
        if (token == token3) {
            this.last = token3.previous;
        }
        if (token.next != null) {
            token.next.previous = token.previous;
        }
        if (token.previous != null) {
            token.previous.next = token.next;
        }
        token.previous = null;
        token.next = null;
        this.size--;
    }

    public void replace(Token token, Token token2) {
        if (this.first == token) {
            this.first = token2;
        }
        if (this.last == token) {
            this.last = token2;
        }
        token2.next = token.next;
        token2.previous = token.previous;
        if (token.next != null) {
            token.next.previous = token2;
        }
        if (token.previous != null) {
            token.previous.next = token2;
        }
        token.previous = null;
        token.next = null;
    }

    public TokenList extractSubList(Token token, Token token2) {
        if (token == token2) {
            remove(token);
            return new TokenList(token, token);
        }
        if (this.first == token) {
            this.first = token2.next;
        }
        if (this.last == token2) {
            this.last = token.previous;
        }
        if (token.previous != null) {
            token.previous.next = token2.next;
        }
        if (token2.next != null) {
            token2.next.previous = token.previous;
        }
        token.previous = null;
        token2.next = null;
        TokenList tokenList = new TokenList(token, token2);
        this.size -= tokenList.size();
        return tokenList;
    }

    public void insertAfter(Token token, TokenList tokenList) {
        Token token2 = token.next;
        token.next = tokenList.first;
        tokenList.first.previous = token;
        if (token2 == null) {
            this.last = tokenList.last;
        } else {
            token2.previous = tokenList.last;
            tokenList.last.next = token2;
        }
        this.size += tokenList.size;
    }

    public String toString() {
        String str = "";
        for (Token token = this.first; token != null; token = token.next) {
            str = str + token + " ";
        }
        return str;
    }

    public Token getFirst() {
        return this.first;
    }

    public Token getLast() {
        return this.last;
    }

    public int size() {
        return this.size;
    }

    public static class Token {
        public Function function;
        public Token next;
        public Token previous;
        public Symbol symbol;
        public Variable variable;
        public String word;

        public Token(Function function) {
            this.function = function;
        }

        public Token(Variable variable) {
            this.variable = variable;
        }

        public Token(Symbol symbol) {
            this.symbol = symbol;
        }

        public Token(String str) {
            this.word = str;
        }

        public Token() {
        }

        public Type getType() {
            if (this.function != null) {
                return Type.FUNCTION;
            }
            if (this.variable != null) {
                return Type.VARIABLE;
            }
            if (this.word != null) {
                return Type.WORD;
            }
            return Type.SYMBOL;
        }

        public Variable getVariable() {
            return this.variable;
        }

        public Function getFunction() {
            return this.function;
        }

        public Symbol getSymbol() {
            return this.symbol;
        }

        public String getWord() {
            return this.word;
        }

        public VariableScalar.Type getScalarType() {
            Variable variable = this.variable;
            if (variable == null || variable.getType() != VariableType.SCALAR) {
                return null;
            }
            return ((VariableScalar) this.variable).getScalarType();
        }

        public String toString() {
            int i = C91411.$SwitchMap$org$ejml$equation$TokenList$Type[getType().ordinal()];
            if (i == 1) {
                return "Func:" + this.function.getName();
            }
            if (i == 2) {
                return "" + this.symbol;
            }
            if (i == 3) {
                return this.variable.toString();
            }
            if (i == 4) {
                return "Word:" + this.word;
            }
            throw new RuntimeException("Unknown type");
        }

        public Token copy() {
            Token token = new Token();
            token.word = this.word;
            token.function = this.function;
            token.symbol = this.symbol;
            token.variable = this.variable;
            return token;
        }
    }

    /* JADX INFO: renamed from: org.ejml.equation.TokenList$1 */
    static /* synthetic */ class C91411 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$equation$TokenList$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$ejml$equation$TokenList$Type = iArr;
            try {
                iArr[Type.FUNCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$equation$TokenList$Type[Type.SYMBOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$equation$TokenList$Type[Type.VARIABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$ejml$equation$TokenList$Type[Type.WORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void print() {
        for (Token token = this.first; token != null; token = token.next) {
            System.out.println(token);
        }
    }
}
