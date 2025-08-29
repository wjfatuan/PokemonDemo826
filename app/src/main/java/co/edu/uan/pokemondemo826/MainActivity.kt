package co.edu.uan.pokemondemo826

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.edu.uan.pokemondemo826.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val pokemonNames = arrayOf("Pikachu", "Chamsey", "Bulbasaur", "Charmander", "Squirtle")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rbChamsey.setOnClickListener {
            binding.ivPokemon.setImageResource(R.drawable.chansey)
        }
        binding.rbPikachu.setOnClickListener {
            binding.ivPokemon.setImageResource(R.drawable.pikachu)
        }
        val adapter = PokemonListAdapter(this, R.layout.list_pokemon, pokemonNames)
        binding.lvPokemon.adapter = adapter
        binding.lvPokemon.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent, view: $view, position: $position, id: $id")
            val id = resources.getIdentifier(pokemonNames[position].lowercase(), "drawable", packageName)
            binding.ivPokemon.setImageResource(id)
        }
    }
}