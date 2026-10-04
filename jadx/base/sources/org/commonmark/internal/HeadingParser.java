package org.commonmark.internal;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import org.apache.commons.codec.language.Soundex;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class HeadingParser extends AbstractBlockParser {
    private final Heading block;
    private final SourceLines content;

    public HeadingParser(int i, SourceLines sourceLines) {
        Heading heading = new Heading();
        this.block = heading;
        heading.setLevel(i);
        this.content = sourceLines;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        inlineParser.parse(this.content, this.block);
    }

    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            HeadingParser atxHeading;
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            SourceLine line = parserState.getLine();
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            if (line.getContent().charAt(nextNonSpaceIndex) == '#' && (atxHeading = HeadingParser.getAtxHeading(line.substring(nextNonSpaceIndex, line.getContent().length()))) != null) {
                return BlockStart.m1664of(atxHeading).atIndex(line.getContent().length());
            }
            int setextHeadingLevel = HeadingParser.getSetextHeadingLevel(line.getContent(), nextNonSpaceIndex);
            if (setextHeadingLevel > 0) {
                SourceLines paragraphLines = matchedBlockParser.getParagraphLines();
                if (!paragraphLines.isEmpty()) {
                    return BlockStart.m1664of(new HeadingParser(setextHeadingLevel, paragraphLines)).atIndex(line.getContent().length()).replaceActiveBlockParser();
                }
            }
            return BlockStart.none();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeadingParser getAtxHeading(SourceLine sourceLine) {
        Scanner scannerM1658of = Scanner.m1658of(SourceLines.m1663of(sourceLine));
        int iMatchMultiple = scannerM1658of.matchMultiple('#');
        if (iMatchMultiple == 0 || iMatchMultiple > 6) {
            return null;
        }
        if (!scannerM1658of.hasNext()) {
            return new HeadingParser(iMatchMultiple, SourceLines.empty());
        }
        char cPeek = scannerM1658of.peek();
        if (cPeek != ' ' && cPeek != '\t') {
            return null;
        }
        scannerM1658of.whitespace();
        Position position = scannerM1658of.position();
        Position position2 = position;
        loop0: while (true) {
            boolean z = true;
            while (scannerM1658of.hasNext()) {
                char cPeek2 = scannerM1658of.peek();
                if (cPeek2 == '\t' || cPeek2 == ' ') {
                    scannerM1658of.next();
                } else {
                    if (cPeek2 != '#') {
                        scannerM1658of.next();
                        position2 = scannerM1658of.position();
                    } else if (z) {
                        scannerM1658of.matchMultiple('#');
                        int iWhitespace = scannerM1658of.whitespace();
                        if (scannerM1658of.hasNext()) {
                            position2 = scannerM1658of.position();
                        }
                        if (iWhitespace > 0) {
                            break;
                        }
                    } else {
                        scannerM1658of.next();
                        position2 = scannerM1658of.position();
                    }
                    z = false;
                }
            }
            break loop0;
        }
        SourceLines source = scannerM1658of.getSource(position, position2);
        if (source.getContent().isEmpty()) {
            return new HeadingParser(iMatchMultiple, SourceLines.empty());
        }
        return new HeadingParser(iMatchMultiple, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSetextHeadingLevel(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt != '-') {
            if (cCharAt != '=') {
                return 0;
            }
            if (isSetextHeadingRest(charSequence, i + 1, Literals.PROPERTY_SPLITTER)) {
                return 1;
            }
        }
        return isSetextHeadingRest(charSequence, i + 1, Soundex.SILENT_MARKER) ? 2 : 0;
    }

    private static boolean isSetextHeadingRest(CharSequence charSequence, int i, char c) {
        return Parsing.skipSpaceTab(charSequence, Parsing.skip(c, charSequence, i, charSequence.length()), charSequence.length()) >= charSequence.length();
    }
}
