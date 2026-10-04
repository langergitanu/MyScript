package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LogicalOperator {
    OR_OPERATOR,
    OTHER;

    static class Serializer extends UnionSerializer<LogicalOperator> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LogicalOperator logicalOperator, JsonGenerator jsonGenerator) throws IOException {
            if (C41181.$SwitchMap$com$dropbox$core$v2$fileproperties$LogicalOperator[logicalOperator.ordinal()] == 1) {
                jsonGenerator.writeString("or_operator");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LogicalOperator deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LogicalOperator logicalOperator;
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
            if ("or_operator".equals(tag)) {
                logicalOperator = LogicalOperator.OR_OPERATOR;
            } else {
                logicalOperator = LogicalOperator.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return logicalOperator;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.LogicalOperator$1 */
    static /* synthetic */ class C41181 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$fileproperties$LogicalOperator;

        static {
            int[] iArr = new int[LogicalOperator.values().length];
            $SwitchMap$com$dropbox$core$v2$fileproperties$LogicalOperator = iArr;
            try {
                iArr[LogicalOperator.OR_OPERATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
