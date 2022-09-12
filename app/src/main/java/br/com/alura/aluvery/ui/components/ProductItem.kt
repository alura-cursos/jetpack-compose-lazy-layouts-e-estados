package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.extensions.toBrazilianCurrency
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ProductItem(
        product: Product,
        modifier: Modifier = Modifier,
) {
    Surface(
            modifier,
            shape = RoundedCornerShape(15.dp),
            elevation = 4.dp
    ) {
        Column(
                Modifier
                        .heightIn(250.dp, 300.dp)
                        .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                    modifier = Modifier
                            .height(imageSize)
                            .background(
                                    brush = Brush.horizontalGradient(
                                            colors = listOf(
                                                    MaterialTheme.colors.primary,
                                                    MaterialTheme.colors.secondary
                                            )
                                    )
                            )
                            .fillMaxWidth()
            ) {
                AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        Modifier
                                .size(imageSize)
                                .offset(y = imageSize / 2)
                                .clip(shape = CircleShape)
                                .align(Alignment.BottomCenter),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                        text = product.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                )
                Text(
                        text = product.price.toBrazilianCurrency(),
                        Modifier.padding(top = 8.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                    Product(
                            name = LoremIpsum(50).values.first(),
                            price = BigDecimal("14.99")
                    )
            )
        }
    }
}