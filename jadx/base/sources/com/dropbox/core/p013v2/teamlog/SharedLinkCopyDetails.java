package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.UserLogInfo;
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
public class SharedLinkCopyDetails {

    @Nullable
    protected final UserLogInfo sharedLinkOwner;

    public SharedLinkCopyDetails(@Nullable UserLogInfo userLogInfo) {
        this.sharedLinkOwner = userLogInfo;
    }

    public SharedLinkCopyDetails() {
        this(null);
    }

    @Nullable
    public UserLogInfo getSharedLinkOwner() {
        return this.sharedLinkOwner;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedLinkOwner});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserLogInfo userLogInfo = this.sharedLinkOwner;
        UserLogInfo userLogInfo2 = ((SharedLinkCopyDetails) obj).sharedLinkOwner;
        return userLogInfo == userLogInfo2 || (userLogInfo != null && userLogInfo.equals(userLogInfo2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkCopyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkCopyDetails sharedLinkCopyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedLinkCopyDetails.sharedLinkOwner != null) {
                jsonGenerator.writeFieldName("shared_link_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(sharedLinkCopyDetails.sharedLinkOwner, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkCopyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserLogInfo userLogInfo = null;
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
                    if ("shared_link_owner".equals(currentName)) {
                        userLogInfo = (UserLogInfo) StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedLinkCopyDetails sharedLinkCopyDetails = new SharedLinkCopyDetails(userLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkCopyDetails, sharedLinkCopyDetails.toStringMultiline());
                return sharedLinkCopyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
