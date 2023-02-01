import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskTitleComponent() {
    Row(modifier = Modifier.padding(8.dp).fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly){
        Text("Наименование задачи")
        Text("Исполнитель Android")
        Text("Исполнитель IOS")
        Text("Авторский надзор Android")
        Text("Авторский надзор IOS")
        Text("ПСИ Android")
        Text("ПСИ IOS")
    }
}