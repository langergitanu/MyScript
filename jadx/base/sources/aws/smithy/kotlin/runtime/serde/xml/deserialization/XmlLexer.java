package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState;
import aws.smithy.kotlin.runtime.text.Utf8Kt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: XmlLexer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080\b¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\f\u0010#\u001a\u00020\u0017*\u00020\u0011H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006$"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/XmlLexer;", "", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/serde/xml/deserialization/StringTextStream;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/deserialization/StringTextStream;)V", "getSource$serde_xml", "()Laws/smithy/kotlin/runtime/serde/xml/deserialization/StringTextStream;", "state", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "endOfDocument", "", "getEndOfDocument", "()Z", "error", "", NotificationCompat.CATEGORY_MESSAGE, "", "error$serde_xml", "parseNext", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "readAttribute", "Lkotlin/Pair;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "readCdata", "readName", "readQuoted", "readReference", "", "readTagToken", "readTextToken", "skipComment", "", "skipPreprocessingInstructions", "skipSpace", "qualify", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlLexer {
    private final StringTextStream source;
    private LexerState state;

    public XmlLexer(StringTextStream source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.state = LexerState.Initial.INSTANCE;
    }

    /* JADX INFO: renamed from: getSource$serde_xml, reason: from getter */
    public final StringTextStream getSource() {
        return this.source;
    }

    public final boolean getEndOfDocument() {
        return Intrinsics.areEqual(this.state, LexerState.EndOfDocument.INSTANCE);
    }

    public final Void error$serde_xml(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringTextStream source = getSource();
        int iMax = Math.max(0, source.offset - 3);
        int iMin = Math.min(source.end - 1, source.offset + 3);
        String strSubstring = source.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(msg + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
    }

    public final XmlToken parseNext() {
        LexerState lexerState = this.state;
        if (Intrinsics.areEqual(lexerState, LexerState.EndOfDocument.INSTANCE)) {
            return null;
        }
        if (lexerState instanceof LexerState.Tag.EmptyTag) {
            LexerState.Tag.EmptyTag emptyTag = (LexerState.Tag.EmptyTag) lexerState;
            LexerState parent = emptyTag.getParent();
            if (parent == null) {
                parent = LexerState.EndOfDocument.INSTANCE;
            }
            this.state = parent;
            return new XmlToken.EndElement(emptyTag.getDepth(), emptyTag.getName());
        }
        if (lexerState instanceof LexerState.Tag.OpenTag) {
            if (this.source.peekMatches("<") && !this.source.peekMatches("<![CDATA[")) {
                return readTagToken();
            }
            return readTextToken();
        }
        if (Intrinsics.areEqual(lexerState, LexerState.Initial.INSTANCE)) {
            skipPreprocessingInstructions();
            this.state = LexerState.BeforeRootTag.INSTANCE;
            return parseNext();
        }
        if (!Intrinsics.areEqual(lexerState, LexerState.BeforeRootTag.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        skipSpace();
        return readTagToken();
    }

    private final Pair<XmlToken.QualifiedName, String> readAttribute() {
        XmlToken.QualifiedName name = readName();
        skipSpace();
        char orThrow = this.source.readOrThrow("trying to read attribute equals");
        if (orThrow != '=') {
            String str = "Unexpected '" + orThrow + "' while trying to read attribute equals";
            StringTextStream source = getSource();
            int iMax = Math.max(0, source.offset - 3);
            int iMin = Math.min(source.end - 1, source.offset + 3);
            String strSubstring = source.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
        }
        skipSpace();
        return TuplesKt.m1606to(name, readQuoted());
    }

    private final String readCdata() {
        String until = this.source.readUntil("]]>", "trying to read CDATA content");
        this.source.advance(3, "trying to read end of CATA");
        return until;
    }

    private final XmlToken.QualifiedName readName() {
        return qualify(this.source.readWhileXmlName());
    }

    private final String readQuoted() {
        char orThrow = this.source.readOrThrow("trying to read attribute value");
        if (orThrow != '\'' && orThrow != '\"') {
            String str = "Unexpected '" + orThrow + "' while trying to read attribute value";
            StringTextStream source = getSource();
            int iMax = Math.max(0, source.offset - 3);
            int iMin = Math.min(source.end - 1, source.offset + 3);
            String strSubstring = source.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            char orThrow2 = this.source.readOrThrow("trying to read a string");
            if (orThrow2 == '&') {
                sb.append(readReference());
            } else {
                if (orThrow2 == '<') {
                    StringTextStream source2 = getSource();
                    int iMax2 = Math.max(0, source2.offset - 3);
                    int iMin2 = Math.min(source2.end - 1, source2.offset + 3);
                    String strSubstring2 = source2.source.substring(iMax2, iMin2 + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    throw new DeserializationException("Unexpected '<' while trying to read a string\n" + ("At offset " + source2.offset + " (showing range " + iMax2 + Soundex.SILENT_MARKER + iMin2 + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring2, "·") + '\n' + (StringsKt.repeat(" ", source2.offset - iMax2) + '^')));
                }
                if (orThrow2 == orThrow) {
                    return sb.toString();
                }
                sb.append(orThrow2);
            }
        }
    }

    private final char[] readReference() {
        String until = this.source.readUntil(Literals.COMMENT_2, "trying to read a char/entity reference");
        this.source.advance(1, "trying to read the end of a char/entity reference");
        String str = until;
        MatchResult matchResultMatchEntire = XmlLexerKt.decimalCharRef.matchEntire(str);
        if (matchResultMatchEntire == null) {
            MatchResult matchResultMatchEntire2 = XmlLexerKt.hexCharRef.matchEntire(str);
            if (matchResultMatchEntire2 == null) {
                Object obj = XmlLexerKt.namedRefs.get(until);
                if (obj == null) {
                    String str2 = "Unknown reference '" + until + '\'';
                    StringTextStream source = getSource();
                    int iMax = Math.max(0, source.offset - 3);
                    int iMin = Math.min(source.end - 1, source.offset + 3);
                    String strSubstring = source.source.substring(iMax, iMin + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    throw new DeserializationException(str2 + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
                }
                return (char[]) obj;
            }
            return Utf8Kt.codePointToChars(CharCompanionObject.INSTANCE, Integer.parseInt(matchResultMatchEntire2.getGroupValues().get(1), CharsKt.checkRadix(16)));
        }
        return Utf8Kt.codePointToChars(CharCompanionObject.INSTANCE, Integer.parseInt(matchResultMatchEntire.getGroupValues().get(1)));
    }

    private final XmlToken readTagToken() {
        boolean z;
        LexerState.Tag.OpenTag openTag;
        char orThrow = this.source.readOrThrow("looking for the start of a tag");
        if (orThrow != '<') {
            String str = "Unexpected character '" + orThrow + "' while looking for the start of a tag";
            StringTextStream source = getSource();
            int iMax = Math.max(0, source.offset - 3);
            int iMin = Math.min(source.end - 1, source.offset + 3);
            String strSubstring = source.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
        }
        if (this.source.advanceIf("!--")) {
            skipComment();
            XmlToken next = parseNext();
            Intrinsics.checkNotNull(next);
            return next;
        }
        if (this.source.advanceIf(DomExceptionUtils.SEPARATOR)) {
            LexerState lexerState = this.state;
            Intrinsics.checkNotNull(lexerState, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag.OpenTag");
            LexerState.Tag.OpenTag openTag2 = (LexerState.Tag.OpenTag) lexerState;
            XmlToken.QualifiedName name = openTag2.getName();
            XmlToken.QualifiedName name2 = readName();
            if (!Intrinsics.areEqual(name2, name)) {
                String str2 = "Unexpected '/" + name2 + "' tag while looking for '/" + name + "' tag";
                StringTextStream source2 = getSource();
                int iMax2 = Math.max(0, source2.offset - 3);
                int iMin2 = Math.min(source2.end - 1, source2.offset + 3);
                String strSubstring2 = source2.source.substring(iMax2, iMin2 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                throw new DeserializationException(str2 + '\n' + ("At offset " + source2.offset + " (showing range " + iMax2 + Soundex.SILENT_MARKER + iMin2 + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring2, "·") + '\n' + (StringsKt.repeat(" ", source2.offset - iMax2) + '^')));
            }
            skipSpace();
            char orThrow2 = this.source.readOrThrow("looking for the end of a tag");
            if (orThrow2 != '>') {
                String str3 = "Unexpected character '" + orThrow2 + "' while looking for the end of a tag";
                StringTextStream source3 = getSource();
                int iMax3 = Math.max(0, source3.offset - 3);
                int iMin3 = Math.min(source3.end - 1, source3.offset + 3);
                String strSubstring3 = source3.source.substring(iMax3, iMin3 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                throw new DeserializationException(str3 + '\n' + ("At offset " + source3.offset + " (showing range " + iMax3 + Soundex.SILENT_MARKER + iMin3 + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring3, "·") + '\n' + (StringsKt.repeat(" ", source3.offset - iMax3) + '^')));
            }
            LexerState parent = openTag2.getParent();
            if (parent == null) {
                parent = LexerState.EndOfDocument.INSTANCE;
            }
            this.state = parent;
            return new XmlToken.EndElement(openTag2.getDepth(), name2);
        }
        int i = 1;
        LexerState lexerState2 = this.state;
        LexerState.Tag.OpenTag openTag3 = lexerState2 instanceof LexerState.Tag.OpenTag ? (LexerState.Tag.OpenTag) lexerState2 : null;
        LexerState.Tag.OpenTag openTagCopy$default = openTag3 != null ? LexerState.Tag.OpenTag.copy$default(openTag3, null, null, true, 3, null) : null;
        XmlToken.QualifiedName name3 = readName();
        skipSpace();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            char orThrow3 = this.source.readOrThrow("looking for the end of a tag");
            if (orThrow3 == '/') {
                z = true;
                break;
            }
            if (orThrow3 == '>') {
                z = false;
                break;
            }
            this.source.rewind(i, "looking for the beginning of an attribute");
            Pair<XmlToken.QualifiedName, String> attribute = readAttribute();
            linkedHashMap.put(attribute.getFirst(), attribute.getSecond());
            skipSpace();
            i = 1;
        }
        Pair pairExtractNsDeclarations = XmlLexerKt.extractNsDeclarations(linkedHashMap);
        Map map = (Map) pairExtractNsDeclarations.component1();
        List list = (List) pairExtractNsDeclarations.component2();
        if (z) {
            if (this.source.readOrThrow("looking for the end of a tag") == '>') {
                openTag = new LexerState.Tag.EmptyTag(name3, openTagCopy$default);
            } else {
                StringTextStream source4 = getSource();
                int iMax4 = Math.max(0, source4.offset - 3);
                int iMin4 = Math.min(source4.end - 1, source4.offset + 3);
                String strSubstring4 = source4.source.substring(iMax4, iMin4 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                throw new DeserializationException("Unexpected characters while looking for the end of a tag\n" + ("At offset " + source4.offset + " (showing range " + iMax4 + Soundex.SILENT_MARKER + iMin4 + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring4, "·") + '\n' + (StringsKt.repeat(" ", source4.offset - iMax4) + '^')));
            }
        } else {
            openTag = new LexerState.Tag.OpenTag(name3, openTagCopy$default, false);
        }
        this.state = openTag;
        return new XmlToken.BeginElement(openTag.getDepth(), name3, map, list);
    }

    private final XmlToken readTextToken() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            char orThrow = this.source.readOrThrow("reading text node");
            if (orThrow == '\t' || orThrow == '\n' || orThrow == '\r' || orThrow == ' ') {
                sb.append(orThrow);
            } else {
                if (orThrow == '&') {
                    sb.append(readReference());
                } else if (orThrow == '<') {
                    if (!this.source.advanceIf("!--")) {
                        if (!this.source.advanceIf("![CDATA[")) {
                            break;
                        }
                        sb.append(readCdata());
                        z = false;
                    } else {
                        skipComment();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    sb.append(orThrow);
                }
                z = false;
            }
        }
        this.source.rewind(1, "looking for the beginning of a tag");
        String string = sb.toString();
        LexerState lexerState = this.state;
        Intrinsics.checkNotNull(lexerState, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag.OpenTag");
        LexerState.Tag.OpenTag openTag = (LexerState.Tag.OpenTag) lexerState;
        boolean seenChildren = openTag.getSeenChildren();
        boolean zPeekMatches = this.source.peekMatches("</");
        this.state = LexerState.Tag.OpenTag.copy$default(openTag, null, null, true, 3, null);
        if (z && (seenChildren || !zPeekMatches)) {
            XmlToken next = parseNext();
            Intrinsics.checkNotNull(next);
            return next;
        }
        return new XmlToken.Text(this.state.getDepth(), string);
    }

    private final void skipComment() {
        this.source.readThrough("-->", "looking for the end of a comment");
    }

    private final void skipPreprocessingInstructions() {
        skipSpace();
        while (this.source.advanceIf("<?")) {
            this.source.advanceUntilSpace();
            skipSpace();
            while (!this.source.advanceIf("?>")) {
                readAttribute();
                skipSpace();
            }
            skipSpace();
        }
    }

    private final void skipSpace() {
        this.source.advanceWhileSpace();
    }

    private final XmlToken.QualifiedName qualify(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
        List list = listSplit$default;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).length() == 0) {
                    String str2 = "Cannot understand qualified name '" + str + '\'';
                    StringTextStream source = getSource();
                    int iMax = Math.max(0, source.offset - 3);
                    int iMin = Math.min(source.end - 1, source.offset + 3);
                    String strSubstring = source.source.substring(iMax, iMin + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    throw new DeserializationException(str2 + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
                }
            }
        }
        int size = listSplit$default.size();
        if (size == 1) {
            return new XmlToken.QualifiedName((String) listSplit$default.get(0), null, 2, null);
        }
        if (size == 2) {
            return new XmlToken.QualifiedName((String) listSplit$default.get(1), (String) listSplit$default.get(0));
        }
        String str3 = "Cannot understand qualified name '" + str + '\'';
        StringTextStream source2 = getSource();
        int iMax2 = Math.max(0, source2.offset - 3);
        int iMin2 = Math.min(source2.end - 1, source2.offset + 3);
        String strSubstring2 = source2.source.substring(iMax2, iMin2 + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        throw new DeserializationException(str3 + '\n' + ("At offset " + source2.offset + " (showing range " + iMax2 + Soundex.SILENT_MARKER + iMin2 + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring2, "·") + '\n' + (StringsKt.repeat(" ", source2.offset - iMax2) + '^')));
    }
}
