package org.commonmark.internal.util;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.compose.runtime.GapComposerKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import okhttp3.internal.p041ws.WebSocketProtocol;
import okio.Utf8;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes7.dex */
public class Parsing {
    private static final String ATTRIBUTE = "(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)";
    private static final String ATTRIBUTENAME = "[a-zA-Z_:][a-zA-Z0-9:._-]*";
    private static final String ATTRIBUTEVALUE = "(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\")";
    private static final String ATTRIBUTEVALUESPEC = "(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))";
    public static final String CLOSETAG = "</[A-Za-z][A-Za-z0-9-]*\\s*[>]";
    public static int CODE_BLOCK_INDENT = 4;
    private static final String DOUBLEQUOTEDVALUE = "\"[^\"]*\"";
    public static final String OPENTAG = "<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
    private static final String SINGLEQUOTEDVALUE = "'[^']*'";
    private static final String TAGNAME = "[A-Za-z][A-Za-z0-9-]*";
    private static final String UNQUOTEDVALUE = "[^\"'=<>`\\x00-\\x20]+";

    public static boolean isEscapable(char c) {
        switch (c) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (c) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (c) {
                            case PDFACompliance.e_PDFA9_1 /* 91 */:
                            case PDFACompliance.e_PDFA9_2 /* 92 */:
                            case PDFACompliance.e_PDFA9_3 /* 93 */:
                            case PDFACompliance.e_PDFA9_4 /* 94 */:
                            case PDFACompliance.e_PDFA9_5 /* 95 */:
                            case '`':
                                return true;
                            default:
                                switch (c) {
                                    case PDFACompliance.e_PDFA1_2_3 /* 123 */:
                                    case '|':
                                    case GapComposerKt.nodeKey /* 125 */:
                                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static int columnsToNextTabStop(int i) {
        return 4 - (i % 4);
    }

    public static int find(char c, CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int findLineBreak(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\n' || cCharAt == '\r') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean isBlank(CharSequence charSequence) {
        return findNonSpace(charSequence, 0) == -1;
    }

    public static boolean hasNonSpace(CharSequence charSequence) {
        int length = charSequence.length();
        return skip(TokenParser.f2383SP, charSequence, 0, length) != length;
    }

    public static boolean isLetter(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static boolean isSpaceOrTab(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i);
        return cCharAt == '\t' || cCharAt == ' ';
    }

    public static boolean isPunctuationCodePoint(int i) {
        int type = Character.getType(i);
        if (type != 29 && type != 30) {
            switch (type) {
                default:
                    if (i != 36 && i != 43 && i != 94 && i != 96 && i != 124 && i != 126) {
                        switch (i) {
                            case 60:
                            case 61:
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                break;
                            default:
                                return false;
                        }
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    return true;
            }
        }
        return true;
    }

    public static boolean isWhitespaceCodePoint(int i) {
        return i == 9 || i == 10 || i == 12 || i == 13 || i == 32 || Character.getType(i) == 12;
    }

    public static CharSequence prepareLine(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 0) {
                if (sb == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                }
                sb.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static int skip(char c, CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipBackwards(char c, CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    public static int skipSpaceTab(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipSpaceTabBackwards(CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    private static int findNonSpace(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ') {
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i;
                }
            }
            i++;
        }
        return -1;
    }
}
