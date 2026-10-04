package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AccessLevel;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentDownloadDetails {

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    @Nonnull
    protected final String sharedContentLink;

    @Nullable
    protected final UserLogInfo sharedContentOwner;

    public SharedContentDownloadDetails(@Nonnull String str, @Nonnull AccessLevel accessLevel, @Nullable UserLogInfo userLogInfo) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentLink' is null");
        }
        this.sharedContentLink = str;
        this.sharedContentOwner = userLogInfo;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
    }

    public SharedContentDownloadDetails(@Nonnull String str, @Nonnull AccessLevel accessLevel) {
        this(str, accessLevel, null);
    }

    @Nonnull
    public String getSharedContentLink() {
        return this.sharedContentLink;
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    @Nullable
    public UserLogInfo getSharedContentOwner() {
        return this.sharedContentOwner;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentLink, this.sharedContentOwner, this.sharedContentAccessLevel});
    }

    public boolean equals(Object obj) {
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        UserLogInfo userLogInfo;
        UserLogInfo userLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentDownloadDetails sharedContentDownloadDetails = (SharedContentDownloadDetails) obj;
        String str = this.sharedContentLink;
        String str2 = sharedContentDownloadDetails.sharedContentLink;
        return (str == str2 || str.equals(str2)) && ((accessLevel = this.sharedContentAccessLevel) == (accessLevel2 = sharedContentDownloadDetails.sharedContentAccessLevel) || accessLevel.equals(accessLevel2)) && ((userLogInfo = this.sharedContentOwner) == (userLogInfo2 = sharedContentDownloadDetails.sharedContentOwner) || (userLogInfo != null && userLogInfo.equals(userLogInfo2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentDownloadDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentDownloadDetails sharedContentDownloadDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_link");
            StoneSerializers.string().serialize(sharedContentDownloadDetails.sharedContentLink, jsonGenerator);
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentDownloadDetails.sharedContentAccessLevel, jsonGenerator);
            if (sharedContentDownloadDetails.sharedContentOwner != null) {
                jsonGenerator.writeFieldName("shared_content_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(sharedContentDownloadDetails.sharedContentOwner, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentDownloadDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccessLevel accessLevelDeserialize = null;
                UserLogInfo userLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_content_link".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_content_owner".equals(currentName)) {
                        userLogInfo = (UserLogInfo) StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_link\" missing.");
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                SharedContentDownloadDetails sharedContentDownloadDetails = new SharedContentDownloadDetails(strDeserialize, accessLevelDeserialize, userLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentDownloadDetails, sharedContentDownloadDetails.toStringMultiline());
                return sharedContentDownloadDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
