package com.clarxlabs.nothton.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clarxlabs.nothton.ui.theme.AppTheme

@Composable
fun TextFormField(
    modifier: Modifier = Modifier,
    value: String = "",
    valueErrorMessage: String = "",
    onValueChanged: (String) -> Unit = {},
    label: @Composable (() -> Unit)? = null,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        isError = valueErrorMessage.isNotEmpty(),
        supportingText = { Text(text = valueErrorMessage).takeUnless { valueErrorMessage.isEmpty() } },
        label = label,
        shape = MaterialTheme.shapes.large,
        enabled = !isLoading and isEnabled,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        maxLines = 1,
        keyboardOptions = keyboardOptions,
    )
}

@Preview
@Composable
private fun TextFormFieldPreview() {
    AppTheme { Surface { TextFormField() } }
}
