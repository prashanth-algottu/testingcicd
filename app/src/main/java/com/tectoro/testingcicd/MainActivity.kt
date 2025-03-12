package com.tectoro.testingcicd

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tectoro.testingcicd.ui.theme.TestingcicdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingcicdTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android 5",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Version name ${getAppVersion(LocalContext.current)}",
            modifier = modifier.padding(top = 60.dp)
        )
        Text(text = "Package name : ${LocalContext.current.packageName}")
    }

}

private fun getAppVersion(context: Context): String {
    val packageManager = context.packageManager
    val packageName = context.packageName
    val versionName = packageManager.getPackageInfo(packageName, 0).versionName
    return "Version: $versionName"
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingcicdTheme {
        Greeting("Android")
    }
}



