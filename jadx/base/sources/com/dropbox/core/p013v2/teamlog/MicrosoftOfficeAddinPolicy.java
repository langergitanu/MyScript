package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MicrosoftOfficeAddinPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<MicrosoftOfficeAddinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44981.f794x3a8fd3b9[microsoftOfficeAddinPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MicrosoftOfficeAddinPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy;
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
            if ("disabled".equals(tag)) {
                microsoftOfficeAddinPolicy = MicrosoftOfficeAddinPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                microsoftOfficeAddinPolicy = MicrosoftOfficeAddinPolicy.ENABLED;
            } else {
                microsoftOfficeAddinPolicy = MicrosoftOfficeAddinPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return microsoftOfficeAddinPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MicrosoftOfficeAddinPolicy$1 */
    static /* synthetic */ class C44981 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$MicrosoftOfficeAddinPolicy */
        static final /* synthetic */ int[] f794x3a8fd3b9;

        static {
            int[] iArr = new int[MicrosoftOfficeAddinPolicy.values().length];
            f794x3a8fd3b9 = iArr;
            try {
                iArr[MicrosoftOfficeAddinPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f794x3a8fd3b9[MicrosoftOfficeAddinPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
