package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LinkAccessLevel {
    VIEWER,
    EDITOR,
    OTHER;

    static class Serializer extends UnionSerializer<LinkAccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkAccessLevel linkAccessLevel, JsonGenerator jsonGenerator) throws IOException {
            int i = C42671.$SwitchMap$com$dropbox$core$v2$sharing$LinkAccessLevel[linkAccessLevel.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("viewer");
            } else if (i == 2) {
                jsonGenerator.writeString("editor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkAccessLevel deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkAccessLevel linkAccessLevel;
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
                linkAccessLevel = LinkAccessLevel.VIEWER;
            } else if ("editor".equals(tag)) {
                linkAccessLevel = LinkAccessLevel.EDITOR;
            } else {
                linkAccessLevel = LinkAccessLevel.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return linkAccessLevel;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkAccessLevel$1 */
    static /* synthetic */ class C42671 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$LinkAccessLevel;

        static {
            int[] iArr = new int[LinkAccessLevel.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$LinkAccessLevel = iArr;
            try {
                iArr[LinkAccessLevel.VIEWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAccessLevel[LinkAccessLevel.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
