package com.biteam.dataElTogar.presentation.features.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.dataElTogar.data.dto.Product
import com.biteam.dataElTogar.presentation.features.HomeScreen
import com.biteam.dataElTogar.presentation.features.areasManagement.AreasScreen
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.checkerframework.checker.units.qual.Area

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val productsViewModel = getViewModel(Unit, viewModelFactory { AuthenticationViewModel() })
        val navigator = LocalNavigator.currentOrThrow

        Column {
            Text(text = "Login Screen")
            ProductListPage(productsViewModel)
            Button(onClick = {
                    navigator.push(HomeScreen)
            },
                content = { Text(text = "Login") })
        }
    }
}

@Composable
fun ProductListPage(viewModel: AuthenticationViewModel) {

    val uiState by viewModel.products.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when(uiState){
            is AuthenticationViewModel.ProductsState.Error<List<Product>> -> {
                println("")
            }
            is AuthenticationViewModel.ProductsState.Idle<List<Product>> -> {
                println("")
            }
            is AuthenticationViewModel.ProductsState.Loading<List<Product>> -> {
                println("")
            }
            is AuthenticationViewModel.ProductsState.Success<List<Product>> -> {
                val dataList = (uiState as AuthenticationViewModel.ProductsState.Success<List<Product>>).data
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 5.dp),
                    content = {
                        items(dataList.size) {
                            dataList[it].title?.let { it1 -> Text(text = it1) }
                        }
                    }
                )
            }
        }
    }
}