package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DurationLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class WebSessionsFixedLengthPolicy {
    private Tag _tag;
    private DurationLogInfo definedValue;
    public static final WebSessionsFixedLengthPolicy UNDEFINED = new WebSessionsFixedLengthPolicy().withTag(Tag.UNDEFINED);
    public static final WebSessionsFixedLengthPolicy OTHER = new WebSessionsFixedLengthPolicy().withTag(Tag.OTHER);

    public enum Tag {
        DEFINED,
        UNDEFINED,
        OTHER
    }

    private WebSessionsFixedLengthPolicy() {
    }

    private WebSessionsFixedLengthPolicy withTag(Tag tag) {
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy = new WebSessionsFixedLengthPolicy();
        webSessionsFixedLengthPolicy._tag = tag;
        return webSessionsFixedLengthPolicy;
    }

    private WebSessionsFixedLengthPolicy withTagAndDefined(Tag tag, DurationLogInfo durationLogInfo) {
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy = new WebSessionsFixedLengthPolicy();
        webSessionsFixedLengthPolicy._tag = tag;
        webSessionsFixedLengthPolicy.definedValue = durationLogInfo;
        return webSessionsFixedLengthPolicy;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isDefined() {
        return this._tag == Tag.DEFINED;
    }

    public static WebSessionsFixedLengthPolicy defined(DurationLogInfo durationLogInfo) {
        if (durationLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WebSessionsFixedLengthPolicy().withTagAndDefined(Tag.DEFINED, durationLogInfo);
    }

    public DurationLogInfo getDefinedValue() {
        if (this._tag != Tag.DEFINED) {
            throw new IllegalStateException("Invalid tag: required Tag.DEFINED, but was Tag." + this._tag.name());
        }
        return this.definedValue;
    }

    public boolean isUndefined() {
        return this._tag == Tag.UNDEFINED;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.definedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof WebSessionsFixedLengthPolicy)) {
            return false;
        }
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy = (WebSessionsFixedLengthPolicy) obj;
        if (this._tag != webSessionsFixedLengthPolicy._tag) {
            return false;
        }
        int i = C45411.f803x157da15c[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        DurationLogInfo durationLogInfo = this.definedValue;
        DurationLogInfo durationLogInfo2 = webSessionsFixedLengthPolicy.definedValue;
        return durationLogInfo == durationLogInfo2 || durationLogInfo.equals(durationLogInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.WebSessionsFixedLengthPolicy$1 */
    static /* synthetic */ class C45411 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$WebSessionsFixedLengthPolicy$Tag */
        static final /* synthetic */ int[] f803x157da15c;

        static {
            int[] iArr = new int[Tag.values().length];
            f803x157da15c = iArr;
            try {
                iArr[Tag.DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f803x157da15c[Tag.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f803x157da15c[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<WebSessionsFixedLengthPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45411.f803x157da15c[webSessionsFixedLengthPolicy.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("undefined");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("defined", jsonGenerator);
            DurationLogInfo.Serializer.INSTANCE.serialize(webSessionsFixedLengthPolicy.definedValue, jsonGenerator, true);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WebSessionsFixedLengthPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicyDefined;
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
            if ("defined".equals(tag)) {
                webSessionsFixedLengthPolicyDefined = WebSessionsFixedLengthPolicy.defined(DurationLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("undefined".equals(tag)) {
                webSessionsFixedLengthPolicyDefined = WebSessionsFixedLengthPolicy.UNDEFINED;
            } else {
                webSessionsFixedLengthPolicyDefined = WebSessionsFixedLengthPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return webSessionsFixedLengthPolicyDefined;
        }
    }
}
