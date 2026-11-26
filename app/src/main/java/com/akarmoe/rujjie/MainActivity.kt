package com.akarmoe.rujjie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF050B08)
private val Panel = Color(0xFF0B1711)
private val Neon = Color(0xFF00FF88)
private val Muted = Color(0xFF8BBBA2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AkarApp() }
    }
}

@Composable
fun AkarApp() {
    var page by remember { mutableStateOf("DASHBOARD") }
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Bg, surface = Panel, primary = Neon,
            onBackground = Color.White, onSurface = Color.White
        )
    ) {
        Column(
            Modifier.fillMaxSize().background(Bg)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("AKARMOE", color = Neon, fontSize = 25.sp, fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Monospace)
                    Text("RUJJIE  //  GATEWAY CONTROL", color = Muted, fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace)
                }
                Text("● DEMO", color = Neon, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
            }
            Spacer(Modifier.height(20.dp))
            Text("SYSTEM STATUS", color = Muted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
            Spacer(Modifier.height(7.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("GATEWAY NOT CONNECTED", color = Color(0xFFFFC857),
                    fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
            Text("Connect to your authorized Ruijie gateway to enable live data.",
                color = Muted, fontSize = 11.sp)
            Spacer(Modifier.height(18.dp))

            val items = listOf(
                Triple("GATEWAY", "Router connection", "ROUTER"),
                Triple("DEVICES", "Connected clients", "DEVICES"),
                Triple("NETWORK SCANNER", "Local network overview", "SCANNER"),
                Triple("TRAFFIC MONITOR", "Bandwidth and usage", "TRAFFIC"),
                Triple("SECURITY", "Network status checks", "SECURITY"),
                Triple("ADMIN PANEL", "Authorized settings", "ADMIN")
            )
            items.chunked(2).forEach { rowItems ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    rowItems.forEach { item ->
                        CyberCard(item.first, item.second, Modifier.weight(1f)) { page = item.third }
                    }
                    if (rowItems.size == 1) Spacer(Modifier.weight(1f))
                }
                Spacer(Modifier.height(10.dp))
            }

            Spacer(Modifier.height(10.dp))
            Text("»  $page", color = Neon, fontSize = 15.sp, fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace)
            Spacer(Modifier.height(8.dp))
            when (page) {
                "DEVICES" -> InfoPanel("DEVICE MONITOR", "No live devices yet. Gateway integration is required.")
                "SCANNER" -> InfoPanel("NETWORK SCANNER", "Scanner interface ready. Only scan networks you own or are authorized to manage.")
                "TRAFFIC" -> InfoPanel("LIVE TRAFFIC", "Live bandwidth data will appear after gateway API integration.")
                "SECURITY" -> InfoPanel("SECURITY CHECK", "Security status is a demo until the gateway is connected.")
                "ADMIN" -> InfoPanel("ADMIN CONTROLS", "Admin actions will require authenticated gateway access.")
                "ROUTER" -> InfoPanel("GATEWAY CONNECTION", "Gateway model and supported management API are needed to connect.")
                else -> InfoPanel("CONSOLE", "AKARMOE Rujjie initialized. Waiting for authorized gateway connection.")
            }
            Spacer(Modifier.height(18.dp))
            Text("AKARMOE RUJJIE  •  VERSION 1.0.0",
                color = Muted, fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun CyberCard(title: String, subtitle: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        modifier = modifier.height(104.dp).border(1.dp, Neon.copy(alpha = 0.55f), RoundedCornerShape(12.dp)),
        color = Panel, shape = RoundedCornerShape(12.dp)
    ) {
        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.Center) {
            Text("▣", color = Neon, fontSize = 19.sp)
            Text(title, color = Neon, fontSize = 11.sp, fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace)
            Text(subtitle, color = Muted, fontSize = 9.sp)
        }
    }
}

@Composable
fun InfoPanel(title: String, message: String) {
    Column(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(12.dp))
        .border(1.dp, Neon.copy(alpha = 0.35f), RoundedCornerShape(12.dp)).padding(14.dp)) {
        Text("> $title", color = Neon, fontSize = 12.sp, fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace)
        Spacer(Modifier.height(8.dp))
        Text(message, color = Color(0xFFB8D9C5), fontSize = 12.sp)
    }
}
