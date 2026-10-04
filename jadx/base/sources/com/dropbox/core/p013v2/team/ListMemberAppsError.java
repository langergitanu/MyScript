package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListMemberAppsError {
    MEMBER_NOT_FOUND,
    OTHER;

    static class Serializer extends UnionSerializer<ListMemberAppsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListMemberAppsError listMemberAppsError, JsonGenerator jsonGenerator) throws IOException {
            if (C43591.$SwitchMap$com$dropbox$core$v2$team$ListMemberAppsError[listMemberAppsError.ordinal()] == 1) {
                jsonGenerator.writeString("member_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListMemberAppsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListMemberAppsError listMemberAppsError;
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
                listMemberAppsError = ListMemberAppsError.MEMBER_NOT_FOUND;
            } else {
                listMemberAppsError = ListMemberAppsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listMemberAppsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListMemberAppsError$1 */
    static /* synthetic */ class C43591 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListMemberAppsError;

        static {
            int[] iArr = new int[ListMemberAppsError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListMemberAppsError = iArr;
            try {
                iArr[ListMemberAppsError.MEMBER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
