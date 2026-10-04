package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.hashing.Sha256Kt;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BaseSigV4SignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"HEADER_TIMESTAMP_TYPE", "", "eventStreamNonSignatureHeaders", "", QuestionSurveyAnswerType.DATE, "Laws/smithy/kotlin/runtime/time/Instant;", "writeLongBE", "", "dest", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "x", "", "aws-signing-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BaseSigV4SignatureCalculatorKt {
    private static final byte HEADER_TIMESTAMP_TYPE = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String eventStreamNonSignatureHeaders(Instant instant) {
        byte[] bArr = new byte[15];
        byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(":date");
        bArr[0] = (byte) bArrEncodeToByteArray.length;
        ArraysKt.copyInto$default(bArrEncodeToByteArray, bArr, 1, 0, 0, 12, (Object) null);
        int length = bArrEncodeToByteArray.length;
        bArr[1 + length] = 8;
        writeLongBE(bArr, length + 2, InstantKt.getEpochMilliseconds(instant));
        return HexKt.encodeToHex(Sha256Kt.sha256(bArr));
    }

    private static final void writeLongBE(byte[] bArr, int i, long j) {
        int i2 = 7;
        while (-1 < i2) {
            bArr[i] = (byte) ((j >>> (i2 * 8)) & 255);
            i2--;
            i++;
        }
    }
}
