package androidx.compose.p004ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.p004ui.geometry.Offset;
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
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.p004ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ULong;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\r\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\rJ\u0006\u0010\u0011\u001a\u00020\u0012J\r\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u000f\u0010(\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010\rJ\b\u0010+\u001a\u00020,H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010.\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m1599d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", TypedValues.Custom.S_STRING, "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeByte", "", "decodeInt", "", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "decodeFloat", "", "decodeString", "dataAvailable", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                if (bDecodeByte != 2) {
                    if (bDecodeByte != 3) {
                        if (bDecodeByte != 4) {
                            if (bDecodeByte != 5) {
                                if (bDecodeByte != 6) {
                                    if (bDecodeByte != 7) {
                                        if (bDecodeByte != 8) {
                                            if (bDecodeByte != 9) {
                                                if (bDecodeByte != 10) {
                                                    if (bDecodeByte != 11) {
                                                        if (bDecodeByte == 12) {
                                                            if (dataAvailable() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.setShadow(decodeShadow());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        if (dataAvailable() < 4) {
                                                            break;
                                                        }
                                                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                                    }
                                                } else {
                                                    if (dataAvailable() < 8) {
                                                        break;
                                                    }
                                                    mutableSpanStyle.m10148setBackground8_81llA(m10101decodeColor0d7_KjU());
                                                }
                                            } else {
                                                if (dataAvailable() < 8) {
                                                    break;
                                                }
                                                mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.m10149setBaselineShift_isdbwI(BaselineShift.m10757boximpl(m10099decodeBaselineShifty9eOQZs()));
                                        }
                                    } else {
                                        if (dataAvailable() < 5) {
                                            break;
                                        }
                                        mutableSpanStyle.m10154setLetterSpacingR2X_6o(m10104decodeTextUnitXSAIIZE());
                                    }
                                } else {
                                    mutableSpanStyle.setFontFeatureSettings(decodeString());
                                }
                            } else {
                                if (dataAvailable() < 1) {
                                    break;
                                }
                                mutableSpanStyle.m10153setFontSynthesistDdu0R4(FontSynthesis.m10575boximpl(m10103decodeFontSynthesisGVVA2EU()));
                            }
                        } else {
                            if (dataAvailable() < 1) {
                                break;
                            }
                            mutableSpanStyle.m10152setFontStylemLjRB2g(FontStyle.m10564boximpl(m10102decodeFontStyle_LCdwA()));
                        }
                    } else {
                        if (dataAvailable() < 4) {
                            break;
                        }
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                    }
                } else {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m10151setFontSizeR2X_6o(m10104decodeTextUnitXSAIIZE());
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle.m10150setColor8_81llA(m10101decodeColor0d7_KjU());
            }
        }
        return mutableSpanStyle.toSpanStyle();
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m10101decodeColor0d7_KjU() {
        return AndroidColor_androidKt.fromColorLong(Color.INSTANCE, this.parcel.readLong());
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m10104decodeTextUnitXSAIIZE() {
        long jM11245getUnspecifiedUIouoOA;
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 1) {
            jM11245getUnspecifiedUIouoOA = TextUnitType.INSTANCE.m11244getSpUIouoOA();
        } else if (bDecodeByte == 2) {
            jM11245getUnspecifiedUIouoOA = TextUnitType.INSTANCE.m11243getEmUIouoOA();
        } else {
            jM11245getUnspecifiedUIouoOA = TextUnitType.INSTANCE.m11245getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m11239equalsimpl0(jM11245getUnspecifiedUIouoOA, TextUnitType.INSTANCE.m11245getUnspecifiedUIouoOA())) {
            return TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m11223TextUnitanM5pPY(decodeFloat(), jM11245getUnspecifiedUIouoOA);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m10102decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontStyle.INSTANCE.m10574getNormal_LCdwA();
        }
        if (bDecodeByte == 1) {
            return FontStyle.INSTANCE.m10573getItalic_LCdwA();
        }
        return FontStyle.INSTANCE.m10574getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m10103decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontSynthesis.INSTANCE.m10585getNoneGVVA2EU();
        }
        if (bDecodeByte == 1) {
            return FontSynthesis.INSTANCE.m10584getAllGVVA2EU();
        }
        if (bDecodeByte == 3) {
            return FontSynthesis.INSTANCE.m10586getStyleGVVA2EU();
        }
        if (bDecodeByte == 2) {
            return FontSynthesis.INSTANCE.m10587getWeightGVVA2EU();
        }
        return FontSynthesis.INSTANCE.m10585getNoneGVVA2EU();
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m10099decodeBaselineShifty9eOQZs() {
        return BaselineShift.m10758constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        return TextDecoration.INSTANCE.valueOf(decodeInt());
    }

    private final Shadow decodeShadow() {
        long jM10101decodeColor0d7_KjU = m10101decodeColor0d7_KjU();
        float fDecodeFloat = decodeFloat();
        return new Shadow(jM10101decodeColor0d7_KjU, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(decodeFloat())) & 4294967295L) | (Float.floatToRawIntBits(fDecodeFloat) << 32)), decodeFloat(), null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m10100decodeULongsVKNKU() {
        return ULong.m14673constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
