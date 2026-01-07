# 📱 Simple Android WebView

A minimal Android WebView wrapper for loading external websites with custom error handling and clean navigation behavior.

---

## Overview

This project is a lightweight Android application that wraps a website inside a native WebView.
It is designed to be simple, reliable, and easy to customize—ideal for small web-based apps or as a starter WebView template.

---

## Features

* Load external HTTPS websites
* Custom offline error page
* Retry connection without restarting the app
* Smart back navigation
* JavaScript bridge support

---

## ⚙️ Configuration

### 1. Target URL

Edit the website URL in `MainActivity.kt`:

```kotlin
private val webUrl = "https://your-website.com/"
```

**Note:**
The URL must start with `https://` due to Android network security policies.

---

### 2. Error Page

The app uses a local error page located at:

```
app/src/main/assets/error.html
```

---

### 3. Change Application Name

Edit `res/values/strings.xml`:

```xml
<string name="app_name">Your App Name</string>
```

---

### 4. Change Application Icon

* Right-click `res`
* Select **New → Image Asset**
* Follow the wizard to generate launcher icons

---

### 5. Change Package Name

* Right-click the package name
* Select **Refactor → Rename**
* Choose **Rename package** (not directory)
* Update `applicationId` in `build.gradle`
* Sync Gradle and rebuild the project

---

## 🏗️ Behavior Summary

* WebView loads the target URL on launch
* Network errors redirect to `error.html`
* Retry button reloads the main URL
* Back button navigates WebView history
* App exits only when no history exists

---

## 📝 Notes

Tested environment:

* **Android Studio:** Chipmunk | 2021.2.1 Patch 1
* Newer Android Studio versions may require Gradle or JDK adjustments

---

## 📄 License

Free to use for personal, educational, and production projects.
