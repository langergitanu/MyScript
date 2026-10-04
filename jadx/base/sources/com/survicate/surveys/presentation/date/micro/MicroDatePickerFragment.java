package com.survicate.surveys.presentation.date.micro;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.DatePicker;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.utils.SurvicateLocalDate;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroDatePickerFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/micro/MicroDatePickerFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/app/DatePickerDialog$OnDateSetListener;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDateSet", "", "view", "Landroid/widget/DatePicker;", "year", "", "month", "day", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String POINT_ID = "point_id";
    public static final String SELECTED_DATE = "selected_date";

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Parcelable parcelable;
        Bundle arguments = getArguments();
        SurvicateLocalDate survicateLocalDate = null;
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable(SELECTED_DATE, SurvicateLocalDate.class);
            } else {
                Parcelable parcelable2 = arguments.getParcelable(SELECTED_DATE);
                parcelable = (SurvicateLocalDate) (parcelable2 instanceof SurvicateLocalDate ? parcelable2 : null);
            }
            survicateLocalDate = (SurvicateLocalDate) parcelable;
        }
        SurvicateLocalDate.Companion companion = SurvicateLocalDate.INSTANCE;
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        SurvicateLocalDate survicateLocalDateFromCalendar = companion.fromCalendar(calendar);
        return new DatePickerDialog(requireContext(), C8369R.style.Widget_DatePickerDialog_Micro, this, survicateLocalDate != null ? survicateLocalDate.getYear() : survicateLocalDateFromCalendar.getYear(), (survicateLocalDate != null ? survicateLocalDate.getMonth() : survicateLocalDateFromCalendar.getMonth()) - 1, survicateLocalDate != null ? survicateLocalDate.getDay() : survicateLocalDateFromCalendar.getDay());
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Intrinsics.checkNotNullParameter(view, "view");
        SurvicateLocalDate survicateLocalDate = new SurvicateLocalDate(year, month + 1, day);
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j = arguments.getLong(POINT_ID);
            Intent intent = new Intent();
            intent.putExtra(SELECTED_DATE, survicateLocalDate);
            intent.putExtra(POINT_ID, j);
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), -1, intent);
            }
        }
    }

    /* JADX INFO: compiled from: MicroDatePickerFragment.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/micro/MicroDatePickerFragment$Companion;", "", "<init>", "()V", "SELECTED_DATE", "", "POINT_ID", "newInstance", "Lcom/survicate/surveys/presentation/date/micro/MicroDatePickerFragment;", "selectedDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "pointId", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MicroDatePickerFragment newInstance(SurvicateLocalDate selectedDate, long pointId) {
            MicroDatePickerFragment microDatePickerFragment = new MicroDatePickerFragment();
            microDatePickerFragment.setArguments(BundleKt.bundleOf(TuplesKt.m1606to(MicroDatePickerFragment.SELECTED_DATE, selectedDate), TuplesKt.m1606to(MicroDatePickerFragment.POINT_ID, Long.valueOf(pointId))));
            return microDatePickerFragment;
        }
    }
}
