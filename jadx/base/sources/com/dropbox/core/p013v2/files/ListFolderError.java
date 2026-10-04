package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.TemplateError;
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
public final class ListFolderError {
    public static final ListFolderError OTHER = new ListFolderError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookupError pathValue;
    private TemplateError templateErrorValue;

    public enum Tag {
        PATH,
        TEMPLATE_ERROR,
        OTHER
    }

    private ListFolderError() {
    }

    private ListFolderError withTag(Tag tag) {
        ListFolderError listFolderError = new ListFolderError();
        listFolderError._tag = tag;
        return listFolderError;
    }

    private ListFolderError withTagAndPath(Tag tag, LookupError lookupError) {
        ListFolderError listFolderError = new ListFolderError();
        listFolderError._tag = tag;
        listFolderError.pathValue = lookupError;
        return listFolderError;
    }

    private ListFolderError withTagAndTemplateError(Tag tag, TemplateError templateError) {
        ListFolderError listFolderError = new ListFolderError();
        listFolderError._tag = tag;
        listFolderError.templateErrorValue = templateError;
        return listFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ListFolderError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFolderError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isTemplateError() {
        return this._tag == Tag.TEMPLATE_ERROR;
    }

    public static ListFolderError templateError(TemplateError templateError) {
        if (templateError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFolderError().withTagAndTemplateError(Tag.TEMPLATE_ERROR, templateError);
    }

    public TemplateError getTemplateErrorValue() {
        if (this._tag != Tag.TEMPLATE_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.TEMPLATE_ERROR, but was Tag." + this._tag.name());
        }
        return this.templateErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.templateErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListFolderError)) {
            return false;
        }
        ListFolderError listFolderError = (ListFolderError) obj;
        if (this._tag != listFolderError._tag) {
            return false;
        }
        int i = C41681.$SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathValue;
            LookupError lookupError2 = listFolderError.pathValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            return i == 3;
        }
        TemplateError templateError = this.templateErrorValue;
        TemplateError templateError2 = listFolderError.templateErrorValue;
        return templateError == templateError2 || templateError.equals(templateError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ListFolderError$1 */
    static /* synthetic */ class C41681 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag[Tag.TEMPLATE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ListFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFolderError listFolderError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41681.$SwitchMap$com$dropbox$core$v2$files$ListFolderError$Tag[listFolderError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(listFolderError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("template_error", jsonGenerator);
                jsonGenerator.writeFieldName("template_error");
                TemplateError.Serializer.INSTANCE.serialize(listFolderError.templateErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFolderError listFolderErrorTemplateError;
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
                listFolderErrorTemplateError = ListFolderError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("template_error".equals(tag)) {
                expectField("template_error", jsonParser);
                listFolderErrorTemplateError = ListFolderError.templateError(TemplateError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                listFolderErrorTemplateError = ListFolderError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFolderErrorTemplateError;
        }
    }
}
