package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DownloadPolicyType {
    ALLOW,
    DISALLOW,
    OTHER;

    static class Serializer extends UnionSerializer<DownloadPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DownloadPolicyType downloadPolicyType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44601.$SwitchMap$com$dropbox$core$v2$teamlog$DownloadPolicyType[downloadPolicyType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("allow");
            } else if (i == 2) {
                jsonGenerator.writeString("disallow");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DownloadPolicyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DownloadPolicyType downloadPolicyType;
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
            if ("allow".equals(tag)) {
                downloadPolicyType = DownloadPolicyType.ALLOW;
            } else if ("disallow".equals(tag)) {
                downloadPolicyType = DownloadPolicyType.DISALLOW;
            } else {
                downloadPolicyType = DownloadPolicyType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return downloadPolicyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DownloadPolicyType$1 */
    static /* synthetic */ class C44601 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DownloadPolicyType;

        static {
            int[] iArr = new int[DownloadPolicyType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DownloadPolicyType = iArr;
            try {
                iArr[DownloadPolicyType.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DownloadPolicyType[DownloadPolicyType.DISALLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
