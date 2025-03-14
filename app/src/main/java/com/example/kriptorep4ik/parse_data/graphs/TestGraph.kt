package com.example.kriptorep4ik.parse_data.graphs

class TestGraph {

//    fun fetchDataWithSelenium(): String? {
//        val options = ChromeOptions().apply {
//            addArguments("--headless")
//            addArguments("--no-sandbox")
//        }
//
//
//        // Подключение к удаленному WebDriver на указанном порту
//        val driver: WebDriver = RemoteWebDriver(URL("http://localhost:50013"), options)
//
//        try {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
//            driver.get("https://tradingeconomics.com/commodity/crude-oil")
//
//            // Поиск SVG-пути
//            val svgPath = driver.findElement(By.cssSelector("path[fill='none']")).getAttribute("d")
//
//            return svgPath
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return null
//        } finally {
//            driver.quit() // Закрытие сессии WebDriver
//        }
//    }
//
//    private fun parseSvgPath(path: String): List<Entry> {
//        val points = mutableListOf<Entry>()
//        val commands = path.split(" ")
//        Log.d("SVGPath", "Full path: $path")
//        Log.d("SVGPath", "Commands: ${commands.joinToString(", ")}")
//
//        var i = 0
//        while (i < commands.size) {
//            when (commands[i]) {
//                "M", "L" -> {
//                    val x = commands[i + 1].toFloat()
//                    val y = commands[i + 2].toFloat()
//                    points.add(Entry(x, y))
//                    i += 3
//                }
//                else -> i++
//            }
//        }
//        return points
//    }
//
//    fun displayData(context: Context, data: List<Entry>, chart: LineChart) {
//        val dataSet = LineDataSet(data, "Crude Oil Price").apply {
//            color = Color.CYAN
//            valueTextColor = Color.WHITE
//            lineWidth = 2f
//            setDrawCircles(false)
//            setDrawValues(false)
//        }
//
//        chart.apply {
//            this.data = LineData(dataSet)
//            setBackgroundColor(Color.DKGRAY)
//            setGridBackgroundColor(Color.BLACK)
//
//            xAxis.apply {
//                position = XAxis.XAxisPosition.BOTTOM
//                textColor = Color.WHITE
//                gridColor = Color.GRAY
//            }
//
//            axisLeft.apply {
//                textColor = Color.WHITE
//                gridColor = Color.GRAY
//            }
//
//            axisRight.isEnabled = false // Отключаем правую ось для минимализма
//
//            description.isEnabled = false
//            legend.textColor = Color.WHITE
//
//            invalidate() // Перерисовать график
//        }
//    }
}
