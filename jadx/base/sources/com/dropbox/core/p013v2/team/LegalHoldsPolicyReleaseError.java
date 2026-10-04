package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsPolicyReleaseError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION,
    LEGAL_HOLD_ALREADY_RELEASING,
    LEGAL_HOLD_POLICY_NOT_FOUND;

    static class Serializer extends UnionSerializer<LegalHoldsPolicyReleaseError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsPolicyReleaseError legalHoldsPolicyReleaseError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43571.$SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[legalHoldsPolicyReleaseError.ordinal()]) {
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
                    jsonGenerator.writeString("legal_hold_performing_another_operation");
                    return;
                case 5:
                    jsonGenerator.writeString("legal_hold_already_releasing");
                    return;
                case 6:
                    jsonGenerator.writeString("legal_hold_policy_not_found");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsPolicyReleaseError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsPolicyReleaseError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsPolicyReleaseError legalHoldsPolicyReleaseError;
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
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.OTHER;
            } else if ("legal_hold_performing_another_operation".equals(tag)) {
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION;
            } else if ("legal_hold_already_releasing".equals(tag)) {
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.LEGAL_HOLD_ALREADY_RELEASING;
            } else if ("legal_hold_policy_not_found".equals(tag)) {
                legalHoldsPolicyReleaseError = LegalHoldsPolicyReleaseError.LEGAL_HOLD_POLICY_NOT_FOUND;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsPolicyReleaseError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsPolicyReleaseError$1 */
    static /* synthetic */ class C43571 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError;

        static {
            int[] iArr = new int[LegalHoldsPolicyReleaseError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError = iArr;
            try {
                iArr[LegalHoldsPolicyReleaseError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[LegalHoldsPolicyReleaseError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[LegalHoldsPolicyReleaseError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[LegalHoldsPolicyReleaseError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[LegalHoldsPolicyReleaseError.LEGAL_HOLD_ALREADY_RELEASING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyReleaseError[LegalHoldsPolicyReleaseError.LEGAL_HOLD_POLICY_NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
