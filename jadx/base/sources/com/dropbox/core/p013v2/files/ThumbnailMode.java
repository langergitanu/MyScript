package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ThumbnailMode {
    STRICT,
    BESTFIT,
    FITONE_BESTFIT;

    static class Serializer extends UnionSerializer<ThumbnailMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ThumbnailMode thumbnailMode, JsonGenerator jsonGenerator) throws IOException {
            int i = C42091.$SwitchMap$com$dropbox$core$v2$files$ThumbnailMode[thumbnailMode.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("strict");
            } else if (i == 2) {
                jsonGenerator.writeString("bestfit");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("fitone_bestfit");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + thumbnailMode);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ThumbnailMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ThumbnailMode thumbnailMode;
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
            if ("strict".equals(tag)) {
                thumbnailMode = ThumbnailMode.STRICT;
            } else if ("bestfit".equals(tag)) {
                thumbnailMode = ThumbnailMode.BESTFIT;
            } else if ("fitone_bestfit".equals(tag)) {
                thumbnailMode = ThumbnailMode.FITONE_BESTFIT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return thumbnailMode;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ThumbnailMode$1 */
    static /* synthetic */ class C42091 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ThumbnailMode;

        static {
            int[] iArr = new int[ThumbnailMode.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ThumbnailMode = iArr;
            try {
                iArr[ThumbnailMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailMode[ThumbnailMode.BESTFIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailMode[ThumbnailMode.FITONE_BESTFIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
