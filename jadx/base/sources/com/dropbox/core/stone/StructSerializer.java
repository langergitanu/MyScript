package com.dropbox.core.stone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StructSerializer<T> extends CompositeSerializer<T> {
    public abstract T deserialize(JsonParser jsonParser, boolean z) throws IOException;

    public abstract void serialize(T t, JsonGenerator jsonGenerator, boolean z) throws IOException;

    @Override // com.dropbox.core.stone.StoneSerializer
    public void serialize(T t, JsonGenerator jsonGenerator) throws IOException {
        serialize((Object) t, jsonGenerator, false);
    }

    @Override // com.dropbox.core.stone.StoneSerializer
    public T deserialize(JsonParser jsonParser) throws IOException {
        return deserialize(jsonParser, false);
    }
}
