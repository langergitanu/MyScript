package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamSelectiveSyncPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<TeamSelectiveSyncPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamSelectiveSyncPolicy teamSelectiveSyncPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45331.$SwitchMap$com$dropbox$core$v2$teamlog$TeamSelectiveSyncPolicy[teamSelectiveSyncPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamSelectiveSyncPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamSelectiveSyncPolicy teamSelectiveSyncPolicy;
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
                teamSelectiveSyncPolicy = TeamSelectiveSyncPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                teamSelectiveSyncPolicy = TeamSelectiveSyncPolicy.ENABLED;
            } else {
                teamSelectiveSyncPolicy = TeamSelectiveSyncPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamSelectiveSyncPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamSelectiveSyncPolicy$1 */
    static /* synthetic */ class C45331 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TeamSelectiveSyncPolicy;

        static {
            int[] iArr = new int[TeamSelectiveSyncPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TeamSelectiveSyncPolicy = iArr;
            try {
                iArr[TeamSelectiveSyncPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TeamSelectiveSyncPolicy[TeamSelectiveSyncPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
