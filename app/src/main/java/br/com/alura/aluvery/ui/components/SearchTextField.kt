package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun SearchTextField(
        searchText: String,
        onSearchChange: (String) -> Unit,
        modifier: Modifier = Modifier
) {
    OutlinedTextField(
            value = searchText,
            onValueChange = { newValue ->
                onSearchChange(newValue)
            },
            modifier,
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "ícone de lupa")
            },
            label = {
                Text(text = "Produto")
            },
            placeholder = {
                Text("O que você procura?")
            })
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    AluveryTheme {
        Surface {
            SearchTextField(
                    "",
                    onSearchChange = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            SearchTextField(
                    searchText = "a",
                    onSearchChange = {},
            )
        }
    }
}