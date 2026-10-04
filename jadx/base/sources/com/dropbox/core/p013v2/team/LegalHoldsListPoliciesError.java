package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsListPoliciesError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    TRANSIENT_ERROR;

    static class Serializer extends UnionSerializer<LegalHoldsListPoliciesError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsListPoliciesError legalHoldsListPoliciesError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43551.$SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError[legalHoldsListPoliciesError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("unknown_legal_hold_error");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("insufficient_permissions");
            } else if (i == 3) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("transient_error");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsListPoliciesError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsListPoliciesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsListPoliciesError legalHoldsListPoliciesError;
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
                legalHoldsListPoliciesError = LegalHoldsListPoliciesError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsListPoliciesError = LegalHoldsListPoliciesError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsListPoliciesError = LegalHoldsListPoliciesError.OTHER;
            } else if ("transient_error".equals(tag)) {
                legalHoldsListPoliciesError = LegalHoldsListPoliciesError.TRANSIENT_ERROR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsListPoliciesError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsListPoliciesError$1 */
    static /* synthetic */ class C43551 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError;

        static {
            int[] iArr = new int[LegalHoldsListPoliciesError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError = iArr;
            try {
                iArr[LegalHoldsListPoliciesError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError[LegalHoldsListPoliciesError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError[LegalHoldsListPoliciesError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsListPoliciesError[LegalHoldsListPoliciesError.TRANSIENT_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
