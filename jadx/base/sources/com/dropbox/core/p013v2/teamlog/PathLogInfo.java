package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.NamespaceRelativePathLogInfo;
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
public class PathLogInfo {

    @Nullable
    protected final String contextual;

    @Nonnull
    protected final NamespaceRelativePathLogInfo namespaceRelative;

    public PathLogInfo(@Nonnull NamespaceRelativePathLogInfo namespaceRelativePathLogInfo, @Nullable String str) {
        this.contextual = str;
        if (namespaceRelativePathLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'namespaceRelative' is null");
        }
        this.namespaceRelative = namespaceRelativePathLogInfo;
    }

    public PathLogInfo(@Nonnull NamespaceRelativePathLogInfo namespaceRelativePathLogInfo) {
        this(namespaceRelativePathLogInfo, null);
    }

    @Nonnull
    public NamespaceRelativePathLogInfo getNamespaceRelative() {
        return this.namespaceRelative;
    }

    @Nullable
    public String getContextual() {
        return this.contextual;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.contextual, this.namespaceRelative});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PathLogInfo pathLogInfo = (PathLogInfo) obj;
        NamespaceRelativePathLogInfo namespaceRelativePathLogInfo = this.namespaceRelative;
        NamespaceRelativePathLogInfo namespaceRelativePathLogInfo2 = pathLogInfo.namespaceRelative;
        return (namespaceRelativePathLogInfo == namespaceRelativePathLogInfo2 || namespaceRelativePathLogInfo.equals(namespaceRelativePathLogInfo2)) && ((str = this.contextual) == (str2 = pathLogInfo.contextual) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PathLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PathLogInfo pathLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("namespace_relative");
            NamespaceRelativePathLogInfo.Serializer.INSTANCE.serialize(pathLogInfo.namespaceRelative, jsonGenerator);
            if (pathLogInfo.contextual != null) {
                jsonGenerator.writeFieldName("contextual");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(pathLogInfo.contextual, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PathLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            NamespaceRelativePathLogInfo namespaceRelativePathLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("namespace_relative".equals(currentName)) {
                        namespaceRelativePathLogInfoDeserialize = NamespaceRelativePathLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("contextual".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (namespaceRelativePathLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"namespace_relative\" missing.");
                }
                PathLogInfo pathLogInfo = new PathLogInfo(namespaceRelativePathLogInfoDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(pathLogInfo, pathLogInfo.toStringMultiline());
                return pathLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
