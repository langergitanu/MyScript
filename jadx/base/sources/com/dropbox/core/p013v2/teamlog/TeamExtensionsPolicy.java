package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamExtensionsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<TeamExtensionsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamExtensionsPolicy teamExtensionsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45271.$SwitchMap$com$dropbox$core$v2$teamlog$TeamExtensionsPolicy[teamExtensionsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamExtensionsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamExtensionsPolicy teamExtensionsPolicy;
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
            if ("disabled".equals(tag)) {
                teamExtensionsPolicy = TeamExtensionsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                teamExtensionsPolicy = TeamExtensionsPolicy.ENABLED;
            } else {
                teamExtensionsPolicy = TeamExtensionsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamExtensionsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamExtensionsPolicy$1 */
    static /* synthetic */ class C45271 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TeamExtensionsPolicy;

        static {
            int[] iArr = new int[TeamExtensionsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TeamExtensionsPolicy = iArr;
            try {
                iArr[TeamExtensionsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TeamExtensionsPolicy[TeamExtensionsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
