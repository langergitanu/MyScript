package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class TemplateError {
    private Tag _tag;
    private String templateNotFoundValue;
    public static final TemplateError RESTRICTED_CONTENT = new TemplateError().withTag(Tag.RESTRICTED_CONTENT);
    public static final TemplateError OTHER = new TemplateError().withTag(Tag.OTHER);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER
    }

    private TemplateError() {
    }

    private TemplateError withTag(Tag tag) {
        TemplateError templateError = new TemplateError();
        templateError._tag = tag;
        return templateError;
    }

    private TemplateError withTagAndTemplateNotFound(Tag tag, String str) {
        TemplateError templateError = new TemplateError();
        templateError._tag = tag;
        templateError.templateNotFoundValue = str;
        return templateError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static TemplateError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new TemplateError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
    }

    public String getTemplateNotFoundValue() {
        if (this._tag != Tag.TEMPLATE_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.TEMPLATE_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.templateNotFoundValue;
    }

    public boolean isRestrictedContent() {
        return this._tag == Tag.RESTRICTED_CONTENT;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.templateNotFoundValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TemplateError)) {
            return false;
        }
        TemplateError templateError = (TemplateError) obj;
        if (this._tag != templateError._tag) {
            return false;
        }
        int i = C41271.$SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        String str = this.templateNotFoundValue;
        String str2 = templateError.templateNotFoundValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.TemplateError$1 */
    static /* synthetic */ class C41271 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag[Tag.OTHER.ordinal()] = 3;
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

    public static class Serializer extends UnionSerializer<TemplateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TemplateError templateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41271.$SwitchMap$com$dropbox$core$v2$fileproperties$TemplateError$Tag[templateError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("restricted_content");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("template_not_found", jsonGenerator);
            jsonGenerator.writeFieldName("template_not_found");
            StoneSerializers.string().serialize(templateError.templateNotFoundValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TemplateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TemplateError templateErrorTemplateNotFound;
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
            if ("template_not_found".equals(tag)) {
                expectField("template_not_found", jsonParser);
                templateErrorTemplateNotFound = TemplateError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                templateErrorTemplateNotFound = TemplateError.RESTRICTED_CONTENT;
            } else {
                templateErrorTemplateNotFound = TemplateError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return templateErrorTemplateNotFound;
        }
    }
}
