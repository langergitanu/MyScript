package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberSpaceLimitsChangePolicyDetails {

    @Nullable
    protected final Long newValue;

    @Nullable
    protected final Long previousValue;

    public MemberSpaceLimitsChangePolicyDetails(@Nullable Long l, @Nullable Long l2) {
        this.previousValue = l;
        this.newValue = l2;
    }

    public MemberSpaceLimitsChangePolicyDetails() {
        this(null, null);
    }

    @Nullable
    public Long getPreviousValue() {
        return this.previousValue;
    }

    @Nullable
    public Long getNewValue() {
        return this.newValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Long previousValue = null;
        protected Long newValue = null;

        protected Builder() {
        }

        public Builder withPreviousValue(Long l) {
            this.previousValue = l;
            return this;
        }

        public Builder withNewValue(Long l) {
            this.newValue = l;
            return this;
        }

        public MemberSpaceLimitsChangePolicyDetails build() {
            return new MemberSpaceLimitsChangePolicyDetails(this.previousValue, this.newValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberSpaceLimitsChangePolicyDetails memberSpaceLimitsChangePolicyDetails = (MemberSpaceLimitsChangePolicyDetails) obj;
        Long l3 = this.previousValue;
        Long l4 = memberSpaceLimitsChangePolicyDetails.previousValue;
        return (l3 == l4 || (l3 != null && l3.equals(l4))) && ((l = this.newValue) == (l2 = memberSpaceLimitsChangePolicyDetails.newValue) || (l != null && l.equals(l2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberSpaceLimitsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberSpaceLimitsChangePolicyDetails memberSpaceLimitsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (memberSpaceLimitsChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(memberSpaceLimitsChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (memberSpaceLimitsChangePolicyDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(memberSpaceLimitsChangePolicyDetails.newValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberSpaceLimitsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long l = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long l2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        l2 = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                MemberSpaceLimitsChangePolicyDetails memberSpaceLimitsChangePolicyDetails = new MemberSpaceLimitsChangePolicyDetails(l, l2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberSpaceLimitsChangePolicyDetails, memberSpaceLimitsChangePolicyDetails.toStringMultiline());
                return memberSpaceLimitsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
