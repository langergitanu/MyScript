package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedLinkCreatePolicy {
    DEFAULT_PUBLIC,
    DEFAULT_TEAM_ONLY,
    TEAM_ONLY,
    DEFAULT_NO_ONE,
    OTHER;

    static class Serializer extends UnionSerializer<SharedLinkCreatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkCreatePolicy sharedLinkCreatePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45551.f812xc9db58b6[sharedLinkCreatePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default_public");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("default_team_only");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("team_only");
            } else if (i == 4) {
                jsonGenerator.writeString("default_no_one");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkCreatePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkCreatePolicy sharedLinkCreatePolicy;
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
            if ("default_public".equals(tag)) {
                sharedLinkCreatePolicy = SharedLinkCreatePolicy.DEFAULT_PUBLIC;
            } else if ("default_team_only".equals(tag)) {
                sharedLinkCreatePolicy = SharedLinkCreatePolicy.DEFAULT_TEAM_ONLY;
            } else if ("team_only".equals(tag)) {
                sharedLinkCreatePolicy = SharedLinkCreatePolicy.TEAM_ONLY;
            } else if ("default_no_one".equals(tag)) {
                sharedLinkCreatePolicy = SharedLinkCreatePolicy.DEFAULT_NO_ONE;
            } else {
                sharedLinkCreatePolicy = SharedLinkCreatePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkCreatePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SharedLinkCreatePolicy$1 */
    static /* synthetic */ class C45551 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$SharedLinkCreatePolicy */
        static final /* synthetic */ int[] f812xc9db58b6;

        static {
            int[] iArr = new int[SharedLinkCreatePolicy.values().length];
            f812xc9db58b6 = iArr;
            try {
                iArr[SharedLinkCreatePolicy.DEFAULT_PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f812xc9db58b6[SharedLinkCreatePolicy.DEFAULT_TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f812xc9db58b6[SharedLinkCreatePolicy.TEAM_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f812xc9db58b6[SharedLinkCreatePolicy.DEFAULT_NO_ONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
