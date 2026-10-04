package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperDocPermissionLevel {
    EDIT,
    VIEW_AND_COMMENT,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDocPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDocPermissionLevel paperDocPermissionLevel, JsonGenerator jsonGenerator) throws IOException {
            int i = C42381.$SwitchMap$com$dropbox$core$v2$paper$PaperDocPermissionLevel[paperDocPermissionLevel.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("edit");
            } else if (i == 2) {
                jsonGenerator.writeString("view_and_comment");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDocPermissionLevel deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDocPermissionLevel paperDocPermissionLevel;
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
            if ("edit".equals(tag)) {
                paperDocPermissionLevel = PaperDocPermissionLevel.EDIT;
            } else if ("view_and_comment".equals(tag)) {
                paperDocPermissionLevel = PaperDocPermissionLevel.VIEW_AND_COMMENT;
            } else {
                paperDocPermissionLevel = PaperDocPermissionLevel.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDocPermissionLevel;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperDocPermissionLevel$1 */
    static /* synthetic */ class C42381 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperDocPermissionLevel;

        static {
            int[] iArr = new int[PaperDocPermissionLevel.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperDocPermissionLevel = iArr;
            try {
                iArr[PaperDocPermissionLevel.EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocPermissionLevel[PaperDocPermissionLevel.VIEW_AND_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
