import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReleaseContent(item: ReleaseItem, onCreateTaskClick: () -> Unit){
    val listOfTasks = remember { mutableStateListOf<TaskItem>() }
    //Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(
                    color = Color(0xffd19ba0),
                    shape = RoundedCornerShape(100.dp)
                ).clickable {
                    listOfTasks.add(TaskItem("Новая задача"))
                }
                .padding(8.dp)
        ){
            Text(text = "+ Добавить задачу", fontSize = 14.sp)
        }
        Column(modifier = Modifier.scrollable(orientation = Orientation.Vertical, state = rememberScrollState())) {
            if(listOfTasks.isNotEmpty()){
                TaskTitleComponent()
            }
            for(task in listOfTasks) {
                TaskItemComponent(task)
            }
        }
    //}
}