package com.example.lab9;
import android.graphics.Color; import android.os.Bundle; import android.view.ContextMenu; import android.view.MenuItem; import android.view.View; import android.widget.RelativeLayout; import android.widget.TextView; import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
TextView textView;
RelativeLayout relativeLayout;
@Override protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
// Link those objects with their respective id's that we have given in .XML file textView = (TextView) findViewById(R.id.textView); relativeLayout = (RelativeLayout) findViewById(R.id.relLayout);
// here you have to register a view for context menu you can register any view
// like listview, image view, textview, button etc registerForContextMenu(textView);
}
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
ContextMenu.ContextMenuInfo menuInfo) { super.onCreateContextMenu(menu, v, menuInfo); // you can set menu header with title icon etc menu.setHeaderTitle("Choose a color");
// add menu items
menu.add(0, v.getId(), 0, "Yellow"); menu.add(0, v.getId(), 0, "Gray"); menu.add(0, v.getId(), 0, "Cyan");
}
// menu item select listener
@Override
public boolean onContextItemSelected(MenuItem item) { if (item.getTitle() == "Yellow") {
relativeLayout.setBackgroundColor(Color.YELLOW);
} else if (item.getTitle() == "Gray") { relativeLayout.setBackgroundColor(Color.GRAY);
} else if (item.getTitle() == "Cyan") { relativeLayout.setBackgroundColor(Color.CYAN);
}
return true;
}
}
xml file
<?xml version="1.0" encoding="utf-8"?>
<!-- Relative Layout to display all the details -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" xmlns:tools="http://schemas.android.com/tools" android:id="@+id/relLayout" android:layout_width="match_parent" android:layout_height="match_parent" android:background="#fff" android:padding="16dp" tools:context=".MainActivity">
<TextView android:id="@+id/textView" android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_centerHorizontal="true" android:layout_marginTop="20dp" android:text="Long press me!" android:textColor="#000" android:textSize="20sp" android:textStyle="bold" />
</RelativeLayout>
