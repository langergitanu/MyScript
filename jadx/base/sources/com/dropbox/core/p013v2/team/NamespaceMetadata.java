package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.NamespaceType;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class NamespaceMetadata {

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String namespaceId;

    @Nonnull
    protected final NamespaceType namespaceType;

    @Nullable
    protected final String teamMemberId;

    public NamespaceMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull NamespaceType namespaceType, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'namespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str2)) {
            throw new IllegalArgumentException("String 'namespaceId' does not match pattern");
        }
        this.namespaceId = str2;
        if (namespaceType == null) {
            throw new IllegalArgumentException("Required value for 'namespaceType' is null");
        }
        this.namespaceType = namespaceType;
        this.teamMemberId = str3;
    }

    public NamespaceMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull NamespaceType namespaceType) {
        this(str, str2, namespaceType, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getNamespaceId() {
        return this.namespaceId;
    }

    @Nonnull
    public NamespaceType getNamespaceType() {
        return this.namespaceType;
    }

    @Nullable
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.namespaceId, this.namespaceType, this.teamMemberId});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        NamespaceType namespaceType;
        NamespaceType namespaceType2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        NamespaceMetadata namespaceMetadata = (NamespaceMetadata) obj;
        String str5 = this.name;
        String str6 = namespaceMetadata.name;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.namespaceId) == (str2 = namespaceMetadata.namespaceId) || str.equals(str2)) && (((namespaceType = this.namespaceType) == (namespaceType2 = namespaceMetadata.namespaceType) || namespaceType.equals(namespaceType2)) && ((str3 = this.teamMemberId) == (str4 = namespaceMetadata.teamMemberId) || (str3 != null && str3.equals(str4))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<NamespaceMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(NamespaceMetadata namespaceMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(namespaceMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("namespace_id");
            StoneSerializers.string().serialize(namespaceMetadata.namespaceId, jsonGenerator);
            jsonGenerator.writeFieldName("namespace_type");
            NamespaceType.Serializer.INSTANCE.serialize(namespaceMetadata.namespaceType, jsonGenerator);
            if (namespaceMetadata.teamMemberId != null) {
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(namespaceMetadata.teamMemberId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public NamespaceMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                NamespaceType namespaceTypeDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("namespace_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("namespace_type".equals(currentName)) {
                        namespaceTypeDeserialize = NamespaceType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"namespace_id\" missing.");
                }
                if (namespaceTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"namespace_type\" missing.");
                }
                NamespaceMetadata namespaceMetadata = new NamespaceMetadata(strDeserialize, strDeserialize2, namespaceTypeDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(namespaceMetadata, namespaceMetadata.toStringMultiline());
                return namespaceMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
