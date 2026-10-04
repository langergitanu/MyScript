package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum RequestedVisibility {
    PUBLIC,
    TEAM_ONLY,
    PASSWORD;

    static class Serializer extends UnionSerializer<RequestedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RequestedVisibility requestedVisibility, JsonGenerator jsonGenerator) throws IOException {
            int i = C42931.$SwitchMap$com$dropbox$core$v2$sharing$RequestedVisibility[requestedVisibility.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("public");
            } else if (i == 2) {
                jsonGenerator.writeString("team_only");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + requestedVisibility);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RequestedVisibility deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RequestedVisibility requestedVisibility;
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
            if ("public".equals(tag)) {
                requestedVisibility = RequestedVisibility.PUBLIC;
            } else if ("team_only".equals(tag)) {
                requestedVisibility = RequestedVisibility.TEAM_ONLY;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                requestedVisibility = RequestedVisibility.PASSWORD;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return requestedVisibility;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RequestedVisibility$1 */
    static /* synthetic */ class C42931 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$RequestedVisibility;

        static {
            int[] iArr = new int[RequestedVisibility.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$RequestedVisibility = iArr;
            try {
                iArr[RequestedVisibility.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RequestedVisibility[RequestedVisibility.TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RequestedVisibility[RequestedVisibility.PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
