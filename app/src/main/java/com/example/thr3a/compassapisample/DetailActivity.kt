package com.example.thr3a.compassapisample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // MainActivity から渡された値を表示
//        Toast.makeText(this, "${intent.extras.get("number")}, ${intent.extras.get("string")}", Toast.LENGTH_LONG).show()

//        val button: Button = findViewById(R.id.button2)
//        button.setOnClickListener {
//
//            // 渡す値を設定
//            val intent = Intent()
//            intent.putExtra("number", 300)
//            intent.putExtra("string", "The message from SecondActivity")
//
//            // 情報を渡して MainActivity の onActivityResult を呼び出す
//            setResult(Activity.RESULT_OK, intent)
//
//            // アクティビティを閉じる
//            finish()
//        }
    }
}