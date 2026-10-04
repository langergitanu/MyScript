package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum GetThumbnailBatchError {
    TOO_MANY_FILES,
    OTHER;

    static class Serializer extends UnionSerializer<GetThumbnailBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetThumbnailBatchError getThumbnailBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C41641.$SwitchMap$com$dropbox$core$v2$files$GetThumbnailBatchError[getThumbnailBatchError.ordinal()] == 1) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetThumbnailBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetThumbnailBatchError getThumbnailBatchError;
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
            if ("too_many_files".equals(tag)) {
                getThumbnailBatchError = GetThumbnailBatchError.TOO_MANY_FILES;
            } else {
                getThumbnailBatchError = GetThumbnailBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getThumbnailBatchError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.GetThumbnailBatchError$1 */
    static /* synthetic */ class C41641 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$GetThumbnailBatchError;

        static {
            int[] iArr = new int[GetThumbnailBatchError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$GetThumbnailBatchError = iArr;
            try {
                iArr[GetThumbnailBatchError.TOO_MANY_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
