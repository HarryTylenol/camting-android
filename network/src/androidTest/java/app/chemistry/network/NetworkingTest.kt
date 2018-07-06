package app.chemistry.network

import androidx.test.runner.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */

@RunWith(AndroidJUnit4::class)
class NetworkingTest {

  private lateinit var camtingSnapshotDataSourceImp: CamtingSnapshotDataSourceImp

  @Before
  fun setup() {
    camtingSnapshotDataSourceImp = mock()
  }

  @Test
  @Throws(Exception::class)
  fun testAddCamting() {
    val result = runBlocking {
      camtingSnapshotDataSourceImp.addCamting(DummyData.camtingData())
    }
    assertTrue("Added Camting", result)
  }

}