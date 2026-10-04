package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedFolderMemberPolicy {
    TEAM,
    ANYONE,
    OTHER;

    static class Serializer extends UnionSerializer<SharedFolderMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderMemberPolicy sharedFolderMemberPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45541.f811xf52116c8[sharedFolderMemberPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("team");
            } else if (i == 2) {
                jsonGenerator.writeString("anyone");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderMemberPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderMemberPolicy sharedFolderMemberPolicy;
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
            if ("team".equals(tag)) {
                sharedFolderMemberPolicy = SharedFolderMemberPolicy.TEAM;
            } else if ("anyone".equals(tag)) {
                sharedFolderMemberPolicy = SharedFolderMemberPolicy.ANYONE;
            } else {
                sharedFolderMemberPolicy = SharedFolderMemberPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderMemberPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SharedFolderMemberPolicy$1 */
    static /* synthetic */ class C45541 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$SharedFolderMemberPolicy */
        static final /* synthetic */ int[] f811xf52116c8;

        static {
            int[] iArr = new int[SharedFolderMemberPolicy.values().length];
            f811xf52116c8 = iArr;
            try {
                iArr[SharedFolderMemberPolicy.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f811xf52116c8[SharedFolderMemberPolicy.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
