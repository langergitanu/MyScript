package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ThumbnailFormat {
    JPEG,
    PNG;

    static class Serializer extends UnionSerializer<ThumbnailFormat> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ThumbnailFormat thumbnailFormat, JsonGenerator jsonGenerator) throws IOException {
            int i = C42081.$SwitchMap$com$dropbox$core$v2$files$ThumbnailFormat[thumbnailFormat.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("jpeg");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("png");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + thumbnailFormat);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ThumbnailFormat deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ThumbnailFormat thumbnailFormat;
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
            if ("jpeg".equals(tag)) {
                thumbnailFormat = ThumbnailFormat.JPEG;
            } else if ("png".equals(tag)) {
                thumbnailFormat = ThumbnailFormat.PNG;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return thumbnailFormat;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ThumbnailFormat$1 */
    static /* synthetic */ class C42081 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ThumbnailFormat;

        static {
            int[] iArr = new int[ThumbnailFormat.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ThumbnailFormat = iArr;
            try {
                iArr[ThumbnailFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailFormat[ThumbnailFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
