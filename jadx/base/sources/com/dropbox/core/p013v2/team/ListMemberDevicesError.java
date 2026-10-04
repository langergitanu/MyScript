package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListMemberDevicesError {
    MEMBER_NOT_FOUND,
    OTHER;

    static class Serializer extends UnionSerializer<ListMemberDevicesError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListMemberDevicesError listMemberDevicesError, JsonGenerator jsonGenerator) throws IOException {
            if (C43601.$SwitchMap$com$dropbox$core$v2$team$ListMemberDevicesError[listMemberDevicesError.ordinal()] == 1) {
                jsonGenerator.writeString("member_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListMemberDevicesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListMemberDevicesError listMemberDevicesError;
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
            if ("member_not_found".equals(tag)) {
                listMemberDevicesError = ListMemberDevicesError.MEMBER_NOT_FOUND;
            } else {
                listMemberDevicesError = ListMemberDevicesError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listMemberDevicesError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListMemberDevicesError$1 */
    static /* synthetic */ class C43601 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListMemberDevicesError;

        static {
            int[] iArr = new int[ListMemberDevicesError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListMemberDevicesError = iArr;
            try {
                iArr[ListMemberDevicesError.MEMBER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
