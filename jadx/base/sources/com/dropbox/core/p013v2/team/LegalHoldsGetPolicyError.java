package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsGetPolicyError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    LEGAL_HOLD_POLICY_NOT_FOUND;

    static class Serializer extends UnionSerializer<LegalHoldsGetPolicyError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsGetPolicyError legalHoldsGetPolicyError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43531.$SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError[legalHoldsGetPolicyError.ordinal()];
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
                    jsonGenerator.writeString("legal_hold_policy_not_found");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsGetPolicyError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsGetPolicyError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsGetPolicyError legalHoldsGetPolicyError;
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
                legalHoldsGetPolicyError = LegalHoldsGetPolicyError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsGetPolicyError = LegalHoldsGetPolicyError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsGetPolicyError = LegalHoldsGetPolicyError.OTHER;
            } else if ("legal_hold_policy_not_found".equals(tag)) {
                legalHoldsGetPolicyError = LegalHoldsGetPolicyError.LEGAL_HOLD_POLICY_NOT_FOUND;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsGetPolicyError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsGetPolicyError$1 */
    static /* synthetic */ class C43531 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError;

        static {
            int[] iArr = new int[LegalHoldsGetPolicyError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError = iArr;
            try {
                iArr[LegalHoldsGetPolicyError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError[LegalHoldsGetPolicyError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError[LegalHoldsGetPolicyError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsGetPolicyError[LegalHoldsGetPolicyError.LEGAL_HOLD_POLICY_NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
