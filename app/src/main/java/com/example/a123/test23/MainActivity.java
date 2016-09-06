package com.example.a123.test23;



import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

        private final static String TAG="myTag";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);


                getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,true,new ContactsObserver(new Handler() ));
        }

        private final class ContactsObserver extends ContentObserver {
                public ContactsObserver(Handler handler){
                        super(handler);
                }

                @Override
                public void onChange(boolean selfChange) {
                        Log.v(TAG,"您修改了联系人");
                }


        }

}