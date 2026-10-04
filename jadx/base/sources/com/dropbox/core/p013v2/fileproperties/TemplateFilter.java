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
public final class TemplateFilter {
    private Tag _tag;
    private List<String> filterSomeValue;
    public static final TemplateFilter OTHER = new TemplateFilter().withTag(Tag.OTHER);
    public static final TemplateFilter FILTER_NONE = new TemplateFilter().withTag(Tag.FILTER_NONE);

    public enum Tag {
        FILTER_SOME,
        OTHER,
        FILTER_NONE
    }

    private TemplateFilter() {
    }

    private TemplateFilter withTag(Tag tag) {
        TemplateFilter templateFilter = new TemplateFilter();
        templateFilter._tag = tag;
        return templateFilter;
    }

    private TemplateFilter withTagAndFilterSome(Tag tag, List<String> list) {
        TemplateFilter templateFilter = new TemplateFilter();
        templateFilter._tag = tag;
        templateFilter.filterSomeValue = list;
        return templateFilter;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isFilterSome() {
        return this._tag == Tag.FILTER_SOME;
    }

    public static TemplateFilter filterSome(List<String> list) {
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
        return new TemplateFilter().withTagAndFilterSome(Tag.FILTER_SOME, list);
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

    public boolean isFilterNone() {
        return this._tag == Tag.FILTER_NONE;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.filterSomeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TemplateFilter)) {
            return false;
        }
        TemplateFilter templateFilter = (TemplateFilter) obj;
        if (this._tag != templateFilter._tag) {
            return false;
        }
        int i = C41281.$SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        List<String> list = this.filterSomeValue;
        List<String> list2 = templateFilter.filterSomeValue;
        return list == list2 || list.equals(list2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.TemplateFilter$1 */
    static /* synthetic */ class C41281 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag = iArr;
            try {
                iArr[Tag.FILTER_SOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag[Tag.FILTER_NONE.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<TemplateFilter> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TemplateFilter templateFilter, JsonGenerator jsonGenerator) throws IOException {
            int i = C41281.$SwitchMap$com$dropbox$core$v2$fileproperties$TemplateFilter$Tag[templateFilter.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("filter_some", jsonGenerator);
                jsonGenerator.writeFieldName("filter_some");
                StoneSerializers.list(StoneSerializers.string()).serialize(templateFilter.filterSomeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("filter_none");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + templateFilter.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TemplateFilter deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TemplateFilter templateFilterFilterSome;
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
                templateFilterFilterSome = TemplateFilter.filterSome((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                templateFilterFilterSome = TemplateFilter.OTHER;
            } else if ("filter_none".equals(tag)) {
                templateFilterFilterSome = TemplateFilter.FILTER_NONE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return templateFilterFilterSome;
        }
    }
}
