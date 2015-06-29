package com.github.shiraji.hidetoolwindowsex.action;

import com.github.shiraji.hidetoolwindowsex.config.HideToolWindowsExConfig;

public class HideBottomToolWindowsToggleAction extends HideToolWindowsExToggleAction {
    @Override
    protected boolean isHideToolWindows(HideToolWindowsExConfig config) {
        return config.isHideBottomToolWindow();
    }

    @Override
    protected void setHideToolWindows(HideToolWindowsExConfig config, boolean b) {
        config.setHideBottomToolWindow(b);
    }
}
