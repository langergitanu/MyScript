package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharingFileAccessError {
    NO_PERMISSION,
    INVALID_FILE,
    IS_FOLDER,
    INSIDE_PUBLIC_FOLDER,
    INSIDE_OSX_PACKAGE,
    OTHER;

    static class Serializer extends UnionSerializer<SharingFileAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingFileAccessError sharingFileAccessError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43081.$SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError[sharingFileAccessError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("no_permission");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invalid_file");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("is_folder");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("inside_public_folder");
            } else if (i == 5) {
                jsonGenerator.writeString("inside_osx_package");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingFileAccessError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingFileAccessError sharingFileAccessError;
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
            if ("no_permission".equals(tag)) {
                sharingFileAccessError = SharingFileAccessError.NO_PERMISSION;
            } else if ("invalid_file".equals(tag)) {
                sharingFileAccessError = SharingFileAccessError.INVALID_FILE;
            } else if ("is_folder".equals(tag)) {
                sharingFileAccessError = SharingFileAccessError.IS_FOLDER;
            } else if ("inside_public_folder".equals(tag)) {
                sharingFileAccessError = SharingFileAccessError.INSIDE_PUBLIC_FOLDER;
            } else if ("inside_osx_package".equals(tag)) {
                sharingFileAccessError = SharingFileAccessError.INSIDE_OSX_PACKAGE;
            } else {
                sharingFileAccessError = SharingFileAccessError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingFileAccessError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharingFileAccessError$1 */
    static /* synthetic */ class C43081 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError;

        static {
            int[] iArr = new int[SharingFileAccessError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError = iArr;
            try {
                iArr[SharingFileAccessError.NO_PERMISSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError[SharingFileAccessError.INVALID_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError[SharingFileAccessError.IS_FOLDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError[SharingFileAccessError.INSIDE_PUBLIC_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharingFileAccessError[SharingFileAccessError.INSIDE_OSX_PACKAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
