package org.ejml.equation;

import androidx.compose.p004ui.spatial.RectListKt;
import com.pdftron.pdf.pdfa.PDFACompliance;

/* JADX INFO: loaded from: classes9.dex */
public enum Symbol {
    PLUS,
    MINUS,
    TIMES,
    LDIVIDE,
    RDIVIDE,
    POWER,
    PERIOD,
    ELEMENT_TIMES,
    ELEMENT_DIVIDE,
    ELEMENT_POWER,
    ASSIGN,
    PAREN_LEFT,
    PAREN_RIGHT,
    BRACKET_LEFT,
    BRACKET_RIGHT,
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_EQ,
    LESS_THAN_EQ,
    COMMA,
    TRANSPOSE,
    COLON,
    SEMICOLON;

    public static Symbol lookup(char c) {
        switch (c) {
            case '\'':
                return TRANSPOSE;
            case '(':
                return PAREN_LEFT;
            case ')':
                return PAREN_RIGHT;
            case '*':
                return TIMES;
            case '+':
                return PLUS;
            case ',':
                return COMMA;
            case '-':
                return MINUS;
            case '.':
                return PERIOD;
            case '/':
                return RDIVIDE;
            default:
                switch (c) {
                    case ':':
                        return COLON;
                    case ';':
                        return SEMICOLON;
                    case '<':
                        return LESS_THAN;
                    case '=':
                        return ASSIGN;
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                        return GREATER_THAN;
                    default:
                        switch (c) {
                            case PDFACompliance.e_PDFA9_1 /* 91 */:
                                return BRACKET_LEFT;
                            case PDFACompliance.e_PDFA9_2 /* 92 */:
                                return LDIVIDE;
                            case PDFACompliance.e_PDFA9_3 /* 93 */:
                                return BRACKET_RIGHT;
                            case PDFACompliance.e_PDFA9_4 /* 94 */:
                                return POWER;
                            default:
                                throw new RuntimeException("Unknown type " + c);
                        }
                }
        }
    }

    public static Symbol lookupElementWise(char c) {
        if (c == '*') {
            return ELEMENT_TIMES;
        }
        if (c == '/') {
            return ELEMENT_DIVIDE;
        }
        if (c == '^') {
            return ELEMENT_POWER;
        }
        throw new RuntimeException("Unknown element-wise type " + c);
    }
}
