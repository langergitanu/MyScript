package com.dropbox.core.p013v2.teamlog;

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
public class SharedFolderNestDetails {

    @Nullable
    protected final String newNsPath;

    @Nullable
    protected final String newParentNsId;

    @Nullable
    protected final String previousNsPath;

    @Nullable
    protected final String previousParentNsId;

    public SharedFolderNestDetails(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.previousParentNsId = str;
        this.newParentNsId = str2;
        this.previousNsPath = str3;
        this.newNsPath = str4;
    }

    public SharedFolderNestDetails() {
        this(null, null, null, null);
    }

    @Nullable
    public String getPreviousParentNsId() {
        return this.previousParentNsId;
    }

    @Nullable
    public String getNewParentNsId() {
        return this.newParentNsId;
    }

    @Nullable
    public String getPreviousNsPath() {
        return this.previousNsPath;
    }

    @Nullable
    public String getNewNsPath() {
        return this.newNsPath;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String previousParentNsId = null;
        protected String newParentNsId = null;
        protected String previousNsPath = null;
        protected String newNsPath = null;

        protected Builder() {
        }

        public Builder withPreviousParentNsId(String str) {
            this.previousParentNsId = str;
            return this;
        }

        public Builder withNewParentNsId(String str) {
            this.newParentNsId = str;
            return this;
        }

        public Builder withPreviousNsPath(String str) {
            this.previousNsPath = str;
            return this;
        }

        public Builder withNewNsPath(String str) {
            this.newNsPath = str;
            return this;
        }

        public SharedFolderNestDetails build() {
            return new SharedFolderNestDetails(this.previousParentNsId, this.newParentNsId, this.previousNsPath, this.newNsPath);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousParentNsId, this.newParentNsId, this.previousNsPath, this.newNsPath});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFolderNestDetails sharedFolderNestDetails = (SharedFolderNestDetails) obj;
        String str7 = this.previousParentNsId;
        String str8 = sharedFolderNestDetails.previousParentNsId;
        return (str7 == str8 || (str7 != null && str7.equals(str8))) && ((str = this.newParentNsId) == (str2 = sharedFolderNestDetails.newParentNsId) || (str != null && str.equals(str2))) && (((str3 = this.previousNsPath) == (str4 = sharedFolderNestDetails.previousNsPath) || (str3 != null && str3.equals(str4))) && ((str5 = this.newNsPath) == (str6 = sharedFolderNestDetails.newNsPath) || (str5 != null && str5.equals(str6))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderNestDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderNestDetails sharedFolderNestDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedFolderNestDetails.previousParentNsId != null) {
                jsonGenerator.writeFieldName("previous_parent_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderNestDetails.previousParentNsId, jsonGenerator);
            }
            if (sharedFolderNestDetails.newParentNsId != null) {
                jsonGenerator.writeFieldName("new_parent_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderNestDetails.newParentNsId, jsonGenerator);
            }
            if (sharedFolderNestDetails.previousNsPath != null) {
                jsonGenerator.writeFieldName("previous_ns_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderNestDetails.previousNsPath, jsonGenerator);
            }
            if (sharedFolderNestDetails.newNsPath != null) {
                jsonGenerator.writeFieldName("new_ns_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderNestDetails.newNsPath, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderNestDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str2 = null;
                String str3 = null;
                String str4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_parent_ns_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_parent_ns_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_ns_path".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_ns_path".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedFolderNestDetails sharedFolderNestDetails = new SharedFolderNestDetails(str, str2, str3, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderNestDetails, sharedFolderNestDetails.toStringMultiline());
                return sharedFolderNestDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
