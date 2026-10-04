package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedFolderJoinPolicy {
    FROM_TEAM_ONLY,
    FROM_ANYONE,
    OTHER;

    static class Serializer extends UnionSerializer<SharedFolderJoinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderJoinPolicy sharedFolderJoinPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45531.f810x15462458[sharedFolderJoinPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("from_team_only");
            } else if (i == 2) {
                jsonGenerator.writeString("from_anyone");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderJoinPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderJoinPolicy sharedFolderJoinPolicy;
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
            if ("from_team_only".equals(tag)) {
                sharedFolderJoinPolicy = SharedFolderJoinPolicy.FROM_TEAM_ONLY;
            } else if ("from_anyone".equals(tag)) {
                sharedFolderJoinPolicy = SharedFolderJoinPolicy.FROM_ANYONE;
            } else {
                sharedFolderJoinPolicy = SharedFolderJoinPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderJoinPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SharedFolderJoinPolicy$1 */
    static /* synthetic */ class C45531 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$SharedFolderJoinPolicy */
        static final /* synthetic */ int[] f810x15462458;

        static {
            int[] iArr = new int[SharedFolderJoinPolicy.values().length];
            f810x15462458 = iArr;
            try {
                iArr[SharedFolderJoinPolicy.FROM_TEAM_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f810x15462458[SharedFolderJoinPolicy.FROM_ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
