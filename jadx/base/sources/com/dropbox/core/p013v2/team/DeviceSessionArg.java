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
public class DeviceSessionArg {

    @Nonnull
    protected final String sessionId;

    @Nonnull
    protected final String teamMemberId;

    public DeviceSessionArg(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str2;
    }

    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionId, this.teamMemberId});
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
        DeviceSessionArg deviceSessionArg = (DeviceSessionArg) obj;
        String str3 = this.sessionId;
        String str4 = deviceSessionArg.sessionId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.teamMemberId) == (str2 = deviceSessionArg.teamMemberId) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceSessionArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceSessionArg deviceSessionArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(deviceSessionArg.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(deviceSessionArg.teamMemberId, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceSessionArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
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
                DeviceSessionArg deviceSessionArg = new DeviceSessionArg(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceSessionArg, deviceSessionArg.toStringMultiline());
                return deviceSessionArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
