package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.UserNameLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberChangeNameDetails {

    @Nonnull
    protected final UserNameLogInfo newValue;

    @Nullable
    protected final UserNameLogInfo previousValue;

    public MemberChangeNameDetails(@Nonnull UserNameLogInfo userNameLogInfo, @Nullable UserNameLogInfo userNameLogInfo2) {
        if (userNameLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = userNameLogInfo;
        this.previousValue = userNameLogInfo2;
    }

    public MemberChangeNameDetails(@Nonnull UserNameLogInfo userNameLogInfo) {
        this(userNameLogInfo, null);
    }

    @Nonnull
    public UserNameLogInfo getNewValue() {
        return this.newValue;
    }

    @Nullable
    public UserNameLogInfo getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        UserNameLogInfo userNameLogInfo;
        UserNameLogInfo userNameLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberChangeNameDetails memberChangeNameDetails = (MemberChangeNameDetails) obj;
        UserNameLogInfo userNameLogInfo3 = this.newValue;
        UserNameLogInfo userNameLogInfo4 = memberChangeNameDetails.newValue;
        return (userNameLogInfo3 == userNameLogInfo4 || userNameLogInfo3.equals(userNameLogInfo4)) && ((userNameLogInfo = this.previousValue) == (userNameLogInfo2 = memberChangeNameDetails.previousValue) || (userNameLogInfo != null && userNameLogInfo.equals(userNameLogInfo2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberChangeNameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberChangeNameDetails memberChangeNameDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            UserNameLogInfo.Serializer.INSTANCE.serialize(memberChangeNameDetails.newValue, jsonGenerator);
            if (memberChangeNameDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullableStruct(UserNameLogInfo.Serializer.INSTANCE).serialize(memberChangeNameDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberChangeNameDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserNameLogInfo userNameLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                UserNameLogInfo userNameLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        userNameLogInfoDeserialize = UserNameLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        userNameLogInfo = (UserNameLogInfo) StoneSerializers.nullableStruct(UserNameLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userNameLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberChangeNameDetails memberChangeNameDetails = new MemberChangeNameDetails(userNameLogInfoDeserialize, userNameLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberChangeNameDetails, memberChangeNameDetails.toStringMultiline());
                return memberChangeNameDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
