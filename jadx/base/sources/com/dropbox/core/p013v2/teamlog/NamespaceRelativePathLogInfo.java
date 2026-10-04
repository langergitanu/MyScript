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
public class NamespaceRelativePathLogInfo {

    @Nullable
    protected final Boolean isSharedNamespace;

    @Nullable
    protected final String nsId;

    @Nullable
    protected final String relativePath;

    public NamespaceRelativePathLogInfo(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        this.nsId = str;
        this.relativePath = str2;
        this.isSharedNamespace = bool;
    }

    public NamespaceRelativePathLogInfo() {
        this(null, null, null);
    }

    @Nullable
    public String getNsId() {
        return this.nsId;
    }

    @Nullable
    public String getRelativePath() {
        return this.relativePath;
    }

    @Nullable
    public Boolean getIsSharedNamespace() {
        return this.isSharedNamespace;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String nsId = null;
        protected String relativePath = null;
        protected Boolean isSharedNamespace = null;

        protected Builder() {
        }

        public Builder withNsId(String str) {
            this.nsId = str;
            return this;
        }

        public Builder withRelativePath(String str) {
            this.relativePath = str;
            return this;
        }

        public Builder withIsSharedNamespace(Boolean bool) {
            this.isSharedNamespace = bool;
            return this;
        }

        public NamespaceRelativePathLogInfo build() {
            return new NamespaceRelativePathLogInfo(this.nsId, this.relativePath, this.isSharedNamespace);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.nsId, this.relativePath, this.isSharedNamespace});
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
        NamespaceRelativePathLogInfo namespaceRelativePathLogInfo = (NamespaceRelativePathLogInfo) obj;
        String str3 = this.nsId;
        String str4 = namespaceRelativePathLogInfo.nsId;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.relativePath) == (str2 = namespaceRelativePathLogInfo.relativePath) || (str != null && str.equals(str2))) && ((bool = this.isSharedNamespace) == (bool2 = namespaceRelativePathLogInfo.isSharedNamespace) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<NamespaceRelativePathLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(NamespaceRelativePathLogInfo namespaceRelativePathLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (namespaceRelativePathLogInfo.nsId != null) {
                jsonGenerator.writeFieldName("ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(namespaceRelativePathLogInfo.nsId, jsonGenerator);
            }
            if (namespaceRelativePathLogInfo.relativePath != null) {
                jsonGenerator.writeFieldName("relative_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(namespaceRelativePathLogInfo.relativePath, jsonGenerator);
            }
            if (namespaceRelativePathLogInfo.isSharedNamespace != null) {
                jsonGenerator.writeFieldName("is_shared_namespace");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(namespaceRelativePathLogInfo.isSharedNamespace, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public NamespaceRelativePathLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("ns_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("relative_path".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_shared_namespace".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                NamespaceRelativePathLogInfo namespaceRelativePathLogInfo = new NamespaceRelativePathLogInfo(str, str2, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(namespaceRelativePathLogInfo, namespaceRelativePathLogInfo.toStringMultiline());
                return namespaceRelativePathLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
