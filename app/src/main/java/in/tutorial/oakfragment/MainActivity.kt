package `in`.tutorial.oakfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import `in`.tutorial.oakfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.flBase, firstFragment)
        fragmentTransaction.commit()

        binding!!.btnReplace.setOnClickListener {
            val secondFragmentManager : FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            secondFragmentTransaction.replace(R.id.flBase, secondFragment)
            secondFragmentTransaction.addToBackStack(null)
            secondFragmentTransaction.commit()
        }
    }
}