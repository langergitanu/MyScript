package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperDefaultFolderPolicy {
    EVERYONE_IN_TEAM,
    INVITE_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDefaultFolderPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDefaultFolderPolicy paperDefaultFolderPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45011.$SwitchMap$com$dropbox$core$v2$teamlog$PaperDefaultFolderPolicy[paperDefaultFolderPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("everyone_in_team");
            } else if (i == 2) {
                jsonGenerator.writeString("invite_only");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDefaultFolderPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDefaultFolderPolicy paperDefaultFolderPolicy;
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
            if ("everyone_in_team".equals(tag)) {
                paperDefaultFolderPolicy = PaperDefaultFolderPolicy.EVERYONE_IN_TEAM;
            } else if ("invite_only".equals(tag)) {
                paperDefaultFolderPolicy = PaperDefaultFolderPolicy.INVITE_ONLY;
            } else {
                paperDefaultFolderPolicy = PaperDefaultFolderPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDefaultFolderPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PaperDefaultFolderPolicy$1 */
    static /* synthetic */ class C45011 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PaperDefaultFolderPolicy;

        static {
            int[] iArr = new int[PaperDefaultFolderPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PaperDefaultFolderPolicy = iArr;
            try {
                iArr[PaperDefaultFolderPolicy.EVERYONE_IN_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperDefaultFolderPolicy[PaperDefaultFolderPolicy.INVITE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
