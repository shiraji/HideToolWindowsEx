package com.github.shiraji.hidetoolwindowsex.config;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(
        name = "HideToolWindowsExConfig",
        storages = {
                @Storage(id = "HideToolWindowsExConfig", file = StoragePathMacros.APP_CONFIG + "/hide_tool_windows_ex.xml")
        }
)
public class HideToolWindowsExConfig implements PersistentStateComponent<HideToolWindowsExConfig> {
    private boolean mHideLeftToolWindow = false;
    private boolean mHideRightToolWindow = true;
    private boolean mHideBottomToolWindow = true;

    @Nullable
    @Override
    public HideToolWindowsExConfig getState() {
        return this;
    }

    @Override
    public void loadState(HideToolWindowsExConfig config) {
        XmlSerializerUtil.copyBean(config, this);
    }

    @Nullable
    public static HideToolWindowsExConfig getInstance() {
        return ServiceManager.getService(HideToolWindowsExConfig.class);
    }

    public boolean isHideLeftToolWindow() {
        return mHideLeftToolWindow;
    }

    public void setHideLeftToolWindow(boolean hideLeftToolWindow) {
        this.mHideLeftToolWindow = hideLeftToolWindow;
    }

    public boolean isHideRightToolWindow() {
        return mHideRightToolWindow;
    }

    public void setHideRightToolWindow(boolean hideRightToolWindow) {
        this.mHideRightToolWindow = hideRightToolWindow;
    }

    public boolean isHideBottomToolWindow() {
        return mHideBottomToolWindow;
    }

    public void setHideBottomToolWindow(boolean hideBottomToolWindow) {
        this.mHideBottomToolWindow = hideBottomToolWindow;
    }
}
