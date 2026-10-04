package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileProviderMigrationPolicyState {
    DISABLED,
    ENABLED,
    DEFAULT,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.FileProviderMigrationPolicyState$1 */
    static /* synthetic */ class C45451 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$FileProviderMigrationPolicyState */
        static final /* synthetic */ int[] f806xa0f95d87;

        static {
            int[] iArr = new int[FileProviderMigrationPolicyState.values().length];
            f806xa0f95d87 = iArr;
            try {
                iArr[FileProviderMigrationPolicyState.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f806xa0f95d87[FileProviderMigrationPolicyState.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f806xa0f95d87[FileProviderMigrationPolicyState.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<FileProviderMigrationPolicyState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileProviderMigrationPolicyState fileProviderMigrationPolicyState, JsonGenerator jsonGenerator) throws IOException {
            int i = C45451.f806xa0f95d87[fileProviderMigrationPolicyState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else if (i == 3) {
                jsonGenerator.writeString("default");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileProviderMigrationPolicyState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileProviderMigrationPolicyState fileProviderMigrationPolicyState;
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
                fileProviderMigrationPolicyState = FileProviderMigrationPolicyState.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileProviderMigrationPolicyState = FileProviderMigrationPolicyState.ENABLED;
            } else if ("default".equals(tag)) {
                fileProviderMigrationPolicyState = FileProviderMigrationPolicyState.DEFAULT;
            } else {
                fileProviderMigrationPolicyState = FileProviderMigrationPolicyState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileProviderMigrationPolicyState;
        }
    }
}
