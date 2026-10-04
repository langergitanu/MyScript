package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListMembersDevicesError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<ListMembersDevicesError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListMembersDevicesError listMembersDevicesError, JsonGenerator jsonGenerator) throws IOException {
            if (C43621.$SwitchMap$com$dropbox$core$v2$team$ListMembersDevicesError[listMembersDevicesError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListMembersDevicesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListMembersDevicesError listMembersDevicesError;
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
                listMembersDevicesError = ListMembersDevicesError.RESET;
            } else {
                listMembersDevicesError = ListMembersDevicesError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listMembersDevicesError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListMembersDevicesError$1 */
    static /* synthetic */ class C43621 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListMembersDevicesError;

        static {
            int[] iArr = new int[ListMembersDevicesError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListMembersDevicesError = iArr;
            try {
                iArr[ListMembersDevicesError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
