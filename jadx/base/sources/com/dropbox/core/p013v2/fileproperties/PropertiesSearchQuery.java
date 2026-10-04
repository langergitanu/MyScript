package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.LogicalOperator;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchMode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.actions.SearchIntents;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class PropertiesSearchQuery {

    @Nonnull
    protected final LogicalOperator logicalOperator;

    @Nonnull
    protected final PropertiesSearchMode mode;

    @Nonnull
    protected final String query;

    public PropertiesSearchQuery(@Nonnull String str, @Nonnull PropertiesSearchMode propertiesSearchMode, @Nonnull LogicalOperator logicalOperator) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        this.query = str;
        if (propertiesSearchMode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = propertiesSearchMode;
        if (logicalOperator == null) {
            throw new IllegalArgumentException("Required value for 'logicalOperator' is null");
        }
        this.logicalOperator = logicalOperator;
    }

    public PropertiesSearchQuery(@Nonnull String str, @Nonnull PropertiesSearchMode propertiesSearchMode) {
        this(str, propertiesSearchMode, LogicalOperator.OR_OPERATOR);
    }

    @Nonnull
    public String getQuery() {
        return this.query;
    }

    @Nonnull
    public PropertiesSearchMode getMode() {
        return this.mode;
    }

    @Nonnull
    public LogicalOperator getLogicalOperator() {
        return this.logicalOperator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.query, this.mode, this.logicalOperator});
    }

    public boolean equals(Object obj) {
        PropertiesSearchMode propertiesSearchMode;
        PropertiesSearchMode propertiesSearchMode2;
        LogicalOperator logicalOperator;
        LogicalOperator logicalOperator2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PropertiesSearchQuery propertiesSearchQuery = (PropertiesSearchQuery) obj;
        String str = this.query;
        String str2 = propertiesSearchQuery.query;
        return (str == str2 || str.equals(str2)) && ((propertiesSearchMode = this.mode) == (propertiesSearchMode2 = propertiesSearchQuery.mode) || propertiesSearchMode.equals(propertiesSearchMode2)) && ((logicalOperator = this.logicalOperator) == (logicalOperator2 = propertiesSearchQuery.logicalOperator) || logicalOperator.equals(logicalOperator2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertiesSearchQuery> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertiesSearchQuery propertiesSearchQuery, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(SearchIntents.EXTRA_QUERY);
            StoneSerializers.string().serialize(propertiesSearchQuery.query, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            PropertiesSearchMode.Serializer.INSTANCE.serialize(propertiesSearchQuery.mode, jsonGenerator);
            jsonGenerator.writeFieldName("logical_operator");
            LogicalOperator.Serializer.INSTANCE.serialize(propertiesSearchQuery.logicalOperator, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertiesSearchQuery deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                LogicalOperator logicalOperatorDeserialize = LogicalOperator.OR_OPERATOR;
                PropertiesSearchMode propertiesSearchModeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (SearchIntents.EXTRA_QUERY.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("mode".equals(currentName)) {
                        propertiesSearchModeDeserialize = PropertiesSearchMode.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("logical_operator".equals(currentName)) {
                        logicalOperatorDeserialize = LogicalOperator.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"query\" missing.");
                }
                if (propertiesSearchModeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"mode\" missing.");
                }
                PropertiesSearchQuery propertiesSearchQuery = new PropertiesSearchQuery(strDeserialize, propertiesSearchModeDeserialize, logicalOperatorDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertiesSearchQuery, propertiesSearchQuery.toStringMultiline());
                return propertiesSearchQuery;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
