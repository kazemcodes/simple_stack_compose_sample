package ir.kazemcodes.simple_stack_compose_sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import kotlinx.parcelize.Parcelize




@Immutable
@Parcelize
data class FirstKey(val title: String) : MainActivity.ComposeKey() {
    @Composable
    override fun ScreenComposable(modifier: Modifier) {
        FirstScreen(title, modifier)
    }
}

@Immutable
@Parcelize
data class SecondKey(val book : Book) : MainActivity.ComposeKey() {
    @Composable
    override fun ScreenComposable(modifier: Modifier) {
        SecondScreen(book, modifier)
    }
}