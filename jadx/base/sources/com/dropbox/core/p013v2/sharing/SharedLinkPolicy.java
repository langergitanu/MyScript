package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharedLinkPolicy {
    ANYONE,
    TEAM,
    MEMBERS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedLinkPolicy$1 */
    static /* synthetic */ class C43061 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkPolicy;

        static {
            int[] iArr = new int[SharedLinkPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkPolicy = iArr;
            try {
                iArr[SharedLinkPolicy.ANYONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkPolicy[SharedLinkPolicy.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkPolicy[SharedLinkPolicy.MEMBERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SharedLinkPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkPolicy sharedLinkPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C43061.$SwitchMap$com$dropbox$core$v2$sharing$SharedLinkPolicy[sharedLinkPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("anyone");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("team");
            } else if (i == 3) {
                jsonGenerator.writeString("members");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkPolicy sharedLinkPolicy;
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
            if ("anyone".equals(tag)) {
                sharedLinkPolicy = SharedLinkPolicy.ANYONE;
            } else if ("team".equals(tag)) {
                sharedLinkPolicy = SharedLinkPolicy.TEAM;
            } else if ("members".equals(tag)) {
                sharedLinkPolicy = SharedLinkPolicy.MEMBERS;
            } else {
                sharedLinkPolicy = SharedLinkPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkPolicy;
        }
    }
}
