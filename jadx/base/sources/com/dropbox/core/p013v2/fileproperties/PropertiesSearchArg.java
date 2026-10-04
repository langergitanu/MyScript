package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertiesSearchQuery;
import com.dropbox.core.p013v2.fileproperties.TemplateFilter;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class PropertiesSearchArg {

    @Nonnull
    protected final List<PropertiesSearchQuery> queries;

    @Nonnull
    protected final TemplateFilter templateFilter;

    public PropertiesSearchArg(@Nonnull List<PropertiesSearchQuery> list, @Nonnull TemplateFilter templateFilter) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'queries' is null");
        }
        if (list.size() < 1) {
            throw new IllegalArgumentException("List 'queries' has fewer than 1 items");
        }
        Iterator<PropertiesSearchQuery> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'queries' is null");
            }
        }
        this.queries = list;
        if (templateFilter == null) {
            throw new IllegalArgumentException("Required value for 'templateFilter' is null");
        }
        this.templateFilter = templateFilter;
    }

    public PropertiesSearchArg(@Nonnull List<PropertiesSearchQuery> list) {
        this(list, TemplateFilter.FILTER_NONE);
    }

    @Nonnull
    public List<PropertiesSearchQuery> getQueries() {
        return this.queries;
    }

    @Nonnull
    public TemplateFilter getTemplateFilter() {
        return this.templateFilter;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.queries, this.templateFilter});
    }

    public boolean equals(Object obj) {
        TemplateFilter templateFilter;
        TemplateFilter templateFilter2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PropertiesSearchArg propertiesSearchArg = (PropertiesSearchArg) obj;
        List<PropertiesSearchQuery> list = this.queries;
        List<PropertiesSearchQuery> list2 = propertiesSearchArg.queries;
        return (list == list2 || list.equals(list2)) && ((templateFilter = this.templateFilter) == (templateFilter2 = propertiesSearchArg.templateFilter) || templateFilter.equals(templateFilter2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertiesSearchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertiesSearchArg propertiesSearchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("queries");
            StoneSerializers.list(PropertiesSearchQuery.Serializer.INSTANCE).serialize(propertiesSearchArg.queries, jsonGenerator);
            jsonGenerator.writeFieldName("template_filter");
            TemplateFilter.Serializer.INSTANCE.serialize(propertiesSearchArg.templateFilter, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertiesSearchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TemplateFilter templateFilterDeserialize = TemplateFilter.FILTER_NONE;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("queries".equals(currentName)) {
                        list = (List) StoneSerializers.list(PropertiesSearchQuery.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("template_filter".equals(currentName)) {
                        templateFilterDeserialize = TemplateFilter.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"queries\" missing.");
                }
                PropertiesSearchArg propertiesSearchArg = new PropertiesSearchArg(list, templateFilterDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertiesSearchArg, propertiesSearchArg.toStringMultiline());
                return propertiesSearchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
