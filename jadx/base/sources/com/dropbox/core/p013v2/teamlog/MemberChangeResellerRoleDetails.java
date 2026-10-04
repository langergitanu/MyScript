package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ResellerRole;
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
public class MemberChangeResellerRoleDetails {

    @Nonnull
    protected final ResellerRole newValue;

    @Nonnull
    protected final ResellerRole previousValue;

    public MemberChangeResellerRoleDetails(@Nonnull ResellerRole resellerRole, @Nonnull ResellerRole resellerRole2) {
        if (resellerRole == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = resellerRole;
        if (resellerRole2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = resellerRole2;
    }

    @Nonnull
    public ResellerRole getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ResellerRole getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ResellerRole resellerRole;
        ResellerRole resellerRole2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberChangeResellerRoleDetails memberChangeResellerRoleDetails = (MemberChangeResellerRoleDetails) obj;
        ResellerRole resellerRole3 = this.newValue;
        ResellerRole resellerRole4 = memberChangeResellerRoleDetails.newValue;
        return (resellerRole3 == resellerRole4 || resellerRole3.equals(resellerRole4)) && ((resellerRole = this.previousValue) == (resellerRole2 = memberChangeResellerRoleDetails.previousValue) || resellerRole.equals(resellerRole2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberChangeResellerRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberChangeResellerRoleDetails memberChangeResellerRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ResellerRole.Serializer.INSTANCE.serialize(memberChangeResellerRoleDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ResellerRole.Serializer.INSTANCE.serialize(memberChangeResellerRoleDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberChangeResellerRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ResellerRole resellerRoleDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ResellerRole resellerRoleDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        resellerRoleDeserialize = ResellerRole.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        resellerRoleDeserialize2 = ResellerRole.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (resellerRoleDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (resellerRoleDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                MemberChangeResellerRoleDetails memberChangeResellerRoleDetails = new MemberChangeResellerRoleDetails(resellerRoleDeserialize, resellerRoleDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberChangeResellerRoleDetails, memberChangeResellerRoleDetails.toStringMultiline());
                return memberChangeResellerRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
