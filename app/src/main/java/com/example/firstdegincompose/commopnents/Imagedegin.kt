import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstdegincompose.R

@Composable
fun CircleImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = 1f,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
            .size(45.dp) // Set the size of the image
            .clip(CircleShape), // Clip the image into a circle

        alpha = alpha,
        colorFilter = colorFilter
    )
}

@Composable
@Preview
fun ProfileScreen() {
    CircleImage(
        painter = painterResource(id = R.drawable.apple), // Use image from resources
        contentDescription = "Profile Image"
    )
}

