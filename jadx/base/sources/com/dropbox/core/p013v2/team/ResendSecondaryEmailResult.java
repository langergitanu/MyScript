package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class ResendSecondaryEmailResult {
    public static final ResendSecondaryEmailResult OTHER = new ResendSecondaryEmailResult().withTag(Tag.OTHER);
    private Tag _tag;
    private String notPendingValue;
    private String rateLimitedValue;
    private String successValue;

    public enum Tag {
        SUCCESS,
        NOT_PENDING,
        RATE_LIMITED,
        OTHER
    }

    private ResendSecondaryEmailResult() {
    }

    private ResendSecondaryEmailResult withTag(Tag tag) {
        ResendSecondaryEmailResult resendSecondaryEmailResult = new ResendSecondaryEmailResult();
        resendSecondaryEmailResult._tag = tag;
        return resendSecondaryEmailResult;
    }

    private ResendSecondaryEmailResult withTagAndSuccess(Tag tag, String str) {
        ResendSecondaryEmailResult resendSecondaryEmailResult = new ResendSecondaryEmailResult();
        resendSecondaryEmailResult._tag = tag;
        resendSecondaryEmailResult.successValue = str;
        return resendSecondaryEmailResult;
    }

    private ResendSecondaryEmailResult withTagAndNotPending(Tag tag, String str) {
        ResendSecondaryEmailResult resendSecondaryEmailResult = new ResendSecondaryEmailResult();
        resendSecondaryEmailResult._tag = tag;
        resendSecondaryEmailResult.notPendingValue = str;
        return resendSecondaryEmailResult;
    }

    private ResendSecondaryEmailResult withTagAndRateLimited(Tag tag, String str) {
        ResendSecondaryEmailResult resendSecondaryEmailResult = new ResendSecondaryEmailResult();
        resendSecondaryEmailResult._tag = tag;
        resendSecondaryEmailResult.rateLimitedValue = str;
        return resendSecondaryEmailResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static ResendSecondaryEmailResult success(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, str);
    }

    public String getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isNotPending() {
        return this._tag == Tag.NOT_PENDING;
    }

    public static ResendSecondaryEmailResult notPending(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndNotPending(Tag.NOT_PENDING, str);
    }

    public String getNotPendingValue() {
        if (this._tag != Tag.NOT_PENDING) {
            throw new IllegalStateException("Invalid tag: required Tag.NOT_PENDING, but was Tag." + this._tag.name());
        }
        return this.notPendingValue;
    }

    public boolean isRateLimited() {
        return this._tag == Tag.RATE_LIMITED;
    }

    public static ResendSecondaryEmailResult rateLimited(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ResendSecondaryEmailResult().withTagAndRateLimited(Tag.RATE_LIMITED, str);
    }

    public String getRateLimitedValue() {
        if (this._tag != Tag.RATE_LIMITED) {
            throw new IllegalStateException("Invalid tag: required Tag.RATE_LIMITED, but was Tag." + this._tag.name());
        }
        return this.rateLimitedValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.notPendingValue, this.rateLimitedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ResendSecondaryEmailResult)) {
            return false;
        }
        ResendSecondaryEmailResult resendSecondaryEmailResult = (ResendSecondaryEmailResult) obj;
        if (this._tag != resendSecondaryEmailResult._tag) {
            return false;
        }
        int i = C43901.f763x6f92e18f[this._tag.ordinal()];
        if (i == 1) {
            String str = this.successValue;
            String str2 = resendSecondaryEmailResult.successValue;
            return str == str2 || str.equals(str2);
        }
        if (i == 2) {
            String str3 = this.notPendingValue;
            String str4 = resendSecondaryEmailResult.notPendingValue;
            return str3 == str4 || str3.equals(str4);
        }
        if (i != 3) {
            return i == 4;
        }
        String str5 = this.rateLimitedValue;
        String str6 = resendSecondaryEmailResult.rateLimitedValue;
        return str5 == str6 || str5.equals(str6);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ResendSecondaryEmailResult$1 */
    static /* synthetic */ class C43901 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$ResendSecondaryEmailResult$Tag */
        static final /* synthetic */ int[] f763x6f92e18f;

        static {
            int[] iArr = new int[Tag.values().length];
            f763x6f92e18f = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f763x6f92e18f[Tag.NOT_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f763x6f92e18f[Tag.RATE_LIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f763x6f92e18f[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ResendSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ResendSecondaryEmailResult resendSecondaryEmailResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C43901.f763x6f92e18f[resendSecondaryEmailResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
                StoneSerializers.string().serialize(resendSecondaryEmailResult.successValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("not_pending", jsonGenerator);
                jsonGenerator.writeFieldName("not_pending");
                StoneSerializers.string().serialize(resendSecondaryEmailResult.notPendingValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("rate_limited", jsonGenerator);
                jsonGenerator.writeFieldName("rate_limited");
                StoneSerializers.string().serialize(resendSecondaryEmailResult.rateLimitedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ResendSecondaryEmailResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ResendSecondaryEmailResult resendSecondaryEmailResultRateLimited;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                expectField(FirebaseAnalytics.Param.SUCCESS, jsonParser);
                resendSecondaryEmailResultRateLimited = ResendSecondaryEmailResult.success(StoneSerializers.string().deserialize(jsonParser));
            } else if ("not_pending".equals(tag)) {
                expectField("not_pending", jsonParser);
                resendSecondaryEmailResultRateLimited = ResendSecondaryEmailResult.notPending(StoneSerializers.string().deserialize(jsonParser));
            } else if ("rate_limited".equals(tag)) {
                expectField("rate_limited", jsonParser);
                resendSecondaryEmailResultRateLimited = ResendSecondaryEmailResult.rateLimited(StoneSerializers.string().deserialize(jsonParser));
            } else {
                resendSecondaryEmailResultRateLimited = ResendSecondaryEmailResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return resendSecondaryEmailResultRateLimited;
        }
    }
}
