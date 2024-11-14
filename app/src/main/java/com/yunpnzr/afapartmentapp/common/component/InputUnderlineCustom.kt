package com.yunpnzr.afapartmentapp.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme
import com.yunpnzr.afapartmentapp.utils.bottomBorder

@Composable
fun InputUnderlineCustom(
    modifier: Modifier = Modifier,
    placeholder: String,
    valueInput: String,
    onValueChange: (String) -> Unit,
){
    val colorBottomBorder = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)

    BasicTextField(
        value = valueInput,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            /*.drawBehind {
                val borderSize = 4.dp.toPx()
                drawLine(
                    colorBottomBorder,
                    Offset(0f, size.height),
                    Offset(size.width, size.height),
                    borderSize
                )
            },*/
            .bottomBorder(
                strokeWidth = 1.dp,
                color = colorBottomBorder
            ),
        textStyle = MaterialTheme.typography.bodyMedium,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                if (valueInput.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                    )
                }
                innerTextField()
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun InputUnderlineCustomPreview() {
    AppTheme {
        InputUnderlineCustom(
            //title = "Email",
            placeholder = "Enter your email",
            valueInput = "",
            onValueChange = {},
            //padding = 48
        )
    }
}