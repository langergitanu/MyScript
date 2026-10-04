package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class DownloadZipError {
    private Tag _tag;
    private LookupError pathValue;
    public static final DownloadZipError TOO_LARGE = new DownloadZipError().withTag(Tag.TOO_LARGE);
    public static final DownloadZipError TOO_MANY_FILES = new DownloadZipError().withTag(Tag.TOO_MANY_FILES);
    public static final DownloadZipError OTHER = new DownloadZipError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        TOO_LARGE,
        TOO_MANY_FILES,
        OTHER
    }

    private DownloadZipError() {
    }

    private DownloadZipError withTag(Tag tag) {
        DownloadZipError downloadZipError = new DownloadZipError();
        downloadZipError._tag = tag;
        return downloadZipError;
    }

    private DownloadZipError withTagAndPath(Tag tag, LookupError lookupError) {
        DownloadZipError downloadZipError = new DownloadZipError();
        downloadZipError._tag = tag;
        downloadZipError.pathValue = lookupError;
        return downloadZipError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static DownloadZipError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DownloadZipError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isTooLarge() {
        return this._tag == Tag.TOO_LARGE;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof DownloadZipError)) {
            return false;
        }
        DownloadZipError downloadZipError = (DownloadZipError) obj;
        if (this._tag != downloadZipError._tag) {
            return false;
        }
        int i = C41561.$SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = downloadZipError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DownloadZipError$1 */
    static /* synthetic */ class C41561 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag[Tag.TOO_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<DownloadZipError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DownloadZipError downloadZipError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41561.$SwitchMap$com$dropbox$core$v2$files$DownloadZipError$Tag[downloadZipError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(downloadZipError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("too_large");
            } else if (i == 3) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DownloadZipError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DownloadZipError downloadZipErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                downloadZipErrorPath = DownloadZipError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("too_large".equals(tag)) {
                downloadZipErrorPath = DownloadZipError.TOO_LARGE;
            } else if ("too_many_files".equals(tag)) {
                downloadZipErrorPath = DownloadZipError.TOO_MANY_FILES;
            } else {
                downloadZipErrorPath = DownloadZipError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return downloadZipErrorPath;
        }
    }
}
