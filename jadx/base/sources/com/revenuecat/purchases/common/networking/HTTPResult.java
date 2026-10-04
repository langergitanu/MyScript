package com.revenuecat.purchases.common.networking;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.BackendHelperKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Arrays;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HTTPResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\b\u0080\b\u0018\u0000 92\u00020\u0001:\u00039:;BA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003JQ\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\b\u00107\u001a\u00020\u001aH\u0002J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006<"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult;", "", "responseCode", "", "payload", "", "origin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "isLoadShedderResponse", "", "isFallbackURL", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Ljava/util/Date;Lcom/revenuecat/purchases/VerificationResult;ZZ)V", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload;", "(ILcom/revenuecat/purchases/common/networking/HTTPResult$Payload;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Ljava/util/Date;Lcom/revenuecat/purchases/VerificationResult;ZZ)V", "backendErrorCode", "getBackendErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "backendErrorMessage", "getBackendErrorMessage", "()Ljava/lang/String;", TtmlNode.TAG_BODY, "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "body$delegate", "Lkotlin/Lazy;", "()Z", "getOrigin", "()Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "getPayload", "()Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload;", "payloadText", "getPayloadText", "getRequestDate", "()Ljava/util/Date;", "getResponseCode", "()I", "getVerificationResult", "()Lcom/revenuecat/purchases/VerificationResult;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "parseBody", "toString", "Companion", HttpHeaders.ORIGIN, "Payload", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class HTTPResult {
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String LOAD_SHEDDER_HEADER_NAME = "x-revenuecat-fortress";
    public static final String REQUEST_TIME_HEADER_NAME = "X-RevenueCat-Request-Time";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private final Integer backendErrorCode;
    private final String backendErrorMessage;

    /* JADX INFO: renamed from: body$delegate, reason: from kotlin metadata */
    private final Lazy body;
    private final boolean isFallbackURL;
    private final boolean isLoadShedderResponse;
    private final Origin origin;
    private final Payload payload;
    private final String payloadText;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    /* JADX INFO: compiled from: HTTPResult.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "", "(Ljava/lang/String;I)V", "BACKEND", "CACHE", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public enum Origin {
        BACKEND,
        CACHE
    }

    public static /* synthetic */ HTTPResult copy$default(HTTPResult hTTPResult, int i, Payload payload, Origin origin, Date date, VerificationResult verificationResult, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hTTPResult.responseCode;
        }
        if ((i2 & 2) != 0) {
            payload = hTTPResult.payload;
        }
        if ((i2 & 4) != 0) {
            origin = hTTPResult.origin;
        }
        if ((i2 & 8) != 0) {
            date = hTTPResult.requestDate;
        }
        if ((i2 & 16) != 0) {
            verificationResult = hTTPResult.verificationResult;
        }
        if ((i2 & 32) != 0) {
            z = hTTPResult.isLoadShedderResponse;
        }
        if ((i2 & 64) != 0) {
            z2 = hTTPResult.isFallbackURL;
        }
        boolean z3 = z;
        boolean z4 = z2;
        VerificationResult verificationResult2 = verificationResult;
        Origin origin2 = origin;
        return hTTPResult.copy(i, payload, origin2, date, verificationResult2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Payload getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsFallbackURL() {
        return this.isFallbackURL;
    }

    public final HTTPResult copy(int responseCode, Payload payload, Origin origin, Date requestDate, VerificationResult verificationResult, boolean isLoadShedderResponse, boolean isFallbackURL) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        return new HTTPResult(responseCode, payload, origin, requestDate, verificationResult, isLoadShedderResponse, isFallbackURL);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPResult)) {
            return false;
        }
        HTTPResult hTTPResult = (HTTPResult) other;
        return this.responseCode == hTTPResult.responseCode && Intrinsics.areEqual(this.payload, hTTPResult.payload) && this.origin == hTTPResult.origin && Intrinsics.areEqual(this.requestDate, hTTPResult.requestDate) && this.verificationResult == hTTPResult.verificationResult && this.isLoadShedderResponse == hTTPResult.isLoadShedderResponse && this.isFallbackURL == hTTPResult.isFallbackURL;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.responseCode) * 31) + this.payload.hashCode()) * 31) + this.origin.hashCode()) * 31;
        Date date = this.requestDate;
        return ((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode()) * 31) + Boolean.hashCode(this.isLoadShedderResponse)) * 31) + Boolean.hashCode(this.isFallbackURL);
    }

    public String toString() {
        return "HTTPResult(responseCode=" + this.responseCode + ", payload=" + this.payload + ", origin=" + this.origin + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ", isLoadShedderResponse=" + this.isLoadShedderResponse + ", isFallbackURL=" + this.isFallbackURL + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HTTPResult(int i, Payload payload, Origin origin, Date date, VerificationResult verificationResult, boolean z, boolean z2) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        this.responseCode = i;
        this.payload = payload;
        this.origin = origin;
        this.requestDate = date;
        this.verificationResult = verificationResult;
        this.isLoadShedderResponse = z;
        this.isFallbackURL = z2;
        this.payloadText = payload.getText();
        this.body = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.revenuecat.purchases.common.networking.HTTPResult$body$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JSONObject invoke() {
                return this.this$0.parseBody();
            }
        });
        String str = null;
        if (!BackendHelperKt.isSuccessful(this)) {
            numValueOf = Integer.valueOf(getBody().optInt("code"));
            numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        }
        this.backendErrorCode = numValueOf;
        if (!BackendHelperKt.isSuccessful(this)) {
            String it = getBody().optString("message");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!StringsKt.isBlank(it)) {
                str = it;
            }
        }
        this.backendErrorMessage = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public final boolean isLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    public final boolean isFallbackURL() {
        return this.isFallbackURL;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HTTPResult(int i, String payload, Origin origin, Date date, VerificationResult verificationResult, boolean z, boolean z2) {
        this(i, new Payload.Text(payload), origin, date, verificationResult, z, z2);
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
    }

    /* JADX INFO: compiled from: HTTPResult.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload;", "", "text", "", "getText", "()Ljava/lang/String;", "RCFormat", "Text", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload$RCFormat;", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload$Text;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface Payload {

        /* JADX INFO: compiled from: HTTPResult.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload$Text;", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Text implements Payload {
            private final String value;

            public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = text.value;
                }
                return text.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final Text copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Text(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Text) && Intrinsics.areEqual(this.value, ((Text) other).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "Text(value=" + this.value + ')';
            }

            public Text(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public final String getValue() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: HTTPResult.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload$RCFormat;", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Payload;", "bytes", "", "([B)V", "getBytes", "()[B", "equals", "", "other", "", "hashCode", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class RCFormat implements Payload {
            private final byte[] bytes;

            public RCFormat(byte[] bytes) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                this.bytes = bytes;
            }

            public final byte[] getBytes() {
                return this.bytes;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RCFormat) && Arrays.equals(this.bytes, ((RCFormat) other).bytes);
                }
                return true;
            }

            public int hashCode() {
                return Arrays.hashCode(this.bytes);
            }
        }

        /* JADX INFO: compiled from: HTTPResult.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static String getText(Payload payload) {
                return Payload.super.getText();
            }
        }

        default String getText() {
            if (this instanceof Text) {
                return ((Text) this).getValue();
            }
            if (this instanceof RCFormat) {
                return "";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String getPayloadText() {
        return this.payloadText;
    }

    public final JSONObject getBody() {
        return (JSONObject) this.body.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject parseBody() {
        String str = this.payloadText;
        JSONObject jSONObject = null;
        if (StringsKt.isBlank(str)) {
            str = null;
        }
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse payload as JSON: " + str, e);
            }
            if (jSONObject != null) {
                return jSONObject;
            }
        }
        return new JSONObject();
    }

    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }

    public final String getBackendErrorMessage() {
        return this.backendErrorMessage;
    }
}
