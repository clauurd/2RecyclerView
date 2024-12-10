package com.example.a2recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2recyclerview.ui.theme._2RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _2RecyclerViewTheme {
                GaleriaDeImagenes()

            }
        }
    }
}


@Composable
fun GaleriaDeImagenes() {

    val imagenes = listOf(
        R.drawable.alhambra,
        R.drawable.mahou,
        R.drawable.victoria,
        R.drawable.cruzcampo,
        R.drawable.estrellagalicia
    )

    val titulos = listOf(
        "Cerveza Alhambra",
        "Cerveza Mahou",
        "Cerveza Victoria",
        "Cerveza Cruzcampo",
        "Cerveza Estrella Galicia"
    )
    Column(modifier = Modifier.background(Color.Gray)) {

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Mis cervezas favoritas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )
        LazyVerticalGrid(

        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imagenes.size) { index ->
            ImagenItem(imagenResId = imagenes[index], titulo = titulos[index])
        }
    }
}
}
@Composable
fun ImagenItem(imagenResId: Int, titulo: String) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
            .clickable {
                Toast.makeText(context, titulo, Toast.LENGTH_SHORT).show()
            }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagenResId),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray, RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = titulo,
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GaleriaDeImagenesPreview() {
    GaleriaDeImagenes()
}
