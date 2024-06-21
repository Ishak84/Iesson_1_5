package com.geeks.iesson_1_5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geeks.iesson_1_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private val presenter = Presenter()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.AttachView(this)

        with(binding) {
            btnInc.setOnClickListener {
            presenter.onIncrementButtonClicked()
            }
            btnDec.setOnClickListener {
                presenter.onDecrementButtonClicked()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvCounterResult.text = count.toString()
    }

    override fun showToast(context: String) {
        Toast.makeText(this, context,Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.tvCounterResult.setTextColor(ContextCompat.getColor(this,R.color.green))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
