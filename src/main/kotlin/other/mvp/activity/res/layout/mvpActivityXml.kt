package other.mvp.activity.res.layout

fun mvpActivityXml(
    activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".mvp.activity.${activityClass}Activity">

</androidx.constraintlayout.widget.ConstraintLayout>
"""