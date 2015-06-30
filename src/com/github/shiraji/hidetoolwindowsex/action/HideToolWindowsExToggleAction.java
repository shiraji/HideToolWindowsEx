package com.github.shiraji.hidetoolwindowsex.action;

import com.github.shiraji.hidetoolwindowsex.config.HideToolWindowsExConfig;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;

public abstract class HideToolWindowsExToggleAction extends ToggleAction {

    protected abstract boolean isHideToolWindows(HideToolWindowsExConfig config);

    protected abstract void setHideToolWindows(HideToolWindowsExConfig config, boolean b);

    @Override
    public boolean isSelected(AnActionEvent anActionEvent) {
        HideToolWindowsExConfig config = HideToolWindowsExConfig.getInstance();
        return isHideToolWindows(config);
    }

    @Override
    public void setSelected(AnActionEvent anActionEvent, boolean b) {
        HideToolWindowsExConfig config = HideToolWindowsExConfig.getInstance();
        setHideToolWindows(config, b);
    }
}
