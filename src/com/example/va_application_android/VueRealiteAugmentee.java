package com.example.va_application_android;

import java.util.Vector;

import modele.UserData;

import android.app.Activity;
import android.content.Context;


import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VueRealiteAugmentee extends Activity{
	
	// camera 
	SurfaceView cameraPreview;
	SurfaceHolder previewHolder;
	Camera camera;
	boolean inPreview = false ;
	
	
	
    //GeoPoint geoPoint;
	static public RelativeLayout var_contentView ; 
	static public Vector<MarqueurPOI> var_vectorMarqueur = new Vector<MarqueurPOI>() ;
	
	
	SensorManager sensorManager;
	

	
	int orientationSensor;
	float headingAngle;


	
	LocationManager locationManager;
	double latitude;
	double longitude;
	
	
	SurfaceHolder.Callback surfaceCallback=new SurfaceHolder.Callback() {


        public void surfaceCreated(SurfaceHolder holder) {
    		try {
    			camera.setPreviewDisplay(previewHolder);	
    		}
    		catch (Throwable t) {
    			Log.e("DEBUG", "Exception in setPreviewDisplay()", t);
    		}
    	}
    	
    public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
    		
    		Camera.Parameters parameters=camera.getParameters();
    		
    		Camera.Size size=getBestPreviewSize(width, height, parameters);

    		if (size!=null) {
    			parameters.setPreviewSize(size.width, size.height);
    			camera.setParameters(parameters);
    			camera.startPreview();
    			inPreview=true;
    		}
	}
    	
    	public void surfaceDestroyed(SurfaceHolder holder) {
    		// not used
    	}
    	
    };
	
	private LocationListener locationListener = new LocationListener() {
    	
    	
        public void onLocationChanged(Location location) {
        		
        	
        		latitude = location.getLatitude();
        		longitude = location.getLongitude();
        		
        	}

    		public void onProviderDisabled(String arg0) {
    			// TODO Auto-generated method stub
    			
    		}

    		public void onProviderEnabled(String arg0) {
    			// TODO Auto-generated method stub
    			
    		}

    		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    			// TODO Auto-generated method stub
    			
    		}
     };
	
	
     
     final SensorEventListener sensorEventListener = new SensorEventListener() {
     	
     	public void onSensorChanged(SensorEvent sensorEvent) {
     		
     		
     		
     		if (sensorEvent.sensor.getType() ==  Sensor.TYPE_ORIENTATION)
     		{
     			
     			headingAngle = sensorEvent.values[0];
     			
     			TextView myLocationText = (TextView)findViewById(R.id.vueRA_text);
     			
     			String latLongString = "Lat:" + latitude + "\nLong:" + longitude + " angle = "+headingAngle;

     	        myLocationText.setText("Your Current Position is:\n" +
     	                latLongString);
     	         
     	         
     			
     		}
     		
     		
     		
     		
     	}
     	
     	public void onAccuracyChanged (Sensor senor, int accuracy) {
     		//Not used
     	}
     };
     
     
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	
    	super.onCreate(savedInstanceState);
        LocationManager locManager;
        setContentView(R.layout.vue_realite_augmentee);
        locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000L,500.0f, locationListener);
        Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        var_contentView = (RelativeLayout) findViewById(R.id.vueRA_contentView);
        
        
        cameraPreview = (SurfaceView)findViewById(R.id.cameraPreview);
        previewHolder = cameraPreview.getHolder();
        previewHolder.addCallback(surfaceCallback);
        previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        
      
        
        
        for(int i = 0 ; i < 10 ; i++){
        	
        	MarqueurPOI temp_marqueur = new MarqueurPOI(this , UserData.shared_instance().var_Array_Poi.lastElement() );
        	
        	var_vectorMarqueur.addElement(temp_marqueur);
        	
        	var_contentView.addView(temp_marqueur);
        	
        }
        
        
        
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, locationListener);
        
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        orientationSensor = Sensor.TYPE_ORIENTATION;
        //accelerometerSensor = Sensor.TYPE_ACCELEROMETER;
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(orientationSensor), SensorManager.SENSOR_DELAY_NORMAL);
        //sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(accelerometerSensor), SensorManager.SENSOR_DELAY_NORMAL);
        
        inPreview = false;
        

      }

    
   
    
    
    

    @Override
    public void onResume() {
      super.onResume();
     
      locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, locationListener);
      sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(orientationSensor), SensorManager.SENSOR_DELAY_NORMAL);
      //sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(accelerometerSensor), SensorManager.SENSOR_DELAY_NORMAL);
      camera=Camera.open();
    }
    
    
      
    @Override
    public void onPause() {
      
    	
    if (inPreview) {
        camera.stopPreview();
      }
      locationManager.removeUpdates(locationListener);
      sensorManager.unregisterListener(sensorEventListener);
      camera.release();
      camera=null;
      inPreview=false;
            
      super.onPause();
    }
    
    
    
    
    
    private Camera.Size getBestPreviewSize(int width, int height, Camera.Parameters parameters) {
    	Camera.Size result=null;

    	for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
    		if (size.width<=width && size.height<=height) {
    			if (result==null) {
    				result=size;
    			}
    			else {
    				int resultArea=result.width*result.height;
    				int newArea=size.width*size.height;

    				if (newArea>resultArea) {
    					result=size;
    				}
    			}
    		}
    	}

    	return(result);
    }
    
    
    
    	
    	
    	
    
}