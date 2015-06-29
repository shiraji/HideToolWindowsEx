package com.github.shiraji.hidetoolwindowsex.action;

import com.github.shiraji.hidetoolwindowsex.config.HideToolWindowsExConfig;

public class HideLeftToolWindowsToggleAction extends HideToolWindowsExToggleAction {
    @Override
    protected boolean isHideToolWindows(HideToolWindowsExConfig config) {
        return config.isHideLeftToolWindow();
    }

    @Override
    protected void setHideToolWindows(HideToolWindowsExConfig config, boolean b) {
        config.setHideLeftToolWindow(b);
    }
}

