package com.dropbox.core.p013v2.common;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class UserRootInfo extends RootInfo {
    public UserRootInfo(@Nonnull String str, @Nonnull String str2) {
        super(str, str2);
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    @Nonnull
    public String getRootNamespaceId() {
        return this.rootNamespaceId;
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    @Nonnull
    public String getHomeNamespaceId() {
        return this.homeNamespaceId;
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserRootInfo userRootInfo = (UserRootInfo) obj;
        return (this.rootNamespaceId == userRootInfo.rootNamespaceId || this.rootNamespaceId.equals(userRootInfo.rootNamespaceId)) && (this.homeNamespaceId == userRootInfo.homeNamespaceId || this.homeNamespaceId.equals(userRootInfo.homeNamespaceId));
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserRootInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserRootInfo userRootInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("user", jsonGenerator);
            jsonGenerator.writeFieldName("root_namespace_id");
            StoneSerializers.string().serialize(userRootInfo.rootNamespaceId, jsonGenerator);
            jsonGenerator.writeFieldName("home_namespace_id");
            StoneSerializers.string().serialize(userRootInfo.homeNamespaceId, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UserRootInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("user".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("root_namespace_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("home_namespace_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"root_namespace_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"home_namespace_id\" missing.");
                }
                UserRootInfo userRootInfo = new UserRootInfo(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userRootInfo, userRootInfo.toStringMultiline());
                return userRootInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
