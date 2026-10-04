package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileCommentNotificationPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<FileCommentNotificationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileCommentNotificationPolicy fileCommentNotificationPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44761.f790x9d36e3b5[fileCommentNotificationPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileCommentNotificationPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileCommentNotificationPolicy fileCommentNotificationPolicy;
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
                fileCommentNotificationPolicy = FileCommentNotificationPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileCommentNotificationPolicy = FileCommentNotificationPolicy.ENABLED;
            } else {
                fileCommentNotificationPolicy = FileCommentNotificationPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileCommentNotificationPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FileCommentNotificationPolicy$1 */
    static /* synthetic */ class C44761 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$FileCommentNotificationPolicy */
        static final /* synthetic */ int[] f790x9d36e3b5;

        static {
            int[] iArr = new int[FileCommentNotificationPolicy.values().length];
            f790x9d36e3b5 = iArr;
            try {
                iArr[FileCommentNotificationPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f790x9d36e3b5[FileCommentNotificationPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
