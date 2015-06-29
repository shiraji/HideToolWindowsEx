package com.github.shiraji.hidetoolwindowsex.action;

import com.github.shiraji.hidetoolwindowsex.config.HideToolWindowsExConfig;

public class HideRightToolWindowsToggleAction extends HideToolWindowsExToggleAction {
    @Override
    protected boolean isHideToolWindows(HideToolWindowsExConfig config) {
        return config.isHideRightToolWindow();
    }

    @Override
    protected void setHideToolWindows(HideToolWindowsExConfig config, boolean b) {
        config.setHideRightToolWindow(b);
    }
}
