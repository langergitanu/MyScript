package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsListHeldRevisionsError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    TRANSIENT_ERROR,
    LEGAL_HOLD_STILL_EMPTY,
    INACTIVE_LEGAL_HOLD;

    static class Serializer extends UnionSerializer<LegalHoldsListHeldRevisionsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsListHeldRevisionsError legalHoldsListHeldRevisionsError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43541.f755xd39eabd7[legalHoldsListHeldRevisionsError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("unknown_legal_hold_error");
                    return;
                case 2:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 3:
                    jsonGenerator.writeString("other");
                    return;
                case 4:
                    jsonGenerator.writeString("transient_error");
                    return;
                case 5:
                    jsonGenerator.writeString("legal_hold_still_empty");
                    return;
                case 6:
                    jsonGenerator.writeString("inactive_legal_hold");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsListHeldRevisionsError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsListHeldRevisionsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsListHeldRevisionsError legalHoldsListHeldRevisionsError;
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
            if ("unknown_legal_hold_error".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.OTHER;
            } else if ("transient_error".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.TRANSIENT_ERROR;
            } else if ("legal_hold_still_empty".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.LEGAL_HOLD_STILL_EMPTY;
            } else if ("inactive_legal_hold".equals(tag)) {
                legalHoldsListHeldRevisionsError = LegalHoldsListHeldRevisionsError.INACTIVE_LEGAL_HOLD;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsListHeldRevisionsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsListHeldRevisionsError$1 */
    static /* synthetic */ class C43541 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListHeldRevisionsError */
        static final /* synthetic */ int[] f755xd39eabd7;

        static {
            int[] iArr = new int[LegalHoldsListHeldRevisionsError.values().length];
            f755xd39eabd7 = iArr;
            try {
                iArr[LegalHoldsListHeldRevisionsError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f755xd39eabd7[LegalHoldsListHeldRevisionsError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f755xd39eabd7[LegalHoldsListHeldRevisionsError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f755xd39eabd7[LegalHoldsListHeldRevisionsError.TRANSIENT_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f755xd39eabd7[LegalHoldsListHeldRevisionsError.LEGAL_HOLD_STILL_EMPTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f755xd39eabd7[LegalHoldsListHeldRevisionsError.INACTIVE_LEGAL_HOLD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
