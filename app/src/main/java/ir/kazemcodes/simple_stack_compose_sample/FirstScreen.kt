package ir.kazemcodes.simple_stack_compose_sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zhuinden.simplestackcomposeintegration.core.LocalBackstack

@Composable
fun FirstScreen(title: String, modifier: Modifier) {
    val backstack = LocalBackstack.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                backstack.goTo(SecondKey(Book("Harry Potter" , "J. K. Rowling")))
            },
            content = {
                Text(title)
            }
        )
    }
}