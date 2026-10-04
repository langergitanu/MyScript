package androidx.compose.p004ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.p004ui.graphics.AndroidColor_androidKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.ULong;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m1599d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", TypedValues.Custom.S_FLOAT, "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", TypedValues.Custom.S_STRING, "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m8149equalsimpl0(spanStyle.m10393getColor0d7_KjU(), Color.INSTANCE.m8184getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m10124encode8_81llA(spanStyle.m10393getColor0d7_KjU());
        }
        if (!TextUnit.m11208equalsimpl0(spanStyle.getFontSize(), TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m10121encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int iM10570unboximpl = fontStyle.m10570unboximpl();
            encode((byte) 4);
            m10126encodenzbMABs(iM10570unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int iM10583unboximpl = fontSynthesis.m10583unboximpl();
            encode((byte) 5);
            m10123encode6p3vJLY(iM10583unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m11208equalsimpl0(spanStyle.getLetterSpacing(), TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m10121encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM10763unboximpl = baselineShift.m10763unboximpl();
            encode((byte) 8);
            m10122encode4Dl_Bck(fM10763unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m8149equalsimpl0(spanStyle.getBackground(), Color.INSTANCE.m8184getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m10124encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode(Ascii.f994VT);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode(Ascii.f983FF);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m10124encode8_81llA(long color) {
        m10125encodeVKZWuLQ(ULong.m14673constructorimpl(AndroidColor_androidKt.m8011toColorLong8_81llA(color)));
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m10121encodeR2X_6o(long textUnit) {
        long jM11210getTypeUIouoOA = TextUnit.m11210getTypeUIouoOA(textUnit);
        byte b = 0;
        if (!TextUnitType.m11239equalsimpl0(jM11210getTypeUIouoOA, TextUnitType.INSTANCE.m11245getUnspecifiedUIouoOA())) {
            if (TextUnitType.m11239equalsimpl0(jM11210getTypeUIouoOA, TextUnitType.INSTANCE.m11244getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m11239equalsimpl0(jM11210getTypeUIouoOA, TextUnitType.INSTANCE.m11243getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m11239equalsimpl0(TextUnit.m11210getTypeUIouoOA(textUnit), TextUnitType.INSTANCE.m11245getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m11211getValueimpl(textUnit));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m10126encodenzbMABs(int fontStyle) {
        byte b = 0;
        if (!FontStyle.m10567equalsimpl0(fontStyle, FontStyle.INSTANCE.m10574getNormal_LCdwA()) && FontStyle.m10567equalsimpl0(fontStyle, FontStyle.INSTANCE.m10573getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m10123encode6p3vJLY(int fontSynthesis) {
        byte b = 0;
        if (!FontSynthesis.m10578equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m10585getNoneGVVA2EU())) {
            if (FontSynthesis.m10578equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m10584getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m10578equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m10587getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m10578equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m10586getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m10122encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m10124encode8_81llA(shadow.getColor());
        encode(Float.intBitsToFloat((int) (shadow.getOffset() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m10125encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
