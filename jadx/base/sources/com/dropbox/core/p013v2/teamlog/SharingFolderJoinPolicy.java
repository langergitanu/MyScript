package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharingFolderJoinPolicy {
    FROM_ANYONE,
    FROM_TEAM_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<SharingFolderJoinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingFolderJoinPolicy sharingFolderJoinPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45171.$SwitchMap$com$dropbox$core$v2$teamlog$SharingFolderJoinPolicy[sharingFolderJoinPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("from_anyone");
            } else if (i == 2) {
                jsonGenerator.writeString("from_team_only");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingFolderJoinPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingFolderJoinPolicy sharingFolderJoinPolicy;
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
            if ("from_anyone".equals(tag)) {
                sharingFolderJoinPolicy = SharingFolderJoinPolicy.FROM_ANYONE;
            } else if ("from_team_only".equals(tag)) {
                sharingFolderJoinPolicy = SharingFolderJoinPolicy.FROM_TEAM_ONLY;
            } else {
                sharingFolderJoinPolicy = SharingFolderJoinPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingFolderJoinPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharingFolderJoinPolicy$1 */
    static /* synthetic */ class C45171 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SharingFolderJoinPolicy;

        static {
            int[] iArr = new int[SharingFolderJoinPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SharingFolderJoinPolicy = iArr;
            try {
                iArr[SharingFolderJoinPolicy.FROM_ANYONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingFolderJoinPolicy[SharingFolderJoinPolicy.FROM_TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
