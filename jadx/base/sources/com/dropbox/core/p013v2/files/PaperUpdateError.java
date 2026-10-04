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
public final class PaperUpdateError {
    private Tag _tag;
    private LookupError pathValue;
    public static final PaperUpdateError INSUFFICIENT_PERMISSIONS = new PaperUpdateError().withTag(Tag.INSUFFICIENT_PERMISSIONS);
    public static final PaperUpdateError CONTENT_MALFORMED = new PaperUpdateError().withTag(Tag.CONTENT_MALFORMED);
    public static final PaperUpdateError DOC_LENGTH_EXCEEDED = new PaperUpdateError().withTag(Tag.DOC_LENGTH_EXCEEDED);
    public static final PaperUpdateError IMAGE_SIZE_EXCEEDED = new PaperUpdateError().withTag(Tag.IMAGE_SIZE_EXCEEDED);
    public static final PaperUpdateError OTHER = new PaperUpdateError().withTag(Tag.OTHER);
    public static final PaperUpdateError REVISION_MISMATCH = new PaperUpdateError().withTag(Tag.REVISION_MISMATCH);
    public static final PaperUpdateError DOC_ARCHIVED = new PaperUpdateError().withTag(Tag.DOC_ARCHIVED);
    public static final PaperUpdateError DOC_DELETED = new PaperUpdateError().withTag(Tag.DOC_DELETED);

    public enum Tag {
        INSUFFICIENT_PERMISSIONS,
        CONTENT_MALFORMED,
        DOC_LENGTH_EXCEEDED,
        IMAGE_SIZE_EXCEEDED,
        OTHER,
        PATH,
        REVISION_MISMATCH,
        DOC_ARCHIVED,
        DOC_DELETED
    }

    private PaperUpdateError() {
    }

    private PaperUpdateError withTag(Tag tag) {
        PaperUpdateError paperUpdateError = new PaperUpdateError();
        paperUpdateError._tag = tag;
        return paperUpdateError;
    }

    private PaperUpdateError withTagAndPath(Tag tag, LookupError lookupError) {
        PaperUpdateError paperUpdateError = new PaperUpdateError();
        paperUpdateError._tag = tag;
        paperUpdateError.pathValue = lookupError;
        return paperUpdateError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInsufficientPermissions() {
        return this._tag == Tag.INSUFFICIENT_PERMISSIONS;
    }

    public boolean isContentMalformed() {
        return this._tag == Tag.CONTENT_MALFORMED;
    }

    public boolean isDocLengthExceeded() {
        return this._tag == Tag.DOC_LENGTH_EXCEEDED;
    }

    public boolean isImageSizeExceeded() {
        return this._tag == Tag.IMAGE_SIZE_EXCEEDED;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static PaperUpdateError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PaperUpdateError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isRevisionMismatch() {
        return this._tag == Tag.REVISION_MISMATCH;
    }

    public boolean isDocArchived() {
        return this._tag == Tag.DOC_ARCHIVED;
    }

    public boolean isDocDeleted() {
        return this._tag == Tag.DOC_DELETED;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PaperUpdateError)) {
            return false;
        }
        PaperUpdateError paperUpdateError = (PaperUpdateError) obj;
        if (this._tag != paperUpdateError._tag) {
            return false;
        }
        switch (C41811.$SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[this._tag.ordinal()]) {
            case 6:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = paperUpdateError.pathValue;
                if (lookupError != lookupError2 && !lookupError.equals(lookupError2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.PaperUpdateError$1 */
    static /* synthetic */ class C41811 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag = iArr;
            try {
                iArr[Tag.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.CONTENT_MALFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.DOC_LENGTH_EXCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.IMAGE_SIZE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.PATH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.REVISION_MISMATCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.DOC_ARCHIVED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[Tag.DOC_DELETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<PaperUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperUpdateError paperUpdateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41811.$SwitchMap$com$dropbox$core$v2$files$PaperUpdateError$Tag[paperUpdateError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 2:
                    jsonGenerator.writeString("content_malformed");
                    return;
                case 3:
                    jsonGenerator.writeString("doc_length_exceeded");
                    return;
                case 4:
                    jsonGenerator.writeString("image_size_exceeded");
                    return;
                case 5:
                    jsonGenerator.writeString("other");
                    return;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                    jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                    LookupError.Serializer.INSTANCE.serialize(paperUpdateError.pathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 7:
                    jsonGenerator.writeString("revision_mismatch");
                    return;
                case 8:
                    jsonGenerator.writeString("doc_archived");
                    return;
                case 9:
                    jsonGenerator.writeString("doc_deleted");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + paperUpdateError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperUpdateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperUpdateError paperUpdateErrorPath;
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
            if ("insufficient_permissions".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.INSUFFICIENT_PERMISSIONS;
            } else if ("content_malformed".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.CONTENT_MALFORMED;
            } else if ("doc_length_exceeded".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.DOC_LENGTH_EXCEEDED;
            } else if ("image_size_exceeded".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.IMAGE_SIZE_EXCEEDED;
            } else if ("other".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.OTHER;
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                paperUpdateErrorPath = PaperUpdateError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("revision_mismatch".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.REVISION_MISMATCH;
            } else if ("doc_archived".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.DOC_ARCHIVED;
            } else if ("doc_deleted".equals(tag)) {
                paperUpdateErrorPath = PaperUpdateError.DOC_DELETED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperUpdateErrorPath;
        }
    }
}
