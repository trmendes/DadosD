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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private GeradorCpf cpf;
    private TextView tvCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpf = new GeradorCpf();

        tvCpf = (TextView) findViewById(R.id.txCpf);

    }

    @SuppressWarnings("unused")
    public void about(@SuppressWarnings("UnusedParameters") View v) {
        Intent myIntent = new Intent(this, AboutUsActivity.class);
        this.startActivity(myIntent);
    }

    @SuppressWarnings("unused")
    public void genData(@SuppressWarnings("UnusedParameters") View v) {
        tvCpf.setText(cpf.getNovoCpf());
        copyData(tvCpf);
    }

    private void copyData(TextView data) {
        String dataS = data.getText().toString();
        String toastS = getResources().getString(R.string.text_copy_info, dataS);

        Toast.makeText(this, toastS, Toast.LENGTH_SHORT).show();

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText(dataS,dataS);
            clipboard.setPrimaryClip(clip);
        } else {
            @SuppressWarnings("deprecation") android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(dataS);
        }

    }
}
