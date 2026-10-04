package com.survicate.surveys.helpers;

import kotlin.Metadata;

/* JADX INFO: compiled from: SurvicateLogger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/helpers/LogTags;", "", "<init>", "()V", "WORKSPACE", "", "TARGETING", "PRESENTATION", "CONTACTS", "RESPONDENT", "EVENTS", "PERSISTENCE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LogTags {
    public static final String CONTACTS = "Contacts";
    public static final String EVENTS = "Events";
    public static final LogTags INSTANCE = new LogTags();
    public static final String PERSISTENCE = "Persistence";
    public static final String PRESENTATION = "Presentation";
    public static final String RESPONDENT = "Respondent";
    public static final String TARGETING = "Targeting";
    public static final String WORKSPACE = "Workspace";

    private LogTags() {
    }
}
