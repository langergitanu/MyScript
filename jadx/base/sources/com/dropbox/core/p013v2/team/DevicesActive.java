package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.events.BackendEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class DevicesActive {

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    @Nonnull
    protected final List<Long> f2961android;

    @Nonnull
    protected final List<Long> ios;

    @Nonnull
    protected final List<Long> linux;

    @Nonnull
    protected final List<Long> macos;

    @Nonnull
    protected final List<Long> other;

    @Nonnull
    protected final List<Long> total;

    @Nonnull
    protected final List<Long> windows;

    public DevicesActive(@Nonnull List<Long> list, @Nonnull List<Long> list2, @Nonnull List<Long> list3, @Nonnull List<Long> list4, @Nonnull List<Long> list5, @Nonnull List<Long> list6, @Nonnull List<Long> list7) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'windows' is null");
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'windows' is null");
            }
        }
        this.windows = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'macos' is null");
        }
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'macos' is null");
            }
        }
        this.macos = list2;
        if (list3 == null) {
            throw new IllegalArgumentException("Required value for 'linux' is null");
        }
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            if (it3.next() == null) {
                throw new IllegalArgumentException("An item in list 'linux' is null");
            }
        }
        this.linux = list3;
        if (list4 == null) {
            throw new IllegalArgumentException("Required value for 'ios' is null");
        }
        Iterator<Long> it4 = list4.iterator();
        while (it4.hasNext()) {
            if (it4.next() == null) {
                throw new IllegalArgumentException("An item in list 'ios' is null");
            }
        }
        this.ios = list4;
        if (list5 == null) {
            throw new IllegalArgumentException("Required value for 'android' is null");
        }
        Iterator<Long> it5 = list5.iterator();
        while (it5.hasNext()) {
            if (it5.next() == null) {
                throw new IllegalArgumentException("An item in list 'android' is null");
            }
        }
        this.f2961android = list5;
        if (list6 == null) {
            throw new IllegalArgumentException("Required value for 'other' is null");
        }
        Iterator<Long> it6 = list6.iterator();
        while (it6.hasNext()) {
            if (it6.next() == null) {
                throw new IllegalArgumentException("An item in list 'other' is null");
            }
        }
        this.other = list6;
        if (list7 == null) {
            throw new IllegalArgumentException("Required value for 'total' is null");
        }
        Iterator<Long> it7 = list7.iterator();
        while (it7.hasNext()) {
            if (it7.next() == null) {
                throw new IllegalArgumentException("An item in list 'total' is null");
            }
        }
        this.total = list7;
    }

    @Nonnull
    public List<Long> getWindows() {
        return this.windows;
    }

    @Nonnull
    public List<Long> getMacos() {
        return this.macos;
    }

    @Nonnull
    public List<Long> getLinux() {
        return this.linux;
    }

    @Nonnull
    public List<Long> getIos() {
        return this.ios;
    }

    @Nonnull
    public List<Long> getAndroid() {
        return this.f2961android;
    }

    @Nonnull
    public List<Long> getOther() {
        return this.other;
    }

    @Nonnull
    public List<Long> getTotal() {
        return this.total;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.windows, this.macos, this.linux, this.ios, this.f2961android, this.other, this.total});
    }

    public boolean equals(Object obj) {
        List<Long> list;
        List<Long> list2;
        List<Long> list3;
        List<Long> list4;
        List<Long> list5;
        List<Long> list6;
        List<Long> list7;
        List<Long> list8;
        List<Long> list9;
        List<Long> list10;
        List<Long> list11;
        List<Long> list12;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DevicesActive devicesActive = (DevicesActive) obj;
        List<Long> list13 = this.windows;
        List<Long> list14 = devicesActive.windows;
        return (list13 == list14 || list13.equals(list14)) && ((list = this.macos) == (list2 = devicesActive.macos) || list.equals(list2)) && (((list3 = this.linux) == (list4 = devicesActive.linux) || list3.equals(list4)) && (((list5 = this.ios) == (list6 = devicesActive.ios) || list5.equals(list6)) && (((list7 = this.f2961android) == (list8 = devicesActive.f2961android) || list7.equals(list8)) && (((list9 = this.other) == (list10 = devicesActive.other) || list9.equals(list10)) && ((list11 = this.total) == (list12 = devicesActive.total) || list11.equals(list12))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DevicesActive> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DevicesActive devicesActive, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("windows");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.windows, jsonGenerator);
            jsonGenerator.writeFieldName("macos");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.macos, jsonGenerator);
            jsonGenerator.writeFieldName("linux");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.linux, jsonGenerator);
            jsonGenerator.writeFieldName("ios");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.ios, jsonGenerator);
            jsonGenerator.writeFieldName(BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM);
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.f2961android, jsonGenerator);
            jsonGenerator.writeFieldName("other");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.other, jsonGenerator);
            jsonGenerator.writeFieldName("total");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(devicesActive.total, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DevicesActive deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                List list3 = null;
                List list4 = null;
                List list5 = null;
                List list6 = null;
                List list7 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("windows".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("macos".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("linux".equals(currentName)) {
                        list3 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("ios".equals(currentName)) {
                        list4 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if (BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM.equals(currentName)) {
                        list5 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("other".equals(currentName)) {
                        list6 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else if ("total".equals(currentName)) {
                        list7 = (List) StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"windows\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"macos\" missing.");
                }
                if (list3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"linux\" missing.");
                }
                if (list4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"ios\" missing.");
                }
                if (list5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"android\" missing.");
                }
                if (list6 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"other\" missing.");
                }
                if (list7 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"total\" missing.");
                }
                DevicesActive devicesActive = new DevicesActive(list, list2, list3, list4, list5, list6, list7);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(devicesActive, devicesActive.toStringMultiline());
                return devicesActive;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
