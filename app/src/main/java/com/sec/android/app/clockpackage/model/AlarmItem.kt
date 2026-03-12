package com.sec.android.app.clockpackage.model

data class AlarmItem(
    val mAlarmId: Int = 0,
    val mAlarmName: String? = null,
    val mAlarmSoundType: Int = 0,
    val mAlarmTime: Int = 0,
    val mAlertTime: Long = 0,
    val mBedtimeAlarmTime: Int = 0,
    val mDailyBriefing: Int = 0,
    val mEnable: Int = 0,
    val mGroupId: Int = 0,
    val mRepeatType: Int = 0,
    val mSnoozeActive: Int = 0,
    val mSnoozeDoneCount: Int = 0,
    val mSnoozeDuration: Int = 0,
    val mSnoozeRepeat: Int = 0,
    val mSortOrder: Int = 0,
) {
    fun isOneTimeAlarm(): Boolean {
        return (this.mRepeatType and 15) == 1
    }

    fun isWakeUpAlarm(): Boolean {
        return (this.mDailyBriefing and 262144) == 262144
    }

    fun isBedtimeAlarm(): Boolean {
        return (this.mDailyBriefing and 131072) == 131072
    }
}