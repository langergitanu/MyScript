package com.dropbox.core.p013v2.paper;

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

/* JADX INFO: loaded from: classes4.dex */
class PaperFolderCreateArg {

    @Nullable
    protected final Boolean isTeamFolder;

    @Nonnull
    protected final String name;

    @Nullable
    protected final String parentFolderId;

    public PaperFolderCreateArg(@Nonnull String str, @Nullable String str2, @Nullable Boolean bool) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        this.parentFolderId = str2;
        this.isTeamFolder = bool;
    }

    public PaperFolderCreateArg(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getParentFolderId() {
        return this.parentFolderId;
    }

    @Nullable
    public Boolean getIsTeamFolder() {
        return this.isTeamFolder;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected Boolean isTeamFolder;
        protected final String name;
        protected String parentFolderId;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str;
            this.parentFolderId = null;
            this.isTeamFolder = null;
        }

        public Builder withParentFolderId(String str) {
            this.parentFolderId = str;
            return this;
        }

        public Builder withIsTeamFolder(Boolean bool) {
            this.isTeamFolder = bool;
            return this;
        }

        public PaperFolderCreateArg build() {
            return new PaperFolderCreateArg(this.name, this.parentFolderId, this.isTeamFolder);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.parentFolderId, this.isTeamFolder});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperFolderCreateArg paperFolderCreateArg = (PaperFolderCreateArg) obj;
        String str3 = this.name;
        String str4 = paperFolderCreateArg.name;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.parentFolderId) == (str2 = paperFolderCreateArg.parentFolderId) || (str != null && str.equals(str2))) && ((bool = this.isTeamFolder) == (bool2 = paperFolderCreateArg.isTeamFolder) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperFolderCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperFolderCreateArg paperFolderCreateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(paperFolderCreateArg.name, jsonGenerator);
            if (paperFolderCreateArg.parentFolderId != null) {
                jsonGenerator.writeFieldName("parent_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperFolderCreateArg.parentFolderId, jsonGenerator);
            }
            if (paperFolderCreateArg.isTeamFolder != null) {
                jsonGenerator.writeFieldName("is_team_folder");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(paperFolderCreateArg.isTeamFolder, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperFolderCreateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("parent_folder_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_team_folder".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                PaperFolderCreateArg paperFolderCreateArg = new PaperFolderCreateArg(strDeserialize, str, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperFolderCreateArg, paperFolderCreateArg.toStringMultiline());
                return paperFolderCreateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
