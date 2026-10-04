package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum EmmState {
    DISABLED,
    OPTIONAL,
    REQUIRED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.EmmState$1 */
    static /* synthetic */ class C45431 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$EmmState;

        static {
            int[] iArr = new int[EmmState.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$EmmState = iArr;
            try {
                iArr[EmmState.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$EmmState[EmmState.OPTIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$EmmState[EmmState.REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<EmmState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(EmmState emmState, JsonGenerator jsonGenerator) throws IOException {
            int i = C45431.$SwitchMap$com$dropbox$core$v2$teampolicies$EmmState[emmState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("optional");
            } else if (i == 3) {
                jsonGenerator.writeString("required");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public EmmState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            EmmState emmState;
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
            if ("disabled".equals(tag)) {
                emmState = EmmState.DISABLED;
            } else if ("optional".equals(tag)) {
                emmState = EmmState.OPTIONAL;
            } else if ("required".equals(tag)) {
                emmState = EmmState.REQUIRED;
            } else {
                emmState = EmmState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return emmState;
        }
    }
}
