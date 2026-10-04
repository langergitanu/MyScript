package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: StringTextStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0082\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0080\b¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0016\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/StringTextStream;", "", FirebaseAnalytics.Param.SOURCE, "", "<init>", "(Ljava/lang/String;)V", TtmlNode.END, "", TypedValues.CycleType.S_WAVE_OFFSET, "advance", "", "length", "errCondition", "advanceIf", "", "text", "advanceUntilSpace", "advanceWhileSpace", "checkBounds", "error", "", NotificationCompat.CATEGORY_MESSAGE, "error$serde_xml", "peekMatches", "readOrThrow", "", "readThrough", "readUntil", "readWhileXmlName", "rewind", "sliceByEnd", "endExclusive", "sliceByLength", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StringTextStream {
    private final int end;
    private int offset;
    private final String source;

    public StringTextStream(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.end = source.length();
    }

    public final boolean advanceIf(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!StringsKt.startsWith$default(this.source, text, this.offset, false, 4, (Object) null)) {
            return false;
        }
        this.offset += text.length();
        return true;
    }

    public final void advanceUntilSpace() {
        char cCharAt;
        while (true) {
            int i = this.offset;
            if (i >= this.end || (cCharAt = this.source.charAt(i)) == '\t' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ') {
                return;
            } else {
                this.offset++;
            }
        }
    }

    public final void advanceWhileSpace() {
        while (true) {
            int i = this.offset;
            if (i >= this.end) {
                return;
            }
            char cCharAt = this.source.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\n' && cCharAt != '\t') {
                return;
            } else {
                this.offset++;
            }
        }
    }

    private final void checkBounds(int length, String errCondition) {
        if (this.offset + length <= this.end) {
            return;
        }
        String str = "Unexpected end-of-doc while " + errCondition;
        int iMax = Math.max(0, this.offset - 3);
        int iMin = Math.min(this.end - 1, this.offset + 3);
        String strSubstring = this.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
    }

    public final Void error$serde_xml(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int iMax = Math.max(0, this.offset - 3);
        int iMin = Math.min(this.end - 1, this.offset + 3);
        String strSubstring = this.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(msg + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
    }

    public final boolean peekMatches(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return Intrinsics.areEqual(sliceByLength(Math.min(text.length(), this.end - this.offset)), text);
    }

    public final String readThrough(String text, String errCondition) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(errCondition, "errCondition");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.source, text, this.offset, false, 4, (Object) null);
        if (iIndexOf$default < 0) {
            String str = "Unexpected end-of-doc while " + errCondition;
            int iMax = Math.max(0, this.offset - 3);
            int iMin = Math.min(this.end - 1, this.offset + 3);
            String strSubstring = this.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
        }
        int length = iIndexOf$default + text.length();
        String strSliceByEnd = sliceByEnd(length);
        this.offset = length;
        return strSliceByEnd;
    }

    public final String readUntil(String text, String errCondition) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(errCondition, "errCondition");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.source, text, this.offset, false, 4, (Object) null);
        if (iIndexOf$default < 0) {
            String str = "Unexpected end-of-doc while " + errCondition;
            int iMax = Math.max(0, this.offset - 3);
            int iMin = Math.min(this.end - 1, this.offset + 3);
            String strSubstring = this.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
        }
        String strSliceByEnd = sliceByEnd(iIndexOf$default);
        this.offset = iIndexOf$default;
        return strSliceByEnd;
    }

    public final String readWhileXmlName() {
        char c;
        char cCharAt = this.source.charAt(this.offset);
        int i = 214;
        int i2 = 90;
        if ((Intrinsics.compare(97, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, PDFACompliance.e_PDFA1_2_2) > 0) && ((Intrinsics.compare(65, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 90) > 0) && cCharAt != ':' && cCharAt != '_' && ((Intrinsics.compare(PsExtractor.AUDIO_STREAM, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 214) > 0) && ((Intrinsics.compare(216, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 246) > 0) && ((Intrinsics.compare(248, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 767) > 0) && ((Intrinsics.compare(880, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 893) > 0) && ((Intrinsics.compare(895, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 8191) > 0) && ((Intrinsics.compare(8204, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 8205) > 0) && ((Intrinsics.compare(8304, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 8591) > 0) && ((Intrinsics.compare(11264, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 12271) > 0) && (Intrinsics.compare(12289, (int) cCharAt) > 0 || Intrinsics.compare((int) cCharAt, 55295) > 0))))))))))) {
            String str = "Found '" + cCharAt + "' but expected a valid XML start name character";
            int iMax = Math.max(0, this.offset - 3);
            int iMin = Math.min(this.end - 1, this.offset + 3);
            String strSubstring = this.source.substring(iMax, iMin + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
        }
        int i3 = this.offset + 1;
        while (i3 < this.end) {
            char cCharAt2 = this.source.charAt(i3);
            if ((Intrinsics.compare(97, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, PDFACompliance.e_PDFA1_2_2) > 0) && ((Intrinsics.compare(65, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, i2) > 0) && !((Intrinsics.compare(48, (int) cCharAt2) <= 0 && Intrinsics.compare((int) cCharAt2, 57) <= 0) || cCharAt2 == ':' || cCharAt2 == '-' || cCharAt2 == '.' || cCharAt2 == '_' || cCharAt2 == 183 || ((Intrinsics.compare(PsExtractor.AUDIO_STREAM, (int) cCharAt2) <= 0 && Intrinsics.compare((int) cCharAt2, i) <= 0) || ((Intrinsics.compare(216, (int) cCharAt2) <= 0 && Intrinsics.compare((int) cCharAt2, 246) <= 0) || ((Intrinsics.compare(248, (int) cCharAt2) <= 0 && Intrinsics.compare((int) cCharAt2, 767) <= 0) || (Intrinsics.compare(ViewUtils.EDGE_TO_EDGE_FLAGS, (int) cCharAt2) <= 0 && Intrinsics.compare((int) cCharAt2, 879) <= 0))))))) {
                if (Intrinsics.compare(880, (int) cCharAt2) <= 0) {
                    c = 893;
                    if (Intrinsics.compare((int) cCharAt2, 893) <= 0) {
                        continue;
                    }
                } else {
                    c = 893;
                }
                if ((Intrinsics.compare(895, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 8191) > 0) && ((Intrinsics.compare(8204, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 8205) > 0) && ((Intrinsics.compare(8255, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 8256) > 0) && ((Intrinsics.compare(8304, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 8591) > 0) && ((Intrinsics.compare(11264, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 12271) > 0) && (Intrinsics.compare(12289, (int) cCharAt2) > 0 || Intrinsics.compare((int) cCharAt2, 55295) > 0)))))) {
                    break;
                }
            } else {
                c = 893;
            }
            i3++;
            i = 214;
            i2 = 90;
        }
        String strSliceByEnd = sliceByEnd(i3);
        this.offset = i3;
        return strSliceByEnd;
    }

    private final String sliceByEnd(int endExclusive) {
        String strSubstring = this.source.substring(this.offset, endExclusive);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String sliceByLength(int length) {
        return sliceByEnd(this.offset + length);
    }

    public final void advance(int length, String errCondition) {
        Intrinsics.checkNotNullParameter(errCondition, "errCondition");
        int i = this.offset;
        if (i + length <= this.end) {
            this.offset = i + length;
            return;
        }
        String str = "Unexpected end-of-doc while " + errCondition;
        int iMax = Math.max(0, this.offset - 3);
        int iMin = Math.min(this.end - 1, this.offset + 3);
        String strSubstring = this.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
    }

    public final char readOrThrow(String errCondition) {
        Intrinsics.checkNotNullParameter(errCondition, "errCondition");
        int i = this.offset;
        if (i + 1 <= this.end) {
            String str = this.source;
            this.offset = i + 1;
            return str.charAt(i);
        }
        String str2 = "Unexpected end-of-doc while " + errCondition;
        int iMax = Math.max(0, this.offset - 3);
        int iMin = Math.min(this.end - 1, this.offset + 3);
        String strSubstring = this.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(str2 + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
    }

    public final void rewind(int length, String errCondition) {
        Intrinsics.checkNotNullParameter(errCondition, "errCondition");
        int i = this.offset;
        if ((-length) + i <= this.end) {
            this.offset = i - length;
            return;
        }
        String str = "Unexpected end-of-doc while " + errCondition;
        int iMax = Math.max(0, this.offset - 3);
        int iMin = Math.min(this.end - 1, this.offset + 3);
        String strSubstring = this.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(str + '\n' + ("At offset " + this.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", this.offset - iMax) + '^')));
    }
}
