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
public class RevokeDesktopClientArg extends DeviceSessionArg {
    protected final boolean deleteOnUnlink;

    public RevokeDesktopClientArg(@Nonnull String str, @Nonnull String str2, boolean z) {
        super(str, str2);
        this.deleteOnUnlink = z;
    }

    public RevokeDesktopClientArg(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, false);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public boolean getDeleteOnUnlink() {
        return this.deleteOnUnlink;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Boolean.valueOf(this.deleteOnUnlink)});
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RevokeDesktopClientArg revokeDesktopClientArg = (RevokeDesktopClientArg) obj;
            if ((this.sessionId == revokeDesktopClientArg.sessionId || this.sessionId.equals(revokeDesktopClientArg.sessionId)) && ((this.teamMemberId == revokeDesktopClientArg.teamMemberId || this.teamMemberId.equals(revokeDesktopClientArg.teamMemberId)) && this.deleteOnUnlink == revokeDesktopClientArg.deleteOnUnlink)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSessionArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeDesktopClientArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeDesktopClientArg revokeDesktopClientArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(revokeDesktopClientArg.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(revokeDesktopClientArg.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("delete_on_unlink");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(revokeDesktopClientArg.deleteOnUnlink), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeDesktopClientArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("delete_on_unlink".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                RevokeDesktopClientArg revokeDesktopClientArg = new RevokeDesktopClientArg(strDeserialize, strDeserialize2, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeDesktopClientArg, revokeDesktopClientArg.toStringMultiline());
                return revokeDesktopClientArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
