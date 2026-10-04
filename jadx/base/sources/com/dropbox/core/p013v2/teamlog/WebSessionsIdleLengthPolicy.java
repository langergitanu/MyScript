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
public final class WebSessionsIdleLengthPolicy {
    private Tag _tag;
    private DurationLogInfo definedValue;
    public static final WebSessionsIdleLengthPolicy UNDEFINED = new WebSessionsIdleLengthPolicy().withTag(Tag.UNDEFINED);
    public static final WebSessionsIdleLengthPolicy OTHER = new WebSessionsIdleLengthPolicy().withTag(Tag.OTHER);

    public enum Tag {
        DEFINED,
        UNDEFINED,
        OTHER
    }

    private WebSessionsIdleLengthPolicy() {
    }

    private WebSessionsIdleLengthPolicy withTag(Tag tag) {
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy = new WebSessionsIdleLengthPolicy();
        webSessionsIdleLengthPolicy._tag = tag;
        return webSessionsIdleLengthPolicy;
    }

    private WebSessionsIdleLengthPolicy withTagAndDefined(Tag tag, DurationLogInfo durationLogInfo) {
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy = new WebSessionsIdleLengthPolicy();
        webSessionsIdleLengthPolicy._tag = tag;
        webSessionsIdleLengthPolicy.definedValue = durationLogInfo;
        return webSessionsIdleLengthPolicy;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isDefined() {
        return this._tag == Tag.DEFINED;
    }

    public static WebSessionsIdleLengthPolicy defined(DurationLogInfo durationLogInfo) {
        if (durationLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WebSessionsIdleLengthPolicy().withTagAndDefined(Tag.DEFINED, durationLogInfo);
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
        if (obj == null || !(obj instanceof WebSessionsIdleLengthPolicy)) {
            return false;
        }
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy = (WebSessionsIdleLengthPolicy) obj;
        if (this._tag != webSessionsIdleLengthPolicy._tag) {
            return false;
        }
        int i = C45421.f804x59631008[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        DurationLogInfo durationLogInfo = this.definedValue;
        DurationLogInfo durationLogInfo2 = webSessionsIdleLengthPolicy.definedValue;
        return durationLogInfo == durationLogInfo2 || durationLogInfo.equals(durationLogInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.WebSessionsIdleLengthPolicy$1 */
    static /* synthetic */ class C45421 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$WebSessionsIdleLengthPolicy$Tag */
        static final /* synthetic */ int[] f804x59631008;

        static {
            int[] iArr = new int[Tag.values().length];
            f804x59631008 = iArr;
            try {
                iArr[Tag.DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f804x59631008[Tag.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f804x59631008[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<WebSessionsIdleLengthPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.mergeExceptions(MethodThrowsVisitor.java:100)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:86)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45421.f804x59631008[webSessionsIdleLengthPolicy.tag().ordinal()];
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
            DurationLogInfo.Serializer.INSTANCE.serialize(webSessionsIdleLengthPolicy.definedValue, jsonGenerator, true);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WebSessionsIdleLengthPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicyDefined;
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
                webSessionsIdleLengthPolicyDefined = WebSessionsIdleLengthPolicy.defined(DurationLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("undefined".equals(tag)) {
                webSessionsIdleLengthPolicyDefined = WebSessionsIdleLengthPolicy.UNDEFINED;
            } else {
                webSessionsIdleLengthPolicyDefined = WebSessionsIdleLengthPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return webSessionsIdleLengthPolicyDefined;
        }
    }
}
