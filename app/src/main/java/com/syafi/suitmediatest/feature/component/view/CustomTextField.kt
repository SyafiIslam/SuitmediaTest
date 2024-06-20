package com.syafi.suitmediatest.feature.component.view

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.syafi.suitmediatest.ui.theme.Neutral50
import com.syafi.suitmediatest.ui.theme.Primary

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String? = null,
    trailingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit = {},
    label: String? = null,
    isNumeric: Boolean = false,
    maxLine: Int = 1,
    minLine: Int = 1,
    onIconClick: () -> Unit = {},
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        placeholder = { if(placeholder != null) Text(placeholder) },
        trailingIcon = {
            if (trailingIcon != null) {
                IconButton(onClick = { onIconClick() }) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = "",
                        Modifier
                            .size(25.dp)
                    )
                }
            }
        },
        shape = RoundedCornerShape(10.dp),
        label = {
            label?.let {
                Text(text = it)
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Neutral50,
            focusedIndicatorColor = Primary,
            focusedLabelColor = Primary,
            focusedContainerColor = Neutral50,
            focusedTextColor = Primary

        ),
        keyboardOptions =
        if (isNumeric) {
            KeyboardOptions(keyboardType = KeyboardType.Number)
        } else {
            KeyboardOptions(keyboardType = KeyboardType.Text)
        },
        maxLines = maxLine,
        minLines = minLine
    )
}