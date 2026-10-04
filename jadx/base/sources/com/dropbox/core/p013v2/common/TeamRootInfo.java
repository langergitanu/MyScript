package com.dropbox.core.p013v2.common;

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

/* JADX INFO: loaded from: classes4.dex */
public class TeamRootInfo extends RootInfo {

    @Nonnull
    protected final String homePath;

    public TeamRootInfo(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        super(str, str2);
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'homePath' is null");
        }
        this.homePath = str3;
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

    @Nonnull
    public String getHomePath() {
        return this.homePath;
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.homePath});
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamRootInfo teamRootInfo = (TeamRootInfo) obj;
        return (this.rootNamespaceId == teamRootInfo.rootNamespaceId || this.rootNamespaceId.equals(teamRootInfo.rootNamespaceId)) && (this.homeNamespaceId == teamRootInfo.homeNamespaceId || this.homeNamespaceId.equals(teamRootInfo.homeNamespaceId)) && ((str = this.homePath) == (str2 = teamRootInfo.homePath) || str.equals(str2));
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.common.RootInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamRootInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamRootInfo teamRootInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("team", jsonGenerator);
            jsonGenerator.writeFieldName("root_namespace_id");
            StoneSerializers.string().serialize(teamRootInfo.rootNamespaceId, jsonGenerator);
            jsonGenerator.writeFieldName("home_namespace_id");
            StoneSerializers.string().serialize(teamRootInfo.homeNamespaceId, jsonGenerator);
            jsonGenerator.writeFieldName("home_path");
            StoneSerializers.string().serialize(teamRootInfo.homePath, jsonGenerator);
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
        public TeamRootInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("team".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("root_namespace_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("home_namespace_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("home_path".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
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
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"home_path\" missing.");
                }
                TeamRootInfo teamRootInfo = new TeamRootInfo(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamRootInfo, teamRootInfo.toStringMultiline());
                return teamRootInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
