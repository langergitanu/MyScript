package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldStatus {
    ACTIVE,
    RELEASED,
    ACTIVATING,
    UPDATING,
    EXPORTING,
    RELEASING,
    OTHER;

    static class Serializer extends UnionSerializer<LegalHoldStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldStatus legalHoldStatus, JsonGenerator jsonGenerator) throws IOException {
            switch (C43521.$SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[legalHoldStatus.ordinal()]) {
                case 1:
                    jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                    break;
                case 2:
                    jsonGenerator.writeString("released");
                    break;
                case 3:
                    jsonGenerator.writeString("activating");
                    break;
                case 4:
                    jsonGenerator.writeString("updating");
                    break;
                case 5:
                    jsonGenerator.writeString("exporting");
                    break;
                case 6:
                    jsonGenerator.writeString("releasing");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldStatus legalHoldStatus;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                legalHoldStatus = LegalHoldStatus.ACTIVE;
            } else if ("released".equals(tag)) {
                legalHoldStatus = LegalHoldStatus.RELEASED;
            } else if ("activating".equals(tag)) {
                legalHoldStatus = LegalHoldStatus.ACTIVATING;
            } else if ("updating".equals(tag)) {
                legalHoldStatus = LegalHoldStatus.UPDATING;
            } else if ("exporting".equals(tag)) {
                legalHoldStatus = LegalHoldStatus.EXPORTING;
            } else if ("releasing".equals(tag)) {
                legalHoldStatus = LegalHoldStatus.RELEASING;
            } else {
                legalHoldStatus = LegalHoldStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldStatus$1 */
    static /* synthetic */ class C43521 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus;

        static {
            int[] iArr = new int[LegalHoldStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus = iArr;
            try {
                iArr[LegalHoldStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[LegalHoldStatus.RELEASED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[LegalHoldStatus.ACTIVATING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[LegalHoldStatus.UPDATING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[LegalHoldStatus.EXPORTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldStatus[LegalHoldStatus.RELEASING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
