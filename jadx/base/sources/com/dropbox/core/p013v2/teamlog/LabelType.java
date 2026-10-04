package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LabelType {
    PERSONAL_INFORMATION,
    TEST_ONLY,
    USER_DEFINED_TAG,
    OTHER;

    static class Serializer extends UnionSerializer<LabelType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LabelType labelType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44891.$SwitchMap$com$dropbox$core$v2$teamlog$LabelType[labelType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("personal_information");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("test_only");
            } else if (i == 3) {
                jsonGenerator.writeString("user_defined_tag");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LabelType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LabelType labelType;
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
                labelType = LabelType.PERSONAL_INFORMATION;
            } else if ("test_only".equals(tag)) {
                labelType = LabelType.TEST_ONLY;
            } else if ("user_defined_tag".equals(tag)) {
                labelType = LabelType.USER_DEFINED_TAG;
            } else {
                labelType = LabelType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return labelType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.LabelType$1 */
    static /* synthetic */ class C44891 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$LabelType;

        static {
            int[] iArr = new int[LabelType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$LabelType = iArr;
            try {
                iArr[LabelType.PERSONAL_INFORMATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LabelType[LabelType.TEST_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LabelType[LabelType.USER_DEFINED_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
