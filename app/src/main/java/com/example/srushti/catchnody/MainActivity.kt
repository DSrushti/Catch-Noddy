package com.example.srushti.catchnody

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var sc=0
    var imgarray=ArrayList<ImageView>()
    var handler:Handler= Handler()
    var runnable:Runnable= Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgarray= arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView7,imageView8,imageView9)

        hide()
        var data=this.openOrCreateDatabase("abc", Context.MODE_PRIVATE,null)

        object : CountDownTimer(10000,1000)
        {
            override fun onFinish() {
                timer.text="Time's Off"
                handler.removeCallbacks(runnable)
                for (img in imgarray)
                {
                    img.visibility=View.INVISIBLE

                }
            }
            override fun onTick(p0: Long) {
               timer.text="Time : " + p0/1000
            }
        }.start()
    }
    fun hide()
    {
        runnable = object : Runnable {

            override fun run() {



                for (image in imgarray) {

                    image.visibility = View.INVISIBLE

                }



                val random = Random()

                val index = random.nextInt(8 - 0)

                imgarray[index].visibility = View.VISIBLE



                handler.postDelayed(runnable,500)



            }



        }



        handler.post(runnable)



    }
    fun increase(view : View)
    {
        sc++
        score.text="Score : " + sc
    }
}
