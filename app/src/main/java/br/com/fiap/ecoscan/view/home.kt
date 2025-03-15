package br.com.fiap.ecoscan.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.ecoscan.database.dao.ProdutoDao
import br.com.fiap.ecoscan.model.Produtos
import br.com.fiap.ecoscan.repository.ProdutoRepository
import br.com.fiap.ecoscan.repository.popularBancoDeDados

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f) // Ocupa 1/4 da tela
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally, // Centraliza na horizontal
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center, // Centraliza o texto
                modifier = Modifier.fillMaxWidth()
                    .offset(y = -80.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = { navController.navigate("Scanner") },
                modifier = Modifier.fillMaxWidth()
                    .offset(y = 100.dp),
                shape = RoundedCornerShape(18.dp)
            )

            {
                Text(
                    text = "Scanner",
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun GamesScreen() {

    var searchTextState by remember {
        mutableStateOf("")
    }

    var produtoListState by remember {
        mutableStateOf(popularBancoDeDados(produtosExemplo))
    }


        OutlinedTextField(
            value = searchTextState,
            onValueChange = {
                searchTextState = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do estúdio")
            },
            trailingIcon = {
                IconButton(onClick = {
                    produtoListState = getGamesByStudio(searchTextState)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )

                }
            }

        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn (){
            items(produtoListState){
                GameCard(game = it)
            }
        }
    }