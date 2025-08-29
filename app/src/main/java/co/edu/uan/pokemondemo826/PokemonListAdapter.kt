package co.edu.uan.pokemondemo826

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PokemonListAdapter(
    val ctx: MainActivity,
    val layout: Int,
    val data: Array<String>
) : ArrayAdapter<String>(ctx, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = ctx.layoutInflater.inflate(layout, parent, false)
        val tv = view.findViewById<TextView>(R.id.pokemonName)
        tv.text = data[position]

        val iv = view.findViewById<ImageView>(R.id.pokemonIcon)
        if(data[position] == "Pikachu")
            iv.setImageResource(R.drawable.pikachu)
        else
            iv.setImageResource(R.drawable.chansey)

        return view
    }
}