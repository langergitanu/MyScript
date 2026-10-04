package com.dropbox.core.p013v2.auth;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperAccessError {
    PAPER_DISABLED,
    NOT_PAPER_USER,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.PaperAccessError$1 */
    static /* synthetic */ class C41101 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$PaperAccessError;

        static {
            int[] iArr = new int[PaperAccessError.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$PaperAccessError = iArr;
            try {
                iArr[PaperAccessError.PAPER_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$PaperAccessError[PaperAccessError.NOT_PAPER_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PaperAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperAccessError paperAccessError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41101.$SwitchMap$com$dropbox$core$v2$auth$PaperAccessError[paperAccessError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("paper_disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("not_paper_user");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperAccessError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperAccessError paperAccessError;
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
            if ("paper_disabled".equals(tag)) {
                paperAccessError = PaperAccessError.PAPER_DISABLED;
            } else if ("not_paper_user".equals(tag)) {
                paperAccessError = PaperAccessError.NOT_PAPER_USER;
            } else {
                paperAccessError = PaperAccessError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperAccessError;
        }
    }
}
