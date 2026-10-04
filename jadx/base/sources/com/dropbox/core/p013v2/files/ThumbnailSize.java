package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ThumbnailSize {
    W32H32,
    W64H64,
    W128H128,
    W256H256,
    W480H320,
    W640H480,
    W960H640,
    W1024H768,
    W2048H1536;

    static class Serializer extends UnionSerializer<ThumbnailSize> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ThumbnailSize thumbnailSize, JsonGenerator jsonGenerator) throws IOException {
            switch (C42101.$SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[thumbnailSize.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("w32h32");
                    return;
                case 2:
                    jsonGenerator.writeString("w64h64");
                    return;
                case 3:
                    jsonGenerator.writeString("w128h128");
                    return;
                case 4:
                    jsonGenerator.writeString("w256h256");
                    return;
                case 5:
                    jsonGenerator.writeString("w480h320");
                    return;
                case 6:
                    jsonGenerator.writeString("w640h480");
                    return;
                case 7:
                    jsonGenerator.writeString("w960h640");
                    return;
                case 8:
                    jsonGenerator.writeString("w1024h768");
                    return;
                case 9:
                    jsonGenerator.writeString("w2048h1536");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + thumbnailSize);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ThumbnailSize deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ThumbnailSize thumbnailSize;
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
            if ("w32h32".equals(tag)) {
                thumbnailSize = ThumbnailSize.W32H32;
            } else if ("w64h64".equals(tag)) {
                thumbnailSize = ThumbnailSize.W64H64;
            } else if ("w128h128".equals(tag)) {
                thumbnailSize = ThumbnailSize.W128H128;
            } else if ("w256h256".equals(tag)) {
                thumbnailSize = ThumbnailSize.W256H256;
            } else if ("w480h320".equals(tag)) {
                thumbnailSize = ThumbnailSize.W480H320;
            } else if ("w640h480".equals(tag)) {
                thumbnailSize = ThumbnailSize.W640H480;
            } else if ("w960h640".equals(tag)) {
                thumbnailSize = ThumbnailSize.W960H640;
            } else if ("w1024h768".equals(tag)) {
                thumbnailSize = ThumbnailSize.W1024H768;
            } else if ("w2048h1536".equals(tag)) {
                thumbnailSize = ThumbnailSize.W2048H1536;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return thumbnailSize;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ThumbnailSize$1 */
    static /* synthetic */ class C42101 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize;

        static {
            int[] iArr = new int[ThumbnailSize.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize = iArr;
            try {
                iArr[ThumbnailSize.W32H32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W64H64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W128H128.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W256H256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W480H320.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W640H480.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W960H640.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W1024H768.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailSize[ThumbnailSize.W2048H1536.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
