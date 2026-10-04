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
public class SharedContentCopyDetails {

    @Nonnull
    protected final String destinationPath;

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    @Nonnull
    protected final String sharedContentLink;

    @Nullable
    protected final UserLogInfo sharedContentOwner;

    public SharedContentCopyDetails(@Nonnull String str, @Nonnull AccessLevel accessLevel, @Nonnull String str2, @Nullable UserLogInfo userLogInfo) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentLink' is null");
        }
        this.sharedContentLink = str;
        this.sharedContentOwner = userLogInfo;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'destinationPath' is null");
        }
        this.destinationPath = str2;
    }

    public SharedContentCopyDetails(@Nonnull String str, @Nonnull AccessLevel accessLevel, @Nonnull String str2) {
        this(str, accessLevel, str2, null);
    }

    @Nonnull
    public String getSharedContentLink() {
        return this.sharedContentLink;
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    @Nonnull
    public String getDestinationPath() {
        return this.destinationPath;
    }

    @Nullable
    public UserLogInfo getSharedContentOwner() {
        return this.sharedContentOwner;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentLink, this.sharedContentOwner, this.sharedContentAccessLevel, this.destinationPath});
    }

    public boolean equals(Object obj) {
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        String str;
        String str2;
        UserLogInfo userLogInfo;
        UserLogInfo userLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentCopyDetails sharedContentCopyDetails = (SharedContentCopyDetails) obj;
        String str3 = this.sharedContentLink;
        String str4 = sharedContentCopyDetails.sharedContentLink;
        return (str3 == str4 || str3.equals(str4)) && ((accessLevel = this.sharedContentAccessLevel) == (accessLevel2 = sharedContentCopyDetails.sharedContentAccessLevel) || accessLevel.equals(accessLevel2)) && (((str = this.destinationPath) == (str2 = sharedContentCopyDetails.destinationPath) || str.equals(str2)) && ((userLogInfo = this.sharedContentOwner) == (userLogInfo2 = sharedContentCopyDetails.sharedContentOwner) || (userLogInfo != null && userLogInfo.equals(userLogInfo2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentCopyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentCopyDetails sharedContentCopyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_link");
            StoneSerializers.string().serialize(sharedContentCopyDetails.sharedContentLink, jsonGenerator);
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentCopyDetails.sharedContentAccessLevel, jsonGenerator);
            jsonGenerator.writeFieldName("destination_path");
            StoneSerializers.string().serialize(sharedContentCopyDetails.destinationPath, jsonGenerator);
            if (sharedContentCopyDetails.sharedContentOwner != null) {
                jsonGenerator.writeFieldName("shared_content_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(sharedContentCopyDetails.sharedContentOwner, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentCopyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize2 = null;
                UserLogInfo userLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_content_link".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("destination_path".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
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
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"destination_path\" missing.");
                }
                SharedContentCopyDetails sharedContentCopyDetails = new SharedContentCopyDetails(strDeserialize, accessLevelDeserialize, strDeserialize2, userLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentCopyDetails, sharedContentCopyDetails.toStringMultiline());
                return sharedContentCopyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
