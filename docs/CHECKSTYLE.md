
## 1. Install the Checkstyle Plugin
- Open IntelliJ
- Go to **Settings** (Windows/Linux) or **Preferences** (macOS)
- Navigate to **Plugins**
- Search for **Checkstyle-IDEA**
- Click **Install**, then **Restart IDE**

## 2. Add Custom Checkstyle File
- Go to **Settings/Preferences** → **Tools** → **Checkstyle**
- Click the **+** icon to add a new configuration
- Set:
    - **Description**: (Any name you want)
    - **Configuration File**: Choose **"Use a local Checkstyle file"**
    - **File**: Browse and select the `config/checkstyle/checkstyle.xml` file
- Click **Next**, then **Finish**

## 3. Configure Settings
- In the Checkstyle settings panel:
    - Under **"Active Checkstyle configuration"**, select the one you added
    - **Treat Checkstyle errors as warnings**: Check this box
    - **Scope**: Set to **All**, but ensure only **Java sources** are selected, and **tests** are excluded
- Click **Apply** → **OK**

![](images/intellij-checkstyle-plugin.png)
