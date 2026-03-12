package com.sec.android.app.clockpackage

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import com.sec.android.app.clockpackage.model.AlarmItem

class AlarmProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to delete one or more rows")
    }

    override fun getType(uri: Uri): String? {
        TODO(
            "Implement this to handle requests for the MIME type of the data" +
                    "at the given URI"
        )
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        when (uri.path) {
            "/alarm" -> {
                Log.i(TAG, "Got alarm query")
                val columnNames = arrayOf(
                    "_id",                    // 0  - mAlarmId
                    "enabled",                // 1  - mEnable
                    "unused2",                // 2  - unused
                    "alertTime",              // 3  - mAlertTime
                    "alarmTime",              // 4  - mAlarmTime
                    "repeatType",             // 5  - mRepeatType
                    "unused6",                // 6  - unused
                    "snoozeActive",           // 7  - mSnoozeActive
                    "snoozeDuration",         // 8  - mSnoozeDuration
                    "snoozeRepeat",           // 9  - mSnoozeRepeat
                    "snoozeDoneCount",        // 10 - mSnoozeDoneCount
                    "dailyBriefing",          // 11 - mDailyBriefing
                    "sortOrder",              // 12 - mSortOrder
                    "unused13",               // 13 - unused
                    "unused14",               // 14 - unused
                    "alarmSoundType",         // 15 - mAlarmSoundType
                    "unused16",               // 16 - unused
                    "unused17",               // 17 - unused
                    "unused18",               // 18 - unused
                    "unused19",               // 19 - unused
                    "alarmName",              // 20 - mAlarmName
                    "unused21",               // 21 - unused
                    "unused22",               // 22 - unused
                    "unused23",               // 23 - unused
                    "unused24",               // 24 - unused
                    "unused25",               // 25 - unused
                    "unused26",               // 26 - unused
                    "bedtimeAlarmTime",       // 27 - mBedtimeAlarmTime
                    "unused28",               // 28 - unused
                    "unused29",               // 29 - unused
                    "unused30",               // 30 - unused
                    "unused31",               // 31 - unused
                    "groupId"                 // 32 - mGroupId
                )
                val alarms = listOf(
                    AlarmItem(
                        mAlarmId = 100,
                        mAlarmName = "",
                        mAlarmTime = 820,
                        mAlertTime = System.currentTimeMillis(),
                        mRepeatType = 0,
                        mEnable = 0,
                    )
                )

                val mc = MatrixCursor(columnNames)
                for (alarm in alarms) {
                    mc.addRow(arrayOf<Any?>(
                        alarm.mAlarmId,           // 0
                        alarm.mEnable,            // 1
                        null,                     // 2
                        alarm.mAlertTime,         // 3
                        alarm.mAlarmTime,         // 4
                        alarm.mRepeatType,        // 5
                        null,                     // 6
                        alarm.mSnoozeActive,      // 7
                        alarm.mSnoozeDuration,    // 8
                        alarm.mSnoozeRepeat,      // 9
                        alarm.mSnoozeDoneCount,   // 10
                        alarm.mDailyBriefing,     // 11
                        alarm.mSortOrder,         // 12
                        null,                     // 13
                        null,                     // 14
                        alarm.mAlarmSoundType,    // 15
                        null,                     // 16
                        null,                     // 17
                        null,                     // 18
                        null,                     // 19
                        alarm.mAlarmName,         // 20
                        null,                     // 21
                        null,                     // 22
                        null,                     // 23
                        null,                     // 24
                        null,                     // 25
                        null,                     // 26
                        alarm.mBedtimeAlarmTime,  // 27
                        null,                     // 28
                        null,                     // 29
                        null,                     // 30
                        null,                     // 31
                        alarm.mGroupId            // 32
                    ))
                }
                return mc
            }
            "/groupAlarm" -> {
                Log.i(TAG, "Got groupAlarm query")
            }
        }
        return null
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        TODO("Implement this to handle requests to update one or more rows.")
    }

    companion object {
        private val TAG = "AlarmProvider"
    }
}