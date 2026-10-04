package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum AccessLevel {
    OWNER,
    EDITOR,
    VIEWER,
    VIEWER_NO_COMMENT,
    TRAVERSE,
    NO_ACCESS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AccessLevel$1 */
    static /* synthetic */ class C42471 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel;

        static {
            int[] iArr = new int[AccessLevel.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel = iArr;
            try {
                iArr[AccessLevel.OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[AccessLevel.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[AccessLevel.VIEWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[AccessLevel.VIEWER_NO_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[AccessLevel.TRAVERSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[AccessLevel.NO_ACCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<AccessLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccessLevel accessLevel, JsonGenerator jsonGenerator) throws IOException {
            switch (C42471.$SwitchMap$com$dropbox$core$v2$sharing$AccessLevel[accessLevel.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("owner");
                    break;
                case 2:
                    jsonGenerator.writeString("editor");
                    break;
                case 3:
                    jsonGenerator.writeString("viewer");
                    break;
                case 4:
                    jsonGenerator.writeString("viewer_no_comment");
                    break;
                case 5:
                    jsonGenerator.writeString("traverse");
                    break;
                case 6:
                    jsonGenerator.writeString("no_access");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccessLevel deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccessLevel accessLevel;
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
            if ("owner".equals(tag)) {
                accessLevel = AccessLevel.OWNER;
            } else if ("editor".equals(tag)) {
                accessLevel = AccessLevel.EDITOR;
            } else if ("viewer".equals(tag)) {
                accessLevel = AccessLevel.VIEWER;
            } else if ("viewer_no_comment".equals(tag)) {
                accessLevel = AccessLevel.VIEWER_NO_COMMENT;
            } else if ("traverse".equals(tag)) {
                accessLevel = AccessLevel.TRAVERSE;
            } else if ("no_access".equals(tag)) {
                accessLevel = AccessLevel.NO_ACCESS;
            } else {
                accessLevel = AccessLevel.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accessLevel;
        }
    }
}
