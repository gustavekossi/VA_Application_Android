package com.keyneosoft.integrationzxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.va_application_android.R;
import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends Activity {
	
	private TextView scanResult = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// lancement du scanner dans le bouton
//		Button scanLauncher = (Button)this.findViewById(R.id.scanButton);
//		scanLauncher.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//				startActivityForResult(intent, 0);
//			}
//			
//		});
		
//		scanResult = (TextView)this.findViewById(R.id.scanResult);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 0) {
			// récupération du QR-Code
			scanResult.setText(""+data.getExtras().getString("codeBarre"));
		}
	}
}
