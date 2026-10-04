package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum AccessInheritance {
    INHERIT,
    NO_INHERIT,
    OTHER;

    static class Serializer extends UnionSerializer<AccessInheritance> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccessInheritance accessInheritance, JsonGenerator jsonGenerator) throws IOException {
            int i = C42461.$SwitchMap$com$dropbox$core$v2$sharing$AccessInheritance[accessInheritance.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("inherit");
            } else if (i == 2) {
                jsonGenerator.writeString("no_inherit");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccessInheritance deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccessInheritance accessInheritance;
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
            if ("inherit".equals(tag)) {
                accessInheritance = AccessInheritance.INHERIT;
            } else if ("no_inherit".equals(tag)) {
                accessInheritance = AccessInheritance.NO_INHERIT;
            } else {
                accessInheritance = AccessInheritance.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accessInheritance;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AccessInheritance$1 */
    static /* synthetic */ class C42461 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AccessInheritance;

        static {
            int[] iArr = new int[AccessInheritance.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AccessInheritance = iArr;
            try {
                iArr[AccessInheritance.INHERIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AccessInheritance[AccessInheritance.NO_INHERIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
