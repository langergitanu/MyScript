package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AddSecondaryEmailsError {
    SECONDARY_EMAILS_DISABLED,
    TOO_MANY_EMAILS,
    OTHER;

    static class Serializer extends UnionSerializer<AddSecondaryEmailsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddSecondaryEmailsError addSecondaryEmailsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43201.$SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailsError[addSecondaryEmailsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("secondary_emails_disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("too_many_emails");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddSecondaryEmailsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddSecondaryEmailsError addSecondaryEmailsError;
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
            if ("secondary_emails_disabled".equals(tag)) {
                addSecondaryEmailsError = AddSecondaryEmailsError.SECONDARY_EMAILS_DISABLED;
            } else if ("too_many_emails".equals(tag)) {
                addSecondaryEmailsError = AddSecondaryEmailsError.TOO_MANY_EMAILS;
            } else {
                addSecondaryEmailsError = AddSecondaryEmailsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addSecondaryEmailsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.AddSecondaryEmailsError$1 */
    static /* synthetic */ class C43201 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailsError;

        static {
            int[] iArr = new int[AddSecondaryEmailsError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailsError = iArr;
            try {
                iArr[AddSecondaryEmailsError.SECONDARY_EMAILS_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailsError[AddSecondaryEmailsError.TOO_MANY_EMAILS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
