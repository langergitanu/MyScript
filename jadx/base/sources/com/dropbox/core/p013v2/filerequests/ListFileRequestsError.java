package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListFileRequestsError {
    DISABLED_FOR_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<ListFileRequestsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFileRequestsError listFileRequestsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41381.f686xd406e4f4[listFileRequestsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled_for_team");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("other");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + listFileRequestsError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFileRequestsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFileRequestsError listFileRequestsError;
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
                listFileRequestsError = ListFileRequestsError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                listFileRequestsError = ListFileRequestsError.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFileRequestsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.ListFileRequestsError$1 */
    static /* synthetic */ class C41381 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$ListFileRequestsError */
        static final /* synthetic */ int[] f686xd406e4f4;

        static {
            int[] iArr = new int[ListFileRequestsError.values().length];
            f686xd406e4f4 = iArr;
            try {
                iArr[ListFileRequestsError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f686xd406e4f4[ListFileRequestsError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
