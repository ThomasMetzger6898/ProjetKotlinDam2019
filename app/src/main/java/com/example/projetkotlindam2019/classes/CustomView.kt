package com.example.projetkotlindam2019.classes


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView : View, View.OnTouchListener {


    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        var mCircletest: MagicCircle = MagicCircle(width, height)
        if (event?.action == MotionEvent.ACTION_UP) {
            Log.d("TOUCH", "on rentre dans ontouch" + array.size)
            // mCircle = MagicCircle(width , height)
            array.add(mCircletest)
        }
        return true
    }


    constructor(context: Context) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }


    companion object {
        val DELTA = 5.1f
    }


    lateinit var mCircle: MagicCircle
    lateinit var mCircle2: MagicCircle
    // lateinit var mCircle3: MagicCircle
    var array = ArrayList<MagicCircle>()
    var colorArray = listOf(Color.BLUE, Color.BLACK, Color.YELLOW, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bot: Int) {
        super.onLayout(changed, left, top, right, bot)
        mCircle = MagicCircle(width, height)
        mCircle2 = MagicCircle(width - 20, height - 20)
        //   mCircle3 = MagicCircle(width+20 , height+20)

        array.add(mCircle)
        array.add(mCircle2)

    }


    private var mPaint = Paint()


    private fun init() {
        super.setOnTouchListener(this)

        //mPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        for (i in 0..(array.size - 1)) {

            array.get(i).move()
            var color = colorArray.random()
            mPaint.color = color
            canvas?.drawCircle(array.get(i).spawnX, array.get(i).spawnY, array.get(i).rad, mPaint)
            invalidate()

            Handler().postDelayed({
                canvas?.drawCircle(array.get(i).spawnX, array.get(i).spawnY, array.get(i).rad, mPaint)
            }, 1000000)
        }

    }


}