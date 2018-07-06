package app.chemistry.network

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.experimental.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */

@RunWith(JUnit4::class)
class NetworkingTest {

  private lateinit var camtingSnapshotDataSourceImp: CamtingSnapshotDataSourceImp

  @Before
  fun setup() {
    camtingSnapshotDataSourceImp = mock()
  }

  @Test
  fun add() {
    launch {
      try {
        camtingSnapshotDataSourceImp.addCamting(DummyData.camtingData())
      } catch (e : Exception) {
        e.printStackTrace()
      }
    }
  }

}