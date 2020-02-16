import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

fun main() {
    val c = AtomicLong()

    // Using Threads
//    for (i in 0..1_000_000L) {
//        thread(start = true) {
//            c.addAndGet(i)
//        }
//    }

    // Using Coroutines
    for (i in 0..1_000_000L) {
        GlobalScope.launch {
            c.addAndGet(i)
        }
    }

    println(c.get())
}