package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.UserNameLogInfo;
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
public class MemberAddNameDetails {

    @Nonnull
    protected final UserNameLogInfo newValue;

    public MemberAddNameDetails(@Nonnull UserNameLogInfo userNameLogInfo) {
        if (userNameLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = userNameLogInfo;
    }

    @Nonnull
    public UserNameLogInfo getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserNameLogInfo userNameLogInfo = this.newValue;
        UserNameLogInfo userNameLogInfo2 = ((MemberAddNameDetails) obj).newValue;
        return userNameLogInfo == userNameLogInfo2 || userNameLogInfo.equals(userNameLogInfo2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberAddNameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAddNameDetails memberAddNameDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            UserNameLogInfo.Serializer.INSTANCE.serialize(memberAddNameDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAddNameDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserNameLogInfo userNameLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        userNameLogInfoDeserialize = UserNameLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userNameLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberAddNameDetails memberAddNameDetails = new MemberAddNameDetails(userNameLogInfoDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAddNameDetails, memberAddNameDetails.toStringMultiline());
                return memberAddNameDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
