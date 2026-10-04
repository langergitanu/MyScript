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
public final class DownloadError {
    private Tag _tag;
    private LookupError pathValue;
    public static final DownloadError UNSUPPORTED_FILE = new DownloadError().withTag(Tag.UNSUPPORTED_FILE);
    public static final DownloadError OTHER = new DownloadError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        UNSUPPORTED_FILE,
        OTHER
    }

    private DownloadError() {
    }

    private DownloadError withTag(Tag tag) {
        DownloadError downloadError = new DownloadError();
        downloadError._tag = tag;
        return downloadError;
    }

    private DownloadError withTagAndPath(Tag tag, LookupError lookupError) {
        DownloadError downloadError = new DownloadError();
        downloadError._tag = tag;
        downloadError.pathValue = lookupError;
        return downloadError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static DownloadError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DownloadError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isUnsupportedFile() {
        return this._tag == Tag.UNSUPPORTED_FILE;
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
        if (obj == null || !(obj instanceof DownloadError)) {
            return false;
        }
        DownloadError downloadError = (DownloadError) obj;
        if (this._tag != downloadError._tag) {
            return false;
        }
        int i = C41551.$SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = downloadError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DownloadError$1 */
    static /* synthetic */ class C41551 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag[Tag.UNSUPPORTED_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<DownloadError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DownloadError downloadError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41551.$SwitchMap$com$dropbox$core$v2$files$DownloadError$Tag[downloadError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("unsupported_file");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            LookupError.Serializer.INSTANCE.serialize(downloadError.pathValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DownloadError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DownloadError downloadErrorPath;
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
                downloadErrorPath = DownloadError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_file".equals(tag)) {
                downloadErrorPath = DownloadError.UNSUPPORTED_FILE;
            } else {
                downloadErrorPath = DownloadError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return downloadErrorPath;
        }
    }
}
