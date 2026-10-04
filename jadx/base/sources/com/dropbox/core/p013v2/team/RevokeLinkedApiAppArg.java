package com.dropbox.core.p013v2.team;

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

/* JADX INFO: loaded from: classes5.dex */
public class RevokeLinkedApiAppArg {

    @Nonnull
    protected final String appId;
    protected final boolean keepAppFolder;

    @Nonnull
    protected final String teamMemberId;

    public RevokeLinkedApiAppArg(@Nonnull String str, @Nonnull String str2, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'appId' is null");
        }
        this.appId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str2;
        this.keepAppFolder = z;
    }

    public RevokeLinkedApiAppArg(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, true);
    }

    @Nonnull
    public String getAppId() {
        return this.appId;
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public boolean getKeepAppFolder() {
        return this.keepAppFolder;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.appId, this.teamMemberId, Boolean.valueOf(this.keepAppFolder)});
    }

    public boolean equals(Object obj) {
        RevokeLinkedApiAppArg revokeLinkedApiAppArg;
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.appId) == (str2 = (revokeLinkedApiAppArg = (RevokeLinkedApiAppArg) obj).appId) || str.equals(str2)) && (((str3 = this.teamMemberId) == (str4 = revokeLinkedApiAppArg.teamMemberId) || str3.equals(str4)) && this.keepAppFolder == revokeLinkedApiAppArg.keepAppFolder);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeLinkedApiAppArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeLinkedApiAppArg revokeLinkedApiAppArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("app_id");
            StoneSerializers.string().serialize(revokeLinkedApiAppArg.appId, jsonGenerator);
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(revokeLinkedApiAppArg.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("keep_app_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(revokeLinkedApiAppArg.keepAppFolder), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeLinkedApiAppArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("app_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("keep_app_folder".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"app_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                RevokeLinkedApiAppArg revokeLinkedApiAppArg = new RevokeLinkedApiAppArg(strDeserialize, strDeserialize2, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeLinkedApiAppArg, revokeLinkedApiAppArg.toStringMultiline());
                return revokeLinkedApiAppArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
