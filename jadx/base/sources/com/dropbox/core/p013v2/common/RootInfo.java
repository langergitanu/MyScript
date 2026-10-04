package com.dropbox.core.p013v2.common;

import com.dropbox.core.p013v2.common.TeamRootInfo;
import com.dropbox.core.p013v2.common.UserRootInfo;
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
public class RootInfo {

    @Nonnull
    protected final String homeNamespaceId;

    @Nonnull
    protected final String rootNamespaceId;

    public RootInfo(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'rootNamespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'rootNamespaceId' does not match pattern");
        }
        this.rootNamespaceId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'homeNamespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str2)) {
            throw new IllegalArgumentException("String 'homeNamespaceId' does not match pattern");
        }
        this.homeNamespaceId = str2;
    }

    @Nonnull
    public String getRootNamespaceId() {
        return this.rootNamespaceId;
    }

    @Nonnull
    public String getHomeNamespaceId() {
        return this.homeNamespaceId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.rootNamespaceId, this.homeNamespaceId});
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
        RootInfo rootInfo = (RootInfo) obj;
        String str3 = this.rootNamespaceId;
        String str4 = rootInfo.rootNamespaceId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.homeNamespaceId) == (str2 = rootInfo.homeNamespaceId) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<RootInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RootInfo rootInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (rootInfo instanceof TeamRootInfo) {
                TeamRootInfo.Serializer.INSTANCE.serialize((TeamRootInfo) rootInfo, jsonGenerator, z);
                return;
            }
            if (rootInfo instanceof UserRootInfo) {
                UserRootInfo.Serializer.INSTANCE.serialize((UserRootInfo) rootInfo, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("root_namespace_id");
            StoneSerializers.string().serialize(rootInfo.rootNamespaceId, jsonGenerator);
            jsonGenerator.writeFieldName("home_namespace_id");
            StoneSerializers.string().serialize(rootInfo.homeNamespaceId, jsonGenerator);
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
        public RootInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            RootInfo rootInfoDeserialize;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
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
                rootInfoDeserialize = new RootInfo(strDeserialize, strDeserialize2);
            } else if ("".equals(tag)) {
                rootInfoDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("team".equals(tag)) {
                rootInfoDeserialize = TeamRootInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("user".equals(tag)) {
                rootInfoDeserialize = UserRootInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(rootInfoDeserialize, rootInfoDeserialize.toStringMultiline());
            return rootInfoDeserialize;
        }
    }
}
