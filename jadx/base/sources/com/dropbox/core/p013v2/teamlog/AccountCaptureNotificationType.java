package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AccountCaptureNotificationType {
    ACTIONABLE_NOTIFICATION,
    PROACTIVE_WARNING_NOTIFICATION,
    OTHER;

    static class Serializer extends UnionSerializer<AccountCaptureNotificationType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccountCaptureNotificationType accountCaptureNotificationType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44301.f774x7b2544c9[accountCaptureNotificationType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("actionable_notification");
            } else if (i == 2) {
                jsonGenerator.writeString("proactive_warning_notification");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccountCaptureNotificationType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccountCaptureNotificationType accountCaptureNotificationType;
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
            if ("actionable_notification".equals(tag)) {
                accountCaptureNotificationType = AccountCaptureNotificationType.ACTIONABLE_NOTIFICATION;
            } else if ("proactive_warning_notification".equals(tag)) {
                accountCaptureNotificationType = AccountCaptureNotificationType.PROACTIVE_WARNING_NOTIFICATION;
            } else {
                accountCaptureNotificationType = AccountCaptureNotificationType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accountCaptureNotificationType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AccountCaptureNotificationType$1 */
    static /* synthetic */ class C44301 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AccountCaptureNotificationType */
        static final /* synthetic */ int[] f774x7b2544c9;

        static {
            int[] iArr = new int[AccountCaptureNotificationType.values().length];
            f774x7b2544c9 = iArr;
            try {
                iArr[AccountCaptureNotificationType.ACTIONABLE_NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f774x7b2544c9[AccountCaptureNotificationType.PROACTIVE_WARNING_NOTIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
