package com.cuboid.cuboidcirclebutton;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
<<<<<<< HEAD
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
=======
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * Created by arsalan.chishti on 7/24/2016.
 */
public class CuboidButton extends TextView {

<<<<<<< HEAD
  float mCenterX;
  float mCenterY;
  private Bitmap b;
  private Coord mCoord;
  private float mRadius;
  private int radius = 0;
  public boolean ripleEffect;
  private String fontStyle = "";
  private int circle_x, circle_y;
  private final int maxWidth = 80;
  private final int maxHeight = 80;
  private Paint mPaint, mRectPaint;
  private final int BORDER_RADIUS = 6;
  private Paint circlePaint, circleBorder;
  private int startcolor, endcolor, user_given_radius;
  private int circle_color, circle_hover_color, default_color, circle_border_color, circle_border_radius, cr_icon;
=======
  private int circle_color, circle_hover_color, default_color, circle_border_color, circle_border_radius, cr_icon;
  private String fontStyle = "";
  private Paint circlePaint, circleBorder;
  private int circle_x, circle_y;
  private int radius = 0;
  private int startcolor, endcolor, user_given_radius;
  private final int BORDER_RADIUS = 6;
  private final int maxWidth = 80;
  private final int maxHeight = 80;
  private boolean ripleEffect;
  private float mRadius;
  private Paint mPaint, mRectPaint;
  private Coord mCoord;
  float mCenterX;
  float mCenterY;
  private Bitmap b;
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19


  public CuboidButton(Context context) {
    super(context);
    //init(null);
  }

  public CuboidButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public CuboidButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    mCoord = new Coord();
<<<<<<< HEAD
    mPaint = new Paint();
    mRectPaint = new Paint();
    circlePaint = new Paint();
    mPaint.setAntiAlias(true);
    circleBorder = new Paint();
    mRectPaint.setAntiAlias(true);
    circlePaint.setAntiAlias(true);
    circleBorder.setAntiAlias(true);

    TypedArray properties = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyCircleView, 0, 0);

=======
    circlePaint = new Paint();
    circleBorder = new Paint();
    mPaint = new Paint();
    mRectPaint = new Paint();
    mRectPaint.setAntiAlias(true);
    circlePaint.setAntiAlias(true);
    circleBorder.setAntiAlias(true);
    mPaint.setAntiAlias(true);
    TypedArray properties = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyCircleView, 0, 0);
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
    try {
      setCircle_color(properties.getInt(R.styleable.MyCircleView_cub_color, Color.BLACK));
      setCircle_hover_color(properties.getInt(R.styleable.MyCircleView_cub_hover_color, Color.GRAY));
      setCircle_border_color(properties.getInt(R.styleable.MyCircleView_cub_border_color, Color.WHITE));
      user_given_radius = properties.getDimensionPixelSize(R.styleable.MyCircleView_cub_border_radius, BORDER_RADIUS);
      setCircle_border_radius(Math.min(user_given_radius, BORDER_RADIUS));
<<<<<<< HEAD
      int btnIcon =properties.getResourceId(R.styleable.MyCircleView_cub_icon, 0) ;
      if(btnIcon!=0){
        setCr_icon(btnIcon);
      }
//      cr_icon = properties.getResourceId(R.styleable.MyCircleView_cub_icon, 0);
      ripleEffect = properties.getBoolean(R.styleable.MyCircleView_cub_riple_effect, false);
      fontStyle = properties.getString(R.styleable.MyCircleView_cub_fontstyle);

=======
      setCr_icon(properties.getResourceId(R.styleable.MyCircleView_cub_icon, 0));
      cr_icon = properties.getResourceId(R.styleable.MyCircleView_cub_icon, 0);
      ripleEffect = properties.getBoolean(R.styleable.MyCircleView_cub_riple_effect, false);
      fontStyle = properties.getString(R.styleable.MyCircleView_cub_fontstyle);
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
      if (fontStyle != null) {
        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), fontStyle);
        setTypeface(typeFace);
      }
<<<<<<< HEAD

      startcolor = getCircle_color();
      default_color = getCircle_color();

      endcolor = getCircle_hover_color();
      mPaint.setColor(Color.parseColor("#0DFFFFFF"));

      mRectPaint.setColor(Color.parseColor("#0DFFFFFF"));
      b = BitmapFactory.decodeResource(getResources(), cr_icon);

      setCr_icon(cr_icon);

