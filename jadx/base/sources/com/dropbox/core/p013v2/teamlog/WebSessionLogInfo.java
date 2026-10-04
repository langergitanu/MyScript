package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class WebSessionLogInfo extends SessionLogInfo {
    public WebSessionLogInfo(@Nullable String str) {
        super(str);
    }

    public WebSessionLogInfo() {
        this(null);
    }

    @Override // com.dropbox.core.p013v2.teamlog.SessionLogInfo
    @Nullable
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.dropbox.core.p013v2.teamlog.SessionLogInfo
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.teamlog.SessionLogInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        WebSessionLogInfo webSessionLogInfo = (WebSessionLogInfo) obj;
        return this.sessionId == webSessionLogInfo.sessionId || (this.sessionId != null && this.sessionId.equals(webSessionLogInfo.sessionId));
    }

    @Override // com.dropbox.core.p013v2.teamlog.SessionLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.SessionLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<WebSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(WebSessionLogInfo webSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("web", jsonGenerator);
            if (webSessionLogInfo.sessionId != null) {
                jsonGenerator.writeFieldName("session_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(webSessionLogInfo.sessionId, jsonGenerator);
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
        public WebSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("web".equals(tag)) {
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
                WebSessionLogInfo webSessionLogInfo = new WebSessionLogInfo(str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(webSessionLogInfo, webSessionLogInfo.toStringMultiline());
                return webSessionLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
