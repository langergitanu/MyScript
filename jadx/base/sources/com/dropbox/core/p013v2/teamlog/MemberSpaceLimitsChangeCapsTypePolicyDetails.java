package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SpaceCapsType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class MemberSpaceLimitsChangeCapsTypePolicyDetails {

    @Nonnull
    protected final SpaceCapsType newValue;

    @Nonnull
    protected final SpaceCapsType previousValue;

    public MemberSpaceLimitsChangeCapsTypePolicyDetails(@Nonnull SpaceCapsType spaceCapsType, @Nonnull SpaceCapsType spaceCapsType2) {
        if (spaceCapsType == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = spaceCapsType;
        if (spaceCapsType2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = spaceCapsType2;
    }

    @Nonnull
    public SpaceCapsType getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SpaceCapsType getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        SpaceCapsType spaceCapsType;
        SpaceCapsType spaceCapsType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberSpaceLimitsChangeCapsTypePolicyDetails memberSpaceLimitsChangeCapsTypePolicyDetails = (MemberSpaceLimitsChangeCapsTypePolicyDetails) obj;
        SpaceCapsType spaceCapsType3 = this.previousValue;
        SpaceCapsType spaceCapsType4 = memberSpaceLimitsChangeCapsTypePolicyDetails.previousValue;
        return (spaceCapsType3 == spaceCapsType4 || spaceCapsType3.equals(spaceCapsType4)) && ((spaceCapsType = this.newValue) == (spaceCapsType2 = memberSpaceLimitsChangeCapsTypePolicyDetails.newValue) || spaceCapsType.equals(spaceCapsType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberSpaceLimitsChangeCapsTypePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberSpaceLimitsChangeCapsTypePolicyDetails memberSpaceLimitsChangeCapsTypePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SpaceCapsType.Serializer.INSTANCE.serialize(memberSpaceLimitsChangeCapsTypePolicyDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SpaceCapsType.Serializer.INSTANCE.serialize(memberSpaceLimitsChangeCapsTypePolicyDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberSpaceLimitsChangeCapsTypePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SpaceCapsType spaceCapsTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SpaceCapsType spaceCapsTypeDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        spaceCapsTypeDeserialize = SpaceCapsType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        spaceCapsTypeDeserialize2 = SpaceCapsType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (spaceCapsTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (spaceCapsTypeDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberSpaceLimitsChangeCapsTypePolicyDetails memberSpaceLimitsChangeCapsTypePolicyDetails = new MemberSpaceLimitsChangeCapsTypePolicyDetails(spaceCapsTypeDeserialize, spaceCapsTypeDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberSpaceLimitsChangeCapsTypePolicyDetails, memberSpaceLimitsChangeCapsTypePolicyDetails.toStringMultiline());
                return memberSpaceLimitsChangeCapsTypePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
