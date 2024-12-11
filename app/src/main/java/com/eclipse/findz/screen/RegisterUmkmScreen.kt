package com.eclipse.findz.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eclipse.findz.R
import com.eclipse.findz.logic.registerUserLogic
import com.eclipse.findz.ui.theme.soraFontFamily

@Composable
fun RegisterUmkmScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var selectedField by remember { mutableStateOf("") }
    val options = listOf("Kecantikan", "Fashion", "FnB", "Elektronik", "Perjalanan dan Pariwisata", "Jasa", "Rumah Tangga")
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.findz_logo_horizontal),
                contentDescription = "Logo Horizontal",
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "Selamat datang!",
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color(0xFF716565),
            )
            Spacer(modifier = Modifier.height(16.dp))
            RegisterUmkmForm(
                name = name,
                onNameChange = { name = it },
                email = email,
                onEmailChange = { email = it },
                phone = phone,
                onPhoneChange = { phone = it },
                password = password,
                onPasswordChange = { password = it },
                confirmPassword = confirmPassword,
                onConfirmPasswordChange = { confirmPassword = it },
                selectedField = selectedField,
                onSelectedFieldChange = { selectedField = it },
                expanded = expanded,
                onExpandedChange = {expanded = it},
                options = options
            )
            // Button Register
            Button(
                onClick = {
                    registerUserLogic(
                        name = name,
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword,
                        role = "UMKM",
                        phoneNumber = phone,
                        businessField = selectedField,
                        interestField = null,
                        instagramAccount = null,
                        onRegisterSuccess = {
                            navController.navigate("tutorial1")
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF625AFE))
            ) {
                Text(
                    text = "Selanjutnya",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sudah punya akun?",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(2.dp))
                TextButton(onClick = { navController.navigate("login") })
                {
                    Text(
                        text = "Masuk",
                        fontFamily = soraFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = 12.sp,
                        color = Color(0xFF625AFE)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterUmkmForm(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    selectedField: String,
    onSelectedFieldChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    options: List<String>
) {


    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nama Lengkap
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nama Lengkap", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            ),
            textStyle = TextStyle(
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Email", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp)  },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            ),
            textStyle = TextStyle(
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Bidang Usaha (Dropdown)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { onExpandedChange(!expanded) },
        ) {
            OutlinedTextField(
                value = selectedField,
                onValueChange = onSelectedFieldChange,
                label = { Text("Bidang Usaha", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp)},
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                    .height(60.dp),
                shape = RoundedCornerShape(48.dp),
                readOnly = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF625AFE),
                    unfocusedBorderColor = Color(0xFFD4D4D7)
                ),
                textStyle = TextStyle(
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = Color.Black
                ),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { onExpandedChange(false) }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option, fontFamily = soraFontFamily, fontSize = 12.sp) },
                        onClick = {
                            onSelectedFieldChange(option)
                            onExpandedChange(false)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nomor Handphone
        OutlinedTextField(
            value = phone,
            onValueChange = onPhoneChange,
            label = { Text("Nomor Handphone", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(48.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            ),
            textStyle = TextStyle(
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Kata Sandi
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Kata Sandi", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Konfirmasi Kata Sandi
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = { Text("Konfirmasi Kata Sandi", fontFamily = soraFontFamily, fontWeight = FontWeight.Black, color = Color(0xFF62636B), fontSize = 10.sp) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            )
        )

        Spacer(modifier = Modifier.height(28.dp))
    }
}

