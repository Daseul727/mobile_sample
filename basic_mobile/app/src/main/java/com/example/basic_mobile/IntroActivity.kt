package com.example.basic_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basic_mobile.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding 초기화
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼 정의
        val goMainBtn = binding.btnGoMain

        //버튼 클릭 이벤트
        goMainBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}