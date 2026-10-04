package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ClassificationPolicyEnumWrapper {
    DISABLED,
    ENABLED,
    MEMBER_AND_TEAM_FOLDERS,
    TEAM_FOLDERS,
    OTHER;

    static class Serializer extends UnionSerializer<ClassificationPolicyEnumWrapper> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper, JsonGenerator jsonGenerator) throws IOException {
            int i = C44501.f784x4f8c0e4f[classificationPolicyEnumWrapper.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("enabled");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("member_and_team_folders");
            } else if (i == 4) {
                jsonGenerator.writeString("team_folders");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ClassificationPolicyEnumWrapper deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper;
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
                classificationPolicyEnumWrapper = ClassificationPolicyEnumWrapper.DISABLED;
            } else if ("enabled".equals(tag)) {
                classificationPolicyEnumWrapper = ClassificationPolicyEnumWrapper.ENABLED;
            } else if ("member_and_team_folders".equals(tag)) {
                classificationPolicyEnumWrapper = ClassificationPolicyEnumWrapper.MEMBER_AND_TEAM_FOLDERS;
            } else if ("team_folders".equals(tag)) {
                classificationPolicyEnumWrapper = ClassificationPolicyEnumWrapper.TEAM_FOLDERS;
            } else {
                classificationPolicyEnumWrapper = ClassificationPolicyEnumWrapper.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return classificationPolicyEnumWrapper;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ClassificationPolicyEnumWrapper$1 */
    static /* synthetic */ class C44501 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ClassificationPolicyEnumWrapper */
        static final /* synthetic */ int[] f784x4f8c0e4f;

        static {
            int[] iArr = new int[ClassificationPolicyEnumWrapper.values().length];
            f784x4f8c0e4f = iArr;
            try {
                iArr[ClassificationPolicyEnumWrapper.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f784x4f8c0e4f[ClassificationPolicyEnumWrapper.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f784x4f8c0e4f[ClassificationPolicyEnumWrapper.MEMBER_AND_TEAM_FOLDERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f784x4f8c0e4f[ClassificationPolicyEnumWrapper.TEAM_FOLDERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
