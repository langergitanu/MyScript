package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DispositionActionType {
    AUTOMATIC_DELETE,
    AUTOMATIC_PERMANENTLY_DELETE,
    OTHER;

    static class Serializer extends UnionSerializer<DispositionActionType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DispositionActionType dispositionActionType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44591.$SwitchMap$com$dropbox$core$v2$teamlog$DispositionActionType[dispositionActionType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("automatic_delete");
            } else if (i == 2) {
                jsonGenerator.writeString("automatic_permanently_delete");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DispositionActionType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DispositionActionType dispositionActionType;
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
            if ("automatic_delete".equals(tag)) {
                dispositionActionType = DispositionActionType.AUTOMATIC_DELETE;
            } else if ("automatic_permanently_delete".equals(tag)) {
                dispositionActionType = DispositionActionType.AUTOMATIC_PERMANENTLY_DELETE;
            } else {
                dispositionActionType = DispositionActionType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return dispositionActionType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DispositionActionType$1 */
    static /* synthetic */ class C44591 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DispositionActionType;

        static {
            int[] iArr = new int[DispositionActionType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DispositionActionType = iArr;
            try {
                iArr[DispositionActionType.AUTOMATIC_DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DispositionActionType[DispositionActionType.AUTOMATIC_PERMANENTLY_DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
