/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tmendes.dadosd;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutUsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView appVersion = (TextView) findViewById(R.id.tvVersion);
        TextView tvHelpDevel = (TextView) findViewById(R.id.tvHelpDevel);
        TextView tvHelpIssue = (TextView) findViewById(R.id.tvHelpIssue);
        TextView tvIcons01 = (TextView) findViewById(R.id.tvIcons01);

        tvHelpDevel.setMovementMethod(LinkMovementMethod.getInstance());
        tvHelpIssue.setMovementMethod(LinkMovementMethod.getInstance());
        tvIcons01.setMovementMethod(LinkMovementMethod.getInstance());

        appVersion.setText(this.getResources().getString(R.string.build, BuildConfig.VERSION_CODE));
    }
}
