package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum GracePeriod {
    ONE_DAY,
    TWO_DAYS,
    SEVEN_DAYS,
    THIRTY_DAYS,
    ALWAYS,
    OTHER;

    static class Serializer extends UnionSerializer<GracePeriod> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GracePeriod gracePeriod, JsonGenerator jsonGenerator) throws IOException {
            int i = C41361.$SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod[gracePeriod.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("one_day");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("two_days");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("seven_days");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("thirty_days");
            } else if (i == 5) {
                jsonGenerator.writeString("always");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GracePeriod deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GracePeriod gracePeriod;
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
            if ("one_day".equals(tag)) {
                gracePeriod = GracePeriod.ONE_DAY;
            } else if ("two_days".equals(tag)) {
                gracePeriod = GracePeriod.TWO_DAYS;
            } else if ("seven_days".equals(tag)) {
                gracePeriod = GracePeriod.SEVEN_DAYS;
            } else if ("thirty_days".equals(tag)) {
                gracePeriod = GracePeriod.THIRTY_DAYS;
            } else if ("always".equals(tag)) {
                gracePeriod = GracePeriod.ALWAYS;
            } else {
                gracePeriod = GracePeriod.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return gracePeriod;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.GracePeriod$1 */
    static /* synthetic */ class C41361 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod;

        static {
            int[] iArr = new int[GracePeriod.values().length];
            $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod = iArr;
            try {
                iArr[GracePeriod.ONE_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod[GracePeriod.TWO_DAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod[GracePeriod.SEVEN_DAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod[GracePeriod.THIRTY_DAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$filerequests$GracePeriod[GracePeriod.ALWAYS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
