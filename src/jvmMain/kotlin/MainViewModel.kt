import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainViewModel() {
    val items = mutableStateListOf<ReleaseItem>()

    fun addItem(item: ReleaseItem){
        items.add(item)
        val a = 0
    }
}