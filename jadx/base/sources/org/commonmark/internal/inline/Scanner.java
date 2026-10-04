package org.commonmark.internal.inline;

import java.util.List;
import org.commonmark.internal.util.CharMatcher;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes7.dex */
public class Scanner {
    public static final char END = 0;
    private int index;
    private int lineIndex;
    private final List<SourceLine> lines;
    private SourceLine line = SourceLine.m1661of("", null);
    private int lineLength = 0;

    Scanner(List<SourceLine> list, int i, int i2) {
        this.lines = list;
        this.lineIndex = i;
        this.index = i2;
        if (list.isEmpty()) {
            return;
        }
        checkPosition(i, i2);
        setLine(list.get(i));
    }

    /* JADX INFO: renamed from: of */
    public static Scanner m1658of(SourceLines sourceLines) {
        return new Scanner(sourceLines.getLines(), 0, 0);
    }

    public char peek() {
        if (this.index < this.lineLength) {
            return this.line.getContent().charAt(this.index);
        }
        return this.lineIndex < this.lines.size() + (-1) ? '\n' : (char) 0;
    }

    public int peekCodePoint() {
        if (this.index >= this.lineLength) {
            return this.lineIndex < this.lines.size() + (-1) ? 10 : 0;
        }
        char cCharAt = this.line.getContent().charAt(this.index);
        if (!Character.isHighSurrogate(cCharAt) || this.index + 1 >= this.lineLength) {
            return cCharAt;
        }
        char cCharAt2 = this.line.getContent().charAt(this.index + 1);
        return Character.isLowSurrogate(cCharAt2) ? Character.toCodePoint(cCharAt, cCharAt2) : cCharAt;
    }

    public int peekPreviousCodePoint() {
        int i = this.index;
        if (i <= 0) {
            return this.lineIndex > 0 ? 10 : 0;
        }
        int i2 = i - 1;
        char cCharAt = this.line.getContent().charAt(i2);
        if (Character.isLowSurrogate(cCharAt) && i2 > 0) {
            char cCharAt2 = this.line.getContent().charAt(i - 2);
            if (Character.isHighSurrogate(cCharAt2)) {
                return Character.toCodePoint(cCharAt2, cCharAt);
            }
        }
        return cCharAt;
    }

    public boolean hasNext() {
        return this.index < this.lineLength || this.lineIndex < this.lines.size() - 1;
    }

    public void next() {
        int i = this.index + 1;
        this.index = i;
        if (i > this.lineLength) {
            int i2 = this.lineIndex + 1;
            this.lineIndex = i2;
            if (i2 < this.lines.size()) {
                setLine(this.lines.get(this.lineIndex));
            } else {
                setLine(SourceLine.m1661of("", null));
            }
            this.index = 0;
        }
    }

    public boolean next(char c) {
        if (peek() != c) {
            return false;
        }
        next();
        return true;
    }

    public boolean next(String str) {
        int i = this.index;
        if (i >= this.lineLength || i + str.length() > this.lineLength) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (this.line.getContent().charAt(this.index + i2) != str.charAt(i2)) {
                return false;
            }
        }
        this.index += str.length();
        return true;
    }

    public int matchMultiple(char c) {
        int i = 0;
        while (peek() == c) {
            i++;
            next();
        }
        return i;
    }

    public int match(CharMatcher charMatcher) {
        int i = 0;
        while (charMatcher.matches(peek())) {
            i++;
            next();
        }
        return i;
    }

    public int whitespace() {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek != ' ') {
                switch (cPeek) {
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
            next();
        }
    }

    public int find(char c) {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek == 0) {
                return -1;
            }
            if (cPeek == c) {
                return i;
            }
            i++;
            next();
        }
    }

    public int find(CharMatcher charMatcher) {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek == 0) {
                return -1;
            }
            if (charMatcher.matches(cPeek)) {
                return i;
            }
            i++;
            next();
        }
    }

    public Position position() {
        return new Position(this.lineIndex, this.index);
    }

    public void setPosition(Position position) {
        checkPosition(position.lineIndex, position.index);
        this.lineIndex = position.lineIndex;
        this.index = position.index;
        setLine(this.lines.get(this.lineIndex));
    }

    public SourceLines getSource(Position position, Position position2) {
        if (position.lineIndex == position2.lineIndex) {
            SourceLine sourceLine = this.lines.get(position.lineIndex);
            CharSequence charSequenceSubSequence = sourceLine.getContent().subSequence(position.index, position2.index);
            SourceSpan sourceSpan = sourceLine.getSourceSpan();
            return SourceLines.m1663of(SourceLine.m1661of(charSequenceSubSequence, sourceSpan != null ? SourceSpan.m1660of(sourceSpan.getLineIndex(), sourceSpan.getColumnIndex() + position.index, charSequenceSubSequence.length()) : null));
        }
        SourceLines sourceLinesEmpty = SourceLines.empty();
        SourceLine sourceLine2 = this.lines.get(position.lineIndex);
        sourceLinesEmpty.addLine(sourceLine2.substring(position.index, sourceLine2.getContent().length()));
        int i = position.lineIndex;
        while (true) {
            i++;
            if (i < position2.lineIndex) {
                sourceLinesEmpty.addLine(this.lines.get(i));
            } else {
                sourceLinesEmpty.addLine(this.lines.get(position2.lineIndex).substring(0, position2.index));
                return sourceLinesEmpty;
            }
        }
    }

    private void setLine(SourceLine sourceLine) {
        this.line = sourceLine;
        this.lineLength = sourceLine.getContent().length();
    }

    private void checkPosition(int i, int i2) {
        if (i < 0 || i >= this.lines.size()) {
            throw new IllegalArgumentException("Line index " + i + " out of range, number of lines: " + this.lines.size());
        }
        SourceLine sourceLine = this.lines.get(i);
        if (i2 < 0 || i2 > sourceLine.getContent().length()) {
            throw new IllegalArgumentException("Index " + i2 + " out of range, line length: " + sourceLine.getContent().length());
        }
    }
}
