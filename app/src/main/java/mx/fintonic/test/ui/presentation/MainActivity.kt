package mx.fintonic.test.ui.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import mx.fintonic.test.databinding.ActivityMainBinding
import mx.fintonic.test.ktx.exhaustive
import mx.fintonic.test.ktx.gone
import mx.fintonic.test.ktx.visible
import mx.fintonic.test.ktx.observe
import mx.fintonic.test.ktx.viewBinding
import mx.fintonic.test.ui.presentation.adapters.BeersAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var managerLayout: LinearLayoutManager
    private lateinit var beersAdapter: BeersAdapter
    private val viewModel: BeerViewModel by viewModels()
    private var offset = 1
    private var loadProducts = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupObservers()
        viewModel.loadBeers(offset)
    }

    private fun setupView() {
        beersAdapter = BeersAdapter {
            //viewModel.onBeerClicked(movementId)
        }
        binding.beersRecyclerView.apply {
            setHasFixedSize(true)
            managerLayout = LinearLayoutManager(this@MainActivity)
            layoutManager = managerLayout
            adapter = beersAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL,
                )
            )
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    onScrolledBeer(dy)
                }
            })

        }
    }

    private fun onScrolledBeer(dy: Int) {
        if (dy > 0) {
            paginate()
        }
    }

    private fun paginate() {
        val visibleItemCount = managerLayout.childCount
        val pastVisibleItems = managerLayout.findFirstVisibleItemPosition()
        val totalItemCount = managerLayout.itemCount

        if (loadProducts && visibleItemCount + pastVisibleItems >= totalItemCount - 5) {
            offset += 1
            viewModel.loadBeers(offset)
        }
    }

    private fun setupObservers() {
        viewModel.state.observe(this, ::handle)
    }

    private fun handle(state: BeerViewModel.State) {
        when (state) {
            BeerViewModel.State.Loading -> showProgress()
            BeerViewModel.State.Retry -> {
                viewModel.loadBeers(offset)
            }
            is BeerViewModel.State.Success -> {
                hideProgress()
                if (state.response.bears.isEmpty()) {
                    loadProducts = false
                } else {
                    beersAdapter.addBeersData(state.response)
                }
            }
        }.exhaustive
    }

    private fun showProgress() {
        with(binding) {
            beersRecyclerView.gone()
        }
    }

    private fun hideProgress() {
        with(binding) {
            beersRecyclerView.visible()
        }
    }

}