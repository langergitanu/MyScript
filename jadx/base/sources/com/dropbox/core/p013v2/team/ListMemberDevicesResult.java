package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.ActiveWebSession;
import com.dropbox.core.p013v2.team.DesktopClientSession;
import com.dropbox.core.p013v2.team.MobileClientSession;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class ListMemberDevicesResult {

    @Nullable
    protected final List<ActiveWebSession> activeWebSessions;

    @Nullable
    protected final List<DesktopClientSession> desktopClientSessions;

    @Nullable
    protected final List<MobileClientSession> mobileClientSessions;

    public ListMemberDevicesResult(@Nullable List<ActiveWebSession> list, @Nullable List<DesktopClientSession> list2, @Nullable List<MobileClientSession> list3) {
        if (list != null) {
            Iterator<ActiveWebSession> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                }
            }
        }
        this.activeWebSessions = list;
        if (list2 != null) {
            Iterator<DesktopClientSession> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                }
            }
        }
        this.desktopClientSessions = list2;
        if (list3 != null) {
            Iterator<MobileClientSession> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (it3.next() == null) {
                    throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                }
            }
        }
        this.mobileClientSessions = list3;
    }

    public ListMemberDevicesResult() {
        this(null, null, null);
    }

    @Nullable
    public List<ActiveWebSession> getActiveWebSessions() {
        return this.activeWebSessions;
    }

    @Nullable
    public List<DesktopClientSession> getDesktopClientSessions() {
        return this.desktopClientSessions;
    }

    @Nullable
    public List<MobileClientSession> getMobileClientSessions() {
        return this.mobileClientSessions;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected List<ActiveWebSession> activeWebSessions = null;
        protected List<DesktopClientSession> desktopClientSessions = null;
        protected List<MobileClientSession> mobileClientSessions = null;

        protected Builder() {
        }

        public Builder withActiveWebSessions(List<ActiveWebSession> list) {
            if (list != null) {
                Iterator<ActiveWebSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                    }
                }
            }
            this.activeWebSessions = list;
            return this;
        }

        public Builder withDesktopClientSessions(List<DesktopClientSession> list) {
            if (list != null) {
                Iterator<DesktopClientSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                    }
                }
            }
            this.desktopClientSessions = list;
            return this;
        }

        public Builder withMobileClientSessions(List<MobileClientSession> list) {
            if (list != null) {
                Iterator<MobileClientSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                    }
                }
            }
            this.mobileClientSessions = list;
            return this;
        }

        public ListMemberDevicesResult build() {
            return new ListMemberDevicesResult(this.activeWebSessions, this.desktopClientSessions, this.mobileClientSessions);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.activeWebSessions, this.desktopClientSessions, this.mobileClientSessions});
    }

    public boolean equals(Object obj) {
        List<DesktopClientSession> list;
        List<DesktopClientSession> list2;
        List<MobileClientSession> list3;
        List<MobileClientSession> list4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ListMemberDevicesResult listMemberDevicesResult = (ListMemberDevicesResult) obj;
        List<ActiveWebSession> list5 = this.activeWebSessions;
        List<ActiveWebSession> list6 = listMemberDevicesResult.activeWebSessions;
        return (list5 == list6 || (list5 != null && list5.equals(list6))) && ((list = this.desktopClientSessions) == (list2 = listMemberDevicesResult.desktopClientSessions) || (list != null && list.equals(list2))) && ((list3 = this.mobileClientSessions) == (list4 = listMemberDevicesResult.mobileClientSessions) || (list3 != null && list3.equals(list4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListMemberDevicesResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListMemberDevicesResult listMemberDevicesResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (listMemberDevicesResult.activeWebSessions != null) {
                jsonGenerator.writeFieldName("active_web_sessions");
                StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).serialize(listMemberDevicesResult.activeWebSessions, jsonGenerator);
            }
            if (listMemberDevicesResult.desktopClientSessions != null) {
                jsonGenerator.writeFieldName("desktop_client_sessions");
                StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).serialize(listMemberDevicesResult.desktopClientSessions, jsonGenerator);
            }
            if (listMemberDevicesResult.mobileClientSessions != null) {
                jsonGenerator.writeFieldName("mobile_client_sessions");
                StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).serialize(listMemberDevicesResult.mobileClientSessions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListMemberDevicesResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list2 = null;
                List list3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("active_web_sessions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("desktop_client_sessions".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("mobile_client_sessions".equals(currentName)) {
                        list3 = (List) StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ListMemberDevicesResult listMemberDevicesResult = new ListMemberDevicesResult(list, list2, list3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listMemberDevicesResult, listMemberDevicesResult.toStringMultiline());
                return listMemberDevicesResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
