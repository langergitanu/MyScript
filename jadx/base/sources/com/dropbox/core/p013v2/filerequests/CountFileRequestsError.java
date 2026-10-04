package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum CountFileRequestsError {
    DISABLED_FOR_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<CountFileRequestsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CountFileRequestsError countFileRequestsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41311.f678xf7fdb70f[countFileRequestsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled_for_team");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("other");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + countFileRequestsError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CountFileRequestsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CountFileRequestsError countFileRequestsError;
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
            if ("disabled_for_team".equals(tag)) {
                countFileRequestsError = CountFileRequestsError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                countFileRequestsError = CountFileRequestsError.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return countFileRequestsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.CountFileRequestsError$1 */
    static /* synthetic */ class C41311 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$CountFileRequestsError */
        static final /* synthetic */ int[] f678xf7fdb70f;

        static {
            int[] iArr = new int[CountFileRequestsError.values().length];
            f678xf7fdb70f = iArr;
            try {
                iArr[CountFileRequestsError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f678xf7fdb70f[CountFileRequestsError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
