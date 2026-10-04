package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes5.dex */
public enum SpaceCapsType {
    HARD,
    OFF,
    SOFT,
    OTHER;

    static class Serializer extends UnionSerializer<SpaceCapsType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SpaceCapsType spaceCapsType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45241.$SwitchMap$com$dropbox$core$v2$teamlog$SpaceCapsType[spaceCapsType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("hard");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i == 3) {
                jsonGenerator.writeString("soft");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SpaceCapsType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SpaceCapsType spaceCapsType;
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
            if ("hard".equals(tag)) {
                spaceCapsType = SpaceCapsType.HARD;
            } else if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(tag)) {
                spaceCapsType = SpaceCapsType.OFF;
            } else if ("soft".equals(tag)) {
                spaceCapsType = SpaceCapsType.SOFT;
            } else {
                spaceCapsType = SpaceCapsType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return spaceCapsType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SpaceCapsType$1 */
    static /* synthetic */ class C45241 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SpaceCapsType;

        static {
            int[] iArr = new int[SpaceCapsType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SpaceCapsType = iArr;
            try {
                iArr[SpaceCapsType.HARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SpaceCapsType[SpaceCapsType.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SpaceCapsType[SpaceCapsType.SOFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
