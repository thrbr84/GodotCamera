// Copyright: Geração Web(geracaoweb.com)
// Author: Thiago Bruno (thiago.bruno@geracaoweb.com)
// https://github.com/thiagobruno/GodotCamera

package org.godotengine.godot;

import android.util.Log;
import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;


public class GodotCamera extends Godot.SingletonBase {
	private static final String TAG = "godot";
	private static Activity activity;
	static final int REQUEST_IMAGE_CAPTURE = 1;
	private Integer cameraCallbackId = 0;

	private static File cameraPathFile;

	public void openCamera()
	{
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {

			Uri uriSavedImage=Uri.fromFile(this.cameraPathFile);
			takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);

			activity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
		}
	}

	static public Godot.SingletonBase initialize (Activity p_activity) {
		return new GodotCamera(p_activity);
	}

	public void setCameraCallbackId(int _cameraCallbackId) {
		this.cameraCallbackId = _cameraCallbackId;
	}

	public GodotCamera(Activity p_activity) {

		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		path.mkdirs();
		String dirPath = path.getAbsolutePath() ;
		dirPath += "/GodotCamera" ;
		Log.d(TAG, dirPath);
		File tmp = new File(dirPath);
		tmp.mkdirs();
		this.cameraPathFile = new File(tmp, "_returnCamera.jpg");

		registerClass("GodotCamera", new String[]
		{
			"openCamera",
			"setCameraCallbackId"
		});
		activity = p_activity;

	}

	protected void onMainActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == activity.RESULT_OK) {
			Log.d(TAG, "photo taken");
			GodotLib.calldeferred(cameraCallbackId, "_on_GodotCamera_success", new Object[] { this.cameraPathFile.toString() });

		}else{
			Log.d(TAG, "canceled");
		}
	}

}
