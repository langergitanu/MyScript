package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListMembersAppsError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<ListMembersAppsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListMembersAppsError listMembersAppsError, JsonGenerator jsonGenerator) throws IOException {
            if (C43611.$SwitchMap$com$dropbox$core$v2$team$ListMembersAppsError[listMembersAppsError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListMembersAppsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListMembersAppsError listMembersAppsError;
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
            if ("reset".equals(tag)) {
                listMembersAppsError = ListMembersAppsError.RESET;
            } else {
                listMembersAppsError = ListMembersAppsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listMembersAppsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListMembersAppsError$1 */
    static /* synthetic */ class C43611 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListMembersAppsError;

        static {
            int[] iArr = new int[ListMembersAppsError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListMembersAppsError = iArr;
            try {
                iArr[ListMembersAppsError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
