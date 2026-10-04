package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FolderLinkRestrictionPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<FolderLinkRestrictionPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FolderLinkRestrictionPolicy folderLinkRestrictionPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44801.f791x68172bcb[folderLinkRestrictionPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FolderLinkRestrictionPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FolderLinkRestrictionPolicy folderLinkRestrictionPolicy;
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
                folderLinkRestrictionPolicy = FolderLinkRestrictionPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                folderLinkRestrictionPolicy = FolderLinkRestrictionPolicy.ENABLED;
            } else {
                folderLinkRestrictionPolicy = FolderLinkRestrictionPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return folderLinkRestrictionPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FolderLinkRestrictionPolicy$1 */
    static /* synthetic */ class C44801 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$FolderLinkRestrictionPolicy */
        static final /* synthetic */ int[] f791x68172bcb;

        static {
            int[] iArr = new int[FolderLinkRestrictionPolicy.values().length];
            f791x68172bcb = iArr;
            try {
                iArr[FolderLinkRestrictionPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f791x68172bcb[FolderLinkRestrictionPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
