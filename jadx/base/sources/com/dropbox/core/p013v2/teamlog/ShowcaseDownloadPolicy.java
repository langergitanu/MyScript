package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ShowcaseDownloadPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ShowcaseDownloadPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShowcaseDownloadPolicy showcaseDownloadPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45201.$SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseDownloadPolicy[showcaseDownloadPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShowcaseDownloadPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShowcaseDownloadPolicy showcaseDownloadPolicy;
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
                showcaseDownloadPolicy = ShowcaseDownloadPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                showcaseDownloadPolicy = ShowcaseDownloadPolicy.ENABLED;
            } else {
                showcaseDownloadPolicy = ShowcaseDownloadPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return showcaseDownloadPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ShowcaseDownloadPolicy$1 */
    static /* synthetic */ class C45201 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseDownloadPolicy;

        static {
            int[] iArr = new int[ShowcaseDownloadPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseDownloadPolicy = iArr;
            try {
                iArr[ShowcaseDownloadPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseDownloadPolicy[ShowcaseDownloadPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
