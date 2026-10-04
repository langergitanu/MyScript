package com.dropbox.core.stone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class StoneSerializers {
    public static StoneSerializer<Long> uInt64() {
        return LongSerializer.INSTANCE;
    }

    public static StoneSerializer<Long> int64() {
        return LongSerializer.INSTANCE;
    }

    public static StoneSerializer<Long> uInt32() {
        return LongSerializer.INSTANCE;
    }

    public static StoneSerializer<Integer> int32() {
        return IntSerializer.INSTANCE;
    }

    public static StoneSerializer<Double> float64() {
        return DoubleSerializer.INSTANCE;
    }

    public static StoneSerializer<Float> float32() {
        return FloatSerializer.INSTANCE;
    }

    public static StoneSerializer<Boolean> boolean_() {
        return BooleanSerializer.INSTANCE;
    }

    public static StoneSerializer<byte[]> bytes() {
        return ByteArraySerializer.INSTANCE;
    }

    public static StoneSerializer<String> string() {
        return StringSerializer.INSTANCE;
    }

    public static StoneSerializer<Date> timestamp() {
        return DateSerializer.INSTANCE;
    }

    public static StoneSerializer<Void> void_() {
        return VoidSerializer.INSTANCE;
    }

    public static <T> StoneSerializer<T> nullable(StoneSerializer<T> stoneSerializer) {
        return new NullableSerializer(stoneSerializer);
    }

    public static <T> StructSerializer<T> nullableStruct(StructSerializer<T> structSerializer) {
        return new NullableStructSerializer(structSerializer);
    }

    public static <T> StoneSerializer<List<T>> list(StoneSerializer<T> stoneSerializer) {
        return new ListSerializer(stoneSerializer);
    }

    public static <T> StoneSerializer<Map<String, T>> map(StoneSerializer<T> stoneSerializer) {
        return new MapSerializer(stoneSerializer);
    }

    private static final class LongSerializer extends StoneSerializer<Long> {
        public static final LongSerializer INSTANCE = new LongSerializer();

        private LongSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Long l, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeNumber(l.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public Long deserialize(JsonParser jsonParser) throws IOException {
            Long lValueOf = Long.valueOf(jsonParser.getLongValue());
            jsonParser.nextToken();
            return lValueOf;
        }
    }

    private static final class IntSerializer extends StoneSerializer<Integer> {
        public static final IntSerializer INSTANCE = new IntSerializer();

        private IntSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Integer num, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeNumber(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public Integer deserialize(JsonParser jsonParser) throws IOException {
            Integer numValueOf = Integer.valueOf(jsonParser.getIntValue());
            jsonParser.nextToken();
            return numValueOf;
        }
    }

    private static final class DoubleSerializer extends StoneSerializer<Double> {
        public static final DoubleSerializer INSTANCE = new DoubleSerializer();

        private DoubleSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Double d, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeNumber(d.doubleValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public Double deserialize(JsonParser jsonParser) throws IOException {
            Double dValueOf = Double.valueOf(jsonParser.getDoubleValue());
            jsonParser.nextToken();
            return dValueOf;
        }
    }

    private static final class FloatSerializer extends StoneSerializer<Float> {
        public static final FloatSerializer INSTANCE = new FloatSerializer();

        private FloatSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Float f, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeNumber(f.floatValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public Float deserialize(JsonParser jsonParser) throws IOException {
            Float fValueOf = Float.valueOf(jsonParser.getFloatValue());
            jsonParser.nextToken();
            return fValueOf;
        }
    }

    private static final class BooleanSerializer extends StoneSerializer<Boolean> {
        public static final BooleanSerializer INSTANCE = new BooleanSerializer();

        private BooleanSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Boolean bool, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeBoolean(bool.booleanValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public Boolean deserialize(JsonParser jsonParser) throws IOException {
            Boolean boolValueOf = Boolean.valueOf(jsonParser.getBooleanValue());
            jsonParser.nextToken();
            return boolValueOf;
        }
    }

    private static final class ByteArraySerializer extends StoneSerializer<byte[]> {
        public static final ByteArraySerializer INSTANCE = new ByteArraySerializer();

        private ByteArraySerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(byte[] bArr, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeBinary(bArr);
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public byte[] deserialize(JsonParser jsonParser) throws IOException {
            byte[] binaryValue = jsonParser.getBinaryValue();
            jsonParser.nextToken();
            return binaryValue;
        }
    }

    private static final class StringSerializer extends StoneSerializer<String> {
        public static final StringSerializer INSTANCE = new StringSerializer();

        private StringSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(String str, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeString(str);
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public String deserialize(JsonParser jsonParser) throws IOException {
            String stringValue = getStringValue(jsonParser);
            jsonParser.nextToken();
            return stringValue;
        }
    }

    private static final class DateSerializer extends StoneSerializer<Date> {
        public static final DateSerializer INSTANCE = new DateSerializer();

        private DateSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Date date, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeString(Util.formatTimestamp(date));
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public Date deserialize(JsonParser jsonParser) throws IOException {
            String stringValue = getStringValue(jsonParser);
            jsonParser.nextToken();
            try {
                return Util.parseTimestamp(stringValue);
            } catch (ParseException e) {
                throw new JsonParseException(jsonParser, "Malformed timestamp: '" + stringValue + "'", e);
            }
        }
    }

    private static final class VoidSerializer extends StoneSerializer<Void> {
        public static final VoidSerializer INSTANCE = new VoidSerializer();

        private VoidSerializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Void r1, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeNull();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public Void deserialize(JsonParser jsonParser) throws IOException {
            skipValue(jsonParser);
            return null;
        }
    }

    private static final class NullableSerializer<T> extends StoneSerializer<T> {
        private final StoneSerializer<T> underlying;

        public NullableSerializer(StoneSerializer<T> stoneSerializer) {
            this.underlying = stoneSerializer;
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(T t, JsonGenerator jsonGenerator) throws IOException {
            if (t == null) {
                jsonGenerator.writeNull();
            } else {
                this.underlying.serialize(t, jsonGenerator);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public T deserialize(JsonParser jsonParser) throws IOException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                jsonParser.nextToken();
                return null;
            }
            return this.underlying.deserialize(jsonParser);
        }
    }

    private static final class NullableStructSerializer<T> extends StructSerializer<T> {
        private final StructSerializer<T> underlying;

        public NullableStructSerializer(StructSerializer<T> structSerializer) {
            this.underlying = structSerializer;
        }

        @Override // com.dropbox.core.stone.StructSerializer, com.dropbox.core.stone.StoneSerializer
        public void serialize(T t, JsonGenerator jsonGenerator) throws IOException {
            if (t == null) {
                jsonGenerator.writeNull();
            } else {
                this.underlying.serialize(t, jsonGenerator);
            }
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(T t, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (t == null) {
                jsonGenerator.writeNull();
            } else {
                this.underlying.serialize(t, jsonGenerator, z);
            }
        }

        @Override // com.dropbox.core.stone.StructSerializer, com.dropbox.core.stone.StoneSerializer
        public T deserialize(JsonParser jsonParser) throws IOException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                jsonParser.nextToken();
                return null;
            }
            return this.underlying.deserialize(jsonParser);
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public T deserialize(JsonParser jsonParser, boolean z) throws IOException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                jsonParser.nextToken();
                return null;
            }
            return this.underlying.deserialize(jsonParser, z);
        }
    }

    private static final class ListSerializer<T> extends StoneSerializer<List<T>> {
        private final StoneSerializer<T> underlying;

        public ListSerializer(StoneSerializer<T> stoneSerializer) {
            this.underlying = stoneSerializer;
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(List<T> list, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeStartArray(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.underlying.serialize(it.next(), jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public List<T> deserialize(JsonParser jsonParser) throws IOException {
            expectStartArray(jsonParser);
            ArrayList arrayList = new ArrayList();
            while (jsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
                arrayList.add(this.underlying.deserialize(jsonParser));
            }
            expectEndArray(jsonParser);
            return arrayList;
        }
    }

    private static final class MapSerializer<T> extends StoneSerializer<Map<String, T>> {
        private final StoneSerializer<T> underlying;

        public MapSerializer(StoneSerializer<T> stoneSerializer) {
            this.underlying = stoneSerializer;
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Map<String, T> map, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeStartObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jsonGenerator.writeFieldName(entry.getKey());
                jsonGenerator.writeRawValue(this.underlying.serialize(entry.getValue()));
            }
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public Map<String, T> deserialize(JsonParser jsonParser) throws IOException {
            HashMap map = new HashMap();
            expectStartObject(jsonParser);
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                map.put(currentName, this.underlying.deserialize(jsonParser));
            }
            expectEndObject(jsonParser);
            return map;
        }
    }
}
