package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DesktopSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.MobileSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.WebSessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SessionLogInfo {

    @Nullable
    protected final String sessionId;

    public SessionLogInfo(@Nullable String str) {
        this.sessionId = str;
    }

    public SessionLogInfo() {
        this(null);
    }

    @Nullable
    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionId});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.sessionId;
        String str2 = ((SessionLogInfo) obj).sessionId;
        return str == str2 || (str != null && str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SessionLogInfo sessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (sessionLogInfo instanceof WebSessionLogInfo) {
                WebSessionLogInfo.Serializer.INSTANCE.serialize((WebSessionLogInfo) sessionLogInfo, jsonGenerator, z);
                return;
            }
            if (sessionLogInfo instanceof DesktopSessionLogInfo) {
                DesktopSessionLogInfo.Serializer.INSTANCE.serialize((DesktopSessionLogInfo) sessionLogInfo, jsonGenerator, z);
                return;
            }
            if (sessionLogInfo instanceof MobileSessionLogInfo) {
                MobileSessionLogInfo.Serializer.INSTANCE.serialize((MobileSessionLogInfo) sessionLogInfo, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sessionLogInfo.sessionId != null) {
                jsonGenerator.writeFieldName("session_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sessionLogInfo.sessionId, jsonGenerator);
            }
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
        public SessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SessionLogInfo sessionLogInfoDeserialize;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                sessionLogInfoDeserialize = new SessionLogInfo(str);
            } else if ("".equals(tag)) {
                sessionLogInfoDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("web".equals(tag)) {
                sessionLogInfoDeserialize = WebSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("desktop".equals(tag)) {
                sessionLogInfoDeserialize = DesktopSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if (NetworkTargetingEvent.TYPE_MOBILE.equals(tag)) {
                sessionLogInfoDeserialize = MobileSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(sessionLogInfoDeserialize, sessionLogInfoDeserialize.toStringMultiline());
            return sessionLogInfoDeserialize;
        }
    }
}
