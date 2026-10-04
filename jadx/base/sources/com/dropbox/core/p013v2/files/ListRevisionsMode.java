package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public enum ListRevisionsMode {
    PATH,
    ID,
    OTHER;

    static class Serializer extends UnionSerializer<ListRevisionsMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListRevisionsMode listRevisionsMode, JsonGenerator jsonGenerator) throws IOException {
            int i = C41711.$SwitchMap$com$dropbox$core$v2$files$ListRevisionsMode[listRevisionsMode.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(ClientCookie.PATH_ATTR);
            } else if (i == 2) {
                jsonGenerator.writeString("id");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListRevisionsMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListRevisionsMode listRevisionsMode;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                listRevisionsMode = ListRevisionsMode.PATH;
            } else if ("id".equals(tag)) {
                listRevisionsMode = ListRevisionsMode.ID;
            } else {
                listRevisionsMode = ListRevisionsMode.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listRevisionsMode;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ListRevisionsMode$1 */
    static /* synthetic */ class C41711 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ListRevisionsMode;

        static {
            int[] iArr = new int[ListRevisionsMode.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ListRevisionsMode = iArr;
            try {
                iArr[ListRevisionsMode.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListRevisionsMode[ListRevisionsMode.ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
