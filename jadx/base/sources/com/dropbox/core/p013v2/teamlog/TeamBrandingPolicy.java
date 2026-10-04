package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamBrandingPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<TeamBrandingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamBrandingPolicy teamBrandingPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45261.$SwitchMap$com$dropbox$core$v2$teamlog$TeamBrandingPolicy[teamBrandingPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamBrandingPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamBrandingPolicy teamBrandingPolicy;
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
                teamBrandingPolicy = TeamBrandingPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                teamBrandingPolicy = TeamBrandingPolicy.ENABLED;
            } else {
                teamBrandingPolicy = TeamBrandingPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamBrandingPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamBrandingPolicy$1 */
    static /* synthetic */ class C45261 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TeamBrandingPolicy;

        static {
            int[] iArr = new int[TeamBrandingPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TeamBrandingPolicy = iArr;
            try {
                iArr[TeamBrandingPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TeamBrandingPolicy[TeamBrandingPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
