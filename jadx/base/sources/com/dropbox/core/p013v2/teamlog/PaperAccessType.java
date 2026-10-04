package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperAccessType {
    COMMENTER,
    EDITOR,
    VIEWER,
    OTHER;

    static class Serializer extends UnionSerializer<PaperAccessType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperAccessType paperAccessType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45001.$SwitchMap$com$dropbox$core$v2$teamlog$PaperAccessType[paperAccessType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("commenter");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("editor");
            } else if (i == 3) {
                jsonGenerator.writeString("viewer");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperAccessType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperAccessType paperAccessType;
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
            if ("commenter".equals(tag)) {
                paperAccessType = PaperAccessType.COMMENTER;
            } else if ("editor".equals(tag)) {
                paperAccessType = PaperAccessType.EDITOR;
            } else if ("viewer".equals(tag)) {
                paperAccessType = PaperAccessType.VIEWER;
            } else {
                paperAccessType = PaperAccessType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperAccessType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PaperAccessType$1 */
    static /* synthetic */ class C45001 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PaperAccessType;

        static {
            int[] iArr = new int[PaperAccessType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PaperAccessType = iArr;
            try {
                iArr[PaperAccessType.COMMENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperAccessType[PaperAccessType.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperAccessType[PaperAccessType.VIEWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
