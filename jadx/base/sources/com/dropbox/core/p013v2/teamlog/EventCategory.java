package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum EventCategory {
    ADMIN_ALERTING,
    APPS,
    COMMENTS,
    DATA_GOVERNANCE,
    DEVICES,
    DOMAINS,
    ENCRYPTION,
    FILE_OPERATIONS,
    FILE_REQUESTS,
    GROUPS,
    LOGINS,
    MEMBERS,
    PAPER,
    PASSWORDS,
    REPORTS,
    SHARING,
    SHOWCASE,
    SSO,
    TEAM_FOLDERS,
    TEAM_POLICIES,
    TEAM_PROFILE,
    TFA,
    TRUSTED_TEAMS,
    OTHER;

    static class Serializer extends UnionSerializer<EventCategory> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(EventCategory eventCategory, JsonGenerator jsonGenerator) throws IOException {
            switch (C44641.$SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[eventCategory.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("admin_alerting");
                    break;
                case 2:
                    jsonGenerator.writeString("apps");
                    break;
                case 3:
                    jsonGenerator.writeString("comments");
                    break;
                case 4:
                    jsonGenerator.writeString("data_governance");
                    break;
                case 5:
                    jsonGenerator.writeString("devices");
                    break;
                case 6:
                    jsonGenerator.writeString("domains");
                    break;
                case 7:
                    jsonGenerator.writeString("encryption");
                    break;
                case 8:
                    jsonGenerator.writeString("file_operations");
                    break;
                case 9:
                    jsonGenerator.writeString("file_requests");
                    break;
                case 10:
                    jsonGenerator.writeString("groups");
                    break;
                case 11:
                    jsonGenerator.writeString("logins");
                    break;
                case 12:
                    jsonGenerator.writeString("members");
                    break;
                case 13:
                    jsonGenerator.writeString("paper");
                    break;
                case 14:
                    jsonGenerator.writeString("passwords");
                    break;
                case 15:
                    jsonGenerator.writeString("reports");
                    break;
                case 16:
                    jsonGenerator.writeString("sharing");
                    break;
                case 17:
                    jsonGenerator.writeString("showcase");
                    break;
                case 18:
                    jsonGenerator.writeString("sso");
                    break;
                case 19:
                    jsonGenerator.writeString("team_folders");
                    break;
                case 20:
                    jsonGenerator.writeString("team_policies");
                    break;
                case 21:
                    jsonGenerator.writeString("team_profile");
                    break;
                case 22:
                    jsonGenerator.writeString("tfa");
                    break;
                case 23:
                    jsonGenerator.writeString("trusted_teams");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public EventCategory deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            EventCategory eventCategory;
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
            if ("admin_alerting".equals(tag)) {
                eventCategory = EventCategory.ADMIN_ALERTING;
            } else if ("apps".equals(tag)) {
                eventCategory = EventCategory.APPS;
            } else if ("comments".equals(tag)) {
                eventCategory = EventCategory.COMMENTS;
            } else if ("data_governance".equals(tag)) {
                eventCategory = EventCategory.DATA_GOVERNANCE;
            } else if ("devices".equals(tag)) {
                eventCategory = EventCategory.DEVICES;
            } else if ("domains".equals(tag)) {
                eventCategory = EventCategory.DOMAINS;
            } else if ("encryption".equals(tag)) {
                eventCategory = EventCategory.ENCRYPTION;
            } else if ("file_operations".equals(tag)) {
                eventCategory = EventCategory.FILE_OPERATIONS;
            } else if ("file_requests".equals(tag)) {
                eventCategory = EventCategory.FILE_REQUESTS;
            } else if ("groups".equals(tag)) {
                eventCategory = EventCategory.GROUPS;
            } else if ("logins".equals(tag)) {
                eventCategory = EventCategory.LOGINS;
            } else if ("members".equals(tag)) {
                eventCategory = EventCategory.MEMBERS;
            } else if ("paper".equals(tag)) {
                eventCategory = EventCategory.PAPER;
            } else if ("passwords".equals(tag)) {
                eventCategory = EventCategory.PASSWORDS;
            } else if ("reports".equals(tag)) {
                eventCategory = EventCategory.REPORTS;
            } else if ("sharing".equals(tag)) {
                eventCategory = EventCategory.SHARING;
            } else if ("showcase".equals(tag)) {
                eventCategory = EventCategory.SHOWCASE;
            } else if ("sso".equals(tag)) {
                eventCategory = EventCategory.SSO;
            } else if ("team_folders".equals(tag)) {
                eventCategory = EventCategory.TEAM_FOLDERS;
            } else if ("team_policies".equals(tag)) {
                eventCategory = EventCategory.TEAM_POLICIES;
            } else if ("team_profile".equals(tag)) {
                eventCategory = EventCategory.TEAM_PROFILE;
            } else if ("tfa".equals(tag)) {
                eventCategory = EventCategory.TFA;
            } else if ("trusted_teams".equals(tag)) {
                eventCategory = EventCategory.TRUSTED_TEAMS;
            } else {
                eventCategory = EventCategory.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return eventCategory;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.EventCategory$1 */
    static /* synthetic */ class C44641 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory;

        static {
            int[] iArr = new int[EventCategory.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory = iArr;
            try {
                iArr[EventCategory.ADMIN_ALERTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.COMMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.DATA_GOVERNANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.DEVICES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.DOMAINS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.ENCRYPTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.FILE_OPERATIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.FILE_REQUESTS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.GROUPS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.LOGINS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.MEMBERS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.PAPER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.PASSWORDS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.REPORTS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.SHARING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.SHOWCASE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.SSO.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.TEAM_FOLDERS.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.TEAM_POLICIES.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.TEAM_PROFILE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.TFA.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventCategory[EventCategory.TRUSTED_TEAMS.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }
}
