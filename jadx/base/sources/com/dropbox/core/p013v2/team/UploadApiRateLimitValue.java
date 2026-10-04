package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadApiRateLimitValue {
    private Tag _tag;
    private Long limitValue;
    public static final UploadApiRateLimitValue UNLIMITED = new UploadApiRateLimitValue().withTag(Tag.UNLIMITED);
    public static final UploadApiRateLimitValue OTHER = new UploadApiRateLimitValue().withTag(Tag.OTHER);

    public enum Tag {
        UNLIMITED,
        LIMIT,
        OTHER
    }

    private UploadApiRateLimitValue() {
    }

    private UploadApiRateLimitValue withTag(Tag tag) {
        UploadApiRateLimitValue uploadApiRateLimitValue = new UploadApiRateLimitValue();
        uploadApiRateLimitValue._tag = tag;
        return uploadApiRateLimitValue;
    }

    private UploadApiRateLimitValue withTagAndLimit(Tag tag, Long l) {
        UploadApiRateLimitValue uploadApiRateLimitValue = new UploadApiRateLimitValue();
        uploadApiRateLimitValue._tag = tag;
        uploadApiRateLimitValue.limitValue = l;
        return uploadApiRateLimitValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUnlimited() {
        return this._tag == Tag.UNLIMITED;
    }

    public boolean isLimit() {
        return this._tag == Tag.LIMIT;
    }

    public static UploadApiRateLimitValue limit(long j) {
        return new UploadApiRateLimitValue().withTagAndLimit(Tag.LIMIT, Long.valueOf(j));
    }

    public long getLimitValue() {
        if (this._tag != Tag.LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.LIMIT, but was Tag." + this._tag.name());
        }
        return this.limitValue.longValue();
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.limitValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadApiRateLimitValue)) {
            return false;
        }
        UploadApiRateLimitValue uploadApiRateLimitValue = (UploadApiRateLimitValue) obj;
        if (this._tag != uploadApiRateLimitValue._tag) {
            return false;
        }
        int i = C44201.$SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i != 2 ? i == 3 : this.limitValue == uploadApiRateLimitValue.limitValue;
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.UploadApiRateLimitValue$1 */
    static /* synthetic */ class C44201 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag = iArr;
            try {
                iArr[Tag.UNLIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag[Tag.LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UploadApiRateLimitValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadApiRateLimitValue uploadApiRateLimitValue, JsonGenerator jsonGenerator) throws IOException {
            int i = C44201.$SwitchMap$com$dropbox$core$v2$team$UploadApiRateLimitValue$Tag[uploadApiRateLimitValue.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("unlimited");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("limit", jsonGenerator);
                jsonGenerator.writeFieldName("limit");
                StoneSerializers.uInt32().serialize(uploadApiRateLimitValue.limitValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadApiRateLimitValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadApiRateLimitValue uploadApiRateLimitValueLimit;
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
            if ("unlimited".equals(tag)) {
                uploadApiRateLimitValueLimit = UploadApiRateLimitValue.UNLIMITED;
            } else if ("limit".equals(tag)) {
                expectField("limit", jsonParser);
                uploadApiRateLimitValueLimit = UploadApiRateLimitValue.limit(StoneSerializers.uInt32().deserialize(jsonParser).longValue());
            } else {
                uploadApiRateLimitValueLimit = UploadApiRateLimitValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadApiRateLimitValueLimit;
        }
    }
}
