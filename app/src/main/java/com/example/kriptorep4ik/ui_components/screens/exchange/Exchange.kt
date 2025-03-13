
import androidx.compose.runtime.Composable

@Composable
fun Screen2() {
//    // Состояние для хранения данных графика
//    val chartData = remember { mutableStateOf<List<Entry>>(emptyList()) }
//
//     Загрузка данных асинхронно
//    LaunchedEffect(Unit) {
//        val data = withContext(Dispatchers.IO) {
//            TestGraph().fetchDataFromWebsite()
//        }
//        chartData.value = data
//    }

    // Отображение графика
//    AndroidView(
//        factory = { context ->
//            LineChart(context).apply {
//                // Настройки графика
//                setBackgroundColor(Color.DKGRAY)
//                description.isEnabled = false
//            }
//        },
//        modifier = Modifier.fillMaxSize(),
//        update = { chart ->
//            // Обновление данных графика
//            if (chartData.value.isNotEmpty()) {
//                TestGraph().displayData(context, chartData.value, chart)
//            }
//        }
//    )
}