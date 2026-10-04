package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ClassificationType {
    PERSONAL_INFORMATION,
    PII,
    OTHER;

    static class Serializer extends UnionSerializer<ClassificationType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ClassificationType classificationType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44511.$SwitchMap$com$dropbox$core$v2$teamlog$ClassificationType[classificationType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("personal_information");
            } else if (i == 2) {
                jsonGenerator.writeString("pii");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ClassificationType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ClassificationType classificationType;
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
            if ("personal_information".equals(tag)) {
                classificationType = ClassificationType.PERSONAL_INFORMATION;
            } else if ("pii".equals(tag)) {
                classificationType = ClassificationType.PII;
            } else {
                classificationType = ClassificationType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return classificationType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ClassificationType$1 */
    static /* synthetic */ class C44511 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ClassificationType;

        static {
            int[] iArr = new int[ClassificationType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ClassificationType = iArr;
            try {
                iArr[ClassificationType.PERSONAL_INFORMATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ClassificationType[ClassificationType.PII.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
