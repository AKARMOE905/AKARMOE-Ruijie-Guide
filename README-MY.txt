AKARMOE Ruijie Myanmar Guide — Android WebView APK project

ဒီ Project က HTML လမ်းညွှန်ကို Android APK အဖြစ်ထည့်ပေးထားတဲ့ အခြေခံ Android Studio/Gradle project ဖြစ်ပါတယ်။
Ruijie Router/AP ကို တိုက်ရိုက်ထိန်းချုပ်တဲ့ App မဟုတ်ပါ။ Offline guide အဖြစ်သာ လုပ်ဆောင်ပါတယ်။

Build:
1) Android SDK + JDK 17 + Gradle 8.9/compatible setup ရှိရပါမယ်။
2) Project folder ထဲမှာ Gradle wrapper ကို သင့် build environment က generate/အစားထိုးပါ။
3) `gradle assembleDebug` သို့မဟုတ် `./gradlew assembleDebug` run ပါ။
4) APK output: app/build/outputs/apk/debug/app-debug.apk

Termux မှာ Android SDK/Gradle configuration အလိုက် build မအောင်နိုင်ပါက AndroidIDE သို့မဟုတ် သင့်လက်ရှိ Termux Android project ထဲက app module ကို အသုံးပြုပါ။
HTML content ကို app/src/main/assets/index.html မှာ ပြင်ဆင်နိုင်ပါတယ်။
