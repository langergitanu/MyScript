package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedLinkAccessLevel {
    NONE,
    READER,
    WRITER,
    OTHER;

    static class Serializer extends UnionSerializer<SharedLinkAccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkAccessLevel sharedLinkAccessLevel, JsonGenerator jsonGenerator) throws IOException {
            int i = C45151.$SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkAccessLevel[sharedLinkAccessLevel.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("none");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("reader");
            } else if (i == 3) {
                jsonGenerator.writeString("writer");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkAccessLevel deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkAccessLevel sharedLinkAccessLevel;
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
            if ("none".equals(tag)) {
                sharedLinkAccessLevel = SharedLinkAccessLevel.NONE;
            } else if ("reader".equals(tag)) {
                sharedLinkAccessLevel = SharedLinkAccessLevel.READER;
            } else if ("writer".equals(tag)) {
                sharedLinkAccessLevel = SharedLinkAccessLevel.WRITER;
            } else {
                sharedLinkAccessLevel = SharedLinkAccessLevel.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkAccessLevel;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharedLinkAccessLevel$1 */
    static /* synthetic */ class C45151 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkAccessLevel;

        static {
            int[] iArr = new int[SharedLinkAccessLevel.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkAccessLevel = iArr;
            try {
                iArr[SharedLinkAccessLevel.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkAccessLevel[SharedLinkAccessLevel.READER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkAccessLevel[SharedLinkAccessLevel.WRITER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
