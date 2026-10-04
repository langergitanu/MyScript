package com.myscript.nebo.penpanel;

import android.app.Application;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.myscript.atk.core.ContentTypes;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.WritingPosition;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WritingSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/WritingSettings;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "contentType", "", "inkSettings", "Lcom/myscript/nebo/penpanel/InkSettings;", "<init>", "(Landroid/app/Application;Ljava/lang/String;Lcom/myscript/nebo/penpanel/InkSettings;)V", "toolConfigurations", "", "Lcom/myscript/snt/core/ToolConfiguration;", "getToolConfigurations", "()Ljava/util/List;", "isActivePenModeEnabled", "", "()Z", "writingPosition", "Lcom/myscript/nebo/common/WritingPosition;", "update", "", "findToolByType", "toolType", "Lcom/myscript/snt/core/ToolType;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WritingSettings {
    private final Application application;
    private final String contentType;
    private final InkSettings inkSettings;
    private final List<ToolConfiguration> toolConfigurations;
    private WritingPosition writingPosition;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WritingSettings(Application application, String contentType) {
        this(application, contentType, null, 4, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
    }

    public WritingSettings(Application application, String contentType, InkSettings inkSettings) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.application = application;
        this.contentType = contentType;
        this.inkSettings = inkSettings;
        this.toolConfigurations = new ArrayList();
        update();
        WritingPosition.Companion companion = WritingPosition.INSTANCE;
        String string = PreferenceManager.getDefaultSharedPreferences(application).getString(application.getString(C6693R.string.pref_cpi_writing_position_key), application.getResources().getString(C6693R.string.pref_cpi_writing_position_key));
        Intrinsics.checkNotNull(string);
        this.writingPosition = companion.deserialize(string);
    }

    public /* synthetic */ WritingSettings(Application application, String str, InkSettings inkSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, (i & 4) != 0 ? null : inkSettings);
    }

    public final List<ToolConfiguration> getToolConfigurations() {
        return this.toolConfigurations;
    }

    public final boolean isActivePenModeEnabled() {
        return CommonUtils.isActivePenMode(this.application);
    }

    public final void update() {
        InkSettings inkSettingsLoadFromPreferences = this.inkSettings;
        if (inkSettingsLoadFromPreferences == null) {
            inkSettingsLoadFromPreferences = InkSettings.INSTANCE.loadFromPreferences(this.application, CollectionsKt.emptyList());
        }
        synchronized (this.toolConfigurations) {
            this.toolConfigurations.clear();
            float selectedThicknessRatio = inkSettingsLoadFromPreferences.getSelectedThicknessRatio(ToolType.Pen, this.application);
            int selectedColor = inkSettingsLoadFromPreferences.getSelectedColor(ToolType.Pen, ResourcesCompat.getColor(this.application.getResources(), C6693R.color.default_pen_color, this.application.getTheme()));
            List<ToolConfiguration> list = this.toolConfigurations;
            ToolConfiguration toolConfiguration = new ToolConfiguration(ToolType.Pen, selectedColor, selectedThicknessRatio);
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER, inkSettingsLoadFromPreferences.getPenStroker());
            list.add(toolConfiguration);
            float selectedThicknessRatio2 = inkSettingsLoadFromPreferences.getSelectedThicknessRatio(ToolType.Highlighter, this.application);
            int selectedColor2 = inkSettingsLoadFromPreferences.getSelectedColor(ToolType.Highlighter, ResourcesCompat.getColor(this.application.getResources(), C6693R.color.default_highlighter_color, this.application.getTheme()));
            List<ToolConfiguration> list2 = this.toolConfigurations;
            ToolConfiguration toolConfiguration2 = new ToolConfiguration(ToolType.Highlighter, selectedColor2, selectedThicknessRatio2);
            String str = this.contentType;
            if (Intrinsics.areEqual(str, ContentTypes.RAW_CONTENT) || Intrinsics.areEqual(str, ContentTypes.PDF)) {
                toolConfiguration2.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, inkSettingsLoadFromPreferences.getHighlighterPolicy());
            } else if (Intrinsics.areEqual(str, ContentTypes.TEXT_DOCUMENT)) {
                toolConfiguration2.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART);
            }
            toolConfiguration2.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR, inkSettingsLoadFromPreferences.getHighlighterClearMode());
            list2.add(toolConfiguration2);
            float selectedThicknessRatio3 = inkSettingsLoadFromPreferences.getSelectedThicknessRatio(ToolType.Eraser, this.application);
            List<ToolConfiguration> list3 = this.toolConfigurations;
            ToolConfiguration toolConfiguration3 = new ToolConfiguration(ToolType.Eraser, 0, selectedThicknessRatio3);
            toolConfiguration3.setProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY, inkSettingsLoadFromPreferences.getEraserPolicy());
            list3.add(toolConfiguration3);
            List<ToolConfiguration> list4 = this.toolConfigurations;
            ToolConfiguration toolConfiguration4 = new ToolConfiguration(ToolType.Lasso, 0);
            toolConfiguration4.setProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE, inkSettingsLoadFromPreferences.getLassoShape());
            list4.add(toolConfiguration4);
        }
    }

    public final ToolConfiguration findToolByType(ToolType toolType) {
        Object next;
        ToolConfiguration toolConfiguration;
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        synchronized (this.toolConfigurations) {
            Iterator<T> it = this.toolConfigurations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ToolConfiguration) next).getType() == toolType) {
                    break;
                }
            }
            toolConfiguration = (ToolConfiguration) next;
        }
        return toolConfiguration;
    }
}
