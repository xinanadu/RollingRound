package info.zhegui.rollinground;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class RollingRound extends TextView {

	private Bitmap mBitmap;
	private Matrix mMatrix = new Matrix();

	public RollingRound(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		mBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.home_menu);

		new Thread() {
			public void run() {
				int degrees = 0;
				while (true) {
					mMatrix.reset();
					mMatrix.preRotate(degrees, mBitmap.getWidth() / 2,
							mBitmap.getHeight() / 2);
					degrees += 15;
					if (degrees >= 360) {
						degrees %= 360;
					}
					log("degrees:" + degrees);
					SystemClock.sleep(200);
					postInvalidate();
				}
			}
		}.start();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
//		super.onDraw(canvas);
		log("onDraw(" + canvas + ")");

		canvas.drawBitmap(mBitmap, mMatrix, null);
	}

	private void log(String msg) {
		Log.d(this.getClass().getSimpleName(), msg);
	}
}
