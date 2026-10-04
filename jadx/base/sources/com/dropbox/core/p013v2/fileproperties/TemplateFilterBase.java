package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class TemplateFilterBase {
    public static final TemplateFilterBase OTHER = new TemplateFilterBase().withTag(Tag.OTHER);
    private Tag _tag;
    private List<String> filterSomeValue;

    public enum Tag {
        FILTER_SOME,
        OTHER
    }

    private TemplateFilterBase() {
    }

    private TemplateFilterBase withTag(Tag tag) {
        TemplateFilterBase templateFilterBase = new TemplateFilterBase();
        templateFilterBase._tag = tag;
        return templateFilterBase;
    }

    private TemplateFilterBase withTagAndFilterSome(Tag tag, List<String> list) {
        TemplateFilterBase templateFilterBase = new TemplateFilterBase();
        templateFilterBase._tag = tag;
        templateFilterBase.filterSomeValue = list;
        return templateFilterBase;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isFilterSome() {
        return this._tag == Tag.FILTER_SOME;
    }

    public static TemplateFilterBase filterSome(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (list.size() < 1) {
            throw new IllegalArgumentException("List has fewer than 1 items");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", str)) {
                throw new IllegalArgumentException("Stringan item in list does not match pattern");
            }
        }
        return new TemplateFilterBase().withTagAndFilterSome(Tag.FILTER_SOME, list);
    }

    public List<String> getFilterSomeValue() {
        if (this._tag != Tag.FILTER_SOME) {
            throw new IllegalStateException("Invalid tag: required Tag.FILTER_SOME, but was Tag." + this._tag.name());
        }
        return this.filterSomeValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.filterSomeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TemplateFilterBase)) {
            return false;
        }
        TemplateFilterBase templateFilterBase = (TemplateFilterBase) obj;
        if (this._tag != templateFilterBase._tag) {
            return false;
        }
        int i = C41291.f676x2475bde0[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        List<String> list = this.filterSomeValue;
        List<String> list2 = templateFilterBase.filterSomeValue;
        return list == list2 || list.equals(list2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.TemplateFilterBase$1 */
    static /* synthetic */ class C41291 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilterBase$Tag */
        static final /* synthetic */ int[] f676x2475bde0;

        static {
            int[] iArr = new int[Tag.values().length];
            f676x2475bde0 = iArr;
            try {
                iArr[Tag.FILTER_SOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f676x2475bde0[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<TemplateFilterBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TemplateFilterBase templateFilterBase, JsonGenerator jsonGenerator) throws IOException {
            if (C41291.f676x2475bde0[templateFilterBase.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("filter_some", jsonGenerator);
                jsonGenerator.writeFieldName("filter_some");
                StoneSerializers.list(StoneSerializers.string()).serialize(templateFilterBase.filterSomeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TemplateFilterBase deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TemplateFilterBase templateFilterBaseFilterSome;
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
            if ("filter_some".equals(tag)) {
                expectField("filter_some", jsonParser);
                templateFilterBaseFilterSome = TemplateFilterBase.filterSome((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else {
                templateFilterBaseFilterSome = TemplateFilterBase.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return templateFilterBaseFilterSome;
        }
    }
}