=======
      startcolor = getCircle_color();
      default_color = getCircle_color();
      endcolor = getCircle_hover_color();
      mPaint.setColor(Color.parseColor("#0DFFFFFF"));
      mRectPaint.setColor(Color.parseColor("#0DFFFFFF"));
      b = BitmapFactory.decodeResource(getResources(), cr_icon);
      setCr_icon(cr_icon);
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
    } catch (Exception e) {
    } finally {
      properties.recycle();
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    int half_width = this.getWidth() / 2;
    int half_height = this.getHeight() / 2;
    radius = Math.min(half_width, half_height) / 4;
    if (half_width > half_height) {
      radius = half_height - 10;
    } else {
      radius = half_width - 10;
    }
    circle_x = half_width;
    circle_y = half_height;
    circlePaint.setStyle(Paint.Style.FILL);
    circlePaint.setColor(default_color);
    canvas.drawCircle(half_width, half_height, radius, circlePaint);//ORIGNAL CIRCLE
    if (getCircle_border_radius() != 0) {
      circleBorder.setStyle(Paint.Style.STROKE);
      circleBorder.setStrokeWidth(getCircle_border_radius());
      circleBorder.setColor(getCircle_border_color());
      this.setLayerType(LAYER_TYPE_HARDWARE, circleBorder);
      circleBorder.setShadowLayer(5.0f, 0.0f, 3.0f, Color.GRAY);
      canvas.drawCircle(half_width, half_height, radius, circleBorder); //BORDER CIRCLE
    }
    if (getCr_icon() != 0) {
      imageIcon(canvas, circlePaint, half_width, half_height);
<<<<<<< HEAD

=======
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
      setText("");
    } else {
      setText(getText());
    }
    setGravity(Gravity.CENTER);
    if (ripleEffect) {
      if (mCoord.x != 0 && mCoord.y != 0) {
        canvas.drawCircle(mCoord.x, mCoord.y, mRadius, mPaint);
      }
    }
    super.onDraw(canvas);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {

    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
      if (inCircle(event.getX(), event.getY(), circle_x, circle_y, radius)) {
        mCenterX = (getTranslationX() + getWidth()) / 2.0f;
        mCenterY = (getTranslationY() + getHeight()) / 2.0f;
        mCoord.setX(event.getX());
        mCoord.setY(event.getY());
        if (ripleEffect == true) {
          rippleAnimation();
        }
      }
    }

    super.onTouchEvent(event);
    int action = event.getAction();
    switch (action) {
      case MotionEvent.ACTION_UP:
        if (inCircle(event.getX(), event.getY(), circle_x, circle_y, radius)) {
          setColorAnimation(endcolor, startcolor);
        } else {
          setColorAnimation(endcolor, startcolor);
        }
        break;

      case MotionEvent.ACTION_DOWN:
        if (inCircle(event.getX(), event.getY(), circle_x, circle_y, radius)) {
          setColorAnimation(startcolor, endcolor);

        }
        break;

      case MotionEvent.ACTION_CANCEL:
        Log.e("called", "cancel else");
        default_color = getCircle_color();
        setColorAnimation(endcolor, startcolor);
        break;
    }
    invalidate();
    return true;

  }

  private boolean inCircle(float x, float y, float circleCenterX, float circleCenterY, float circleRadius) {
    double dx = Math.pow(x - circleCenterX, 2);
    double dy = Math.pow(y - circleCenterY, 2);

    if ((dx + dy) < Math.pow(circleRadius, 2)) {
      return true;
    } else {
      return false;
    }
  }

  public void imageIcon(Canvas canvas, Paint p, int p1, int p2) {
    Bitmap b2 = scaleBitmap(b);
<<<<<<< HEAD
    if(b2!=null){
      canvas.drawBitmap(b2, p1 - b2.getWidth() * 0.5f, p2 - b2.getHeight() * 0.5f, null);
    }

  }

  private Bitmap scaleBitmap(Bitmap bm) {

    if(bm!=null){
      int width = bm.getWidth();
      int height = bm.getHeight();
      if (width > height) {
        float ratio = (float) width / maxWidth;
        width = maxWidth;
        height = (int) (height / ratio);
      } else if (height > width) {
        float ratio = (float) height / maxHeight;
        height = maxHeight;
        width = (int) (width / ratio);
      } else {
        height = maxHeight;
        width = maxWidth;
      }

      bm = Bitmap.createScaledBitmap(bm, width, height, true);
    }


=======
    canvas.drawBitmap(b2, p1 - b2.getWidth() * 0.5f, p2 - b2.getHeight() * 0.5f, null);
  }

  private Bitmap scaleBitmap(Bitmap bm) {
    int width = bm.getWidth();
    int height = bm.getHeight();
    if (width > height) {
      float ratio = (float) width / maxWidth;
      width = maxWidth;
      height = (int) (height / ratio);
    } else if (height > width) {
      float ratio = (float) height / maxHeight;
      height = maxHeight;
      width = (int) (width / ratio);
    } else {
      height = maxHeight;
      width = maxWidth;
    }

    bm = Bitmap.createScaledBitmap(bm, width, height, true);
>>>>>>> 9105492b34e574bce80cfaf98a84065d545ecc19
    return bm;
  }

  public void setColorAnimation(int start, int end) {
    ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), start, end);
    animator.setDuration(500);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        default_color = (int) animation.getAnimatedValue();
        invalidate();
      }
    });
    animator.setInterpolator(new AccelerateDecelerateInterpolator());
    animator.start();
  }

  public void rippleAnimation() {
    Interpolator interpolator = new LinearInterpolator();
    long duration = 500;

    ObjectAnimator animRadius = ObjectAnimator.ofFloat(this, "radius", 10f, getWidth() / 3f);
    animRadius.setInterpolator(interpolator);
    animRadius.setDuration(duration);

    ObjectAnimator animAlpha = ObjectAnimator.ofInt(mPaint, "alpha", 200, 0);
    animAlpha.setInterpolator(interpolator);
    animAlpha.setDuration(duration);

    ObjectAnimator animX = ObjectAnimator.ofFloat(mCoord, "x", mCoord.x, mCenterX);
    animX.setInterpolator(interpolator);
    animX.setDuration(duration);

    ObjectAnimator animY = ObjectAnimator.ofFloat(mCoord, "y", mCoord.y, mCenterY);
    animY.setInterpolator(interpolator);
    animY.setDuration(duration);

    ObjectAnimator animRectAlpha = ObjectAnimator.ofInt(mRectPaint, "alpha", 0, 100, 0);
    animRectAlpha.setInterpolator(interpolator);
    animRectAlpha.setDuration(duration);

    AnimatorSet animSetAlphaRadius = new AnimatorSet();
    animSetAlphaRadius.playTogether(animRadius, animAlpha, animX, animY, animRectAlpha);
    animSetAlphaRadius.start();
  }

  //  GETTER SETTER----------------------------
  public int getCircle_color() {
    return circle_color;
  }

  public void setCircle_color(int circle_color) {
    this.circle_color = circle_color;
  }

  public int getCircle_hover_color() {
    return circle_hover_color;
  }

  public void setCircle_hover_color(int circle_hover_color) {
    this.circle_hover_color = circle_hover_color;
  }

  public int getCircle_border_color() {
    return circle_border_color;
  }

  public void setCircle_border_color(int circle_border_color) {
    this.circle_border_color = circle_border_color;
  }

  public int getCircle_border_radius() {
    return circle_border_radius;
  }

  public void setCircle_border_radius(int circle_border_radius) {
    this.circle_border_radius = circle_border_radius;
  }

  public int getCr_icon() {
    return cr_icon;
  }

  public void setCr_icon(int cr_icon) {
    this.cr_icon = cr_icon;
  }

  public void setRadius(final float radius) {
    mRadius = radius;
    //invalidate();
  }
  //  GETTER SETTER----------------------------

  private class Coord {
    public float x = 0;
    public float y = 0;


    public Coord() {
    }

    public Coord(float xValue, float yValue) {
      this.x = xValue;
      this.y = yValue;
    }

    private void setX(float value) {
      this.x = value;
    }

    private void setY(float value) {
      this.y = value;
    }
  }
}