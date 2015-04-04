package com.os.operando.samplecodeproject.support_annotations;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.os.operando.samplecodeproject.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notNull(null);
        // res(5);
        res(R.string.app_name);
        // new IceCreamFlavourManager().setFlavour(1);
        new IceCreamFlavourManager().setFlavour(IceCreamFlavourManager.VANILLA);
    }


    @Nullable
    void notNull(@NonNull String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    void res(@StringRes int strRes) {
        Toast.makeText(this, getString(strRes), Toast.LENGTH_LONG).show();
    }

    public static class IceCreamFlavourManager {

        private int flavour;

        public static final int VANILLA = 0;
        public static final int CHOCOLATE = 1;
        public static final int STRAWBERRY = 2;

        @IntDef({VANILLA, CHOCOLATE, STRAWBERRY})
        public @interface Flavour {
        }

        @Flavour
        public int getFlavour() {
            return flavour;
        }

        public void setFlavour(@Flavour int flavour) {
            this.flavour = flavour;
        }

    }
}
