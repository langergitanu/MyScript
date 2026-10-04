package org.ejml.equation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ejml.data.DMatrixRMaj;
import org.ejml.equation.IntegerSequence;
import org.ejml.equation.Operation;
import org.ejml.equation.TokenList;
import org.ejml.equation.VariableScalar;
import org.ejml.simple.SimpleMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class Equation {
    HashMap<String, Variable> variables = new HashMap<>();
    HashMap<String, Macro> macros = new HashMap<>();
    char[] storage = new char[1024];
    ManagerFunctions functions = new ManagerFunctions();

    protected enum TokenType {
        WORD,
        INTEGER,
        FLOAT,
        FLOAT_EXP,
        UNKNOWN
    }

    protected static boolean isSymbol(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-' || c == '(' || c == ')' || c == '[' || c == ']' || c == '=' || c == '\'' || c == '.' || c == ',' || c == ':' || c == ';' || c == '\\' || c == '^';
    }

    public Equation() {
        alias(3.141592653589793d, "pi");
        alias(2.718281828459045d, "e");
    }

    public void alias(DMatrixRMaj dMatrixRMaj, String str) {
        if (isReserved(str)) {
            throw new RuntimeException("Reserved word or contains a reserved character");
        }
        VariableMatrix variableMatrix = (VariableMatrix) this.variables.get(str);
        if (variableMatrix == null) {
            this.variables.put(str, new VariableMatrix(dMatrixRMaj));
        } else {
            variableMatrix.matrix = dMatrixRMaj;
        }
    }

    public void alias(SimpleMatrix simpleMatrix, String str) {
        alias(simpleMatrix.getMatrix(), str);
    }

    public void alias(double d, String str) {
        if (isReserved(str)) {
            throw new RuntimeException("Reserved word or contains a reserved character. '" + str + "'");
        }
        VariableDouble variableDouble = (VariableDouble) this.variables.get(str);
        if (variableDouble == null) {
            this.variables.put(str, new VariableDouble(d));
        } else {
            variableDouble.value = d;
        }
    }

    public void alias(int i, String str) {
        if (isReserved(str)) {
            throw new RuntimeException("Reserved word or contains a reserved character");
        }
        VariableInteger variableInteger = (VariableInteger) this.variables.get(str);
        if (variableInteger == null) {
            this.variables.put(str, new VariableInteger(i));
        } else {
            variableInteger.value = i;
        }
    }

    private void alias(IntegerSequence integerSequence, String str) {
        if (isReserved(str)) {
            throw new RuntimeException("Reserved word or contains a reserved character");
        }
        VariableIntegerSequence variableIntegerSequence = (VariableIntegerSequence) this.variables.get(str);
        if (variableIntegerSequence == null) {
            this.variables.put(str, new VariableIntegerSequence(integerSequence));
        } else {
            variableIntegerSequence.sequence = integerSequence;
        }
    }

    public void alias(Object... objArr) {
        if (objArr.length % 2 == 1) {
            throw new RuntimeException("Even number of arguments expected");
        }
        for (int i = 0; i < objArr.length; i += 2) {
            if (objArr[i].getClass() == Integer.class) {
                alias(((Integer) objArr[i]).intValue(), (String) objArr[i + 1]);
            } else if (objArr[i].getClass() == Double.class) {
                alias(((Double) objArr[i]).doubleValue(), (String) objArr[i + 1]);
            } else if (objArr[i].getClass() == DMatrixRMaj.class) {
                alias((DMatrixRMaj) objArr[i], (String) objArr[i + 1]);
            } else if (objArr[i].getClass() == SimpleMatrix.class) {
                alias((SimpleMatrix) objArr[i], (String) objArr[i + 1]);
            } else {
                throw new RuntimeException("Unknown value type " + objArr[i]);
            }
        }
    }

    public Sequence compile(String str) {
        return compile(str, false);
    }

    public Sequence compile(String str, boolean z) {
        ManagerTempVariables managerTempVariables = new ManagerTempVariables();
        this.functions.setManagerTemp(managerTempVariables);
        Sequence sequence = new Sequence();
        TokenList tokenListExtractTokens = extractTokens(str, managerTempVariables);
        if (tokenListExtractTokens.size() < 3) {
            throw new RuntimeException("Too few tokens");
        }
        TokenList.Token first = tokenListExtractTokens.getFirst();
        if (first.word != null && first.word.compareToIgnoreCase("macro") == 0) {
            parseMacro(tokenListExtractTokens, sequence);
            return sequence;
        }
        insertFunctionsAndVariables(tokenListExtractTokens);
        insertMacros(tokenListExtractTokens);
        if (z) {
            System.out.println("Parsed tokens:\n------------");
            tokenListExtractTokens.print();
            System.out.println();
        }
        if (first.getType() != TokenList.Type.VARIABLE && first.getType() != TokenList.Type.WORD) {
            throw new ParseError("Expected variable name first.  Not " + first);
        }
        List<Variable> assignRange = parseAssignRange(sequence, tokenListExtractTokens, first);
        TokenList.Token token = first.next;
        if (token.getType() != TokenList.Type.SYMBOL || token.getSymbol() != Symbol.ASSIGN) {
            throw new ParseError("Expected assignment operator next");
        }
        TokenList tokenListExtractSubList = tokenListExtractTokens.extractSubList(token.next, tokenListExtractTokens.last);
        checkForUnknownVariables(tokenListExtractSubList);
        handleParentheses(tokenListExtractSubList, sequence);
        if (tokenListExtractSubList.size() > 1) {
            parseBlockNoParentheses(tokenListExtractSubList, sequence, false);
        }
        if (tokenListExtractSubList.size() != 1) {
            throw new RuntimeException("BUG");
        }
        if (tokenListExtractSubList.getLast().getType() != TokenList.Type.VARIABLE) {
            throw new RuntimeException("BUG the last token must be a variable");
        }
        Variable variable = tokenListExtractSubList.getFirst().getVariable();
        if (assignRange == null) {
            sequence.addOperation(Operation.copy(variable, createVariableInferred(first, variable)));
        } else {
            if (first.getType() == TokenList.Type.WORD) {
                throw new ParseError("Can't do lazy variable initialization with submatrices. " + first.getWord());
            }
            sequence.addOperation(Operation.copy(variable, first.getVariable(), assignRange));
        }
        if (z) {
            System.out.println("Operations:\n------------");
            for (int i = 0; i < sequence.operations.size(); i++) {
                System.out.println(sequence.operations.get(i).name());
            }
        }
        return sequence;
    }

    private void parseMacro(TokenList tokenList, Sequence sequence) {
        Macro macro = new Macro();
        TokenList.Token token = tokenList.getFirst().next;
        if (token.word == null) {
            throw new ParseError("Expected the macro's name after " + tokenList.getFirst().word);
        }
        ArrayList arrayList = new ArrayList();
        macro.name = token.word;
        TokenList.Token macroInput = parseMacroInput(arrayList, token.next);
        for (TokenList.Token token2 : arrayList) {
            if (token2.word == null) {
                throw new ParseError("expected word in macro header");
            }
            macro.inputs.add(token2.word);
        }
        TokenList.Token token3 = macroInput.next;
        if (token3 == null || token3.getSymbol() != Symbol.ASSIGN) {
            throw new ParseError("Expected assignment");
        }
        macro.tokens = new TokenList(token3.next, tokenList.last);
        sequence.addOperation(macro.createOperation(this.macros));
    }

    private TokenList.Token parseMacroInput(List<TokenList.Token> list, TokenList.Token token) {
        if (token.getSymbol() != Symbol.PAREN_LEFT) {
            throw new ParseError("Expected (");
        }
        TokenList.Token token2 = token.next;
        boolean z = true;
        while (token2 != null && token2.getSymbol() != Symbol.PAREN_RIGHT) {
            if (z) {
                list.add(token2);
                z = false;
            } else {
                if (token2.getSymbol() != Symbol.COMMA) {
                    throw new ParseError("Expected comma");
                }
                z = true;
            }
            token2 = token2.next;
        }
        if (token2 != null) {
            return token2;
        }
        throw new ParseError("Token sequence ended unexpectedly");
    }

    private void checkForUnknownVariables(TokenList tokenList) {
        for (TokenList.Token first = tokenList.getFirst(); first != null; first = first.next) {
            if (first.getType() == TokenList.Type.WORD) {
                throw new ParseError("Unknown variable on right side. " + first.getWord());
            }
        }
    }

    private Variable createVariableInferred(TokenList.Token token, Variable variable) {
        if (token.getType() == TokenList.Type.WORD) {
            int i = C90231.$SwitchMap$org$ejml$equation$VariableType[variable.getType().ordinal()];
            if (i == 1) {
                alias(new DMatrixRMaj(1, 1), token.getWord());
            } else if (i != 2) {
                if (i == 3) {
                    alias((IntegerSequence) null, token.getWord());
                } else {
                    throw new RuntimeException("Type not supported for assignment: " + variable.getType());
                }
            } else if (variable instanceof VariableInteger) {
                alias(0, token.getWord());
            } else {
                alias(1.0d, token.getWord());
            }
            return this.variables.get(token.getWord());
        }
        return token.getVariable();
    }

    private List<Variable> parseAssignRange(Sequence sequence, TokenList tokenList, TokenList.Token token) {
        TokenList.Token token2 = token.next;
        while (token2 != null && token2.symbol != Symbol.ASSIGN) {
            token2 = token2.next;
        }
        if (token2 == null) {
            throw new ParseError("Can't find assignment operator");
        }
        if (token2.previous.symbol != Symbol.PAREN_RIGHT) {
            return null;
        }
        TokenList.Token token3 = token.next;
        if (token3.symbol != Symbol.PAREN_LEFT) {
            throw new ParseError("Expected left param for assignment");
        }
        TokenList tokenListExtractSubList = tokenList.extractSubList(token3, token2.previous);
        tokenListExtractSubList.remove(tokenListExtractSubList.getFirst());
        tokenListExtractSubList.remove(tokenListExtractSubList.getLast());
        handleParentheses(tokenListExtractSubList, sequence);
        List<TokenList.Token> parameterCommaBlock = parseParameterCommaBlock(tokenListExtractSubList, sequence);
        if (parameterCommaBlock.isEmpty()) {
            throw new ParseError("Empty function input parameters");
        }
        ArrayList arrayList = new ArrayList();
        addSubMatrixVariables(parameterCommaBlock, arrayList);
        if (arrayList.size() == 1 || arrayList.size() == 2) {
            return arrayList;
        }
        throw new ParseError("Unexpected number of range variables.  1 or 2 expected");
    }

    protected void handleParentheses(TokenList tokenList, Sequence sequence) {
        ArrayList arrayList = new ArrayList();
        TokenList.Token token = tokenList.first;
        while (token != null) {
            TokenList.Token token2 = token.next;
            if (token.getType() == TokenList.Type.SYMBOL) {
                if (token.getSymbol() == Symbol.PAREN_LEFT) {
                    arrayList.add(token);
                } else if (token.getSymbol() != Symbol.PAREN_RIGHT) {
                    continue;
                } else {
                    if (arrayList.isEmpty()) {
                        throw new ParseError(") found with no matching (");
                    }
                    TokenList.Token token3 = (TokenList.Token) arrayList.remove(arrayList.size() - 1);
                    TokenList.Token token4 = token3.previous;
                    TokenList tokenListExtractSubList = tokenList.extractSubList(token3, token);
                    tokenListExtractSubList.remove(tokenListExtractSubList.first);
                    tokenListExtractSubList.remove(tokenListExtractSubList.last);
                    if (token4 != null && token4.getType() == TokenList.Type.FUNCTION) {
                        List<TokenList.Token> parameterCommaBlock = parseParameterCommaBlock(tokenListExtractSubList, sequence);
                        if (parameterCommaBlock.isEmpty()) {
                            throw new ParseError("Empty function input parameters");
                        }
                        createFunction(token4, parameterCommaBlock, tokenList, sequence);
                    } else if (token4 != null && token4.getType() == TokenList.Type.VARIABLE && token4.getVariable().getType() == VariableType.MATRIX) {
                        tokenList.insert(token4, parseSubmatrixToExtract(token4, tokenListExtractSubList, sequence));
                        tokenList.remove(token4);
                    } else {
                        TokenList.Token blockNoParentheses = parseBlockNoParentheses(tokenListExtractSubList, sequence, false);
                        if (blockNoParentheses != null) {
                            tokenList.insert(token4, blockNoParentheses);
                        }
                    }
                }
            }
            token = token2;
        }
        if (!arrayList.isEmpty()) {
            throw new ParseError("Dangling ( parentheses");
        }
    }

    protected List<TokenList.Token> parseParameterCommaBlock(TokenList tokenList, Sequence sequence) {
        ArrayList arrayList = new ArrayList();
        for (TokenList.Token token = tokenList.first; token != null; token = token.next) {
            if (token.getType() == TokenList.Type.SYMBOL && token.getSymbol() == Symbol.COMMA) {
                arrayList.add(token);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.isEmpty()) {
            arrayList2.add(parseBlockNoParentheses(tokenList, sequence, false));
            return arrayList2;
        }
        TokenList.Token token2 = tokenList.first;
        int i = 0;
        while (i < arrayList.size()) {
            TokenList.Token token3 = (TokenList.Token) arrayList.get(i);
            if (token2 == token3) {
                throw new ParseError("No empty function inputs allowed!");
            }
            TokenList.Token token4 = token3.next;
            TokenList tokenListExtractSubList = tokenList.extractSubList(token2, token3);
            tokenListExtractSubList.remove(token3);
            arrayList2.add(parseBlockNoParentheses(tokenListExtractSubList, sequence, false));
            i++;
            token2 = token4;
        }
        if (token2 == null) {
            throw new ParseError("No empty function inputs allowed!");
        }
        arrayList2.add(parseBlockNoParentheses(tokenList.extractSubList(token2, tokenList.last), sequence, false));
        return arrayList2;
    }

    protected TokenList.Token parseSubmatrixToExtract(TokenList.Token token, TokenList tokenList, Sequence sequence) {
        Operation.Info infoCreate;
        List<TokenList.Token> parameterCommaBlock = parseParameterCommaBlock(tokenList, sequence);
        ArrayList arrayList = new ArrayList();
        arrayList.add(token.getVariable());
        addSubMatrixVariables(parameterCommaBlock, arrayList);
        if (arrayList.size() != 2 && arrayList.size() != 3) {
            throw new ParseError("Unexpected number of variables.  1 or 2 expected");
        }
        if (parameterCommaBlock.size() == 1) {
            if (arrayList.get(1).getType() == VariableType.SCALAR) {
                infoCreate = this.functions.create("extractScalar", arrayList);
            } else {
                infoCreate = this.functions.create("extract", arrayList);
            }
        } else if (parameterCommaBlock.size() == 2) {
            Variable variable = arrayList.get(1);
            Variable variable2 = arrayList.get(2);
            if (variable.getType() == VariableType.SCALAR && variable2.getType() == VariableType.SCALAR) {
                infoCreate = this.functions.create("extractScalar", arrayList);
            } else {
                infoCreate = this.functions.create("extract", arrayList);
            }
        } else {
            throw new ParseError("Expected 2 inputs to sub-matrix");
        }
        sequence.addOperation(infoCreate.f2755op);
        return new TokenList.Token(infoCreate.output);
    }

    private void addSubMatrixVariables(List<TokenList.Token> list, List<Variable> list2) {
        for (int i = 0; i < list.size(); i++) {
            TokenList.Token token = list.get(i);
            if (token.getType() != TokenList.Type.VARIABLE) {
                throw new ParseError("Expected variables only in sub-matrix input, not " + token.getType());
            }
            Variable variable = token.getVariable();
            if (variable.getType() == VariableType.INTEGER_SEQUENCE || isVariableInteger(token)) {
                list2.add(variable);
            } else {
                throw new ParseError("Expected an integer, integer sequence, or array range to define a submatrix");
            }
        }
    }

    protected TokenList.Token parseBlockNoParentheses(TokenList tokenList, Sequence sequence, boolean z) {
        if (!z) {
            parseBracketCreateMatrix(tokenList, sequence);
        }
        parseSequencesWithColons(tokenList, sequence);
        parseNegOp(tokenList, sequence);
        parseOperationsL(tokenList, sequence);
        parseOperationsLR(new Symbol[]{Symbol.POWER, Symbol.ELEMENT_POWER}, tokenList, sequence);
        parseOperationsLR(new Symbol[]{Symbol.TIMES, Symbol.RDIVIDE, Symbol.LDIVIDE, Symbol.ELEMENT_TIMES, Symbol.ELEMENT_DIVIDE}, tokenList, sequence);
        parseOperationsLR(new Symbol[]{Symbol.PLUS, Symbol.MINUS}, tokenList, sequence);
        stripCommas(tokenList);
        parseIntegerLists(tokenList);
        parseCombineIntegerLists(tokenList);
        if (z) {
            return null;
        }
        if (tokenList.size() > 1) {
            throw new RuntimeException("BUG in parser.  There should only be a single token left");
        }
        return tokenList.first;
    }

    private void stripCommas(TokenList tokenList) {
        TokenList.Token first = tokenList.getFirst();
        while (first != null) {
            TokenList.Token token = first.next;
            if (first.getSymbol() == Symbol.COMMA) {
                tokenList.remove(first);
            }
            first = token;
        }
    }

    protected void parseSequencesWithColons(TokenList tokenList, Sequence sequence) {
        TokenList.Token first = tokenList.getFirst();
        if (first == null) {
            return;
        }
        TokenList.Token token = first;
        char c = 0;
        boolean z = false;
        TokenList.Token token2 = null;
        TokenList.Token token3 = null;
        while (true) {
            if (c != 0) {
                if (c == 1) {
                    if (isVariableInteger(first)) {
                        token = first;
                        c = 2;
                    } else {
                        replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Range(token2, null)), token2, token);
                    }
                } else if (c != 2) {
                    if (c == 3) {
                        if (isVariableInteger(first)) {
                            first = replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.For(token2, token3, first)), token2, first);
                        } else {
                            replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Range(token2, token3)), token2, token);
                        }
                    }
                    token = first;
                } else if (first == null || first.getSymbol() != Symbol.COLON) {
                    replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.For(token2, null, token)), token2, token);
                    if (first != null) {
                        first = first.previous;
                    }
                } else {
                    token3 = token;
                    c = 3;
                    token = first;
                }
                token = first;
                c = 0;
            } else if (isVariableInteger(first) && first.next != null && first.next.getSymbol() == Symbol.COLON) {
                token = first.next;
                token2 = first;
                c = 1;
            } else if (first == null || first.getSymbol() != Symbol.COLON) {
                token = first;
            } else {
                TokenList.Token token4 = new TokenList.Token(this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Range(null, null)));
                tokenList.insert(first.previous, token4);
                tokenList.remove(first);
                token = token4;
            }
            if (z) {
                return;
            }
            if (token.next == null) {
                z = true;
            }
            first = token.next;
        }
    }

    protected void parseIntegerLists(TokenList tokenList) {
        TokenList.Token first = tokenList.getFirst();
        if (first == null || first.next == null) {
            return;
        }
        char c = 0;
        boolean z = false;
        TokenList.Token token = null;
        TokenList.Token token2 = first;
        while (true) {
            if (c == 0) {
                if (isVariableInteger(first)) {
                    token = first;
                    c = 1;
                }
            } else if (c == 1) {
                c = isVariableInteger(first) ? (char) 2 : (char) 0;
            } else if (c == 2 && !isVariableInteger(first)) {
                replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Explicit(token, token2)), token, token2);
            }
            if (z) {
                return;
            }
            if (first.next == null) {
                z = true;
            }
            token2 = first;
            first = first.next;
        }
    }

    protected void parseCombineIntegerLists(TokenList tokenList) {
        TokenList.Token first = tokenList.getFirst();
        if (first == null || first.next == null) {
            return;
        }
        TokenList.Token token = null;
        TokenList.Token token2 = null;
        int i = 0;
        while (first != null) {
            if (first.getType() != TokenList.Type.VARIABLE || (!isVariableInteger(first) && first.getVariable().getType() != VariableType.INTEGER_SEQUENCE)) {
                if (i > 1) {
                    replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Combined(token, token2)), token, token2);
                }
                i = 0;
            } else if (i == 0) {
                token = first;
                token2 = token;
                i = 1;
            } else {
                i++;
                token2 = first;
            }
            first = first.next;
        }
        if (i > 1) {
            replaceSequence(tokenList, this.functions.getManagerTemp().createIntegerSequence(new IntegerSequence.Combined(token, token2)), token, token2);
        }
    }

    private TokenList.Token replaceSequence(TokenList tokenList, Variable variable, TokenList.Token token, TokenList.Token token2) {
        TokenList.Token token3 = new TokenList.Token(variable);
        tokenList.insert(token.previous, token3);
        tokenList.extractSubList(token, token2);
        return token3;
    }

    private static boolean isVariableInteger(TokenList.Token token) {
        return token != null && token.getScalarType() == VariableScalar.Type.INTEGER;
    }

    protected void parseBracketCreateMatrix(TokenList tokenList, Sequence sequence) {
        ArrayList arrayList = new ArrayList();
        TokenList.Token first = tokenList.getFirst();
        while (first != null) {
            TokenList.Token token = first.next;
            if (first.getSymbol() == Symbol.BRACKET_LEFT) {
                arrayList.add(first);
            } else if (first.getSymbol() != Symbol.BRACKET_RIGHT) {
                continue;
            } else {
                if (arrayList.isEmpty()) {
                    throw new RuntimeException("No matching left bracket for right");
                }
                TokenList.Token token2 = (TokenList.Token) arrayList.remove(arrayList.size() - 1);
                TokenList tokenListExtractSubList = tokenList.extractSubList(token2.next, first.previous);
                parseBlockNoParentheses(tokenListExtractSubList, sequence, true);
                Operation.Info infoMatrixConstructor = Operation.matrixConstructor(constructMatrix(tokenListExtractSubList));
                sequence.addOperation(infoMatrixConstructor.f2755op);
                tokenList.insert(token2.previous, new TokenList.Token(infoMatrixConstructor.output));
                tokenList.remove(token2);
                tokenList.remove(first);
            }
            first = token;
        }
        if (!arrayList.isEmpty()) {
            throw new RuntimeException("Dangling [");
        }
    }

    private MatrixConstructor constructMatrix(TokenList tokenList) {
        MatrixConstructor matrixConstructor = new MatrixConstructor(this.functions.getManagerTemp());
        for (TokenList.Token token = tokenList.first; token != null; token = token.next) {
            if (token.getType() == TokenList.Type.VARIABLE) {
                matrixConstructor.addToRow(token.getVariable());
            } else if (token.getType() == TokenList.Type.SYMBOL) {
                if (token.getSymbol() == Symbol.SEMICOLON) {
                    matrixConstructor.endRow();
                }
            } else {
                throw new ParseError("Expected variable or symbol only");
            }
        }
        matrixConstructor.endRow();
        return matrixConstructor;
    }

    protected void parseNegOp(TokenList tokenList, Sequence sequence) {
        if (tokenList.size == 0) {
            return;
        }
        TokenList.Token token = tokenList.first;
        while (token != null) {
            TokenList.Token token2 = token.next;
            if (token.getSymbol() != Symbol.MINUS || (!(token.previous == null || token.previous.getType() == TokenList.Type.SYMBOL) || token.next == null || token.next.getType() == TokenList.Type.SYMBOL)) {
                token = token2;
            } else {
                if (token.next.getType() != TokenList.Type.VARIABLE) {
                    throw new RuntimeException("Crap bug rethink this function");
                }
                Operation.Info infoNeg = Operation.neg(token.next.getVariable(), this.functions.getManagerTemp());
                sequence.addOperation(infoNeg.f2755op);
                TokenList.Token token3 = new TokenList.Token(infoNeg.output);
                tokenList.insert(token.next, token3);
                tokenList.remove(token.next);
                tokenList.remove(token);
                token = token3;
            }
        }
    }

    protected void parseOperationsL(TokenList tokenList, Sequence sequence) {
        if (tokenList.size == 0) {
            return;
        }
        TokenList.Token tokenInsertTranspose = tokenList.first;
        if (tokenInsertTranspose.getType() != TokenList.Type.VARIABLE) {
            throw new ParseError("The first token in an equation needs to be a variable and not " + tokenInsertTranspose);
        }
        while (tokenInsertTranspose != null) {
            if (tokenInsertTranspose.getType() == TokenList.Type.FUNCTION) {
                throw new ParseError("Function encountered with no parentheses");
            }
            if (tokenInsertTranspose.getType() == TokenList.Type.SYMBOL && tokenInsertTranspose.getSymbol() == Symbol.TRANSPOSE) {
                if (tokenInsertTranspose.previous.getType() == TokenList.Type.VARIABLE) {
                    tokenInsertTranspose = insertTranspose(tokenInsertTranspose.previous, tokenList, sequence);
                } else {
                    throw new ParseError("Expected variable before transpose");
                }
            }
            tokenInsertTranspose = tokenInsertTranspose.next;
        }
    }

    protected void parseOperationsLR(Symbol[] symbolArr, TokenList tokenList, Sequence sequence) {
        TokenList tokenList2;
        Sequence sequence2;
        if (tokenList.size == 0) {
            return;
        }
        TokenList.Token token = tokenList.first;
        if (token.getType() != TokenList.Type.VARIABLE) {
            throw new ParseError("The first token in an equation needs to be a variable and not " + token);
        }
        boolean z = false;
        TokenList.Token tokenCreateOp = token;
        while (tokenCreateOp != null) {
            if (tokenCreateOp.getType() == TokenList.Type.FUNCTION) {
                throw new ParseError("Function encountered with no parentheses");
            }
            if (tokenCreateOp.getType() != TokenList.Type.VARIABLE) {
                tokenList2 = tokenList;
                sequence2 = sequence;
                if (tokenCreateOp.previous.getType() == TokenList.Type.SYMBOL) {
                    throw new ParseError("Two symbols next to each other. " + tokenCreateOp.previous + " and " + tokenCreateOp);
                }
            } else if (!z) {
                tokenList2 = tokenList;
                sequence2 = sequence;
                z = true;
            } else if (isTargetOp(tokenCreateOp.previous, symbolArr)) {
                tokenList2 = tokenList;
                sequence2 = sequence;
                tokenCreateOp = createOp(tokenCreateOp.previous.previous, tokenCreateOp.previous, tokenCreateOp, tokenList2, sequence2);
            } else {
                tokenList2 = tokenList;
                sequence2 = sequence;
            }
            tokenCreateOp = tokenCreateOp.next;
            tokenList = tokenList2;
            sequence = sequence2;
        }
    }

    protected TokenList.Token insertTranspose(TokenList.Token token, TokenList tokenList, Sequence sequence) {
        Operation.Info infoCreate = this.functions.create('\'', token.getVariable());
        sequence.addOperation(infoCreate.f2755op);
        TokenList.Token token2 = new TokenList.Token(infoCreate.output);
        tokenList.remove(token.next);
        tokenList.replace(token, token2);
        return token2;
    }

    protected TokenList.Token createOp(TokenList.Token token, TokenList.Token token2, TokenList.Token token3, TokenList tokenList, Sequence sequence) {
        Operation.Info infoCreate = this.functions.create(token2.symbol, token.getVariable(), token3.getVariable());
        sequence.addOperation(infoCreate.f2755op);
        TokenList.Token token4 = new TokenList.Token(infoCreate.output);
        tokenList.remove(token);
        tokenList.remove(token3);
        tokenList.replace(token2, token4);
        return token4;
    }

    protected TokenList.Token createFunction(TokenList.Token token, List<TokenList.Token> list, TokenList tokenList, Sequence sequence) {
        Operation.Info infoCreate;
        if (list.size() == 1) {
            infoCreate = this.functions.create(token.getFunction().getName(), list.get(0).getVariable());
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).getVariable());
            }
            infoCreate = this.functions.create(token.getFunction().getName(), arrayList);
        }
        sequence.addOperation(infoCreate.f2755op);
        TokenList.Token token2 = new TokenList.Token(infoCreate.output);
        tokenList.replace(token, token2);
        return token2;
    }

    public <T extends Variable> T lookupVariable(String str) {
        return (T) this.variables.get(str);
    }

    public Macro lookupMacro(String str) {
        return this.macros.get(str);
    }

    public DMatrixRMaj lookupMatrix(String str) {
        return ((VariableMatrix) this.variables.get(str)).matrix;
    }

    public int lookupInteger(String str) {
        return ((VariableInteger) this.variables.get(str)).value;
    }

    public double lookupDouble(String str) {
        Variable variable = this.variables.get(str);
        if (variable instanceof VariableMatrix) {
            DMatrixRMaj dMatrixRMaj = ((VariableMatrix) variable).matrix;
            if (dMatrixRMaj.numCols == 1 && dMatrixRMaj.numRows == 1) {
                return dMatrixRMaj.get(0, 0);
            }
            throw new RuntimeException("Can only return 1x1 real matrices as doubles");
        }
        return ((VariableScalar) this.variables.get(str)).getDouble();
    }

    protected TokenList extractTokens(String str, ManagerTempVariables managerTempVariables) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        boolean z3;
        int i3;
        String str2 = str + " ";
        TokenList tokenList = new TokenList();
        TokenType tokenType = TokenType.UNKNOWN;
        int i4 = 0;
        int i5 = 0;
        while (i4 < str2.length()) {
            char cCharAt = str2.charAt(i4);
            if (tokenType == TokenType.WORD) {
                if (isLetter(cCharAt)) {
                    i3 = i5 + 1;
                    this.storage[i5] = cCharAt;
                    z = false;
                    i5 = i3;
                } else {
                    tokenList.add(new String(this.storage, 0, i5));
                    tokenType = TokenType.UNKNOWN;
                    z = true;
                }
            } else if (tokenType == TokenType.INTEGER) {
                if (cCharAt == '.') {
                    tokenType = TokenType.FLOAT;
                    i3 = i5 + 1;
                    this.storage[i5] = cCharAt;
                } else if (cCharAt == 'e' || cCharAt == 'E') {
                    tokenType = TokenType.FLOAT_EXP;
                    i3 = i5 + 1;
                    this.storage[i5] = cCharAt;
                } else if (Character.isDigit(cCharAt)) {
                    i3 = i5 + 1;
                    this.storage[i5] = cCharAt;
                } else if (isSymbol(cCharAt) || Character.isWhitespace(cCharAt)) {
                    tokenList.add(managerTempVariables.createInteger(Integer.parseInt(new String(this.storage, 0, i5))));
                    tokenType = TokenType.UNKNOWN;
                    z = true;
                } else {
                    throw new ParseError("Unexpected character at the end of an integer " + cCharAt);
                }
                z = false;
                i5 = i3;
            } else {
                if (tokenType != TokenType.FLOAT) {
                    if (tokenType == TokenType.FLOAT_EXP) {
                        if (cCharAt == '-') {
                            char[] cArr = this.storage;
                            char c = cArr[i5 - 1];
                            if (c == 'e' || c == 'E') {
                                i2 = i5 + 1;
                                cArr[i5] = cCharAt;
                                z3 = false;
                                i5 = i2;
                            }
                            z3 = true;
                        } else if (Character.isDigit(cCharAt)) {
                            i2 = i5 + 1;
                            this.storage[i5] = cCharAt;
                            z3 = false;
                            i5 = i2;
                        } else {
                            if (!isSymbol(cCharAt) && !Character.isWhitespace(cCharAt)) {
                                throw new ParseError("Unexpected character at the end of an float " + cCharAt);
                            }
                            z3 = true;
                        }
                        if (z3) {
                            tokenList.add(managerTempVariables.createDouble(Double.parseDouble(new String(this.storage, 0, i5))));
                            tokenType = TokenType.UNKNOWN;
                            z = true;
                        }
                    } else if (isSymbol(cCharAt)) {
                        if (cCharAt == '-' && (i = i4 + 1) < str2.length() && Character.isDigit(str2.charAt(i)) && (tokenList.last == null || isOperatorLR(tokenList.last.getSymbol()))) {
                            tokenType = TokenType.INTEGER;
                            this.storage[0] = cCharAt;
                            i5 = 1;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            TokenList.Token tokenAdd = tokenList.add(Symbol.lookup(cCharAt));
                            if (tokenAdd.previous != null && tokenAdd.previous.getType() == TokenList.Type.SYMBOL && tokenAdd.previous.getSymbol() == Symbol.PERIOD) {
                                tokenList.remove(tokenAdd.previous);
                                tokenList.remove(tokenAdd);
                                tokenList.add(Symbol.lookupElementWise(cCharAt));
                            }
                        }
                    } else if (!Character.isWhitespace(cCharAt)) {
                        if (Character.isDigit(cCharAt)) {
                            tokenType = TokenType.INTEGER;
                        } else {
                            tokenType = TokenType.WORD;
                        }
                        this.storage[0] = cCharAt;
                        z = false;
                        i5 = 1;
                    }
                    z = false;
                } else {
                    if (cCharAt == '.') {
                        throw new ParseError("Unexpected '.' in a float");
                    }
                    if (cCharAt == 'e' || cCharAt == 'E') {
                        this.storage[i5] = cCharAt;
                        tokenType = TokenType.FLOAT_EXP;
                        z = false;
                        i5++;
                    } else if (Character.isDigit(cCharAt)) {
                        i3 = i5 + 1;
                        this.storage[i5] = cCharAt;
                        z = false;
                        i5 = i3;
                    } else if (isSymbol(cCharAt) || Character.isWhitespace(cCharAt)) {
                        tokenList.add(managerTempVariables.createDouble(Double.parseDouble(new String(this.storage, 0, i5))));
                        tokenType = TokenType.UNKNOWN;
                        z = true;
                    } else {
                        throw new ParseError("Unexpected character at the end of an float " + cCharAt);
                    }
                }
                i4++;
            }
            if (z) {
                i4--;
            }
            i4++;
        }
        return tokenList;
    }

    void insertFunctionsAndVariables(TokenList tokenList) {
        for (TokenList.Token first = tokenList.getFirst(); first != null; first = first.next) {
            if (first.getType() == TokenList.Type.WORD) {
                Variable variableLookupVariable = lookupVariable(first.word);
                if (variableLookupVariable != null) {
                    first.variable = variableLookupVariable;
                    first.word = null;
                } else if (this.functions.isFunctionName(first.word)) {
                    first.function = new Function(first.word);
                    first.word = null;
                }
            }
        }
    }

    void insertMacros(TokenList tokenList) {
        Macro macroLookupMacro;
        TokenList.Token first = tokenList.getFirst();
        while (first != null) {
            if (first.getType() == TokenList.Type.WORD && (macroLookupMacro = lookupMacro(first.word)) != null) {
                TokenList.Token token = first.previous;
                ArrayList arrayList = new ArrayList();
                TokenList.Token macroInput = parseMacroInput(arrayList, first.next);
                TokenList tokenListExecute = macroLookupMacro.execute(arrayList);
                tokenList.extractSubList(token.next, macroInput);
                tokenList.insertAfter(token, tokenListExecute);
                first = tokenListExecute.last;
            }
            first = first.next;
        }
    }

    protected static boolean isTargetOp(TokenList.Token token, Symbol[] symbolArr) {
        Symbol symbol = token.symbol;
        for (Symbol symbol2 : symbolArr) {
            if (symbol == symbol2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: org.ejml.equation.Equation$1 */
    static /* synthetic */ class C90231 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$equation$Symbol;
        static final /* synthetic */ int[] $SwitchMap$org$ejml$equation$VariableType;

        static {
            int[] iArr = new int[Symbol.values().length];
            $SwitchMap$org$ejml$equation$Symbol = iArr;
            try {
                iArr[Symbol.ELEMENT_DIVIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ELEMENT_TIMES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ELEMENT_POWER.ordinal()] = 3;
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
                $SwitchMap$org$ejml$equation$Symbol[Symbol.TIMES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.POWER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.PLUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.MINUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$ejml$equation$Symbol[Symbol.ASSIGN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[VariableType.values().length];
            $SwitchMap$org$ejml$equation$VariableType = iArr2;
            try {
                iArr2[VariableType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$ejml$equation$VariableType[VariableType.SCALAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$ejml$equation$VariableType[VariableType.INTEGER_SEQUENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    protected static boolean isOperatorLR(Symbol symbol) {
        if (symbol == null) {
            return false;
        }
        switch (C90231.$SwitchMap$org$ejml$equation$Symbol[symbol.ordinal()]) {
        }
        return false;
    }

    protected static boolean isLetter(char c) {
        return (isSymbol(c) || Character.isWhitespace(c)) ? false : true;
    }

    protected boolean isReserved(String str) {
        if (this.functions.isFunctionName(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isLetter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public void process(String str) {
        compile(str).perform();
    }

    public void process(String str, boolean z) {
        compile(str, z).perform();
    }

    public ManagerFunctions getFunctions() {
        return this.functions;
    }
}
