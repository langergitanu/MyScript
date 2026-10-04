package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SpaceLimitsStatus;
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
public class MemberSpaceLimitsChangeStatusDetails {

    @Nonnull
    protected final SpaceLimitsStatus newValue;

    @Nonnull
    protected final SpaceLimitsStatus previousValue;

    public MemberSpaceLimitsChangeStatusDetails(@Nonnull SpaceLimitsStatus spaceLimitsStatus, @Nonnull SpaceLimitsStatus spaceLimitsStatus2) {
        if (spaceLimitsStatus == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = spaceLimitsStatus;
        if (spaceLimitsStatus2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = spaceLimitsStatus2;
    }

    @Nonnull
    public SpaceLimitsStatus getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SpaceLimitsStatus getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        SpaceLimitsStatus spaceLimitsStatus;
        SpaceLimitsStatus spaceLimitsStatus2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberSpaceLimitsChangeStatusDetails memberSpaceLimitsChangeStatusDetails = (MemberSpaceLimitsChangeStatusDetails) obj;
        SpaceLimitsStatus spaceLimitsStatus3 = this.previousValue;
        SpaceLimitsStatus spaceLimitsStatus4 = memberSpaceLimitsChangeStatusDetails.previousValue;
        return (spaceLimitsStatus3 == spaceLimitsStatus4 || spaceLimitsStatus3.equals(spaceLimitsStatus4)) && ((spaceLimitsStatus = this.newValue) == (spaceLimitsStatus2 = memberSpaceLimitsChangeStatusDetails.newValue) || spaceLimitsStatus.equals(spaceLimitsStatus2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberSpaceLimitsChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberSpaceLimitsChangeStatusDetails memberSpaceLimitsChangeStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SpaceLimitsStatus.Serializer.INSTANCE.serialize(memberSpaceLimitsChangeStatusDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SpaceLimitsStatus.Serializer.INSTANCE.serialize(memberSpaceLimitsChangeStatusDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberSpaceLimitsChangeStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SpaceLimitsStatus spaceLimitsStatusDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SpaceLimitsStatus spaceLimitsStatusDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        spaceLimitsStatusDeserialize = SpaceLimitsStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        spaceLimitsStatusDeserialize2 = SpaceLimitsStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (spaceLimitsStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (spaceLimitsStatusDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberSpaceLimitsChangeStatusDetails memberSpaceLimitsChangeStatusDetails = new MemberSpaceLimitsChangeStatusDetails(spaceLimitsStatusDeserialize, spaceLimitsStatusDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberSpaceLimitsChangeStatusDetails, memberSpaceLimitsChangeStatusDetails.toStringMultiline());
                return memberSpaceLimitsChangeStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
