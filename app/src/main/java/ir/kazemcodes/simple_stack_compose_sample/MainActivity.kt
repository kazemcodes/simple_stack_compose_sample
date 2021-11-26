package ir.kazemcodes.simple_stack_compose_sample

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.zhuinden.simplestack.AsyncStateChanger
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackcomposeintegration.core.BackstackProvider
import com.zhuinden.simplestackcomposeintegration.core.ComposeStateChanger
import com.zhuinden.simplestackcomposeintegration.core.DefaultComposeKey
import com.zhuinden.simplestackextensions.navigatorktx.androidContentFrame
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import kotlinx.parcelize.Parcelize


class MainActivity : ComponentActivity() {
    private val composeStateChanger = ComposeStateChanger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val backstack = Navigator.configure()
            .setScopedServices(DefaultServiceProvider())
            .setStateChanger(AsyncStateChanger(composeStateChanger))
            .install(this, androidContentFrame, History.of(FirstKey("FirstScreen")))
        setContent {
            BackstackProvider(backstack) {  // <--
                MaterialTheme {
                    Box(Modifier.fillMaxSize()) {
                        composeStateChanger.RenderScreen()  // <--
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed()
        }
    }

    abstract class ComposeKey : DefaultComposeKey(), Parcelable,
        DefaultServiceProvider.HasServices {
        override val saveableStateProviderKey: Any = this

        override fun getScopeTag(): String = javaClass.name

        override fun bindServices(serviceBinder: ServiceBinder) {
        }
    }



}

@Parcelize
data class Book(
    val title : String,
    val author : String
):Parcelable

