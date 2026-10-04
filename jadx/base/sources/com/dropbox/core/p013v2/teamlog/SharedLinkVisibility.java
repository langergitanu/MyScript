package com.dropbox.core.p013v2.teamlog;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedLinkVisibility {
    NO_ONE,
    PASSWORD,
    PUBLIC,
    TEAM_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<SharedLinkVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkVisibility sharedLinkVisibility, JsonGenerator jsonGenerator) throws IOException {
            int i = C45161.$SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility[sharedLinkVisibility.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("no_one");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("public");
            } else if (i == 4) {
                jsonGenerator.writeString("team_only");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkVisibility deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkVisibility sharedLinkVisibility;
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
            if ("no_one".equals(tag)) {
                sharedLinkVisibility = SharedLinkVisibility.NO_ONE;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                sharedLinkVisibility = SharedLinkVisibility.PASSWORD;
            } else if ("public".equals(tag)) {
                sharedLinkVisibility = SharedLinkVisibility.PUBLIC;
            } else if ("team_only".equals(tag)) {
                sharedLinkVisibility = SharedLinkVisibility.TEAM_ONLY;
            } else {
                sharedLinkVisibility = SharedLinkVisibility.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkVisibility;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharedLinkVisibility$1 */
    static /* synthetic */ class C45161 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility;

        static {
            int[] iArr = new int[SharedLinkVisibility.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility = iArr;
            try {
                iArr[SharedLinkVisibility.NO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility[SharedLinkVisibility.PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility[SharedLinkVisibility.PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharedLinkVisibility[SharedLinkVisibility.TEAM_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
