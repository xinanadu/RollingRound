package info.zhegui.rollinground;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class RollingRound extends TextView {

	private Bitmap mBitmap;
	private Matrix mMaxtrix = new Matrix();

	public RollingRound(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		mBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.home_menu);

//		new Thread() {
//			public void run() {
//				int degrees = 0;
//				while (true) {
//					log("RollingRound.this.getWidth():"+RollingRound.this.getWidth());
//					log("RollingRound.this.getHeight():"+RollingRound.this.getHeight());
//					mMaxtrix.postRotate(degrees, RollingRound.this.getWidth()/2, RollingRound.this.getHeight()/2 );
////					degrees += 30;
////					if (degrees >= 360) {
////						degrees %= 360;
////					}
//					log("degrees:"+degrees);
//					SystemClock.sleep(200);
//					postInvalidate();
//				}
//			}
//		}.start();

	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		log("onDraw(" + canvas + ")");

//		canvas.drawBitmap(mBitmap, mMaxtrix, null);
	}

	private void log(String msg) {
		Log.d(this.getClass().getSimpleName(), msg);
	}
}
