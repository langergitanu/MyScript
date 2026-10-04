package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class AudienceRestrictingSharedFolder {

    @Nonnull
    protected final LinkAudience audience;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String sharedFolderId;

    public AudienceRestrictingSharedFolder(@Nonnull String str, @Nonnull String str2, @Nonnull LinkAudience linkAudience) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (linkAudience == null) {
            throw new IllegalArgumentException("Required value for 'audience' is null");
        }
        this.audience = linkAudience;
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public LinkAudience getAudience() {
        return this.audience;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderId, this.name, this.audience});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AudienceRestrictingSharedFolder audienceRestrictingSharedFolder = (AudienceRestrictingSharedFolder) obj;
        String str3 = this.sharedFolderId;
        String str4 = audienceRestrictingSharedFolder.sharedFolderId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = audienceRestrictingSharedFolder.name) || str.equals(str2)) && ((linkAudience = this.audience) == (linkAudience2 = audienceRestrictingSharedFolder.audience) || linkAudience.equals(linkAudience2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AudienceRestrictingSharedFolder> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AudienceRestrictingSharedFolder audienceRestrictingSharedFolder, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(audienceRestrictingSharedFolder.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(audienceRestrictingSharedFolder.name, jsonGenerator);
            jsonGenerator.writeFieldName("audience");
            LinkAudience.Serializer.INSTANCE.serialize(audienceRestrictingSharedFolder.audience, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AudienceRestrictingSharedFolder deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                LinkAudience linkAudienceDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("audience".equals(currentName)) {
                        linkAudienceDeserialize = LinkAudience.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (linkAudienceDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"audience\" missing.");
                }
                AudienceRestrictingSharedFolder audienceRestrictingSharedFolder = new AudienceRestrictingSharedFolder(strDeserialize, strDeserialize2, linkAudienceDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(audienceRestrictingSharedFolder, audienceRestrictingSharedFolder.toStringMultiline());
                return audienceRestrictingSharedFolder;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
