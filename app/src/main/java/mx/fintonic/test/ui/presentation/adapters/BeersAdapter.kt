package mx.fintonic.test.ui.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.fintonic.test.R
import mx.fintonic.test.databinding.ViewBeerItemBinding
import mx.fintonic.test.ui.domain.models.Beers
import mx.fintonic.test.ui.presentation.models.BeerDataUI

internal class BeersAdapter(
    private val listener: (String) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val beerData: MutableList<BeerDataUI> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        BeerViewHolder(
            ViewBeerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BeerViewHolder).bind(beerData[position])

    override fun getItemCount(): Int = beerData.size

    override fun getItemViewType(position: Int): Int = beerData[position].id!!

    @SuppressLint("NotifyDataSetChanged")
    fun addBeersData(data: Beers) {
        //this.beerData.clear()
        this.beerData.addAll(data.bears)
        notifyDataSetChanged()
    }

    inner class BeerViewHolder(private val binding: ViewBeerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: BeerDataUI) = with(binding) {
            Glide.with(binding.ivBeer).load(beer.imageUrl).placeholder(R.drawable.ic_beer)
                .into(ivBeer)
            titleTextView.text = beer.name
            container.setOnClickListener { listener(beer.name ?: "") }
        }
    }

}
