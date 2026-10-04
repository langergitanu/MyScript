package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum RequestedLinkAccessLevel {
    VIEWER,
    EDITOR,
    MAX,
    DEFAULT,
    OTHER;

    static class Serializer extends UnionSerializer<RequestedLinkAccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RequestedLinkAccessLevel requestedLinkAccessLevel, JsonGenerator jsonGenerator) throws IOException {
            int i = C42921.$SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel[requestedLinkAccessLevel.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("viewer");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("editor");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("max");
            } else if (i == 4) {
                jsonGenerator.writeString("default");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RequestedLinkAccessLevel deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RequestedLinkAccessLevel requestedLinkAccessLevel;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("viewer".equals(tag)) {
                requestedLinkAccessLevel = RequestedLinkAccessLevel.VIEWER;
            } else if ("editor".equals(tag)) {
                requestedLinkAccessLevel = RequestedLinkAccessLevel.EDITOR;
            } else if ("max".equals(tag)) {
                requestedLinkAccessLevel = RequestedLinkAccessLevel.MAX;
            } else if ("default".equals(tag)) {
                requestedLinkAccessLevel = RequestedLinkAccessLevel.DEFAULT;
            } else {
                requestedLinkAccessLevel = RequestedLinkAccessLevel.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return requestedLinkAccessLevel;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RequestedLinkAccessLevel$1 */
    static /* synthetic */ class C42921 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel;

        static {
            int[] iArr = new int[RequestedLinkAccessLevel.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel = iArr;
            try {
                iArr[RequestedLinkAccessLevel.VIEWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel[RequestedLinkAccessLevel.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel[RequestedLinkAccessLevel.MAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RequestedLinkAccessLevel[RequestedLinkAccessLevel.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
