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
public final class ModifyTemplateError {
    private Tag _tag;
    private String templateNotFoundValue;
    public static final ModifyTemplateError RESTRICTED_CONTENT = new ModifyTemplateError().withTag(Tag.RESTRICTED_CONTENT);
    public static final ModifyTemplateError OTHER = new ModifyTemplateError().withTag(Tag.OTHER);
    public static final ModifyTemplateError CONFLICTING_PROPERTY_NAMES = new ModifyTemplateError().withTag(Tag.CONFLICTING_PROPERTY_NAMES);
    public static final ModifyTemplateError TOO_MANY_PROPERTIES = new ModifyTemplateError().withTag(Tag.TOO_MANY_PROPERTIES);
    public static final ModifyTemplateError TOO_MANY_TEMPLATES = new ModifyTemplateError().withTag(Tag.TOO_MANY_TEMPLATES);
    public static final ModifyTemplateError TEMPLATE_ATTRIBUTE_TOO_LARGE = new ModifyTemplateError().withTag(Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER,
        CONFLICTING_PROPERTY_NAMES,
        TOO_MANY_PROPERTIES,
        TOO_MANY_TEMPLATES,
        TEMPLATE_ATTRIBUTE_TOO_LARGE
    }

    private ModifyTemplateError() {
    }

    private ModifyTemplateError withTag(Tag tag) {
        ModifyTemplateError modifyTemplateError = new ModifyTemplateError();
        modifyTemplateError._tag = tag;
        return modifyTemplateError;
    }

    private ModifyTemplateError withTagAndTemplateNotFound(Tag tag, String str) {
        ModifyTemplateError modifyTemplateError = new ModifyTemplateError();
        modifyTemplateError._tag = tag;
        modifyTemplateError.templateNotFoundValue = str;
        return modifyTemplateError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static ModifyTemplateError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ModifyTemplateError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
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

    public boolean isConflictingPropertyNames() {
        return this._tag == Tag.CONFLICTING_PROPERTY_NAMES;
    }

    public boolean isTooManyProperties() {
        return this._tag == Tag.TOO_MANY_PROPERTIES;
    }

    public boolean isTooManyTemplates() {
        return this._tag == Tag.TOO_MANY_TEMPLATES;
    }

    public boolean isTemplateAttributeTooLarge() {
        return this._tag == Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.templateNotFoundValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifyTemplateError)) {
            return false;
        }
        ModifyTemplateError modifyTemplateError = (ModifyTemplateError) obj;
        if (this._tag != modifyTemplateError._tag) {
            return false;
        }
        switch (C41211.f670x83e092c3[this._tag.ordinal()]) {
            case 1:
                String str = this.templateNotFoundValue;
                String str2 = modifyTemplateError.templateNotFoundValue;
                return str == str2 || str.equals(str2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.ModifyTemplateError$1 */
    static /* synthetic */ class C41211 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$ModifyTemplateError$Tag */
        static final /* synthetic */ int[] f670x83e092c3;

        static {
            int[] iArr = new int[Tag.values().length];
            f670x83e092c3 = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f670x83e092c3[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f670x83e092c3[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f670x83e092c3[Tag.CONFLICTING_PROPERTY_NAMES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f670x83e092c3[Tag.TOO_MANY_PROPERTIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f670x83e092c3[Tag.TOO_MANY_TEMPLATES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f670x83e092c3[Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<ModifyTemplateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ModifyTemplateError modifyTemplateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41211.f670x83e092c3[modifyTemplateError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("template_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(modifyTemplateError.templateNotFoundValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 2:
                    jsonGenerator.writeString("restricted_content");
                    return;
                case 3:
                    jsonGenerator.writeString("other");
                    return;
                case 4:
                    jsonGenerator.writeString("conflicting_property_names");
                    return;
                case 5:
                    jsonGenerator.writeString("too_many_properties");
                    return;
                case 6:
                    jsonGenerator.writeString("too_many_templates");
                    return;
                case 7:
                    jsonGenerator.writeString("template_attribute_too_large");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + modifyTemplateError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ModifyTemplateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ModifyTemplateError modifyTemplateErrorTemplateNotFound;
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
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.RESTRICTED_CONTENT;
            } else if ("other".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.OTHER;
            } else if ("conflicting_property_names".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.CONFLICTING_PROPERTY_NAMES;
            } else if ("too_many_properties".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.TOO_MANY_PROPERTIES;
            } else if ("too_many_templates".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.TOO_MANY_TEMPLATES;
            } else if ("template_attribute_too_large".equals(tag)) {
                modifyTemplateErrorTemplateNotFound = ModifyTemplateError.TEMPLATE_ATTRIBUTE_TOO_LARGE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return modifyTemplateErrorTemplateNotFound;
        }
    }
}
