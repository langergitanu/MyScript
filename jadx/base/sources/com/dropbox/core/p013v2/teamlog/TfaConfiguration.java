package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TfaConfiguration {
    AUTHENTICATOR,
    DISABLED,
    ENABLED,
    SMS,
    OTHER;

    static class Serializer extends UnionSerializer<TfaConfiguration> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TfaConfiguration tfaConfiguration, JsonGenerator jsonGenerator) throws IOException {
            int i = C45341.$SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration[tfaConfiguration.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("authenticator");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("enabled");
            } else if (i == 4) {
                jsonGenerator.writeString("sms");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TfaConfiguration deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TfaConfiguration tfaConfiguration;
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
            if ("authenticator".equals(tag)) {
                tfaConfiguration = TfaConfiguration.AUTHENTICATOR;
            } else if ("disabled".equals(tag)) {
                tfaConfiguration = TfaConfiguration.DISABLED;
            } else if ("enabled".equals(tag)) {
                tfaConfiguration = TfaConfiguration.ENABLED;
            } else if ("sms".equals(tag)) {
                tfaConfiguration = TfaConfiguration.SMS;
            } else {
                tfaConfiguration = TfaConfiguration.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return tfaConfiguration;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TfaConfiguration$1 */
    static /* synthetic */ class C45341 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration;

        static {
            int[] iArr = new int[TfaConfiguration.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration = iArr;
            try {
                iArr[TfaConfiguration.AUTHENTICATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration[TfaConfiguration.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration[TfaConfiguration.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TfaConfiguration[TfaConfiguration.SMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
