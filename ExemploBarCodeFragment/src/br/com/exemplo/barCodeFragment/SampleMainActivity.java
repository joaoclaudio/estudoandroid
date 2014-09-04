package br.com.exemplo.barCodeFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.abhi.barcode.frag.libv2.BarcodeFragment;
import com.abhi.barcode.frag.libv2.IScanResultHandler;
import com.abhi.barcode.frag.libv2.ScanResult;

public class SampleMainActivity extends FragmentActivity implements IScanResultHandler{

	BarcodeFragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_main);
		
		fragment = (BarcodeFragment) getSupportFragmentManager().findFragmentById(R.id.sample);
		fragment.setScanResultHandler(this);
		//fragment.setDecodeFor(EnumSet.of(BarcodeFormat.EAN_13));
		
	}

	@Override
	public void scanResult(ScanResult result) {
		Toast.makeText(this, result.getRawResult().getText(), Toast.LENGTH_LONG).show();
		fragment.restart();
	}
}
