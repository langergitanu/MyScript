package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum FileStatus {
    ACTIVE,
    DELETED,
    OTHER;

    static class Serializer extends UnionSerializer<FileStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileStatus fileStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41601.$SwitchMap$com$dropbox$core$v2$files$FileStatus[fileStatus.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            } else if (i == 2) {
                jsonGenerator.writeString("deleted");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileStatus fileStatus;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                fileStatus = FileStatus.ACTIVE;
            } else if ("deleted".equals(tag)) {
                fileStatus = FileStatus.DELETED;
            } else {
                fileStatus = FileStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.FileStatus$1 */
    static /* synthetic */ class C41601 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$FileStatus;

        static {
            int[] iArr = new int[FileStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$files$FileStatus = iArr;
            try {
                iArr[FileStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileStatus[FileStatus.DELETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
