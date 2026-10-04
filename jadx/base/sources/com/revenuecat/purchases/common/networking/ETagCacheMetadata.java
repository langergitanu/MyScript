package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ETagManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'J\t\u0010+\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagCacheMetadata;", "", "eTagData", "Lcom/revenuecat/purchases/common/networking/ETagData;", ETagCacheMetadata.SERIALIZATION_NAME_RESPONSE_CODE, "", ETagCacheMetadata.SERIALIZATION_NAME_REQUEST_DATE, "Ljava/util/Date;", ETagCacheMetadata.SERIALIZATION_NAME_VERIFICATION_RESULT, "Lcom/revenuecat/purchases/VerificationResult;", ETagCacheMetadata.SERIALIZATION_NAME_IS_LOAD_SHEDDER_RESPONSE, "", ETagCacheMetadata.SERIALIZATION_NAME_IS_FALLBACK_URL, ETagCacheMetadata.SERIALIZATION_NAME_PAYLOAD_CHECKSUM, "", "(Lcom/revenuecat/purchases/common/networking/ETagData;ILjava/util/Date;Lcom/revenuecat/purchases/VerificationResult;ZZJ)V", "getETagData", "()Lcom/revenuecat/purchases/common/networking/ETagData;", "()Z", "getPayloadChecksum", "()J", "getRequestDate", "()Ljava/util/Date;", "getResponseCode", "()I", "getVerificationResult", "()Lcom/revenuecat/purchases/VerificationResult;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "serialize", "", "toHTTPResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "payload", "toString", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class ETagCacheMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SERIALIZATION_NAME_ETAG = "eTag";
    private static final String SERIALIZATION_NAME_IS_FALLBACK_URL = "isFallbackURL";
    private static final String SERIALIZATION_NAME_IS_LOAD_SHEDDER_RESPONSE = "isLoadShedderResponse";
    private static final String SERIALIZATION_NAME_LAST_REFRESH_TIME = "lastRefreshTime";
    private static final String SERIALIZATION_NAME_PAYLOAD_CHECKSUM = "payloadChecksum";
    private static final String SERIALIZATION_NAME_REQUEST_DATE = "requestDate";
    private static final String SERIALIZATION_NAME_RESPONSE_CODE = "responseCode";
    private static final String SERIALIZATION_NAME_VERIFICATION_RESULT = "verificationResult";
    private final ETagData eTagData;
    private final boolean isFallbackURL;
    private final boolean isLoadShedderResponse;
    private final long payloadChecksum;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    public static /* synthetic */ ETagCacheMetadata copy$default(ETagCacheMetadata eTagCacheMetadata, ETagData eTagData, int i, Date date, VerificationResult verificationResult, boolean z, boolean z2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            eTagData = eTagCacheMetadata.eTagData;
        }
        if ((i2 & 2) != 0) {
            i = eTagCacheMetadata.responseCode;
        }
        if ((i2 & 4) != 0) {
            date = eTagCacheMetadata.requestDate;
        }
        if ((i2 & 8) != 0) {
            verificationResult = eTagCacheMetadata.verificationResult;
        }
        if ((i2 & 16) != 0) {
            z = eTagCacheMetadata.isLoadShedderResponse;
        }
        if ((i2 & 32) != 0) {
            z2 = eTagCacheMetadata.isFallbackURL;
        }
        if ((i2 & 64) != 0) {
            j = eTagCacheMetadata.payloadChecksum;
        }
        long j2 = j;
        boolean z3 = z;
        boolean z4 = z2;
        return eTagCacheMetadata.copy(eTagData, i, date, verificationResult, z3, z4, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ETagData getETagData() {
        return this.eTagData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFallbackURL() {
        return this.isFallbackURL;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getPayloadChecksum() {
        return this.payloadChecksum;
    }

    public final ETagCacheMetadata copy(ETagData eTagData, int responseCode, Date requestDate, VerificationResult verificationResult, boolean isLoadShedderResponse, boolean isFallbackURL, long payloadChecksum) {
        Intrinsics.checkNotNullParameter(eTagData, "eTagData");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        return new ETagCacheMetadata(eTagData, responseCode, requestDate, verificationResult, isLoadShedderResponse, isFallbackURL, payloadChecksum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ETagCacheMetadata)) {
            return false;
        }
        ETagCacheMetadata eTagCacheMetadata = (ETagCacheMetadata) other;
        return Intrinsics.areEqual(this.eTagData, eTagCacheMetadata.eTagData) && this.responseCode == eTagCacheMetadata.responseCode && Intrinsics.areEqual(this.requestDate, eTagCacheMetadata.requestDate) && this.verificationResult == eTagCacheMetadata.verificationResult && this.isLoadShedderResponse == eTagCacheMetadata.isLoadShedderResponse && this.isFallbackURL == eTagCacheMetadata.isFallbackURL && this.payloadChecksum == eTagCacheMetadata.payloadChecksum;
    }

    public int hashCode() {
        int iHashCode = ((this.eTagData.hashCode() * 31) + Integer.hashCode(this.responseCode)) * 31;
        Date date = this.requestDate;
        return ((((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode()) * 31) + Boolean.hashCode(this.isLoadShedderResponse)) * 31) + Boolean.hashCode(this.isFallbackURL)) * 31) + Long.hashCode(this.payloadChecksum);
    }

    public String toString() {
        return "ETagCacheMetadata(eTagData=" + this.eTagData + ", responseCode=" + this.responseCode + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ", isLoadShedderResponse=" + this.isLoadShedderResponse + ", isFallbackURL=" + this.isFallbackURL + ", payloadChecksum=" + this.payloadChecksum + ')';
    }

    public ETagCacheMetadata(ETagData eTagData, int i, Date date, VerificationResult verificationResult, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(eTagData, "eTagData");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        this.eTagData = eTagData;
        this.responseCode = i;
        this.requestDate = date;
        this.verificationResult = verificationResult;
        this.isLoadShedderResponse = z;
        this.isFallbackURL = z2;
        this.payloadChecksum = j;
    }

    public final ETagData getETagData() {
        return this.eTagData;
    }

    public final int getResponseCode() {
        return this.responseCode;
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

    public final long getPayloadChecksum() {
        return this.payloadChecksum;
    }

    public final String serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SERIALIZATION_NAME_ETAG, this.eTagData.getETag());
        Date lastRefreshTime = this.eTagData.getLastRefreshTime();
        if (lastRefreshTime != null) {
            jSONObject.put(SERIALIZATION_NAME_LAST_REFRESH_TIME, lastRefreshTime.getTime());
        }
        jSONObject.put(SERIALIZATION_NAME_RESPONSE_CODE, this.responseCode);
        Date date = this.requestDate;
        if (date != null) {
            jSONObject.put(SERIALIZATION_NAME_REQUEST_DATE, date.getTime());
        }
        jSONObject.put(SERIALIZATION_NAME_VERIFICATION_RESULT, this.verificationResult.name());
        jSONObject.put(SERIALIZATION_NAME_IS_LOAD_SHEDDER_RESPONSE, this.isLoadShedderResponse);
        jSONObject.put(SERIALIZATION_NAME_IS_FALLBACK_URL, this.isFallbackURL);
        jSONObject.put(SERIALIZATION_NAME_PAYLOAD_CHECKSUM, this.payloadChecksum);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …sum)\n        }.toString()");
        return string;
    }

    public final HTTPResult toHTTPResult(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new HTTPResult(this.responseCode, payload, HTTPResult.Origin.CACHE, this.requestDate, this.verificationResult, this.isLoadShedderResponse, this.isFallbackURL);
    }

    /* JADX INFO: compiled from: ETagManager.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagCacheMetadata$Companion;", "", "()V", "SERIALIZATION_NAME_ETAG", "", "SERIALIZATION_NAME_IS_FALLBACK_URL", "SERIALIZATION_NAME_IS_LOAD_SHEDDER_RESPONSE", "SERIALIZATION_NAME_LAST_REFRESH_TIME", "SERIALIZATION_NAME_PAYLOAD_CHECKSUM", "SERIALIZATION_NAME_REQUEST_DATE", "SERIALIZATION_NAME_RESPONSE_CODE", "SERIALIZATION_NAME_VERIFICATION_RESULT", "deserialize", "Lcom/revenuecat/purchases/common/networking/ETagCacheMetadata;", "serialized", "fromResult", "result", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "eTagData", "Lcom/revenuecat/purchases/common/networking/ETagData;", ETagCacheMetadata.SERIALIZATION_NAME_PAYLOAD_CHECKSUM, "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ETagCacheMetadata fromResult(HTTPResult result, ETagData eTagData, long payloadChecksum) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(eTagData, "eTagData");
            return new ETagCacheMetadata(eTagData, result.getResponseCode(), result.getRequestDate(), result.getVerificationResult(), result.isLoadShedderResponse(), result.isFallbackURL(), payloadChecksum);
        }

        public final ETagCacheMetadata deserialize(String serialized) {
            VerificationResult verificationResultValueOf;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                JSONObject jSONObject = new JSONObject(serialized);
                Long lValueOf = Long.valueOf(jSONObject.optLong(ETagCacheMetadata.SERIALIZATION_NAME_LAST_REFRESH_TIME, -1L));
                if (lValueOf.longValue() == -1) {
                    lValueOf = null;
                }
                Date date = lValueOf != null ? new Date(lValueOf.longValue()) : null;
                Long lValueOf2 = Long.valueOf(jSONObject.optLong(ETagCacheMetadata.SERIALIZATION_NAME_REQUEST_DATE, -1L));
                if (lValueOf2.longValue() == -1) {
                    lValueOf2 = null;
                }
                Date date2 = lValueOf2 != null ? new Date(lValueOf2.longValue()) : null;
                if (jSONObject.has(ETagCacheMetadata.SERIALIZATION_NAME_VERIFICATION_RESULT)) {
                    String string = jSONObject.getString(ETagCacheMetadata.SERIALIZATION_NAME_VERIFICATION_RESULT);
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(SER…NAME_VERIFICATION_RESULT)");
                    verificationResultValueOf = VerificationResult.valueOf(string);
                } else {
                    verificationResultValueOf = VerificationResult.NOT_REQUESTED;
                }
                VerificationResult verificationResult = verificationResultValueOf;
                String string2 = jSONObject.getString(ETagCacheMetadata.SERIALIZATION_NAME_ETAG);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SERIALIZATION_NAME_ETAG)");
                return new ETagCacheMetadata(new ETagData(string2, date), jSONObject.getInt(ETagCacheMetadata.SERIALIZATION_NAME_RESPONSE_CODE), date2, verificationResult, jSONObject.optBoolean(ETagCacheMetadata.SERIALIZATION_NAME_IS_LOAD_SHEDDER_RESPONSE, false), jSONObject.optBoolean(ETagCacheMetadata.SERIALIZATION_NAME_IS_FALLBACK_URL, false), jSONObject.getLong(ETagCacheMetadata.SERIALIZATION_NAME_PAYLOAD_CHECKSUM));
            } catch (IllegalArgumentException | JSONException unused) {
                return null;
            }
        }
    }
}
