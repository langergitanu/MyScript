package org.ejml.equation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ejml.equation.TokenList;

/* JADX INFO: loaded from: classes9.dex */
public class Macro {
    List<String> inputs = new ArrayList();
    String name;
    TokenList tokens;

    public TokenList execute(List<TokenList.Token> list) {
        TokenList tokenList = new TokenList();
        for (TokenList.Token first = this.tokens.getFirst(); first != null; first = first.next) {
            if (first.word != null) {
                int i = 0;
                while (true) {
                    if (i < this.inputs.size()) {
                        if (this.inputs.get(i).equals(first.word)) {
                            tokenList.insert(tokenList.last, list.get(i).copy());
                            break;
                        }
                        i++;
                    } else {
                        tokenList.insert(tokenList.last, first.copy());
                        break;
                    }
                }
            } else {
                tokenList.insert(tokenList.last, first.copy());
            }
        }
        return tokenList;
    }

    public class Assign extends Operation {
        HashMap<String, Macro> macros;

        protected Assign(HashMap<String, Macro> map) {
            super("Macro:" + Macro.this.name);
            this.macros = map;
        }

        @Override // org.ejml.equation.Operation
        public void process() {
            this.macros.put(Macro.this.name, Macro.this);
        }
    }

    public Operation createOperation(HashMap<String, Macro> map) {
        return new Assign(map);
    }
}
