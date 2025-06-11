package org.utl.Ejemplo1ComposeIDGS904

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta("Vegeta", "Mucho texto"),
    PersonajeTarjeta("Androide 17", "Mucho texto"),
    PersonajeTarjeta("Gohan", "Mucho texto"),
    PersonajeTarjeta("Androide 18", "Mucho texto"),
    PersonajeTarjeta("Freezer", "Mucho texto"),
    PersonajeTarjeta("Yamcha", "Mucho texto"),
    PersonajeTarjeta("Piccolo", "Mucho texto"),
    PersonajeTarjeta("Maestro Roshi", "Mucho texto"),
    PersonajeTarjeta("Bardock", "Mucho texto")

);

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Ejemplo1ComposeIDGS904Theme {

                Tarjeta(tarjetas)
            }
        }
    }

    @Composable
    fun Tarjeta(personajes : List<PersonajeTarjeta>) {
        LazyColumn {
            items (personajes){
                    personaje -> MyPersonajes(personaje)
            }
        }

    }


    @Preview
    @Composable
    fun PreviewMessageCard() {
        Tarjeta(tarjetas)
    }

    @Composable
    fun MyPersonajes(personaje:PersonajeTarjeta){

        Card (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp)
            ){
                ImagenHeroe(personaje.title.lowercase())
                Personajes(personaje)
            }
        }
    }

    @Composable
    fun Personajes(personaje: PersonajeTarjeta){
        Column{
            Personaje(personaje.title,
                MaterialTheme.colorScheme.primary,
                MaterialTheme.typography.titleLarge)
            Personaje(personaje.body,
                MaterialTheme.colorScheme.primary,
                MaterialTheme.typography.bodyMedium)
        }
    }


    @Composable
    fun Personaje(name:String, color: Color, style: TextStyle){
        Text(text = name, color = color, style = style)
    }

    @Composable
    fun ImagenHeroe(imageName:String){
        val context = LocalContext.current
        val imageResid = remember (imageName) {
            context.resources.getIdentifier(imageName.lowercase(),
                "drawable", context.packageName)
        }
        Image(
            painterResource(id = imageResid),
            contentDescription = imageName,
            modifier = Modifier
                .padding(16.dp)
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)

        )
    }

}
